/**
 */
package org.palladiosimulator.indirections.system.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Supplier Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.impl.SupplierQueueImpl#getSourceEventGroup
 * <em>Source Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.SupplierQueueImpl#getSourceConnector
 * <em>Source Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.impl.SupplierQueueImpl#getOutgoingQueueConnector
 * <em>Outgoing Queue Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupplierQueueImpl extends EntityImpl implements SupplierQueue {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SupplierQueueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SystemPackage.Literals.SUPPLIER_QUEUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getSourceEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventGroup basicGetSourceEventGroup() {
        return (EventGroup) this.eDynamicGet(SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceEventGroup(final EventGroup newSourceEventGroup) {
        this.eDynamicSet(SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP,
                SystemPackage.Literals.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP, newSourceEventGroup);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<SupplierQueueSourceConnector> getSourceConnector() {
        return (EList<SupplierQueueSourceConnector>) this.eDynamicGet(SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR,
                SystemPackage.Literals.SUPPLIER_QUEUE__SOURCE_CONNECTOR, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<QueueConnector> getOutgoingQueueConnector() {
        return (EList<QueueConnector>) this.eDynamicGet(SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR,
                SystemPackage.Literals.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR, true, true);
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getSourceConnector()).basicAdd(otherEnd,
                    msgs);
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getOutgoingQueueConnector())
                    .basicAdd(otherEnd, msgs);
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            return ((InternalEList<?>) this.getSourceConnector()).basicRemove(otherEnd, msgs);
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            return ((InternalEList<?>) this.getOutgoingQueueConnector()).basicRemove(otherEnd, msgs);
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP:
            if (resolve) {
                return this.getSourceEventGroup();
            }
            return this.basicGetSourceEventGroup();
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            return this.getSourceConnector();
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            return this.getOutgoingQueueConnector();
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP:
            this.setSourceEventGroup((EventGroup) newValue);
            return;
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            this.getSourceConnector().clear();
            this.getSourceConnector().addAll((Collection<? extends SupplierQueueSourceConnector>) newValue);
            return;
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            this.getOutgoingQueueConnector().clear();
            this.getOutgoingQueueConnector().addAll((Collection<? extends QueueConnector>) newValue);
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP:
            this.setSourceEventGroup((EventGroup) null);
            return;
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            this.getSourceConnector().clear();
            return;
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            this.getOutgoingQueueConnector().clear();
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
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_EVENT_GROUP:
            return this.basicGetSourceEventGroup() != null;
        case SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR:
            return !this.getSourceConnector().isEmpty();
        case SystemPackage.SUPPLIER_QUEUE__OUTGOING_QUEUE_CONNECTOR:
            return !this.getOutgoingQueueConnector().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // SupplierQueueImpl
