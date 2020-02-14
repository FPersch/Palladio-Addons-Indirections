/**
 */
package org.palladiosimulator.indirections.system.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl;
import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.indirections.system.SystemFactory;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SystemPackageImpl extends EPackageImpl implements SystemPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass consumerQueueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass supplierQueueEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.palladiosimulator.indirections.system.SystemPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SystemPackageImpl() {
        super(eNS_URI, SystemFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link SystemPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SystemPackage init() {
        if (isInited) {
            return (SystemPackage) EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredSystemPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final SystemPackageImpl theSystemPackage = registeredSystemPackage instanceof SystemPackageImpl
                ? (SystemPackageImpl) registeredSystemPackage
                : new SystemPackageImpl();

        isInited = true;

        // Initialize simple dependencies
        IdentifierPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();
        ProbfunctionPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        UnitsPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);
        final ActionsPackageImpl theActionsPackage = (ActionsPackageImpl) (registeredPackage instanceof ActionsPackageImpl
                ? registeredPackage
                : ActionsPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);
        final DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (registeredPackage instanceof DatatypesPackageImpl
                ? registeredPackage
                : DatatypesPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);
        final PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl) (registeredPackage instanceof PartitioningPackageImpl
                ? registeredPackage
                : PartitioningPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        final CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (registeredPackage instanceof CompositionPackageImpl
                ? registeredPackage
                : CompositionPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
        final RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
                ? registeredPackage
                : RepositoryPackage.eINSTANCE);

        // Create package meta-data objects
        theSystemPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theDatatypesPackage.createPackageContents();
        thePartitioningPackage.createPackageContents();
        theCompositionPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();

        // Initialize created meta-data
        theSystemPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theDatatypesPackage.initializePackageContents();
        thePartitioningPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSystemPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SystemPackage.eNS_URI, theSystemPackage);
        return theSystemPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConsumerQueue() {
        return this.consumerQueueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConsumerQueue_Capacity() {
        return (EAttribute) this.consumerQueueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_SourceEventGroup() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_SinkEventGroup() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_IncomingQueueConnector() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_SinkConnector() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_Partitioning() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_TimeGrouping() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueue_Joins() {
        return (EReference) this.consumerQueueEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConsumerQueue_OutgoingDistribution() {
        return (EAttribute) this.consumerQueueEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConsumerQueue_Scheduling() {
        return (EAttribute) this.consumerQueueEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConsumerQueue_PutPolicy() {
        return (EAttribute) this.consumerQueueEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSupplierQueue() {
        return this.supplierQueueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueue_SourceEventGroup() {
        return (EReference) this.supplierQueueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueue_SourceConnector() {
        return (EReference) this.supplierQueueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueue_OutgoingQueueConnector() {
        return (EReference) this.supplierQueueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SystemFactory getSystemFactory() {
        return (SystemFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.consumerQueueEClass = this.createEClass(CONSUMER_QUEUE);
        this.createEAttribute(this.consumerQueueEClass, CONSUMER_QUEUE__CAPACITY);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__SOURCE_EVENT_GROUP);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__SINK_EVENT_GROUP);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__SINK_CONNECTOR);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__PARTITIONING);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__TIME_GROUPING);
        this.createEReference(this.consumerQueueEClass, CONSUMER_QUEUE__JOINS);
        this.createEAttribute(this.consumerQueueEClass, CONSUMER_QUEUE__OUTGOING_DISTRIBUTION);
        this.createEAttribute(this.consumerQueueEClass, CONSUMER_QUEUE__SCHEDULING);
        this.createEAttribute(this.consumerQueueEClass, CONSUMER_QUEUE__PUT_POLICY);

        this.supplierQueueEClass = this.createEClass(SUPPLIER_QUEUE);
        this.createEReference(this.supplierQueueEClass, SUPPLIER_QUEUE__SOURCE_EVENT_GROUP);
        this.createEReference(this.supplierQueueEClass, SUPPLIER_QUEUE__SOURCE_CONNECTOR);
        this.createEReference(this.supplierQueueEClass, SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI);
        final org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
        final CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
                .getEPackage(CompositionPackage.eNS_URI);
        final PartitioningPackage thePartitioningPackage = (PartitioningPackage) EPackage.Registry.INSTANCE
                .getEPackage(PartitioningPackage.eNS_URI);
        final DatatypesPackage theDatatypesPackage = (DatatypesPackage) EPackage.Registry.INSTANCE
                .getEPackage(DatatypesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.consumerQueueEClass.getESuperTypes().add(theEntityPackage.getEntity());
        this.supplierQueueEClass.getESuperTypes().add(theEntityPackage.getEntity());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.consumerQueueEClass, ConsumerQueue.class, "ConsumerQueue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getConsumerQueue_Capacity(), this.ecorePackage.getEInt(), "capacity", "-1", 1, 1,
                ConsumerQueue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_SourceEventGroup(), theRepositoryPackage_1.getEventGroup(), null,
                "sourceEventGroup", null, 1, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_SinkEventGroup(), theRepositoryPackage_1.getEventGroup(), null,
                "sinkEventGroup", null, 1, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_IncomingQueueConnector(), theCompositionPackage.getQueueConnector(),
                theCompositionPackage.getQueueConnector_Sink(), "incomingQueueConnector", null, 0, -1,
                ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_SinkConnector(),
                theCompositionPackage.getConsumerQueueSinkConnector(),
                theCompositionPackage.getConsumerQueueSinkConnector_ConsumerQueue(), "sinkConnector", null, 0, -1,
                ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getConsumerQueue_Partitioning(), thePartitioningPackage.getPartitioning(), null,
                "partitioning", null, 0, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_TimeGrouping(), thePartitioningPackage.getTimeGrouping(), null,
                "timeGrouping", null, 0, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getConsumerQueue_Joins(), thePartitioningPackage.getJoining(), null, "joins", null, 0,
                -1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getConsumerQueue_OutgoingDistribution(), theDatatypesPackage.getOutgoingDistribution(),
                "outgoingDistribution", null, 0, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getConsumerQueue_Scheduling(), theDatatypesPackage.getScheduling(), "scheduling", null,
                0, 1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getConsumerQueue_PutPolicy(), theDatatypesPackage.getPutPolicy(), "putPolicy", null, 0,
                1, ConsumerQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.supplierQueueEClass, SupplierQueue.class, "SupplierQueue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSupplierQueue_SourceEventGroup(), theRepositoryPackage_1.getEventGroup(), null,
                "sourceEventGroup", null, 1, 1, SupplierQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getSupplierQueue_SourceConnector(),
                theCompositionPackage.getSupplierQueueSourceConnector(),
                theCompositionPackage.getSupplierQueueSourceConnector_SupplierQueue(), "sourceConnector", null, 0, -1,
                SupplierQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSupplierQueue_OutgoingQueueConnector(), theCompositionPackage.getQueueConnector(),
                theCompositionPackage.getQueueConnector_Source(), "outgoingQueueConnector", null, 0, -1,
                SupplierQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // SystemPackageImpl
