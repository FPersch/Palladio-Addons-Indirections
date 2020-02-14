/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.impl.ActionsPackageImpl;
import org.palladiosimulator.indirections.composition.CompositionFactory;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.datatypes.DatatypesPackage;
import org.palladiosimulator.indirections.datatypes.impl.DatatypesPackageImpl;
import org.palladiosimulator.indirections.partitioning.PartitioningPackage;
import org.palladiosimulator.indirections.partitioning.impl.PartitioningPackageImpl;
import org.palladiosimulator.indirections.repository.RepositoryPackage;
import org.palladiosimulator.indirections.repository.impl.RepositoryPackageImpl;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.indirections.system.impl.SystemPackageImpl;
import org.palladiosimulator.pcm.PcmPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositionPackageImpl extends EPackageImpl implements CompositionPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass supplierQueueSourceConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass consumerQueueSinkConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataChannelConnectorEClass = null;

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
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CompositionPackageImpl() {
        super(eNS_URI, CompositionFactory.eINSTANCE);
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
     * This method is used to initialize {@link CompositionPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CompositionPackage init() {
        if (isInited) {
            return (CompositionPackage) EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        }

        // Obtain or create and register package
        final Object registeredCompositionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        final CompositionPackageImpl theCompositionPackage = registeredCompositionPackage instanceof CompositionPackageImpl
                ? (CompositionPackageImpl) registeredCompositionPackage
                : new CompositionPackageImpl();

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
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        final SystemPackageImpl theSystemPackage = (SystemPackageImpl) (registeredPackage instanceof SystemPackageImpl
                ? registeredPackage
                : SystemPackage.eINSTANCE);
        registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
        final RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (registeredPackage instanceof RepositoryPackageImpl
                ? registeredPackage
                : RepositoryPackage.eINSTANCE);

        // Create package meta-data objects
        theCompositionPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theDatatypesPackage.createPackageContents();
        thePartitioningPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();

        // Initialize created meta-data
        theCompositionPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theDatatypesPackage.initializePackageContents();
        thePartitioningPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCompositionPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CompositionPackage.eNS_URI, theCompositionPackage);
        return theCompositionPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSupplierQueueSourceConnector() {
        return this.supplierQueueSourceConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueueSourceConnector_DataSourceRole() {
        return (EReference) this.supplierQueueSourceConnectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueueSourceConnector_AssemblyContext() {
        return (EReference) this.supplierQueueSourceConnectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSupplierQueueSourceConnector_SupplierQueue() {
        return (EReference) this.supplierQueueSourceConnectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConsumerQueueSinkConnector() {
        return this.consumerQueueSinkConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueueSinkConnector_DataSinkRole() {
        return (EReference) this.consumerQueueSinkConnectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueueSinkConnector_AssemblyContext() {
        return (EReference) this.consumerQueueSinkConnectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConsumerQueueSinkConnector_ConsumerQueue() {
        return (EReference) this.consumerQueueSinkConnectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataChannelConnector() {
        return this.dataChannelConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataChannelConnector_Source() {
        return (EReference) this.dataChannelConnectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataChannelConnector_Sink() {
        return (EReference) this.dataChannelConnectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompositionFactory getCompositionFactory() {
        return (CompositionFactory) this.getEFactoryInstance();
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
        this.supplierQueueSourceConnectorEClass = this.createEClass(SUPPLIER_QUEUE_SOURCE_CONNECTOR);
        this.createEReference(this.supplierQueueSourceConnectorEClass,
                SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE);
        this.createEReference(this.supplierQueueSourceConnectorEClass,
                SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT);
        this.createEReference(this.supplierQueueSourceConnectorEClass, SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE);

        this.consumerQueueSinkConnectorEClass = this.createEClass(CONSUMER_QUEUE_SINK_CONNECTOR);
        this.createEReference(this.consumerQueueSinkConnectorEClass, CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE);
        this.createEReference(this.consumerQueueSinkConnectorEClass, CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT);
        this.createEReference(this.consumerQueueSinkConnectorEClass, CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE);

        this.dataChannelConnectorEClass = this.createEClass(DATA_CHANNEL_CONNECTOR);
        this.createEReference(this.dataChannelConnectorEClass, DATA_CHANNEL_CONNECTOR__SOURCE);
        this.createEReference(this.dataChannelConnectorEClass, DATA_CHANNEL_CONNECTOR__SINK);
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
        final org.palladiosimulator.pcm.core.composition.CompositionPackage theCompositionPackage_1 = (org.palladiosimulator.pcm.core.composition.CompositionPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.core.composition.CompositionPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        final SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.supplierQueueSourceConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());
        this.consumerQueueSinkConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());
        this.dataChannelConnectorEClass.getESuperTypes().add(theCompositionPackage_1.getConnector());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.supplierQueueSourceConnectorEClass, SupplierQueueSourceConnector.class,
                "SupplierQueueSourceConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSupplierQueueSourceConnector_DataSourceRole(),
                theRepositoryPackage.getDataSourceRole(), null, "dataSourceRole", null, 1, 1,
                SupplierQueueSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSupplierQueueSourceConnector_AssemblyContext(),
                theCompositionPackage_1.getAssemblyContext(), null, "assemblyContext", null, 1, 1,
                SupplierQueueSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSupplierQueueSourceConnector_SupplierQueue(), theSystemPackage.getSupplierQueue(),
                theSystemPackage.getSupplierQueue_SourceConnector(), "supplierQueue", null, 1, 1,
                SupplierQueueSourceConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.consumerQueueSinkConnectorEClass, ConsumerQueueSinkConnector.class,
                "ConsumerQueueSinkConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getConsumerQueueSinkConnector_DataSinkRole(), theRepositoryPackage.getDataSinkRole(),
                null, "dataSinkRole", null, 1, 1, ConsumerQueueSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getConsumerQueueSinkConnector_AssemblyContext(),
                theCompositionPackage_1.getAssemblyContext(), null, "assemblyContext", null, 1, 1,
                ConsumerQueueSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getConsumerQueueSinkConnector_ConsumerQueue(), theSystemPackage.getConsumerQueue(),
                theSystemPackage.getConsumerQueue_SinkConnector(), "consumerQueue", null, 1, 1,
                ConsumerQueueSinkConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.dataChannelConnectorEClass, DataChannelConnector.class, "DataChannelConnector",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getDataChannelConnector_Source(), theSystemPackage.getSupplierQueue(),
                theSystemPackage.getSupplierQueue_OutgoingDataChannelConnector(), "source", null, 1, 1,
                DataChannelConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getDataChannelConnector_Sink(), theSystemPackage.getConsumerQueue(),
                theSystemPackage.getConsumerQueue_IncomingDataChannelConnector(), "sink", null, 1, 1,
                DataChannelConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // CompositionPackageImpl
