/**
 */
package org.palladiosimulator.indirections.composition.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.ConsumerQueueSinkConnector;
import org.palladiosimulator.indirections.composition.QueueConnector;
import org.palladiosimulator.indirections.composition.SupplierQueueSourceConnector;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.indirections.composition.CompositionPackage
 * @generated
 */
public class CompositionSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static CompositionPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CompositionSwitch() {
        if (modelPackage == null) {
            modelPackage = CompositionPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case CompositionPackage.SUPPLIER_QUEUE_SOURCE_CONNECTOR: {
            final SupplierQueueSourceConnector supplierQueueSourceConnector = (SupplierQueueSourceConnector) theEObject;
            T result = this.caseSupplierQueueSourceConnector(supplierQueueSourceConnector);
            if (result == null) {
                result = this.caseConnector(supplierQueueSourceConnector);
            }
            if (result == null) {
                result = this.caseEntity(supplierQueueSourceConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(supplierQueueSourceConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(supplierQueueSourceConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case CompositionPackage.CONSUMER_QUEUE_SINK_CONNECTOR: {
            final ConsumerQueueSinkConnector consumerQueueSinkConnector = (ConsumerQueueSinkConnector) theEObject;
            T result = this.caseConsumerQueueSinkConnector(consumerQueueSinkConnector);
            if (result == null) {
                result = this.caseConnector(consumerQueueSinkConnector);
            }
            if (result == null) {
                result = this.caseEntity(consumerQueueSinkConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(consumerQueueSinkConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(consumerQueueSinkConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case CompositionPackage.QUEUE_CONNECTOR: {
            final QueueConnector queueConnector = (QueueConnector) theEObject;
            T result = this.caseQueueConnector(queueConnector);
            if (result == null) {
                result = this.caseConnector(queueConnector);
            }
            if (result == null) {
                result = this.caseEntity(queueConnector);
            }
            if (result == null) {
                result = this.caseIdentifier(queueConnector);
            }
            if (result == null) {
                result = this.caseNamedElement(queueConnector);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Supplier Queue Source
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Supplier Queue Source
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSupplierQueueSourceConnector(final SupplierQueueSourceConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumer Queue Sink
     * Connector</em>'. <!-- begin-user-doc --> This implementation returns null; returning a
     * non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumer Queue Sink
     *         Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConsumerQueueSinkConnector(final ConsumerQueueSinkConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Queue Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Queue Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueueConnector(final QueueConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(final NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(final Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connector</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnector(final Connector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // CompositionSwitch
