/**
 */
package org.palladiosimulator.indirections.system;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.repository.EventGroup;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Supplier Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceEventGroup <em>Source
 * Event Group</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceConnector <em>Source
 * Connector</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.system.SupplierQueue#getOutgoingQueueConnector
 * <em>Outgoing Queue Connector</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.system.SystemPackage#getSupplierQueue()
 * @model
 * @generated
 */
public interface SupplierQueue extends Entity {
    /**
     * Returns the value of the '<em><b>Source Event Group</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Event Group</em>' reference.
     * @see #setSourceEventGroup(EventGroup)
     * @see org.palladiosimulator.indirections.system.SystemPackage#getSupplierQueue_SourceEventGroup()
     * @model required="true"
     * @generated
     */
    EventGroup getSourceEventGroup();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.system.SupplierQueue#getSourceEventGroup
     * <em>Source Event Group</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source Event Group</em>' reference.
     * @see #getSourceEventGroup()
     * @generated
     */
    void setSourceEventGroup(EventGroup value);

    /**
     * Returns the value of the '<em><b>Source Connector</b></em>' reference list. The list contents
     * are of type
     * {@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector}. It is
     * bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue
     * <em>Supplier Queue</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getSupplierQueue_SourceConnector()
     * @see org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector#getSupplierQueue
     * @model opposite="supplierQueue" ordered="false"
     * @generated
     */
    EList<SupplierQueueSourceConnector> getSourceConnector();

    /**
     * Returns the value of the '<em><b>Outgoing Queue Connector</b></em>' reference list. The list
     * contents are of type {@link org.palladiosimulator.indirections.composition.QueueConnector}.
     * It is bidirectional and its opposite is
     * '{@link org.palladiosimulator.indirections.composition.QueueConnector#getSource
     * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Outgoing Queue Connector</em>' reference list.
     * @see org.palladiosimulator.indirections.system.SystemPackage#getSupplierQueue_OutgoingQueueConnector()
     * @see org.palladiosimulator.indirections.composition.QueueConnector#getSource
     * @model opposite="source"
     * @generated
     */
    EList<QueueConnector> getOutgoingQueueConnector();

} // SupplierQueue
