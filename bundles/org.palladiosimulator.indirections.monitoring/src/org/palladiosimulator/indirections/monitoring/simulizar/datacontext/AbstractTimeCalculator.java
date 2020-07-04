package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.edp2source.Edp2DataTupleDataSource;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataFactory;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.MeasuringType;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.ExperimentData.Run;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

public abstract class AbstractTimeCalculator {
	
	private final IDataSource start;
	private final IDataSource stop;
	private final IDataSource dependencies;
	private Map<Long, List<Long>> dependencyMap = new HashMap<>();
	protected Map<Long, Double> startMap = new HashMap<>();
	protected Map<Long, Double> stopMap = new HashMap<>();
	protected TreeSet<Long> notYetFound = new TreeSet<>();
	
	private Run run;
	private final String measurementName;
	
    private final ExperimentDataFactory EXPERIMENT_DATA_FACTORY = ExperimentDataFactory.eINSTANCE;
    private final MeasuringpointFactory MEASURING_POINT_FACTORY = MeasuringpointFactory.eINSTANCE;
	
	public AbstractTimeCalculator(Measurement start, Measurement stop, Measurement dependencies) {
		this.start = new Edp2DataTupleDataSource(start.getMeasurementRanges().get(0).getRawMeasurements());
		this.stop = new Edp2DataTupleDataSource(stop.getMeasurementRanges().get(0).getRawMeasurements());
		this.dependencies = new Edp2DataTupleDataSource(dependencies.getMeasurementRanges().get(0).getRawMeasurements());
		run = start.getRun();
		measurementName = start.getMeasuringType().getMeasuringPoint().getStringRepresentation() + " - " + stop.getMeasuringType().getMeasuringPoint().getStringRepresentation();
	}
	
	protected abstract void match(Measurement measurement);
	
	public abstract void calculate();
	
	protected void calculate(MetricDescription metric) {
		createDependencyMap(dependencies, dependencyMap);
		createTimeMap(start, startMap);
		createTimeMap(stop, stopMap);
		notYetFound.addAll(startMap.keySet());
		match(createNewMeasurementEntry(metric));
	}
	
	protected List<Long> matchStopPoint(long key, TreeSet<Long> subSet) {
		List<Long> matchingStart = new ArrayList<>();
		if (subSet.contains(key)) {
			matchingStart.add(key);
			subSet.remove(key);
			notYetFound.remove(key);
		} else if (!subSet.isEmpty() && dependencyMap.containsKey(key)) {
			for (long childKey : dependencyMap.get(key)) {
				if (!subSet.isEmpty() && childKey >= subSet.first()) {
					matchingStart.addAll(matchStopPoint(childKey, subSet));
				}
			}
		}
		return matchingStart;
	}
	
	protected void createDependencyMap(IDataSource source, Map<Long, List<Long>> map) {
		var dependencyStream = source.getDataStream();
		for (var tuple : dependencyStream) {
			var key = (long) tuple.getMeasureForMetric(IndirectionsMetricDescriptionConstants.DATA_CONTEXT_ID_METRIC).getValue();
			var value = (long) tuple.getMeasureForMetric(IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_ID_METRIC).getValue();
			if (map.containsKey(key)) {
				if (!map.get(key).contains(value)) {
					map.get(key).add(value);
				}
			} else {
				List<Long> tmpList = new ArrayList<>();
				tmpList.add(value);
				map.put(key, tmpList);
			}
		}
		dependencyStream.close();
	}
	
	protected void createTimeMap(IDataSource source, Map<Long, Double> map) {
		var dependencyStream = source.getDataStream();
		for (var tuple : dependencyStream) {
			var key = (long) tuple.getMeasureForMetric(IndirectionsMetricDescriptionConstants.DATA_CONTEXT_ID_METRIC).getValue();
			var value = (double) tuple.getMeasureForMetric(MetricDescriptionConstants.POINT_IN_TIME_METRIC).getValue();
			map.put(key, value);
		}
		dependencyStream.close();
	}
	
	protected TreeSet<Long> getEntriesWithSmallerID(long id) {
		TreeSet<Long> smallerID = new TreeSet<>();
		for (var mapID : notYetFound) {
			if (mapID < id) {
				smallerID.add(mapID);
			} else if (mapID == id) {
				smallerID.add(mapID);
				break;
			}
		}
		return smallerID;
	}
	
	protected Measurement createNewMeasurementEntry(MetricDescription metric) {
		MeasuringType mType = EXPERIMENT_DATA_FACTORY.createMeasuringType();
		mType.setMetric(metric);
		mType.setExperimentGroup(run.getMeasurement().get(0).getMeasuringType().getExperimentGroup());
		
		StringMeasuringPoint mPoint = MEASURING_POINT_FACTORY.createStringMeasuringPoint();
		mPoint.setMeasuringPoint(measurementName);
		mType.setMeasuringPoint(mPoint);
		
		Measurement measurement = EXPERIMENT_DATA_FACTORY.createMeasurement(mType);
		run.getMeasurement().add(measurement);

		MeasurementRange range = EXPERIMENT_DATA_FACTORY.createMeasurementRange(measurement);
		RawMeasurements rawMeasurements = EXPERIMENT_DATA_FACTORY.createRawMeasurements(range);
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		
		return measurement;
	}
	
}