/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Queue Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.QueueConnectorImpl#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.QueueConnectorImpl#getSink
 * <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueueConnectorImpl extends ConnectorImpl implements QueueConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected QueueConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.QUEUE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SupplierQueue getSource() {
        return (SupplierQueue) this.eDynamicGet(CompositionPackage.QUEUE_CONNECTOR__SOURCE,
                CompositionPackage.Literals.QUEUE_CONNECTOR__SOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SupplierQueue basicGetSource() {
        return (SupplierQueue) this.eDynamicGet(CompositionPackage.QUEUE_CONNECTOR__SOURCE,
                CompositionPackage.Literals.QUEUE_CONNECTOR__SOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSource(final SupplierQueue newSource, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newSource, CompositionPackage.QUEUE_CONNECTOR__SOURCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSource(final SupplierQueue newSource) {
        this.eDynamicSet(CompositionPackage.QUEUE_CONNECTOR__SOURCE,
                CompositionPackage.Literals.QUEUE_CONNECTOR__SOURCE, newSource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConsumerQueue getSink() {
        return (ConsumerQueue) this.eDynamicGet(CompositionPackage.QUEUE_CONNECTOR__SINK,
                CompositionPackage.Literals.QUEUE_CONNECTOR__SINK, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ConsumerQueue basicGetSink() {
        return (ConsumerQueue) this.eDynamicGet(CompositionPackage.QUEUE_CONNECTOR__SINK,
                CompositionPackage.Literals.QUEUE_CONNECTOR__SINK, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSink(final ConsumerQueue newSink, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newSink, CompositionPackage.QUEUE_CONNECTOR__SINK, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSink(final ConsumerQueue newSink) {
        this.eDynamicSet(CompositionPackage.QUEUE_CONNECTOR__SINK, CompositionPackage.Literals.QUEUE_CONNECTOR__SINK,
                newSink);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            final SupplierQueue source = this.basicGetSource();
            if (source != null) {
                msgs = ((InternalEObject) source).eInverseRemove(this,
                        SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR, SupplierQueue.class, msgs);
            }
            return this.basicSetSource((SupplierQueue) otherEnd, msgs);
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            final ConsumerQueue sink = this.basicGetSink();
            if (sink != null) {
                msgs = ((InternalEObject) sink).eInverseRemove(this,
                        SystemPackage.CONSUMER_QUEUE__INCOMING_QUEUE_CONNECTOR, ConsumerQueue.class, msgs);
            }
            return this.basicSetSink((ConsumerQueue) otherEnd, msgs);
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
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            return this.basicSetSource(null, msgs);
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            return this.basicSetSink(null, msgs);
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
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            if (resolve) {
                return this.getSource();
            }
            return this.basicGetSource();
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            if (resolve) {
                return this.getSink();
            }
            return this.basicGetSink();
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
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            this.setSource((SupplierQueue) newValue);
            return;
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            this.setSink((ConsumerQueue) newValue);
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
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            this.setSource((SupplierQueue) null);
            return;
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            this.setSink((ConsumerQueue) null);
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
        case CompositionPackage.QUEUE_CONNECTOR__SOURCE:
            return this.basicGetSource() != null;
        case CompositionPackage.QUEUE_CONNECTOR__SINK:
            return this.basicGetSink() != null;
        }
        return super.eIsSet(featureID);
    }

} // QueueConnectorImpl
