package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.util.MetricDescriptionUtility;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.monitorrepository.MeasurementSpecification;
import org.palladiosimulator.monitorrepository.Monitor;
import org.palladiosimulator.monitorrepository.MonitorRepository;
import org.palladiosimulator.monitorrepository.MonitorRepositoryPackage;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.probeframework.calculator.CalculatorProbeSet;
import org.palladiosimulator.probeframework.calculator.DefaultCalculatorProbeSets;
import org.palladiosimulator.probeframework.calculator.IGenericCalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.simulizar.interpreter.listener.AbstractInterpreterListener;
import org.palladiosimulator.simulizar.interpreter.listener.ModelElementPassedEvent;
import org.palladiosimulator.simulizar.interpreter.listener.RDSEFFElementPassedEvent;
import org.palladiosimulator.simulizar.utils.MonitorRepositoryUtil;
import org.palladiosimulator.simulizar.utils.PCMPartitionManager;

public class DataContextProbeFrameworkListener extends AbstractInterpreterListener {
	
	protected final SimuComModel simuComModel;
	protected final PCMPartitionManager pcmPartitionManager;
	protected final IGenericCalculatorFactory calculatorFactory;
	
	private final Map<String, DataContextTupleProbe> currentContextDataTupleProbes = new HashMap<String, DataContextTupleProbe>();
	private final List<DependentDataContextTupleProbe> currentDependendContextDataTupleProbe = new ArrayList<DependentDataContextTupleProbe>();
	private final Map<String, Long> currentContext = new HashMap<>();
	
	public DataContextProbeFrameworkListener(final PCMPartitionManager pcmPartitionManager, final SimuComModel simuComModel) {
		this.simuComModel = simuComModel;
		this.pcmPartitionManager = pcmPartitionManager;
		this.calculatorFactory = simuComModel.getProbeFrameworkContext().getGenericCalculatorFactory();
		
		initDataContextTimeMeasurements();
	}
	
	public SimuComModel getSimuComModel() {
		return this.simuComModel;
	}
	
	@Override
	public void beginExternalCallInterpretation(RDSEFFElementPassedEvent<ExternalCallAction> event) {
		long dcid = -1L;
		try {
			dcid = (long) event.getContext().getStack().currentStackFrame().getValue("_dcid");
		} catch (ValueNotInFrameException e) {}
		String requestContext = event.getThread().getRequestContext().toString();
		if (!currentContext.containsKey(requestContext)) {
			currentContext.put(requestContext, dcid);
		} else if (currentContext.get(requestContext) != dcid) {
			currentContext.put(requestContext, dcid);
		}
		measureDataContextTuple(event);
	}

	@Override
	public void endExternalCallInterpretation(RDSEFFElementPassedEvent<ExternalCallAction> event) {
		for (Entry<String, Object> entry : event.getContext().getStack().currentStackFrame().getContents()) {
			if (entry.getKey().contentEquals("_dependenddcid")) {
				measureDependendDataContextTuple(event);
			}
		}
	}

	@Override
	public <T extends EObject> void beginUnknownElementInterpretation(ModelElementPassedEvent<T> event) {
		long dcid = -1L;
		try {
			dcid = (long) event.getContext().getStack().currentStackFrame().getValue("_dcid");
		} catch (ValueNotInFrameException e) {}
		String requestContext = event.getThread().getRequestContext().toString();
		if (dcid != -1L && !currentContext.containsKey(requestContext)) {
			currentContext.put(requestContext, dcid);
		} else if (dcid != -1L && currentContext.get(requestContext) != dcid) {
			currentContext.put(requestContext, dcid);
		}
		//System.out.println(event.getModelElement() + " - " + requestContext + " : " + currentContext.get(requestContext));
		measureDataContextTuple(event);
	}

	@Override
	public <T extends EObject> void endUnknownElementInterpretation(ModelElementPassedEvent<T> event) {	
		for (Entry<String, Object> entry : event.getContext().getStack().currentStackFrame().getContents()) {
			if (entry.getKey().contentEquals("_dependenddcid")) {
				measureDependendDataContextTuple(event);
			}
		}
	}
	
