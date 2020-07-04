package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.util.ArrayList;
import java.util.Collections;
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

public class ExpectedWorstCaseReactionTimeCalculator extends AbstractTimeCalculator{
	
	public ExpectedWorstCaseReactionTimeCalculator(Measurement start, Measurement stop, Measurement dependencies) {
		super(start, stop, dependencies);
	}
	
	@Override
	public void calculate() {
		super.calculate(IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC_TUPLE);
	}

	protected void match(Measurement measurement) {
		
		double lastReceived = 0.0;
		for (long key : new TreeSet<Long>(stopMap.keySet())) {
			TreeSet<Long> subSet = this.getEntriesWithSmallerID(key);
			
			if (startMap.containsKey(key) && stopMap.containsKey(key)) {
				if (startMap.get(key) > stopMap.get(key)) {
					subSet.remove(key);
				}
 			}
			
			List<Long> startPoints = matchStopPoint(key, subSet);
			
			if (startPoints.isEmpty()) {
				continue;
			}
			
			Collections.sort(startPoints);
			int indexLatest = startPoints.size() - 1;
			
			removeSmaller(startPoints.get(indexLatest));
			
			double reactionTime = stopMap.get(key) - lastReceived;
			lastReceived = startMap.get(startPoints.get(indexLatest));
			
			List<MeasuringValue> list = new ArrayList<>();
			final BasicMeasurement<Double, Duration> id1 = new BasicMeasurement<>(Measure.valueOf(stopMap.get(key), SI.SECOND), MetricDescriptionConstants.POINT_IN_TIME_METRIC);
			final BasicMeasurement<Double, Duration> id2 = new BasicMeasurement<>(Measure.valueOf(reactionTime, SI.SECOND), IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC);
			list.add(id1);
			list.add(id2);
			TupleMeasurement tupleMeasurement = new TupleMeasurement(list, IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC_TUPLE);
			MeasurementsUtility.storeMeasurement(measurement, tupleMeasurement);
		}
	}
	
	private void removeSmaller(long id) {
		List<Long> removeList = new ArrayList<>();
		for (long removeCandidate : notYetFound) {
			if (removeCandidate <= id && startMap.get(removeCandidate) <= startMap.get(id)) {
				removeList.add(removeCandidate);
				if (removeCandidate == id) {
					break;
				}
			}
		}
		notYetFound.removeAll(removeList);
	}
	
}
