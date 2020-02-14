package org.palladiosimulator.indirections.util;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.actions.ConsumeDataAction;
import org.palladiosimulator.indirections.actions.EmitDataAction;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.interfaces.IConsumerQueueResource;
import org.palladiosimulator.indirections.interfaces.ISupplierQueueResource;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.indirections.util.simulizar.DataChannelRegistry;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

public final class IndirectionModelUtil {
    private IndirectionModelUtil() {

    }

    public static SupplierQueue getConnectedSinkDataChannel(final AssemblyContext assemblyContext,
            final DataSourceRole sourceRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();
        final List<SupplierQueueSourceConnector> dataChannelSourceConnectors = connectors.stream()
                .filter(SupplierQueueSourceConnector.class::isInstance).map(SupplierQueueSourceConnector.class::cast)
                .collect(Collectors.toList());

        return dataChannelSourceConnectors.stream().filter(it -> it.getDataSourceRole().equals(sourceRole)).findAny()
                .orElseThrow(
                        () -> new IllegalStateException("Could not find data channel for source role " + sourceRole))
                .getSupplierQueue();
    }

    public static ConsumerQueueSinkConnector getSinkConnectorForRole(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();

        final List<ConsumerQueueSinkConnector> dataChannelSinkConnectors = connectors.stream()
                .filter(ConsumerQueueSinkConnector.class::isInstance).map(ConsumerQueueSinkConnector.class::cast)
                .collect(Collectors.toList());

        final ConsumerQueueSinkConnector sinkConnectorForRole = dataChannelSinkConnectors.stream()
                .filter(it -> it.getDataSinkRole().equals(sinkRole)).findAny()
                .orElseThrow(() -> new IllegalStateException("Could not find data channel for sink role " + sinkRole));

        return sinkConnectorForRole;
    }

    public static SupplierQueueSourceConnector getSourceConnectorForRole(final AssemblyContext assemblyContext,
            final DataSourceRole sourceRole) {
        final EList<Connector> connectors = assemblyContext.getParentStructure__AssemblyContext()
                .getConnectors__ComposedStructure();

        final List<SupplierQueueSourceConnector> dataChannelSourceConnectors = connectors.stream()
                .filter(SupplierQueueSourceConnector.class::isInstance).map(SupplierQueueSourceConnector.class::cast)
                .collect(Collectors.toList());

        final SupplierQueueSourceConnector sourceConnectorForRole = dataChannelSourceConnectors.stream()
                .filter(it -> it.getDataSourceRole().equals(sourceRole)).findAny().orElseThrow(
                        () -> new IllegalStateException("Could not find data channel for source role " + sourceRole));

        return sourceConnectorForRole;
    }

    public static ConsumerQueue getConnectedSourceDataChannel(final AssemblyContext assemblyContext,
            final DataSinkRole sinkRole) {
        return getSinkConnectorForRole(assemblyContext, sinkRole).getConsumerQueue();
    }

    public static ISupplierQueueResource getDataChannelResource(InterpreterDefaultContext context,
            final EmitDataAction action) {
        final SupplierQueue supplierQueue = getSourceConnector(context, action).getSupplierQueue();

        final ISupplierQueueResource supplierQueueResource = DataChannelRegistry.getInstanceFor(context)
                .getOrCreateSupplierQueueResource(supplierQueue);
        return supplierQueueResource;
    }

    public static SupplierQueueSourceConnector getSourceConnector(InterpreterDefaultContext context,
            final EmitDataAction action) {
        final AssemblyContext assemblyContext = context.getAssemblyContextStack().peek();
        final DataSourceRole sinkRole = action.getDataSourceRole();

        return IndirectionModelUtil.getSourceConnectorForRole(assemblyContext, sinkRole);
    }

    public static IConsumerQueueResource getDataChannelResource(InterpreterDefaultContext context,
            final ConsumeDataAction action) {
        final ConsumerQueue consumerQueue = getSinkConnector(context, action).getConsumerQueue();
        final IConsumerQueueResource dataChannelResource = DataChannelRegistry.getInstanceFor(context)
                .getOrCreateConsumerQueueResource(consumerQueue);
        return dataChannelResource;
    }

    public static ConsumerQueueSinkConnector getSinkConnector(InterpreterDefaultContext context,
            final ConsumeDataAction action) {
        final AssemblyContext assemblyContext = context.getAssemblyContextStack().peek();
        final DataSinkRole sinkRole = action.getDataSinkRole();

        return IndirectionModelUtil.getSinkConnectorForRole(assemblyContext, sinkRole);
    }
}
