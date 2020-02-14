/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.pcm.core.entity.EntityPackage;

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
 * @see org.palladiosimulator.indirections.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "system";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://palladiosimulator.org/Indirections/System/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "org.palladiosimulator.indirections.system";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    SystemPackage eINSTANCE = org.palladiosimulator.indirections.system.impl.SystemPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl <em>Consumer
     * Queue</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl
     * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getConsumerQueue()
     * @generated
     */
    int CONSUMER_QUEUE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Capacity</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__CAPACITY = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__SOURCE_EVENT_GROUP = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Sink Event Group</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__SINK_EVENT_GROUP = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Incoming Queue Connector</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR = EntityPackage.ENTITY_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Sink Connector</b></em>' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__SINK_CONNECTOR = EntityPackage.ENTITY_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Partitioning</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__PARTITIONING = EntityPackage.ENTITY_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Time Grouping</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__TIME_GROUPING = EntityPackage.ENTITY_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Joins</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__JOINS = EntityPackage.ENTITY_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Outgoing Distribution</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__OUTGOING_DISTRIBUTION = EntityPackage.ENTITY_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Scheduling</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__SCHEDULING = EntityPackage.ENTITY_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Put Policy</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE__PUT_POLICY = EntityPackage.ENTITY_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Consumer Queue</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSUMER_QUEUE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 11;

    /**
     * The meta object id for the
     * '{@link org.palladiosimulator.indirections.system.impl.SupplierQueueImpl <em>Supplier
     * Queue</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.palladiosimulator.indirections.system.impl.SupplierQueueImpl
     * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getSupplierQueue()
     * @generated
     */
    int SUPPLIER_QUEUE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Source Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE__SOURCE_EVENT_GROUP = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source Connector</b></em>' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE__SOURCE_CONNECTOR = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Outgoing Queue Connector</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Supplier Queue</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SUPPLIER_QUEUE_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue <em>Consumer Queue</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Consumer Queue</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue
     * @generated
     */
    EClass getConsumerQueue();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getCapacity
     * <em>Capacity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Capacity</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getCapacity()
     * @see #getConsumerQueue()
     * @generated
     */
    EAttribute getConsumerQueue_Capacity();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSourceEventGroup
     * <em>Source Event Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Source Event Group</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getSourceEventGroup()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_SourceEventGroup();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkEventGroup <em>Sink
     * Event Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Sink Event Group</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getSinkEventGroup()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_SinkEventGroup();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getIncomingQueueConnector
     * <em>Incoming Queue Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Incoming Queue Connector</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getIncomingQueueConnector()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_IncomingQueueConnector();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkConnector <em>Sink
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Sink Connector</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getSinkConnector()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_SinkConnector();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPartitioning
     * <em>Partitioning</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Partitioning</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getPartitioning()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_Partitioning();

    /**
     * Returns the meta object for the containment reference
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getTimeGrouping <em>Time
     * Grouping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Time Grouping</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getTimeGrouping()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_TimeGrouping();

    /**
     * Returns the meta object for the containment reference list
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getJoins <em>Joins</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Joins</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getJoins()
     * @see #getConsumerQueue()
     * @generated
     */
    EReference getConsumerQueue_Joins();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getOutgoingDistribution
     * <em>Outgoing Distribution</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Outgoing Distribution</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getOutgoingDistribution()
     * @see #getConsumerQueue()
     * @generated
     */
    EAttribute getConsumerQueue_OutgoingDistribution();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getScheduling
     * <em>Scheduling</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Scheduling</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getScheduling()
     * @see #getConsumerQueue()
     * @generated
     */
    EAttribute getConsumerQueue_Scheduling();

    /**
     * Returns the meta object for the attribute
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPutPolicy <em>Put
     * Policy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Put Policy</em>'.
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getPutPolicy()
     * @see #getConsumerQueue()
     * @generated
     */
    EAttribute getConsumerQueue_PutPolicy();

    /**
     * Returns the meta object for class
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue <em>Supplier Queue</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Supplier Queue</em>'.
     * @see org.palladiosimulator.indirections.system.SupplierQueue
     * @generated
     */
    EClass getSupplierQueue();

    /**
     * Returns the meta object for the reference
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceEventGroup
     * <em>Source Event Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Source Event Group</em>'.
     * @see org.palladiosimulator.indirections.system.SupplierQueue#getSourceEventGroup()
     * @see #getSupplierQueue()
     * @generated
     */
    EReference getSupplierQueue_SourceEventGroup();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceConnector <em>Source
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Source Connector</em>'.
     * @see org.palladiosimulator.indirections.system.SupplierQueue#getSourceConnector()
     * @see #getSupplierQueue()
     * @generated
     */
    EReference getSupplierQueue_SourceConnector();

    /**
     * Returns the meta object for the reference list
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue#getOutgoingQueueConnector
     * <em>Outgoing Queue Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Outgoing Queue Connector</em>'.
     * @see org.palladiosimulator.indirections.system.SupplierQueue#getOutgoingQueueConnector()
     * @see #getSupplierQueue()
     * @generated
     */
    EReference getSupplierQueue_OutgoingQueueConnector();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SystemFactory getSystemFactory();

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
         * '{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl <em>Consumer
         * Queue</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl
         * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getConsumerQueue()
         * @generated
         */
        EClass CONSUMER_QUEUE = eINSTANCE.getConsumerQueue();

        /**
         * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSUMER_QUEUE__CAPACITY = eINSTANCE.getConsumerQueue_Capacity();

        /**
         * The meta object literal for the '<em><b>Source Event Group</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__SOURCE_EVENT_GROUP = eINSTANCE.getConsumerQueue_SourceEventGroup();

        /**
         * The meta object literal for the '<em><b>Sink Event Group</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__SINK_EVENT_GROUP = eINSTANCE.getConsumerQueue_SinkEventGroup();

        /**
         * The meta object literal for the '<em><b>Incoming Queue Connector</b></em>' reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR = eINSTANCE.getConsumerQueue_IncomingQueueConnector();

        /**
         * The meta object literal for the '<em><b>Sink Connector</b></em>' reference list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__SINK_CONNECTOR = eINSTANCE.getConsumerQueue_SinkConnector();

        /**
         * The meta object literal for the '<em><b>Partitioning</b></em>' containment reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__PARTITIONING = eINSTANCE.getConsumerQueue_Partitioning();

        /**
         * The meta object literal for the '<em><b>Time Grouping</b></em>' containment reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__TIME_GROUPING = eINSTANCE.getConsumerQueue_TimeGrouping();

        /**
         * The meta object literal for the '<em><b>Joins</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSUMER_QUEUE__JOINS = eINSTANCE.getConsumerQueue_Joins();

        /**
         * The meta object literal for the '<em><b>Outgoing Distribution</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSUMER_QUEUE__OUTGOING_DISTRIBUTION = eINSTANCE.getConsumerQueue_OutgoingDistribution();

        /**
         * The meta object literal for the '<em><b>Scheduling</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSUMER_QUEUE__SCHEDULING = eINSTANCE.getConsumerQueue_Scheduling();

        /**
         * The meta object literal for the '<em><b>Put Policy</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSUMER_QUEUE__PUT_POLICY = eINSTANCE.getConsumerQueue_PutPolicy();

        /**
         * The meta object literal for the
         * '{@link org.palladiosimulator.indirections.system.impl.SupplierQueueImpl <em>Supplier
         * Queue</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.palladiosimulator.indirections.system.impl.SupplierQueueImpl
         * @see org.palladiosimulator.indirections.system.impl.SystemPackageImpl#getSupplierQueue()
         * @generated
         */
        EClass SUPPLIER_QUEUE = eINSTANCE.getSupplierQueue();

        /**
         * The meta object literal for the '<em><b>Source Event Group</b></em>' reference feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SUPPLIER_QUEUE__SOURCE_EVENT_GROUP = eINSTANCE.getSupplierQueue_SourceEventGroup();

        /**
         * The meta object literal for the '<em><b>Source Connector</b></em>' reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SUPPLIER_QUEUE__SOURCE_CONNECTOR = eINSTANCE.getSupplierQueue_SourceConnector();

        /**
         * The meta object literal for the '<em><b>Outgoing Queue Connector</b></em>' reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR = eINSTANCE.getSupplierQueue_OutgoingQueueConnector();

    }

} // SystemPackage
