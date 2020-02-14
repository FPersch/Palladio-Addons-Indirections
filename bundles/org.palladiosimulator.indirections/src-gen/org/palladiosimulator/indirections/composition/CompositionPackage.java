/**
 */
package org.palladiosimulator.indirections.composition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.composition.CompositionFactory
 * @model kind="package"
 * @generated
 */
public interface CompositionPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "composition";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/Composition/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.composition";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    CompositionPackage eINSTANCE = org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl
     * <em>Supplier Queue Source Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getSupplierQueueSourceConnector()
     * @generated
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Assembly Context</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The feature id for the '<em><b>Supplier Queue</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 2;

    /**
     * The number of structural features of the '<em>Supplier Queue Source Connector</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_SOURCE_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 3;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl
     * <em>Consumer Queue Sink Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getConsumerQueueSinkConnector()
     * @generated
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Assembly Context</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The feature id for the '<em><b>Consumer Queue</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 2;

    /**
     * The number of structural features of the '<em>Consumer Queue Sink Connector</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_SINK_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 3;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl <em>Data
     * Channel Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl
     * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelConnector()
     * @generated
     */
    int DATA_CHANNEL_CONNECTOR = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR__ID = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR__ENTITY_NAME = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Parent Structure Connector</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR__PARENT_STRUCTURE_CONNECTOR = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR__SOURCE = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 0;

    /**
     * The feature id for the '<em><b>Sink</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR__SINK = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 1;

    /**
     * The number of structural features of the '<em>Data Channel Connector</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_CHANNEL_CONNECTOR_FEATURE_COUNT = org.palladiosimulator.pcm.core.composition.CompositionPackage.CONNECTOR_FEATURE_COUNT
            + 2;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector
     * <em>Supplier Queue Source Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Supplier Queue Source Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector
     * @generated
     */
    EClass getSupplierQueueSourceConnector();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getDataSourceRole
     * <em>Data Source Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Data Source Role</em>'.
     * @see org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getDataSourceRole()
     * @see #getSupplierQueueSourceConnector()
     * @generated
     */
    EReference getSupplierQueueSourceConnector_DataSourceRole();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getAssemblyContext
     * <em>Assembly Context</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Assembly Context</em>'.
     * @see org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getAssemblyContext()
     * @see #getSupplierQueueSourceConnector()
     * @generated
     */
    EReference getSupplierQueueSourceConnector_AssemblyContext();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue
     * <em>Supplier Queue</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Supplier Queue</em>'.
     * @see org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue()
     * @see #getSupplierQueueSourceConnector()
     * @generated
     */
    EReference getSupplierQueueSourceConnector_SupplierQueue();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector
     * <em>Consumer Queue Sink Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Consumer Queue Sink Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector
     * @generated
     */
    EClass getConsumerQueueSinkConnector();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getDataSinkRole
     * <em>Data Sink Role</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Data Sink Role</em>'.
     * @see org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getDataSinkRole()
     * @see #getConsumerQueueSinkConnector()
     * @generated
     */
    EReference getConsumerQueueSinkConnector_DataSinkRole();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getAssemblyContext
     * <em>Assembly Context</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Assembly Context</em>'.
     * @see org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getAssemblyContext()
     * @see #getConsumerQueueSinkConnector()
     * @generated
     */
    EReference getConsumerQueueSinkConnector_AssemblyContext();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue
     * <em>Consumer Queue</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Consumer Queue</em>'.
     * @see org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue()
     * @see #getConsumerQueueSinkConnector()
     * @generated
     */
    EReference getConsumerQueueSinkConnector_ConsumerQueue();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.composition.DataChannelConnector <em>Data Channel
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Data Channel Connector</em>'.
     * @see org.palladiosimulator.indirections.composition.DataChannelConnector
     * @generated
     */
    EClass getDataChannelConnector();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.DataChannelConnector#getSource
     * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.palladiosimulator.indirections.composition.DataChannelConnector#getSource()
     * @see #getDataChannelConnector()
     * @generated
     */
    EReference getDataChannelConnector_Source();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.composition.DataChannelConnector#getSink
     * <em>Sink</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Sink</em>'.
     * @see org.palladiosimulator.indirections.composition.DataChannelConnector#getSink()
     * @see #getDataChannelConnector()
     * @generated
     */
    EReference getDataChannelConnector_Sink();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CompositionFactory getCompositionFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl
         * <em>Supplier Queue Source Connector</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getSupplierQueueSourceConnector()
         * @generated
         */
        EClass SUPPLIER_QUEUE_SOURCE_CONNECTOR = eINSTANCE.getSupplierQueueSourceConnector();

        /**
         * The meta object literal for the '<em><b>Data Source Role</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE = eINSTANCE
                .getSupplierQueueSourceConnector_DataSourceRole();

        /**
         * The meta object literal for the '<em><b>Assembly Context</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT = eINSTANCE
                .getSupplierQueueSourceConnector_AssemblyContext();

        /**
         * The meta object literal for the '<em><b>Supplier Queue</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE = eINSTANCE
                .getSupplierQueueSourceConnector_SupplierQueue();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl
         * <em>Consumer Queue Sink Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getConsumerQueueSinkConnector()
         * @generated
         */
        EClass CONSUMER_QUEUE_SINK_CONNECTOR = eINSTANCE.getConsumerQueueSinkConnector();

        /**
         * The meta object literal for the '<em><b>Data Sink Role</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE = eINSTANCE
                .getConsumerQueueSinkConnector_DataSinkRole();

        /**
         * The meta object literal for the '<em><b>Assembly Context</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT = eINSTANCE
                .getConsumerQueueSinkConnector_AssemblyContext();

        /**
         * The meta object literal for the '<em><b>Consumer Queue</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE = eINSTANCE
                .getConsumerQueueSinkConnector_ConsumerQueue();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl
         * <em>Data Channel Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.composition.impl.DataChannelConnectorImpl
         * @see org.palladiosimulator.indirections.composition.impl.CompositionPackageImpl#getDataChannelConnector()
         * @generated
         */
        EClass DATA_CHANNEL_CONNECTOR = eINSTANCE.getDataChannelConnector();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL_CONNECTOR__SOURCE = eINSTANCE.getDataChannelConnector_Source();

        /**
         * The meta object literal for the '<em><b>Sink</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference DATA_CHANNEL_CONNECTOR__SINK = eINSTANCE.getDataChannelConnector_Sink();

    }

} // CompositionPackage
