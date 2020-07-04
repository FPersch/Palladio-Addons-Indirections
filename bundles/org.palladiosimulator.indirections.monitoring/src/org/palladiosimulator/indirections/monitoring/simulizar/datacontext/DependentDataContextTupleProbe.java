package org.palladiosimulator.indirections.monitoring.simulizar.datacontext;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.Unit;

import org.palladiosimulator.indirections.monitoring.IndirectionsMetricDescriptionConstants;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.measurementframework.measureprovider.MeasurementListMeasureProvider;
import org.palladiosimulator.probeframework.measurement.ProbeMeasurement;
import org.palladiosimulator.probeframework.probes.Probe;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;

public class DependentDataContextTupleProbe extends Probe {

	protected DependentDataContextTupleProbe() {
		super(IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_METRIC_TUPLE);
	}
	
	@SuppressWarnings("unchecked")
	public ProbeMeasurement takeMeasurement(final Context context) {
		Long dataContextID;
		List<Long> dependentDataContextIDs;
		try {
			dataContextID = (long) context.getStack().currentStackFrame().getValue("_dcid");
			dependentDataContextIDs = (List<Long>) context.getStack().currentStackFrame().getValue("_dependenddcid");
		} catch (ValueNotInFrameException e) {
			return null;
		}
		ProbeMeasurement newMeasurement = null;
		if (dependentDataContextIDs.size() > 0) {
			for (long dependendDcid : dependentDataContextIDs) {
				List<MeasuringValue> list = new ArrayList<>();
				final BasicMeasurement<Long, Dimensionless> id1 = new BasicMeasurement<>(Measure.valueOf(dataContextID, Unit.ONE), IndirectionsMetricDescriptionConstants.DATA_CONTEXT_ID_METRIC);
				final BasicMeasurement<Long, Dimensionless> id2 = new BasicMeasurement<>(Measure.valueOf(dependendDcid, Unit.ONE), IndirectionsMetricDescriptionConstants.DEPENDENT_DATA_CONTEXT_ID_METRIC);
				list.add(id1);
				list.add(id2);
				MeasurementListMeasureProvider tupleMeasurement = new MeasurementListMeasureProvider(list);
				newMeasurement = new ProbeMeasurement(tupleMeasurement, this, context.getThread().getRequestContext());
				notifyMeasurementSourceListener(newMeasurement);
			}
		}
        return newMeasurement;
    }
	
}
