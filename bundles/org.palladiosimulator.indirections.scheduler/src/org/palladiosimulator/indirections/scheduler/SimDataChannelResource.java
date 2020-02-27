package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.UUID;

import org.palladiosimulator.indirections.composition.DataChannelSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelSourceConnector;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.SpinType;
import org.palladiosimulator.indirections.interfaces.IDataChannelResource;
import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackIteratingUser;
import org.palladiosimulator.indirections.scheduler.CallbackUserFactory.CallbackUser;
import org.palladiosimulator.indirections.scheduler.calculators.TriggerableTimeSpanCalculator;
import org.palladiosimulator.indirections.scheduler.util.IndirectionSimulationUtil;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.util.IterableUtil;
import org.palladiosimulator.simulizar.exceptions.PCMModelInterpreterException;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimDataChannelResource implements IDataChannelResource {
	protected Deque<IndirectionDate> outgoingQueue = new ArrayDeque<IndirectionDate>();
	protected DataChannel dataChannel;
	protected DataChannelSinkConnector sinkConnector;

	protected final InterpreterDefaultContext context;
	protected SimuComModel model;

	protected final String name;
	protected final String id;
	protected final int capacity;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public SimDataChannelResource(final DataChannel dataChannel, InterpreterDefaultContext context,
			final SchedulerModel model) {
		if (!(model instanceof SimuComModel)) {
			throw new IllegalArgumentException("Currently only works with " + SimuComModel.class.getName() + ", got "
					+ model.getClass().getName());
		}

		this.dataChannel = dataChannel;

		if (!dataChannel.getOutgoingDistribution().equals(OutgoingDistribution.EXACTLY_ONE_CONSUMER))
			throw new IllegalStateException();

		this.id = dataChannel.getId() + "_" + UUID.randomUUID().toString();
		this.name = dataChannel.getEntityName() + "_" + this.getClass().getSimpleName();

		this.capacity = dataChannel.getCapacity();

		this.model = (SimuComModel) model;
		this.context = context;

		this.sinkConnector = IterableUtil.claimOne(dataChannel.getDataChannelSinkConnector());

		this.createPushingUserFactories();
		this.setupCalculators();

	}

	private TriggerableTimeSpanCalculator afterAcceptingAgeCalculator;
	private TriggerableTimeSpanCalculator beforeEmittingAgeCalculator;

	private void setupCalculators() {
		this.afterAcceptingAgeCalculator = new TriggerableTimeSpanCalculator(
				"Data age after accepting date (" + name + ")", IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
		this.beforeEmittingAgeCalculator = new TriggerableTimeSpanCalculator("Data age before emitting (" + name + ")",
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC,
				IndirectionsMetricDescriptionConstants.DATA_AGE_METRIC_TUPLE, context);
	}

	private CallbackUserFactory sinkConnectorUserFactory;

	private void createPushingUserFactories() {
		if (sinkConnectorUserFactory != null) {
			throw new IllegalStateException("User factory already created.");
		}

		sinkConnectorUserFactory = CallbackUserFactory.createPushingUserFactory(sinkConnector, model);
	}

	private void spawnNewConsumerUser() {
		IndirectionDate date = outgoingQueue.removeLast();
		String parameterName = IndirectionSimulationUtil
				.getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName();
		
		CallbackUser user = sinkConnectorUserFactory.createUser();
		user.setDataAndStartUserLife(parameterName, date, context);

	}
	
	private void spawnNewConsumeAllUser() {
		List<IndirectionDate> date = new ArrayList<>();
		while (outgoingQueue.size() > 0)
			date.add(outgoingQueue.removeLast());
		
		String parameterName = IndirectionSimulationUtil
				.getOneParameter(sinkConnector.getDataSinkRole().getEventGroup()).getParameterName();
		
		CallbackIteratingUser user = sinkConnectorUserFactory.createIteratingUser();
		user.setDataAndStartUserLife(parameterName, date, context);
	}

	@Override
	public boolean put(final ISchedulableProcess schedulableProcess, final DataChannelSourceConnector sourceConnector,
			final IndirectionDate date) {
		IndirectionSimulationUtil.validateIndirectionDateStructure(date,
				sourceConnector.getDataSourceRole().getEventGroup());

		if (!this.model.getSimulationControl().isRunning()) {
			return true;
		}

		if (dataChannel.getPutPolicy() != PutPolicy.OVERWRITE_LAST) {
			throw new PCMModelInterpreterException("Currently only supports " + PutPolicy.OVERWRITE_LAST
					+ ". Chosen put policy: " + dataChannel.getPutPolicy());
		}

		// remove one more, because we will subsequently add an element
		while ((this.capacity != -1) && (this.outgoingQueue.size() >= this.capacity - 1)) {
			this.outgoingQueue.removeLast();
		}
		this.outgoingQueue.add(date);

		if (dataChannel.getSpinType() == SpinType.SPIN) {
			spawnNewConsumerUser();
		}

		afterAcceptingAgeCalculator.doMeasure(date.getTime());

		return true;
	}

	@Override
	public void spinOnce(final ISchedulableProcess schedulableProcess) {
		if (dataChannel.getSpinType() != SpinType.SPIN_ONCE) {
			throw new PCMModelInterpreterException("Data channel is not configured for spinOnce");
		}

		spawnNewConsumeAllUser();
	}

	protected String getOutgoingParameterName() {
		return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSourceEventGroup()).getParameterName();
	}

	protected String getIncomingParameterName() {
		return IndirectionSimulationUtil.getOneParameter(this.dataChannel.getSinkEventGroup()).getParameterName();
	}
}
