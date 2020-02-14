package org.palladiosimulator.indirections.util.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;
import org.palladiosimulator.indirections.interfaces.IConsumerQueueResource;
import org.palladiosimulator.indirections.interfaces.IDataChannelResourceFactory;
import org.palladiosimulator.indirections.interfaces.ISupplierQueueResource;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class DataChannelRegistry {
    private static final String ATTRIBUTE_NAME = "dataChannelResourceFactory";
    private static final String EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.datachannelresourcefactory";

    private final Map<ConsumerQueue, IConsumerQueueResource> consumerQueueToResource = new HashMap<ConsumerQueue, IConsumerQueueResource>();
    private final Map<SupplierQueue, ISupplierQueueResource> supplierQueueToResource = new HashMap<SupplierQueue, ISupplierQueueResource>();
    private IDataChannelResourceFactory dataChannelResourceFactory;

    private final SimuComModel model;
    private final InterpreterDefaultContext context;

    private static Map<SimuComModel, DataChannelRegistry> registries = new HashMap<>();

    public static DataChannelRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context.getModel(), (model) -> new DataChannelRegistry(context, model));

        return registries.get(context.getModel());
    }

    private DataChannelRegistry(InterpreterDefaultContext ctx, final SimuComModel myModel) {
        this.context = ctx;
        this.model = myModel;
    }

    public IConsumerQueueResource getOrCreateConsumerQueueResource(final ConsumerQueue consumerQueue) {
        if (this.dataChannelResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.consumerQueueToResource.containsKey(consumerQueue)) {
            this.consumerQueueToResource.put(consumerQueue,
                    this.dataChannelResourceFactory.createConsumerQueueResource(consumerQueue, context, model));
        }
        return this.consumerQueueToResource.get(consumerQueue);
    }

    private void initializeDataChannelResourceFactory() {
        final List<Object> executableExtensions = ExtensionHelper.getExecutableExtensions(EXTENSION_POINT_ID,
                ATTRIBUTE_NAME);
        this.dataChannelResourceFactory = executableExtensions.stream().map((it) -> (IDataChannelResourceFactory) it)
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "No " + IDataChannelResourceFactory.class.getName() + " found."));
    }

    public ISupplierQueueResource getOrCreateSupplierQueueResource(SupplierQueue supplierQueue) {
        if (this.dataChannelResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.supplierQueueToResource.containsKey(supplierQueue)) {
            this.supplierQueueToResource.put(supplierQueue,
                    this.dataChannelResourceFactory.createSupplierQueueResource(supplierQueue, context, model));
        }
        return this.supplierQueueToResource.get(supplierQueue);
    }

}
