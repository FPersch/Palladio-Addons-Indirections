package org.palladiosimulator.indirections.scheduler;

import static org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil.initName;

import java.util.List;
import java.util.Objects;

import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.parameter.ParameterFactory;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.interpreter.UsageScenarioSwitch;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.usage.AbstractWorkloadUserFactory;
import de.uka.ipd.sdq.simucomframework.usage.IUser;
import de.uka.ipd.sdq.simucomframework.usage.IUserFactory;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class OpenWorkloadUserWithStackFactory extends AbstractWorkloadUserFactory implements IUserFactory {
    public class OpenWorkloadUserWithStack extends SimuComSimProcess implements IUser {
        private String dataId = null;
        private IndirectionDate date = null;
        private InterpreterDefaultContext context;

        public OpenWorkloadUserWithStack(SimuComModel owner, String name) {
            super(owner, name);
        }

        public void setDataAndStartUserLife(String dataId, IndirectionDate date, InterpreterDefaultContext context) {
            this.dataId = dataId;
            this.date = date;
            this.context = context;
            startUserLife();
        }

        @Override
        public void scenarioRunner(SimuComSimProcess thread) {
            final InterpreterDefaultContext newContext = new InterpreterDefaultContext(
                    context.getRuntimeState().getMainContext(), thread);

            // TODO: fix helper method to handle data on stack
            context.getStack().createAndPushNewStackFrame();
            IndirectionSimulationUtil.createNewDataOnStack(context.getStack(), Objects.requireNonNull(dataId),
                    Objects.requireNonNull(date));

            final UsageModel usageModel = newContext.getPCMPartitionManager().getLocalPCMModel().getUsageModel();
            new UsageScenarioSwitch<Object>(newContext).doSwitch(usageScenario);
        }

        /*
         * (non-Javadoc)
         * 
         * @see de.uka.ipd.sdq.simucomframework.usage.OpenWorkloadUser#startUserLife()
         */
        @Override
        public void startUserLife() {
            this.scheduleAt(0);
        }

        /*
         * (non-Javadoc)
         * 
         * @see de.uka.ipd.sdq.simucomframework.usage.OpenWorkloadUser#internalLifeCycle()
         */
        @Override
        protected void internalLifeCycle() {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(getName() + " started! I'm alive!!!");
            }
            // update session id
            updateNewSessionID();
            try {
                // TODO: Fixme and provide a new solution
                // blackboardGarbageCollector.enterRegion(getRequestContext()
                // .rootContext());
                ((TriggeredProbe) usageStartStopProbes.get(0)).takeMeasurement(getRequestContext());
                scenarioRunner(this);
                ((TriggeredProbe) usageStartStopProbes.get(1)).takeMeasurement(getRequestContext());
                if (getModel().getConfiguration().getSimulateFailures()) {
                    getModel().getFailureStatistics().recordSuccess();
                }
            } catch (final FailureException exception) {
                if (getModel().getConfiguration().getSimulateFailures()) {
                    getModel().getFailureStatistics().increaseUnhandledFailureCounter(exception.getFailureType(),
                            currentSessionId);
                }
            } finally {
                // Increase measurements counter manually as usage scenario run is
                // not finished:
                getModel().increaseMainMeasurementsCount();

                // TODO: Fixme and provide a new solution
                // blackboardGarbageCollector.leaveRegion(getRequestContext()
                // .rootContext());
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(getName() + " done! I'm dying!!!");
            }
        }
    }

    private final UsageScenario usageScenario;

    public OpenWorkloadUserWithStackFactory(SimuComModel model, UsageScenario usageScenario) {
        super(model, usageScenario);
        this.usageScenario = usageScenario;
    }

    @Override
    public OpenWorkloadUserWithStack createUser() {
        return new OpenWorkloadUserWithStack(model, "OpenWorkloadUserWithStack");
    }

    public static OpenWorkloadUserWithStackFactory createPushingUserFactory(ConsumerQueueSinkConnector sinkConnector,
            SimuComModel model) {

        final DataSinkRole sinkRole = sinkConnector.getDataSinkRole();

        if (!sinkRole.isPushing()) {
            throw new IllegalStateException(
                    "Sink role " + sinkRole + " for connector " + sinkConnector + " is not pushing.");
        }

        UsagemodelFactory factory = UsagemodelFactory.eINSTANCE;
        ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;
        StoexFactory stoexFactory = StoexFactory.eINSTANCE;
        CoreFactory coreFactory = CoreFactory.eINSTANCE;

        final String baseName = sinkConnector.getEntityName() + ".Generated";
        final String parameterName = IndirectionSimulationUtil.getOneParameter(sinkRole.getEventGroup())
                .getParameterName();

        UsageScenario usageScenario = initName(factory.createUsageScenario(), baseName + ".UsageScenario");
        ScenarioBehaviour scenarioBehaviour = initName(factory.createScenarioBehaviour(),
                baseName + ".UsageScenario.Behaviour");

        EntryLevelSystemCall elsc = initName(factory.createEntryLevelSystemCall(), baseName + ".UsageScenario.ELSC");

        PCMRandomVariable pcmRandomVariable = coreFactory.createPCMRandomVariable();
        pcmRandomVariable.setSpecification(parameterName);

        VariableCharacterisation variableCharacterisation = parameterFactory.createVariableCharacterisation();
        variableCharacterisation.setSpecification_VariableCharacterisation(pcmRandomVariable);

        VariableReference variableReference = stoexFactory.createVariableReference();
        variableReference.setReferenceName(parameterName);

        VariableUsage variableUsage = parameterFactory.createVariableUsage();
        variableUsage.setEntryLevelSystemCall_InputParameterUsage(elsc);
        variableUsage.setNamedReference__VariableUsage(variableReference);
        variableUsage.getVariableCharacterisation_VariableUsage().add(variableCharacterisation);

        variableUsage.setNamedReference__VariableUsage(variableReference);

        elsc.getInputParameterUsages_EntryLevelSystemCall().add(variableUsage);

        Start startAction = initName(factory.createStart(), baseName + ".UsageScenario.Start");
        Stop stopAction = initName(factory.createStop(), baseName + ".UsageScenario.Stop");

        startAction.setSuccessor(elsc);
        elsc.setSuccessor(stopAction);

        scenarioBehaviour.getActions_ScenarioBehaviour().addAll(List.of(startAction, elsc, stopAction));

        usageScenario.setScenarioBehaviour_UsageScenario(scenarioBehaviour);

        OpenWorkloadUserWithStackFactory userFactory = new OpenWorkloadUserWithStackFactory(model, usageScenario);

        return userFactory;
    }
}