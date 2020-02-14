/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Consumer Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getCapacity
 * <em>Capacity</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSourceEventGroup <em>Source
 * Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkEventGroup <em>Sink
 * Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getIncomingQueueConnector
 * <em>Incoming Queue Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkConnector <em>Sink
 * Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPartitioning
 * <em>Partitioning</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getTimeGrouping <em>Time
 * Grouping</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getJoins <em>Joins</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getOutgoingDistribution
 * <em>Outgoing Distribution</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getScheduling
 * <em>Scheduling</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPutPolicy <em>Put
 * Policy</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue()
 * @model
 * @generated
 */
public interface ConsumerQueue extends Entity {
    /**
     * Returns the value of the '<em><b>Capacity</b></em>' attribute. The default value is
     * <code>"-1"</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Capacity</em>' attribute.
     * @see #setCapacity(int)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_Capacity()
     * @model default="-1" required="true" transient="true"
     * @generated
     */
    int getCapacity();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getCapacity
     * <em>Capacity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Capacity</em>' attribute.
     * @see #getCapacity()
     * @generated
     */
    void setCapacity(int value);

    /**
     * Returns the value of the '<em><b>Source Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Event Group</em>' reference.
     * @see #setSourceEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_SourceEventGroup()
     * @model required="true"
     * @generated
     */
    EventGroup getSourceEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSourceEventGroup
     * <em>Source Event Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source Event Group</em>' reference.
     * @see #getSourceEventGroup()
     * @generated
     */
    void setSourceEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Sink Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Sink Event Group</em>' reference.
     * @see #setSinkEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_SinkEventGroup()
     * @model required="true"
     * @generated
     */
    EventGroup getSinkEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkEventGroup <em>Sink
     * Event Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Sink Event Group</em>' reference.
     * @see #getSinkEventGroup()
     * @generated
     */
    void setSinkEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Incoming Queue Connector</b></em>' reference list. The list
     * contents are of type {@link org.palladiosimulator.indirections.composition.QueueConnector}.
     * It is bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.QueueConnector#getSink
     * <em>Sink</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Incoming Queue Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_IncomingQueueConnector()
     * @see org.palladiosimulator.indirections.composition.QueueConnector#getSink
     * @model opposite="sink"
     * @generated
     */
    EList<QueueConnector> getIncomingQueueConnector();

    /**
     * Returns the value of the '<em><b>Sink Connector</b></em>' reference list. The list contents
     * are of type
     * {@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector}. It is
     * bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue
     * <em>Consumer Queue</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Sink Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_SinkConnector()
     * @see org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue
     * @model opposite="consumerQueue" ordered="false"
     * @generated
     */
    EList<ConsumerQueueSinkConnector> getSinkConnector();

    /**
     * Returns the value of the '<em><b>Partitioning</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Partitioning</em>' containment reference.
     * @see #setPartitioning(Partitioning)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_Partitioning()
     * @model containment="true"
     * @generated
     */
    Partitioning getPartitioning();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPartitioning
     * <em>Partitioning</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Partitioning</em>' containment reference.
     * @see #getPartitioning()
     * @generated
     */
    void setPartitioning(Partitioning value);

    /**
     * Returns the value of the '<em><b>Time Grouping</b></em>' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Time Grouping</em>' containment reference.
     * @see #setTimeGrouping(TimeGrouping)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_TimeGrouping()
     * @model containment="true"
     * @generated
     */
    TimeGrouping getTimeGrouping();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getTimeGrouping <em>Time
     * Grouping</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Time Grouping</em>' containment reference.
     * @see #getTimeGrouping()
     * @generated
     */
    void setTimeGrouping(TimeGrouping value);

    /**
     * Returns the value of the '<em><b>Joins</b></em>' containment reference list. The list
     * contents are of type {@link org.palladiosimulator.indirections.partitioning.Joining}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Joins</em>' containment reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_Joins()
     * @model containment="true"
     * @generated
     */
    EList<Joining> getJoins();

    /**
     * Returns the value of the '<em><b>Outgoing Distribution</b></em>' attribute. The literals are
     * from the enumeration
     * {@link org.palladiosimulator.indirections.datatypes.OutgoingDistribution}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Outgoing Distribution</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @see #setOutgoingDistribution(OutgoingDistribution)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_OutgoingDistribution()
     * @model
     * @generated
     */
    OutgoingDistribution getOutgoingDistribution();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getOutgoingDistribution
     * <em>Outgoing Distribution</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Outgoing Distribution</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.OutgoingDistribution
     * @see #getOutgoingDistribution()
     * @generated
     */
    void setOutgoingDistribution(OutgoingDistribution value);

    /**
     * Returns the value of the '<em><b>Scheduling</b></em>' attribute. The literals are from the
     * enumeration {@link org.palladiosimulator.indirections.datatypes.Scheduling}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Scheduling</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @see #setScheduling(Scheduling)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_Scheduling()
     * @model
     * @generated
     */
    Scheduling getScheduling();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getScheduling
     * <em>Scheduling</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Scheduling</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.Scheduling
     * @see #getScheduling()
     * @generated
     */
    void setScheduling(Scheduling value);

    /**
     * Returns the value of the '<em><b>Put Policy</b></em>' attribute. The literals are from the
     * enumeration {@link org.palladiosimulator.indirections.datatypes.PutPolicy}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Put Policy</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @see #setPutPolicy(PutPolicy)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getConsumerQueue_PutPolicy()
     * @model
     * @generated
     */
    PutPolicy getPutPolicy();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getPutPolicy <em>Put
     * Policy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Put Policy</em>' attribute.
     * @see org.palladiosimulator.indirections.datatypes.PutPolicy
     * @see #getPutPolicy()
     * @generated
     */
    void setPutPolicy(PutPolicy value);

} // ConsumerQueue
