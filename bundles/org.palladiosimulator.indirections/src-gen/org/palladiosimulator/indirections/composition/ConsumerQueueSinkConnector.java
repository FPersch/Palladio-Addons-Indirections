/**
 */
package org.palladiosimulator.indirections.composition;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.system.ConsumerQueue;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Consumer Queue Sink
 * Connector</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getDataSinkRole
 * <em>Data Sink Role</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getAssemblyContext
 * <em>Assembly Context</em>}</li>
 * <li>{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue
 * <em>Consumer Queue</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.composition.CompositionPackage#getConsumerQueueSinkConnector()
 * @model
 * @generated
 */
public interface ConsumerQueueSinkConnector extends Connector {
    /**
     * Returns the value of the '<em><b>Data Sink Role</b></em>' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Sink Role</em>' reference.
     * @see #setDataSinkRole(DataSinkRole)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getConsumerQueueSinkConnector_DataSinkRole()
     * @model required="true" ordered="false"
     * @generated
     */
    DataSinkRole getDataSinkRole();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getDataSinkRole
     * <em>Data Sink Role</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Data Sink Role</em>' reference.
     * @see #getDataSinkRole()
     * @generated
     */
    void setDataSinkRole(DataSinkRole value);

    /**
     * Returns the value of the '<em><b>Assembly Context</b></em>' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Assembly Context</em>' reference.
     * @see #setAssemblyContext(AssemblyContext)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getConsumerQueueSinkConnector_AssemblyContext()
     * @model required="true" ordered="false"
     * @generated
     */
    AssemblyContext getAssemblyContext();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getAssemblyContext
     * <em>Assembly Context</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Assembly Context</em>' reference.
     * @see #getAssemblyContext()
     * @generated
     */
    void setAssemblyContext(AssemblyContext value);

    /**
     * Returns the value of the '<em><b>Consumer Queue</b></em>' reference. It is bidirectional and
     * its opposite is
     * '{@link org.palladiosimulator.indirections.system.ConsumerQueue#getSinkConnector <em>Sink
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Consumer Queue</em>' reference.
     * @see #setConsumerQueue(ConsumerQueue)
     * @see org.palladiosimulator.indirections.composition.CompositionPackage#getConsumerQueueSinkConnector_ConsumerQueue()
     * @see org.palladiosimulator.indirections.system.ConsumerQueue#getSinkConnector
     * @model opposite="sinkConnector" required="true" ordered="false"
     * @generated
     */
    ConsumerQueue getConsumerQueue();

    /**
     * Sets the value of the
     * '{@link org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector#getConsumerQueue
     * <em>Consumer Queue</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Consumer Queue</em>' reference.
     * @see #getConsumerQueue()
     * @generated
     */
    void setConsumerQueue(ConsumerQueue value);

} // ConsumerQueueSinkConnector
