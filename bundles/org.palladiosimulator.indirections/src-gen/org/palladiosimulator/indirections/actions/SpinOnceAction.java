/**
 */
package org.palladiosimulator.indirections.actions;

import org.palladiosimulator.indirections.repository.DataRole;

import org.palladiosimulator.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spin Once Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.SpinOnceAction#getDataRole <em>Data Role</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getSpinOnceAction()
 * @model
 * @generated
 */
public interface SpinOnceAction extends AbstractAction {
	/**
	 * Returns the value of the '<em><b>Data Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Role</em>' reference.
	 * @see #setDataRole(DataRole)
	 * @see org.palladiosimulator.indirections.actions.ActionsPackage#getSpinOnceAction_DataRole()
	 * @model required="true"
	 * @generated
	 */
	DataRole getDataRole();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.indirections.actions.SpinOnceAction#getDataRole <em>Data Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Role</em>' reference.
	 * @see #getDataRole()
	 * @generated
	 */
	void setDataRole(DataRole value);

} // SpinOnceAction
