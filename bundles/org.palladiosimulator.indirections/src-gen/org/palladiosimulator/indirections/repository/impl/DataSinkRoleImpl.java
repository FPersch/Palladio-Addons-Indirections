/**
 */
package org.palladiosimulator.indirections.repository.impl;

import org.eclipse.emf.ecore.EClass;

import org.palladiosimulator.indirections.repository.DataSinkRole;
import org.palladiosimulator.indirections.repository.RepositoryPackage;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.impl.ProvidedRoleImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Sink Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl#getEventGroup <em>Event Group</em>}</li>
 *   <li>{@link org.palladiosimulator.indirections.repository.impl.DataSinkRoleImpl#isIsPushing <em>Is Pushing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataSinkRoleImpl extends ProvidedRoleImpl implements DataSinkRole {
	/**
	 * The default value of the '{@link #isIsPushing() <em>Is Pushing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPushing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PUSHING_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSinkRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.DATA_SINK_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventGroup getEventGroup() {
		return (EventGroup) eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGroup basicGetEventGroup() {
		return (EventGroup) eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventGroup(EventGroup newEventGroup) {
		eDynamicSet(RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP,
				RepositoryPackage.Literals.DATA_SINK_ROLE__EVENT_GROUP, newEventGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPushing() {
		return (Boolean) eDynamicGet(RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING,
				RepositoryPackage.Literals.DATA_SINK_ROLE__IS_PUSHING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPushing(boolean newIsPushing) {
		eDynamicSet(RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING, RepositoryPackage.Literals.DATA_SINK_ROLE__IS_PUSHING,
				newIsPushing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
			if (resolve)
				return getEventGroup();
			return basicGetEventGroup();
		case RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING:
			return isIsPushing();
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
		case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
			setEventGroup((EventGroup) newValue);
			return;
		case RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING:
			setIsPushing((Boolean) newValue);
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
		case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
			setEventGroup((EventGroup) null);
			return;
		case RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING:
			setIsPushing(IS_PUSHING_EDEFAULT);
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
		case RepositoryPackage.DATA_SINK_ROLE__EVENT_GROUP:
			return basicGetEventGroup() != null;
		case RepositoryPackage.DATA_SINK_ROLE__IS_PUSHING:
			return isIsPushing() != IS_PUSHING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //DataSinkRoleImpl
