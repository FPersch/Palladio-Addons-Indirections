package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.visualization.IDerivedMetric;
import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.metricspec.MetricDescription;

public class ExpectedWorstCaseReactionTimeDerivedMetric implements IDerivedMetric {
	
	private Map<String, MetricDescription> neededMetrics;
	
	public ExpectedWorstCaseReactionTimeDerivedMetric() {
		neededMetrics = new HashMap<>();
		neededMetrics.put("Starting Point", IndirectionsMetricDescriptionConstants.DATA_CONTEXT_METRIC_TUPLE);
		neededMetrics.put("Stopping Point", IndirectionsMetricDescriptionConstants.DATA_CONTEXT_METRIC_TUPLE);
		neededMetrics.put("Dependencies", IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_METRIC_TUPLE);
	}
	
	@Override
	public void calculate(Map<String, Measurement> measurements) {
		if (measurements.size() != 3) {
			System.out.println("ERROR");
		}
		
		ExpectedWorstCaseReactionTimeCalculator calc = new ExpectedWorstCaseReactionTimeCalculator(measurements.get("Starting Point"), measurements.get("Stopping Point"), measurements.get("Dependencies"));
		calc.calculate();
	}

	@Override
	public Map<String, MetricDescription> getNeededMetrics() {
		return neededMetrics;
	}

	@Override
	public String getName() {
		return "Expected Worst-Case Reaction Time Derived Metric";
	}

}
