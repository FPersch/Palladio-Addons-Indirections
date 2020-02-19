package org.palladiosimulator.indirections.util.simulizar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;
import org.palladiosimulator.indirections.interfaces.IConsumerQueueResource;
import org.palladiosimulator.indirections.interfaces.IQueueResourceFactory;
import org.palladiosimulator.indirections.interfaces.ISupplierQueueResource;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class QueueRegistry {
    private static final String ATTRIBUTE_NAME = "queueResourceFactory";
    private static final String EXTENSION_POINT_ID = "org.palladiosimulator.indirections.interfaces.queueresourcefactory";

    private final Map<ConsumerQueue, IConsumerQueueResource> consumerQueueToResource = new HashMap<ConsumerQueue, IConsumerQueueResource>();
    private final Map<SupplierQueue, ISupplierQueueResource> supplierQueueToResource = new HashMap<SupplierQueue, ISupplierQueueResource>();
    private IQueueResourceFactory queueResourceFactory;

    private final SimuComModel model;
    private final InterpreterDefaultContext context;

    private static Map<SimuComModel, QueueRegistry> registries = new HashMap<>();

    public static QueueRegistry getInstanceFor(final InterpreterDefaultContext context) {
        registries.computeIfAbsent(context.getModel(), (model) -> new QueueRegistry(context, model));

        return registries.get(context.getModel());
    }

    private QueueRegistry(InterpreterDefaultContext ctx, final SimuComModel myModel) {
        this.context = ctx;
        this.model = myModel;
    }

    public IConsumerQueueResource getOrCreateConsumerQueueResource(final ConsumerQueue consumerQueue) {
        if (this.queueResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.consumerQueueToResource.containsKey(consumerQueue)) {
            this.consumerQueueToResource.put(consumerQueue,
                    this.queueResourceFactory.createConsumerQueueResource(consumerQueue, context, model));
        }
        return this.consumerQueueToResource.get(consumerQueue);
    }

    private void initializeDataChannelResourceFactory() {
        final List<Object> executableExtensions = ExtensionHelper.getExecutableExtensions(EXTENSION_POINT_ID,
                ATTRIBUTE_NAME);
        this.queueResourceFactory = executableExtensions.stream().map((it) -> (IQueueResourceFactory) it).findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("No " + IQueueResourceFactory.class.getName() + " found."));
    }

    public ISupplierQueueResource getOrCreateSupplierQueueResource(SupplierQueue supplierQueue) {
        if (this.queueResourceFactory == null) {
            this.initializeDataChannelResourceFactory();
        }

        if (!this.supplierQueueToResource.containsKey(supplierQueue)) {
            this.supplierQueueToResource.put(supplierQueue,
                    this.queueResourceFactory.createSupplierQueueResource(supplierQueue, context, model));
        }
        return this.supplierQueueToResource.get(supplierQueue);
    }

}
