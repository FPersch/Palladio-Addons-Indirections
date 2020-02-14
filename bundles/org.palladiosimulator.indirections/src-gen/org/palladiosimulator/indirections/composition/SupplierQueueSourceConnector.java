/**
 */
package org.palladiosimulator.indirections.composition;

import org.palladiosimulator.indirections.repository.DataSourceRole;
import org.palladiosimulator.indirections.system.SupplierQueue;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Supplier Queue Source
 * Connector</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getDataSourceRole
 * <em>Data Source Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getAssemblyContext
 * <em>Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue
 * <em>Supplier Queue</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getSupplierQueueSourceConnector()
 * @model
 * @generated
 */
public interface SupplierQueueSourceConnector extends Connector {
    /**
     * Returns the value of the '<em><b>Data Source Role</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Source Role</em>' reference.
     * @see #setDataSourceRole(DataSourceRole)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getSupplierQueueSourceConnector_DataSourceRole()
     * @model required="true" ordered="false"
     * @generated
     */
    DataSourceRole getDataSourceRole();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getDataSourceRole
     * <em>Data Source Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Data Source Role</em>' reference.
     * @see #getDataSourceRole()
     * @generated
     */
    void setDataSourceRole(DataSourceRole value);

    /**
     * Returns the value of the '<em><b>Assembly Context</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Assembly Context</em>' reference.
     * @see #setAssemblyContext(AssemblyContext)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getSupplierQueueSourceConnector_AssemblyContext()
     * @model required="true" ordered="false"
     * @generated
     */
    AssemblyContext getAssemblyContext();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getAssemblyContext
     * <em>Assembly Context</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Assembly Context</em>' reference.
     * @see #getAssemblyContext()
     * @generated
     */
    void setAssemblyContext(AssemblyContext value);

    /**
     * Returns the value of the '<em><b>Supplier Queue</b></em>' reference. It is bidirectional and
     * its opposite is
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceConnector <em>Source
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Supplier Queue</em>' reference.
     * @see #setSupplierQueue(SupplierQueue)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getSupplierQueueSourceConnector_SupplierQueue()
     * @see org.palladiosimulator.indirections.system.SupplierQueue#getSourceConnector
     * @model opposite="sourceConnector" required="true" ordered="false"
     * @generated
     */
    SupplierQueue getSupplierQueue();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue
     * <em>Supplier Queue</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Supplier Queue</em>' reference.
     * @see #getSupplierQueue()
     * @generated
     */
    void setSupplierQueue(SupplierQueue value);

} // SupplierQueueSourceConnector
