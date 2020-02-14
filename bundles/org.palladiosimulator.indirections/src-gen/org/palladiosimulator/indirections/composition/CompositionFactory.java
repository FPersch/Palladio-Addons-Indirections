/**
 */
package org.palladiosimulator.indirections.composition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public interface CompositionFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    CompositionFactory eINSTANCE = org.palladiosimulator.indirections.composition.impl.CompositionFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Supplier Queue Source Connector</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Supplier Queue Source Connector</em>'.
     * @generated
     */
    SupplierQueueSourceConnector createSupplierQueueSourceConnector();

    /**
     * Returns a new object of class '<em>Consumer Queue Sink Connector</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Consumer Queue Sink Connector</em>'.
     * @generated
     */
    ConsumerQueueSinkConnector createConsumerQueueSinkConnector();

    /**
     * Returns a new object of class '<em>Queue Connector</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Queue Connector</em>'.
     * @generated
     */
    QueueConnector createQueueConnector();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    CompositionPackage getCompositionPackage();

} // CompositionFactory
