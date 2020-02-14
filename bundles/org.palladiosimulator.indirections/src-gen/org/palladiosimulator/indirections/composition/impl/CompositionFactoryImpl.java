/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositionFactoryImpl extends EFactoryImpl implements CompositionFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static CompositionFactory init() {
        try {
            final CompositionFactory theCompositionFactory = (CompositionFactory) EPackage.Registry.INSTANCE
                    .getEFactory(CompositionPackage.eNS_URI);
            if (theCompositionFactory != null) {
                return theCompositionFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CompositionFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CompositionFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR:
            return this.createSupplierQueueSourceConnector();
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR:
            return this.createConsumerQueueSinkConnector();
        case CompositionPackage.QUEUE_CONNECTOR:
            return this.createQueueConnector();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SupplierQueueSourceConnector createSupplierQueueSourceConnector() {
        final SupplierQueueSourceConnectorImpl supplierQueueSourceConnector = new SupplierQueueSourceConnectorImpl();
        return supplierQueueSourceConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConsumerQueueSinkConnector createConsumerQueueSinkConnector() {
        final ConsumerQueueSinkConnectorImpl consumerQueueSinkConnector = new ConsumerQueueSinkConnectorImpl();
        return consumerQueueSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QueueConnector createQueueConnector() {
        final QueueConnectorImpl queueConnector = new QueueConnectorImpl();
        return queueConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompositionPackage getCompositionPackage() {
        return (CompositionPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CompositionPackage getPackage() {
        return CompositionPackage.eINSTANCE;
    }

} // CompositionFactoryImpl
