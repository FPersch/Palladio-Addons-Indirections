package org.palladiosimulator.indirections.simulizar.measurements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Duration;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.indirections.actions.AnalyseStackAction;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;
import org.palladiosimulator.simulizar.runtimestate.AbstractSimuLizarRuntimeState;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;
import indirectionsmeasuringpoint.IndirectionsmeasuringpointFactory;

public class IndirectionMeasuringPointRegistry {
    /** Default EMF factory for measuring points. */
    private static final MeasuringpointFactory MEASURINGPOINT_FACTORY = MeasuringpointFactory.eINSTANCE;

    private static final IndirectionsmeasuringpointFactory INDIRECTIONS_MEASURINGPOINT_FACTORY = IndirectionsmeasuringpointFactory.eINSTANCE;

    /** Default repository where measuring points are attached to. */
    private static final MeasuringPointRepository MEASURING_POINT_REPOSITORY = MEASURINGPOINT_FACTORY
            .createMeasuringPointRepository();

    private final SimuComModel myModel;
    private final ICalculatorFactory factory;

    private static Map<AbstractSimuLizarRuntimeState, IndirectionMeasuringPointRegistry> registries = new HashMap<>();

    // TODO: really static?
    public static IndirectionMeasuringPointRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context.getRuntimeState(),
                (ctx) -> new IndirectionMeasuringPointRegistry(ctx.getModel()));

        return registries.get(context.getRuntimeState());
    }

    private static class AllocatedAction {
        public final AbstractAction action;
        public final Allocation allocation;

        public AllocatedAction(AbstractAction action, Allocation allocation) {
            this.action = action;
            this.allocation = allocation;
        }

        @Override
        public int hashCode() {
            return Objects.hash(action, allocation);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AllocatedAction other = (AllocatedAction) obj;
            return Objects.equals(action, other.action) && Objects.equals(allocation, other.allocation);
        }

    }

    private Map<AllocatedAction, TriggeredProxyProbe<Double, Duration>> actionToProbe = new HashMap<>();

    private TakeCurrentSimulationTimeProbe timeProbe;

    private IndirectionMeasuringPointRegistry(final SimuComModel myModel) {
        this.myModel = myModel;
        this.factory = myModel.getProbeFrameworkContext().getCalculatorFactory();
        this.timeProbe = new TakeCurrentSimulationTimeProbe(myModel.getSimulationControl());
    }

    private TriggeredProxyProbe<Double, Duration> createProbe(AllocatedAction allocatedAction) {
        StringMeasuringPoint measuringPoint = MeasuringUtil.createStringMeasuringPoint(MEASURING_POINT_REPOSITORY,
                "Data age for " + allocatedAction.action.getEntityName() + " @ "
                        + allocatedAction.allocation.getEntityName());

        TriggeredProxyProbe<Double, Duration> dataAgeProxyProbe = new TriggeredProxyProbe<Double, Duration>(
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC);
        TriggeredCombiningProbe<Double, Duration> dataAgeMetricSetProbeList = new TriggeredCombiningProbe<Double, Duration>(
                IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, List.of(timeProbe, dataAgeProxyProbe),
                dataAgeProxyProbe);

        factory.buildExecutionResultCalculator(measuringPoint, dataAgeMetricSetProbeList);
        return dataAgeProxyProbe;
    }

    public TriggeredProxyProbe<Double, Duration> getProbe(AnalyseStackAction action, Allocation allocation) {
        return actionToProbe.computeIfAbsent(new AllocatedAction(action, allocation), this::createProbe);
    }
}
