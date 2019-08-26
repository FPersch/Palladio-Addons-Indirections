/**
 */
package org.palladiosimulator.simulizar.indirection.partitioning.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.simulizar.indirection.partitioning.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartitioningFactoryImpl extends EFactoryImpl implements PartitioningFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PartitioningFactory init() {
		try {
			PartitioningFactory thePartitioningFactory = (PartitioningFactory) EPackage.Registry.INSTANCE
					.getEFactory(PartitioningPackage.eNS_URI);
			if (thePartitioningFactory != null) {
				return thePartitioningFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PartitioningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case PartitioningPackage.PARTITIONING:
			return createPartitioning();
		case PartitioningPackage.WINDOWING:
			return createWindowing();
		case PartitioningPackage.CONSUME_ALL_AVAILABLE:
			return createConsumeAllAvailable();
		case PartitioningPackage.COLLECT_WITH_HOLDBACK:
			return createCollectWithHoldback();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Partitioning createPartitioning() {
		PartitioningImpl partitioning = new PartitioningImpl();
		return partitioning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Windowing createWindowing() {
		WindowingImpl windowing = new WindowingImpl();
		return windowing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsumeAllAvailable createConsumeAllAvailable() {
		ConsumeAllAvailableImpl consumeAllAvailable = new ConsumeAllAvailableImpl();
		return consumeAllAvailable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectWithHoldback createCollectWithHoldback() {
		CollectWithHoldbackImpl collectWithHoldback = new CollectWithHoldbackImpl();
		return collectWithHoldback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartitioningPackage getPartitioningPackage() {
		return (PartitioningPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PartitioningPackage getPackage() {
		return PartitioningPackage.eINSTANCE;
	}

} //PartitioningFactoryImpl
