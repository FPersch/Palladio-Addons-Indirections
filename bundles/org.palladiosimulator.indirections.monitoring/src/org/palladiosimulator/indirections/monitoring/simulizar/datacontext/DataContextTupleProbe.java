package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import static javax.measure.unit.SI.SECOND;
import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;

import java.util.ArrayList;
import java.util.List;

import javax.measure.unit.Unit;

import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.measurementframework.measureprovider.MeasurementListMeasureProvider;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.measurement.ProbeMeasurement;
import org.palladiosimulator.probeframework.probes.Probe;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;

public class DataContextTupleProbe extends Probe {

	protected DataContextTupleProbe() {
		super(IndirectionsMetricDescriptionConstants.DATA_CONTEXT_METRIC_TUPLE);
	}
	
	public ProbeMeasurement takeMeasurement(final Context context) {
		Long dataContextID;
		try {
			dataContextID = (long) context.getStack().currentStackFrame().getValue("_dcid");
		} catch (ValueNotInFrameException e) {
			dataContextID = -1L;
		}
		List<MeasuringValue> list = new ArrayList<>();
		final BasicMeasurement<Long, Dimensionless> id = new BasicMeasurement<>(Measure.valueOf(dataContextID, Unit.ONE), IndirectionsMetricDescriptionConstants.DATA_CONTEXT_ID_METRIC);
		final BasicMeasurement<Double, Duration> time = new BasicMeasurement<>(Measure.valueOf(context.getModel().getSimulationControl().getCurrentSimulationTime(), SECOND), MetricDescriptionConstants.POINT_IN_TIME_METRIC);
		list.add(id);
		list.add(time);
		MeasurementListMeasureProvider tupleMeasurement = new MeasurementListMeasureProvider(list);
		
		ProbeMeasurement newMeasurement = new ProbeMeasurement(tupleMeasurement, this, context.getThread().getRequestContext());
		notifyMeasurementSourceListener(newMeasurement);
        return newMeasurement;
    }
}
