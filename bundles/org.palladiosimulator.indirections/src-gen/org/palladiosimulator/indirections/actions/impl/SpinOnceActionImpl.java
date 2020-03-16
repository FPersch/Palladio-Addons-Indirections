/**
 */
package org.palladiosimulator.indirections.actions.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.actions.ActionsPackage;
import org.palladiosimulator.indirections.actions.SpinOnceAction;

import org.palladiosimulator.indirections.repository.DataRole;

import org.palladiosimulator.pcm.seff.impl.AbstractActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spin Once Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.actions.impl.SpinOnceActionImpl#getDataRole <em>Data Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpinOnceActionImpl extends AbstractActionImpl implements SpinOnceAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpinOnceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.SPIN_ONCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataRole getDataRole() {
		return (DataRole) eDynamicGet(ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE,
				ActionsPackage.Literals.SPIN_ONCE_ACTION__DATA_ROLE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataRole basicGetDataRole() {
		return (DataRole) eDynamicGet(ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE,
				ActionsPackage.Literals.SPIN_ONCE_ACTION__DATA_ROLE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataRole(DataRole newDataRole) {
		eDynamicSet(ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE, ActionsPackage.Literals.SPIN_ONCE_ACTION__DATA_ROLE,
				newDataRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE:
			if (resolve)
				return getDataRole();
			return basicGetDataRole();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE:
			setDataRole((DataRole) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE:
			setDataRole((DataRole) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActionsPackage.SPIN_ONCE_ACTION__DATA_ROLE:
			return basicGetDataRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //SpinOnceActionImpl
