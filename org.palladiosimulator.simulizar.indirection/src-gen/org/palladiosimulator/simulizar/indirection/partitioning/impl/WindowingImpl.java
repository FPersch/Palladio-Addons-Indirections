/**
 */
package org.palladiosimulator.simulizar.indirection.partitioning.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.simulizar.indirection.partitioning.PartitioningPackage;
import org.palladiosimulator.simulizar.indirection.partitioning.Windowing;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Windowing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.partitioning.impl.WindowingImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.palladiosimulator.simulizar.indirection.partitioning.impl.WindowingImpl#getShift <em>Shift</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WindowingImpl extends CDOObjectImpl implements Windowing {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getShift() <em>Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShift()
	 * @generated
	 * @ordered
	 */
	protected static final double SHIFT_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.WINDOWING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSize() {
		return (Double) eDynamicGet(PartitioningPackage.WINDOWING__SIZE, PartitioningPackage.Literals.WINDOWING__SIZE,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(double newSize) {
		eDynamicSet(PartitioningPackage.WINDOWING__SIZE, PartitioningPackage.Literals.WINDOWING__SIZE, newSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getShift() {
		return (Double) eDynamicGet(PartitioningPackage.WINDOWING__SHIFT, PartitioningPackage.Literals.WINDOWING__SHIFT,
				true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShift(double newShift) {
		eDynamicSet(PartitioningPackage.WINDOWING__SHIFT, PartitioningPackage.Literals.WINDOWING__SHIFT, newShift);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PartitioningPackage.WINDOWING__SIZE:
			return getSize();
		case PartitioningPackage.WINDOWING__SHIFT:
			return getShift();
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
		case PartitioningPackage.WINDOWING__SIZE:
			setSize((Double) newValue);
			return;
		case PartitioningPackage.WINDOWING__SHIFT:
			setShift((Double) newValue);
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
		case PartitioningPackage.WINDOWING__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case PartitioningPackage.WINDOWING__SHIFT:
			setShift(SHIFT_EDEFAULT);
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
		case PartitioningPackage.WINDOWING__SIZE:
			return getSize() != SIZE_EDEFAULT;
		case PartitioningPackage.WINDOWING__SHIFT:
			return getShift() != SHIFT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //WindowingImpl
