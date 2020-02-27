package org.palladiosimulator.indirections.simulizar.rdseffswitch;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.apache.log4j.Logger;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.actions.CreateDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.actions.PutDataOnStackAction;
import org.palladiosimulator.indirections.actions.util.ActionsSwitch;
import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.simulizar.IndirectionMeasuringPointRegistry;
import org.palladiosimulator.indirections.monitoring.simulizar.TriggeredProxyProbe;
import org.palladiosimulator.indirections.scheduler.data.ConcreteIndirectionDate;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.util.IndirectionModelUtil;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.ExplicitDispatchComposedSwitch;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.SimulatedBasicComponentInstance;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.VariableReference;

public class IndirectionsAwareRDSeffSwitch extends ActionsSwitch<Object> {
    private static final Logger LOGGER = Logger.getLogger(IndirectionsAwareRDSeffSwitch.class);

    private final InterpreterDefaultContext context;
    private final SimulatedBasicComponentInstance basicComponentInstance;
    private ExplicitDispatchComposedSwitch<Object> parentSwitch;
    private final Allocation allocation;
    private final AssemblyContext assemblyContext;
    private final SimulatedStackframe<Object> resultStackFrame;

    private final DataChannelRegistry dataChannelRegistry;
    private final IndirectionMeasuringPointRegistry indirectionMeasuringPointRegistry;

    /**
     * copied from
     * {@link org.palladiosimulator.simulizar.interpreter.RDSeffSwitch#RDSeffSwitch(InterpreterDefaultContext, SimulatedBasicComponentInstance)}
     * 
     * @param context
     * @param basicComponentInstance
     */
    public IndirectionsAwareRDSeffSwitch(final InterpreterDefaultContext context,
            final SimulatedBasicComponentInstance basicComponentInstance) {
        super();

        this.context = context;
        this.allocation = context.getLocalPCMModelAtContextCreation().getAllocation();
        this.assemblyContext = context.getAssemblyContextStack().lastElement();
        this.resultStackFrame = new SimulatedStackframe<Object>();
        this.basicComponentInstance = basicComponentInstance;

        this.dataChannelRegistry = DataChannelRegistry.getInstanceFor(context);
        this.indirectionMeasuringPointRegistry = IndirectionMeasuringPointRegistry.getInstanceFor(context);
    }

    public IndirectionsAwareRDSeffSwitch(final InterpreterDefaultContext context,
            final SimulatedBasicComponentInstance basicComponentInstance,
            final ExplicitDispatchComposedSwitch<Object> parentSwitch) {
        this(context, basicComponentInstance);
        this.parentSwitch = parentSwitch;
    }

    @Override
    public Object caseEmitDataAction(final EmitDataAction action) {
        LOGGER.trace("Emit event action: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();
        IndirectionDate date = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), referenceName);

        Map<DataChannelSourceConnector, IDataChannelResource> targetResources = IndirectionModelUtil.getEmitTargetResources(context, action);
        
        for (Entry<DataChannelSourceConnector, IDataChannelResource> kv : targetResources.entrySet()) {
        	LOGGER.trace("Trying to emit data " + date + " to " + kv.getValue().getName() + " - "
        			+ kv.getValue().getId());
        	kv.getValue().put(this.context.getThread(), kv.getKey(), date);
        }

        return true;
    }

    @Override
    public Object caseCreateDataAction(CreateDataAction action) {
        LOGGER.trace("Creating birth date: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();
        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();

        IndirectionDate date = IndirectionSimulationUtil.createData(context.getStack(), action.getVariableUsages(),
                currentSimulationTime);
        IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), referenceName, date);

        return true;
    }

    @Override
    public Object caseAnalyseStackAction(AnalyseStackAction action) {
        LOGGER.trace("Analyzing data: " + action.getEntityName());

        String referenceName = action.getVariableReference().getReferenceName();

        IndirectionDate data = IndirectionSimulationUtil.claimDataFromStack(context.getStack(), referenceName);
        List<Double> ages = IndirectionSimulationUtil.getDataAgeRecursive(data);

        ages.forEach(it -> measureDataAge(action, it));

        return true;
    }

    @Override
    public Object casePutDataOnStackAction(PutDataOnStackAction action) {
        LOGGER.trace("Putting data on stack: " + action.getEntityName());

        VariableReference variableReference = (VariableReference) action.getVariableUsages().get(0)
                .getNamedReference__VariableUsage();

        LOGGER.trace("Variable reference: " + variableReference.getReferenceName());

        if (variableReference.getReferenceName().equals("NUMBER_OF_ELEMENTS_0")) {
//            LOGGER.trace("Putting number of elements on stack.");
//
//            PartitionedIndirectionDate<Map<String, Object>, IndirectionDate> median = null;
//            SimulatedStackframe<Object> currentStackFrame = context.getStack().currentStackFrame();
//            try {
//                median = (PartitionedIndirectionDate<Map<String, Object>, IndirectionDate>) currentStackFrame
//                        .getValue("median");
//            } catch (ValueNotInFrameException e) {
////                e.printStackTrace();
//            }
//
//            currentStackFrame.addValue("median.NUMBER_OF_ELEMENTS", median.getDataInGroup().size());

            return true;
        }

        
        return true;
    }

    private void measureDataAge(AnalyseStackAction action, double value) {
        TriggeredProxyProbe<Double, Duration> probe = this.indirectionMeasuringPointRegistry.getProbe(action,
                assemblyContext);

        double currentSimulationTime = context.getModel().getSimulationControl().getCurrentSimulationTime();
        LOGGER.trace("Measuring age " + (currentSimulationTime - value) + " at " + currentSimulationTime);
        probe.doMeasure(Measure.valueOf(currentSimulationTime - value, SI.SECOND));
    }
}