    protected Probe createDataContextTupleProbe(final MeasuringPoint measuringPoint) {
    	DataContextTupleProbe probe = new DataContextTupleProbe();
        final EObject modelElement = MonitorRepositoryUtil.getMonitoredElement(measuringPoint);
        this.currentContextDataTupleProbes.put(((Entity) modelElement).getId(), probe);
        return probe;
    }

    protected DependentDataContextTupleProbe createDependendDataContextTupleProbe() {
    	DependentDataContextTupleProbe probe = new DependentDataContextTupleProbe();
        this.currentDependendContextDataTupleProbe.add(probe);
        return probe;
    }
    
	private void initDataContextTimeMeasurements() {
		for (MeasurementSpecification dataContextTupleMeasurementSpec : this
                .getMeasurementSpecificationsForMetricDescription(IndirectionsMetricDescriptionConstants.DATA_CONTEXT_ID_METRIC)) {
            MeasuringPoint dcMeasuringPoint = dataContextTupleMeasurementSpec.getMonitor().getMeasuringPoint();
            CalculatorProbeSet dcProbe = DefaultCalculatorProbeSets.createSingularProbeConfiguration(this.createDataContextTupleProbe(dcMeasuringPoint));
            this.calculatorFactory.buildCalculator(IndirectionsMetricDescriptionConstants.DATA_CONTEXT_METRIC_TUPLE, dcMeasuringPoint, dcProbe);
        }
		
		for (MeasurementSpecification dependendDataContextTupleMeasurementSpec : this
                .getMeasurementSpecificationsForMetricDescription(IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_ID_METRIC)) {
            MeasuringPoint ddcMeasuringPoint = dependendDataContextTupleMeasurementSpec.getMonitor().getMeasuringPoint();
            CalculatorProbeSet ddcProbe = DefaultCalculatorProbeSets.createSingularProbeConfiguration(this.createDependendDataContextTupleProbe());
            this.calculatorFactory.buildCalculator(IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_METRIC_TUPLE, ddcMeasuringPoint, ddcProbe);
        }
        
    }
	
	/**
     * @param <T>
     * @param event
     */
    private <T extends EObject> void measureDataContextTuple(final ModelElementPassedEvent<T> event) {
        if (this.currentContextDataTupleProbes.containsKey(((Entity) event.getModelElement()).getId())
                && this.simulationIsRunning()) {
            this.currentContextDataTupleProbes.get(((Entity) event.getModelElement()).getId()).takeMeasurement(event.getContext());
        }
    }
    
    /**
     * @param <T>
     * @param event
     */
    private <T extends EObject> void measureDependendDataContextTuple(final ModelElementPassedEvent<T> event) {
        if (this.simulationIsRunning() && !this.currentDependendContextDataTupleProbe.isEmpty()) {
        	this.currentDependendContextDataTupleProbe.get(0).takeMeasurement(event.getContext());
        }
    }
    
    private boolean simulationIsRunning() {
        return this.simuComModel.getSimulationControl().isRunning();
    }
    
    //Copied from AbstractProbeFrameworkListener
    public Collection<MeasurementSpecification> getMeasurementSpecificationsForMetricDescription(
            final MetricDescription soughtFor) {
        Objects.requireNonNull(soughtFor, "Given MetricDescription must not be null.");

        return filterMeasurementSpecifications(
                m -> MetricDescriptionUtility.metricDescriptionIdsEqual(m.getMetricDescription(), soughtFor));
    }
    
    //Copied from AbstractProbeFrameworkListener
    private Collection<MeasurementSpecification> filterMeasurementSpecifications(
            final Predicate<? super MeasurementSpecification> predicate) {
        assert predicate != null;

        MonitorRepository monitorRepositoryModel = this.pcmPartitionManager.findModel(MonitorRepositoryPackage.eINSTANCE.getMonitorRepository());
        if (monitorRepositoryModel != null) {
            return monitorRepositoryModel.getMonitors().stream().filter(Monitor::isActivated)
                    .flatMap(monitor -> monitor.getMeasurementSpecifications().stream()).filter(predicate)
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        }
        return Collections.emptyList();
    }
    
}