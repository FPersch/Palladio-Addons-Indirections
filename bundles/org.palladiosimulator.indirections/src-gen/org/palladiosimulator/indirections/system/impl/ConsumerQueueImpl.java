/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.datatypes.OutgoingDistribution;
import org.palladiosimulator.indirections.datatypes.PutPolicy;
import org.palladiosimulator.indirections.datatypes.Scheduling;
import org.palladiosimulator.indirections.partitioning.Joining;
import org.palladiosimulator.indirections.partitioning.Partitioning;
import org.palladiosimulator.indirections.partitioning.TimeGrouping;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Consumer Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getCapacity
 * <em>Capacity</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getSourceEventGroup
 * <em>Source Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getSinkEventGroup
 * <em>Sink Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getIncomingQueueConnector
 * <em>Incoming Queue Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getSinkConnector
 * <em>Sink Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getPartitioning
 * <em>Partitioning</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getTimeGrouping
 * <em>Time Grouping</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getJoins
 * <em>Joins</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getOutgoingDistribution
 * <em>Outgoing Distribution</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getScheduling
 * <em>Scheduling</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.ConsumerQueueImpl#getPutPolicy <em>Put
 * Policy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumerQueueImpl extends EntityImpl implements ConsumerQueue {
    /**
     * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCapacity()
     * @generated
     * @ordered
     */
    protected static final int CAPACITY_EDEFAULT = -1;

    /**
     * The default value of the '{@link #getOutgoingDistribution() <em>Outgoing Distribution</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOutgoingDistribution()
     * @generated
     * @ordered
     */
    protected static final OutgoingDistribution OUTGOING_DISTRIBUTION_EDEFAULT = OutgoingDistribution.BROADCAST;

    /**
     * The default value of the '{@link #getScheduling() <em>Scheduling</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getScheduling()
     * @generated
     * @ordered
     */
    protected static final Scheduling SCHEDULING_EDEFAULT = Scheduling.FIRST_IN_FIRST_OUT;

    /**
     * The default value of the '{@link #getPutPolicy() <em>Put Policy</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPutPolicy()
     * @generated
     * @ordered
     */
    protected static final PutPolicy PUT_POLICY_EDEFAULT = PutPolicy.BLOCKING;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConsumerQueueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.CONSUMER_QUEUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getCapacity() {
        return (Integer) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__CAPACITY,
                SystemPackage.Literals.CONSUMER_QUEUE__CAPACITY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCapacity(final int newCapacity) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__CAPACITY, SystemPackage.Literals.CONSUMER_QUEUE__CAPACITY,
                newCapacity);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getSourceEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SOURCE_EVENT_GROUP, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventGroup basicGetSourceEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SOURCE_EVENT_GROUP, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceEventGroup(final EventGroup newSourceEventGroup) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SOURCE_EVENT_GROUP, newSourceEventGroup);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getSinkEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SINK_EVENT_GROUP, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventGroup basicGetSinkEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SINK_EVENT_GROUP, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSinkEventGroup(final EventGroup newSinkEventGroup) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP,
                SystemPackage.Literals.CONSUMER_QUEUE__SINK_EVENT_GROUP, newSinkEventGroup);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<QueueConnector> getIncomingQueueConnector() {
        return (EList<QueueConnector>) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR,
                SystemPackage.Literals.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ConsumerQueueSinkConnector> getSinkConnector() {
        return (EList<ConsumerQueueSinkConnector>) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR,
                SystemPackage.Literals.CONSUMER_QUEUE__SINK_CONNECTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Partitioning getPartitioning() {
        return (Partitioning) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__PARTITIONING,
                SystemPackage.Literals.CONSUMER_QUEUE__PARTITIONING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPartitioning(final Partitioning newPartitioning, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newPartitioning, SystemPackage.CONSUMER_QUEUE__PARTITIONING,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPartitioning(final Partitioning newPartitioning) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__PARTITIONING,
                SystemPackage.Literals.CONSUMER_QUEUE__PARTITIONING, newPartitioning);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TimeGrouping getTimeGrouping() {
        return (TimeGrouping) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__TIME_GROUPING,
                SystemPackage.Literals.CONSUMER_QUEUE__TIME_GROUPING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTimeGrouping(final TimeGrouping newTimeGrouping, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newTimeGrouping, SystemPackage.CONSUMER_QUEUE__TIME_GROUPING,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTimeGrouping(final TimeGrouping newTimeGrouping) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__TIME_GROUPING,
                SystemPackage.Literals.CONSUMER_QUEUE__TIME_GROUPING, newTimeGrouping);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<Joining> getJoins() {
        return (EList<Joining>) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__JOINS,
                SystemPackage.Literals.CONSUMER_QUEUE__JOINS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OutgoingDistribution getOutgoingDistribution() {
        return (OutgoingDistribution) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION,
                SystemPackage.Literals.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOutgoingDistribution(final OutgoingDistribution newOutgoingDistribution) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION,
                SystemPackage.Literals.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION, newOutgoingDistribution);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Scheduling getScheduling() {
        return (Scheduling) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__SCHEDULING,
                SystemPackage.Literals.CONSUMER_QUEUE__SCHEDULING, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setScheduling(final Scheduling newScheduling) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__SCHEDULING, SystemPackage.Literals.CONSUMER_QUEUE__SCHEDULING,
                newScheduling);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PutPolicy getPutPolicy() {
        return (PutPolicy) this.eDynamicGet(SystemPackage.CONSUMER_QUEUE__PUT_POLICY,
                SystemPackage.Literals.CONSUMER_QUEUE__PUT_POLICY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPutPolicy(final PutPolicy newPutPolicy) {
        this.eDynamicSet(SystemPackage.CONSUMER_QUEUE__PUT_POLICY, SystemPackage.Literals.CONSUMER_QUEUE__PUT_POLICY,
                newPutPolicy);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getIncomingQueueConnector())
                    .basicAdd(otherEnd, msgs);
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getSinkConnector()).basicAdd(otherEnd,
                    msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            return ((InternalEList<?>) this.getIncomingQueueConnector()).basicRemove(otherEnd, msgs);
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            return ((InternalEList<?>) this.getSinkConnector()).basicRemove(otherEnd, msgs);
        case SystemPackage.CONSUMER_QUEUE__PARTITIONING:
            return this.basicSetPartitioning(null, msgs);
        case SystemPackage.CONSUMER_QUEUE__TIME_GROUPING:
            return this.basicSetTimeGrouping(null, msgs);
        case SystemPackage.CONSUMER_QUEUE__JOINS:
            return ((InternalEList<?>) this.getJoins()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__CAPACITY:
            return this.getCapacity();
        case SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP:
            if (resolve) {
                return this.getSourceEventGroup();
            }
            return this.basicGetSourceEventGroup();
        case SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP:
            if (resolve) {
                return this.getSinkEventGroup();
            }
            return this.basicGetSinkEventGroup();
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            return this.getIncomingQueueConnector();
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            return this.getSinkConnector();
        case SystemPackage.CONSUMER_QUEUE__PARTITIONING:
            return this.getPartitioning();
        case SystemPackage.CONSUMER_QUEUE__TIME_GROUPING:
            return this.getTimeGrouping();
        case SystemPackage.CONSUMER_QUEUE__JOINS:
            return this.getJoins();
        case SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION:
            return this.getOutgoingDistribution();
        case SystemPackage.CONSUMER_QUEUE__SCHEDULING:
            return this.getScheduling();
        case SystemPackage.CONSUMER_QUEUE__PUT_POLICY:
            return this.getPutPolicy();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__CAPACITY:
            this.setCapacity((Integer) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP:
            this.setSourceEventGroup((EventGroup) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP:
            this.setSinkEventGroup((EventGroup) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            this.getIncomingQueueConnector().clear();
            this.getIncomingQueueConnector().addAll((Collection<? extends QueueConnector>) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            this.getSinkConnector().clear();
            this.getSinkConnector().addAll((Collection<? extends ConsumerQueueSinkConnector>) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__PARTITIONING:
            this.setPartitioning((Partitioning) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__TIME_GROUPING:
            this.setTimeGrouping((TimeGrouping) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__JOINS:
            this.getJoins().clear();
            this.getJoins().addAll((Collection<? extends Joining>) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION:
            this.setOutgoingDistribution((OutgoingDistribution) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__SCHEDULING:
            this.setScheduling((Scheduling) newValue);
            return;
        case SystemPackage.CONSUMER_QUEUE__PUT_POLICY:
            this.setPutPolicy((PutPolicy) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__CAPACITY:
            this.setCapacity(CAPACITY_EDEFAULT);
            return;
        case SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP:
            this.setSourceEventGroup((EventGroup) null);
            return;
        case SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP:
            this.setSinkEventGroup((EventGroup) null);
            return;
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            this.getIncomingQueueConnector().clear();
            return;
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            this.getSinkConnector().clear();
            return;
        case SystemPackage.CONSUMER_QUEUE__PARTITIONING:
            this.setPartitioning((Partitioning) null);
            return;
        case SystemPackage.CONSUMER_QUEUE__TIME_GROUPING:
            this.setTimeGrouping((TimeGrouping) null);
            return;
        case SystemPackage.CONSUMER_QUEUE__JOINS:
            this.getJoins().clear();
            return;
        case SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION:
            this.setOutgoingDistribution(OUTGOING_DISTRIBUTION_EDEFAULT);
            return;
        case SystemPackage.CONSUMER_QUEUE__SCHEDULING:
            this.setScheduling(SCHEDULING_EDEFAULT);
            return;
        case SystemPackage.CONSUMER_QUEUE__PUT_POLICY:
            this.setPutPolicy(PUT_POLICY_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SystemPackage.CONSUMER_QUEUE__CAPACITY:
            return this.getCapacity() != CAPACITY_EDEFAULT;
        case SystemPackage.CONSUMER_QUEUE__SOURCE_EVENT_GROUP:
            return this.basicGetSourceEventGroup() != null;
        case SystemPackage.CONSUMER_QUEUE__SINK_EVENT_GROUP:
            return this.basicGetSinkEventGroup() != null;
        case SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR:
            return !this.getIncomingQueueConnector().isEmpty();
        case SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR:
            return !this.getSinkConnector().isEmpty();
        case SystemPackage.CONSUMER_QUEUE__PARTITIONING:
            return this.getPartitioning() != null;
        case SystemPackage.CONSUMER_QUEUE__TIME_GROUPING:
            return this.getTimeGrouping() != null;
        case SystemPackage.CONSUMER_QUEUE__JOINS:
            return !this.getJoins().isEmpty();
        case SystemPackage.CONSUMER_QUEUE__OUTGOING_DISTRIBUTION:
            return this.getOutgoingDistribution() != OUTGOING_DISTRIBUTION_EDEFAULT;
        case SystemPackage.CONSUMER_QUEUE__SCHEDULING:
            return this.getScheduling() != SCHEDULING_EDEFAULT;
        case SystemPackage.CONSUMER_QUEUE__PUT_POLICY:
            return this.getPutPolicy() != PUT_POLICY_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} // ConsumerQueueImpl
