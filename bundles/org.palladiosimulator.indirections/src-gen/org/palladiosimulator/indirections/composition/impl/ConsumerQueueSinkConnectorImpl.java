/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Consumer Queue Sink
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl#getAssemblyContext
 * <em>Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.ConsumerQueueSinkConnectorImpl#getConsumerQueue
 * <em>Consumer Queue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsumerQueueSinkConnectorImpl extends ConnectorImpl implements ConsumerQueueSinkConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConsumerQueueSinkConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataSinkRole getDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataSinkRole basicGetDataSinkRole() {
        return (DataSinkRole) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataSinkRole(final DataSinkRole newDataSinkRole) {
        this.eDynamicSet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE, newDataSinkRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext(final AssemblyContext newAssemblyContext) {
        this.eDynamicSet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT, newAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConsumerQueue getConsumerQueue() {
        return (ConsumerQueue) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ConsumerQueue basicGetConsumerQueue() {
        return (ConsumerQueue) this.eDynamicGet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetConsumerQueue(final ConsumerQueue newConsumerQueue, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newConsumerQueue,
                CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setConsumerQueue(final ConsumerQueue newConsumerQueue) {
        this.eDynamicSet(CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE,
                CompositionPackage.Literals.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE, newConsumerQueue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            final ConsumerQueue consumerQueue = this.basicGetConsumerQueue();
            if (consumerQueue != null) {
                msgs = ((InternalEObject) consumerQueue).eInverseRemove(this,
                        SystemPackage.CONSUMER_QUEUE__SINK_CONNECTOR, ConsumerQueue.class, msgs);
            }
            return this.basicSetConsumerQueue((ConsumerQueue) otherEnd, msgs);
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
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            return this.basicSetConsumerQueue(null, msgs);
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
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE:
            if (resolve) {
                return this.getDataSinkRole();
            }
            return this.basicGetDataSinkRole();
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getAssemblyContext();
            }
            return this.basicGetAssemblyContext();
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            if (resolve) {
                return this.getConsumerQueue();
            }
            return this.basicGetConsumerQueue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) newValue);
            return;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) newValue);
            return;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            this.setConsumerQueue((ConsumerQueue) newValue);
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
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE:
            this.setDataSinkRole((DataSinkRole) null);
            return;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) null);
            return;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            this.setConsumerQueue((ConsumerQueue) null);
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
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__DATA_SINK_ROLE:
            return this.basicGetDataSinkRole() != null;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__ASSEMBLY_CONTEXT:
            return this.basicGetAssemblyContext() != null;
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR__CONSUMER_QUEUE:
            return this.basicGetConsumerQueue() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConsumerQueueSinkConnectorImpl
