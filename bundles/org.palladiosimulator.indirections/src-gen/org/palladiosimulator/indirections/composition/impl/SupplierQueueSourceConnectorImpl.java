/**
 */
package org.palladiosimulator.indirections.composition.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.impl.ConnectorImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Supplier Queue Source
 * Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl#getDataSourceRole
 * <em>Data Source Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl#getAssemblyContext
 * <em>Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.impl.SupplierQueueSourceConnectorImpl#getSupplierQueue
 * <em>Supplier Queue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupplierQueueSourceConnectorImpl extends ConnectorImpl implements SupplierQueueSourceConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SupplierQueueSourceConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataSourceRole getDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DataSourceRole basicGetDataSourceRole() {
        return (DataSourceRole) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataSourceRole(final DataSourceRole newDataSourceRole) {
        this.eDynamicSet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE, newDataSourceRole);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext() {
        return (AssemblyContext) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAssemblyContext(final AssemblyContext newAssemblyContext) {
        this.eDynamicSet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT, newAssemblyContext);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SupplierQueue getSupplierQueue() {
        return (SupplierQueue) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SupplierQueue basicGetSupplierQueue() {
        return (SupplierQueue) this.eDynamicGet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSupplierQueue(final SupplierQueue newSupplierQueue, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newSupplierQueue,
                CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSupplierQueue(final SupplierQueue newSupplierQueue) {
        this.eDynamicSet(CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE,
                CompositionPackage.Literals.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE, newSupplierQueue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            final SupplierQueue supplierQueue = this.basicGetSupplierQueue();
            if (supplierQueue != null) {
                msgs = ((InternalEObject) supplierQueue).eInverseRemove(this,
                        SystemPackage.SUPPLIER_QUEUE__SOURCE_CONNECTOR, SupplierQueue.class, msgs);
            }
            return this.basicSetSupplierQueue((SupplierQueue) otherEnd, msgs);
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
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            return this.basicSetSupplierQueue(null, msgs);
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
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
            if (resolve) {
                return this.getDataSourceRole();
            }
            return this.basicGetDataSourceRole();
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getAssemblyContext();
            }
            return this.basicGetAssemblyContext();
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            if (resolve) {
                return this.getSupplierQueue();
            }
            return this.basicGetSupplierQueue();
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
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) newValue);
            return;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) newValue);
            return;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            this.setSupplierQueue((SupplierQueue) newValue);
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
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
            this.setDataSourceRole((DataSourceRole) null);
            return;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
            this.setAssemblyContext((AssemblyContext) null);
            return;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            this.setSupplierQueue((SupplierQueue) null);
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
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__DATA_SOURCE_ROLE:
            return this.basicGetDataSourceRole() != null;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT:
            return this.basicGetAssemblyContext() != null;
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR__SUPPLIER_QUEUE:
            return this.basicGetSupplierQueue() != null;
        }
        return super.eIsSet(featureID);
    }

} // SupplierQueueSourceConnectorImpl
