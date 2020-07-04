package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

public class ProcessingTimeCalculator extends AbstractTimeCalculator {
	
	public ProcessingTimeCalculator(Measurement start, Measurement stop, Measurement dependencies) {
		super(start, stop, dependencies);
	}
	
	public void calculate() {
		super.calculate(IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC_TUPLE);
	}
	
	protected void match(Measurement measurement) {
		for (long key : new TreeSet<Long>(stopMap.keySet())) {
			TreeSet<Long> subSet = getEntriesWithSmallerID(key);
			
			if (startMap.containsKey(key) && stopMap.containsKey(key)) {
				if (startMap.get(key) > stopMap.get(key)) {
					subSet.remove(key);
				}
 			}
			
			List<Long> startPoints = matchStopPoint(key, subSet);
			for (long startPoint : startPoints) {
				List<MeasuringValue> list = new ArrayList<>();
				double reactionTime = stopMap.get(key) - startMap.get(startPoint);
				
				final BasicMeasurement<Double, Duration> id1 = new BasicMeasurement<>(Measure.valueOf(stopMap.get(key), SI.SECOND), MetricDescriptionConstants.POINT_IN_TIME_METRIC);
				final BasicMeasurement<Double, Duration> id2 = new BasicMeasurement<>(Measure.valueOf(reactionTime, SI.SECOND), IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC);
				list.add(id1);
				list.add(id2);
				TupleMeasurement tupleMeasurement = new TupleMeasurement(list, IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC_TUPLE);
				MeasurementsUtility.storeMeasurement(measurement, tupleMeasurement);
			}
		}
	}
	
}
