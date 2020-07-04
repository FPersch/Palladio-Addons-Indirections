package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataFactory;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.MeasuringType;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.ExperimentData.Run;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.edp2.visualization.IDerivedMetric;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.TupleMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

public class AddCustomMeasurements implements IDerivedMetric {

	private Map<String, MetricDescription> neededMetrics;
	private final ExperimentDataFactory EXPERIMENT_DATA_FACTORY = ExperimentDataFactory.eINSTANCE;
	private final MeasuringpointFactory MEASURING_POINT_FACTORY = MeasuringpointFactory.eINSTANCE;
	private final String path = "D:\\Daten\\Desktop\\Eval60.txt";    
	@Override
	public Map<String, MetricDescription> getNeededMetrics() {
		neededMetrics = new HashMap<>();
		neededMetrics.put("None", IndirectionsMetricDescriptionConstants.DATA_CONTEXT_METRIC_TUPLE);
		return neededMetrics;
	}

	@Override
	public void calculate(Map<String, Measurement> measurements) {
		Measurement m = measurements.get("None");
		pt(m);
		ewcrt(m);
	}

	@Override
	public String getName() {
		return "Debug: Add custom Measurements";
	}

	private void ewcrt(Measurement m) {
		Run run = m.getRun();
		MeasuringType mType = EXPERIMENT_DATA_FACTORY.createMeasuringType();
		mType.setMetric(IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC_TUPLE);
		mType.setExperimentGroup(run.getMeasurement().get(0).getMeasuringType().getExperimentGroup());
		
		StringMeasuringPoint mPoint = MEASURING_POINT_FACTORY.createStringMeasuringPoint();
		mPoint.setMeasuringPoint("AADC2018 - EWCR Time");
		mType.setMeasuringPoint(mPoint);
		
		Measurement measurement = EXPERIMENT_DATA_FACTORY.createMeasurement(mType);
		run.getMeasurement().add(measurement);

		MeasurementRange range = EXPERIMENT_DATA_FACTORY.createMeasurementRange(measurement);
		RawMeasurements rawMeasurements = EXPERIMENT_DATA_FACTORY.createRawMeasurements(range);
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		
		double pit = 0.0;
		double ewcrt = 0.0;
		double first = 0.0;
		double lastStart = 0.0;
		double start = 0.0;
		double stop = 0.0;
		boolean a = false;
		File file = new File(path);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			FileWriter myWriter = new FileWriter("D:\\Daten\\Desktop\\EWCRT_Eval60.txt");
			String st; 
			while ((st = br.readLine()) != null) {
				if (st.contains("stop-start")) {
					String[] parsed = st.split("-");
					if (first == 0.0) {
						first = Double.parseDouble(parsed[3]);
					}
					pit = Double.parseDouble(parsed[3]) - first;
					
					stop = Double.parseDouble(parsed[3]);
					start = Double.parseDouble(parsed[4]);
					a = true;
				}
				if (a) {
					a = false;
					if (lastStart == 0.0) {
						lastStart = start;
						continue;
					}
					ewcrt = stop - lastStart;
					lastStart = start;
					myWriter.write(Double.toString(ewcrt));
					myWriter.append( System.getProperty("line.separator") );
					List<MeasuringValue> list = new ArrayList<>();
					final BasicMeasurement<Double, Duration> id1 = new BasicMeasurement<>(Measure.valueOf(pit, SI.SECOND), MetricDescriptionConstants.POINT_IN_TIME_METRIC);
					final BasicMeasurement<Double, Duration> id2 = new BasicMeasurement<>(Measure.valueOf(ewcrt, SI.SECOND), IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC);
					list.add(id1);
					list.add(id2);
					TupleMeasurement tupleMeasurement = new TupleMeasurement(list, IndirectionsMetricDescriptionConstants.EXPECTED_WORST_CASE_REACTION_TIME_METRIC_TUPLE);
					MeasurementsUtility.storeMeasurement(measurement, tupleMeasurement);
				}
			}
			br.close();
			myWriter.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void pt(Measurement m) {
		Run run = m.getRun();
		MeasuringType mType = EXPERIMENT_DATA_FACTORY.createMeasuringType();
		mType.setMetric(IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC_TUPLE);
		mType.setExperimentGroup(run.getMeasurement().get(0).getMeasuringType().getExperimentGroup());
		
		StringMeasuringPoint mPoint = MEASURING_POINT_FACTORY.createStringMeasuringPoint();
		mPoint.setMeasuringPoint("AADC2018 - Processing Time");
		mType.setMeasuringPoint(mPoint);
		
		Measurement measurement = EXPERIMENT_DATA_FACTORY.createMeasurement(mType);
		run.getMeasurement().add(measurement);

		MeasurementRange range = EXPERIMENT_DATA_FACTORY.createMeasurementRange(measurement);
		RawMeasurements rawMeasurements = EXPERIMENT_DATA_FACTORY.createRawMeasurements(range);
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		
		double pit = 0.0;
		double processingTime = 0.0;
		double first = 0.0;
		boolean a = false;
		boolean b = false;
		File file = new File(path);
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(file));
			FileWriter myWriter = new FileWriter("D:\\Daten\\Desktop\\PT_Eval60.txt");
			String st; 
			while ((st = br.readLine()) != null) {
				if (st.contains("ProcessingTime")) {
					processingTime = Double.parseDouble(st.substring(st.lastIndexOf("-") + 1));
					myWriter.write(Double.toString(processingTime));
					myWriter.append( System.getProperty("line.separator") );
					a = true;
				} else if (st.contains("stop-start")) {
					if (first == 0.0) {
						first = Double.parseDouble(st.substring(st.lastIndexOf("-") + 1));
					}
					pit = Double.parseDouble(st.substring(st.lastIndexOf("-") + 1)) - first;
					b = true;
				}
				if (a && b) {
					a = false;
					b = false;
					List<MeasuringValue> list = new ArrayList<>();
					final BasicMeasurement<Double, Duration> id1 = new BasicMeasurement<>(Measure.valueOf(pit, SI.SECOND), MetricDescriptionConstants.POINT_IN_TIME_METRIC);
					final BasicMeasurement<Double, Duration> id2 = new BasicMeasurement<>(Measure.valueOf(processingTime, SI.SECOND), IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC);
					list.add(id1);
					list.add(id2);
					TupleMeasurement tupleMeasurement = new TupleMeasurement(list, IndirectionsMetricDescriptionConstants.PROCESSING_TIME_METRIC_TUPLE);
					MeasurementsUtility.storeMeasurement(measurement, tupleMeasurement);
				}
			}
			br.close();
			myWriter.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
