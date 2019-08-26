/**
 */
package org.palladiosimulator.simulizar.indirection.actions.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.palladiosimulator.pcm.parameter.ParameterFactory;

import org.palladiosimulator.pcm.seff.SeffPackage;

import org.palladiosimulator.pcm.seff.provider.AbstractActionItemProvider;

import org.palladiosimulator.simulizar.indirection.actions.ActionsPackage;
import org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction;

/**
 * This is the item provider adapter for a {@link org.palladiosimulator.simulizar.indirection.actions.ConsumeEventAction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConsumeEventActionItemProvider extends AbstractActionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumeEventActionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEventTypePropertyDescriptor(object);
			addSinkRolePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Event Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConsumeEventAction_eventType_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ConsumeEventAction_eventType_feature",
								"_UI_ConsumeEventAction_type"),
						ActionsPackage.Literals.CONSUME_EVENT_ACTION__EVENT_TYPE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Sink Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSinkRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConsumeEventAction_sinkRole_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ConsumeEventAction_sinkRole_feature",
								"_UI_ConsumeEventAction_type"),
						ActionsPackage.Literals.CONSUME_EVENT_ACTION__SINK_ROLE, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION);
			childrenFeatures.add(SeffPackage.Literals.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConsumeEventAction.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConsumeEventAction"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConsumeEventAction) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_ConsumeEventAction_type")
				: getString("_UI_ConsumeEventAction_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConsumeEventAction.class)) {
		case ActionsPackage.CONSUME_EVENT_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
		case ActionsPackage.CONSUME_EVENT_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
						ParameterFactory.eINSTANCE.createVariableUsage()));

		newChildDescriptors.add(
				createChildParameter(SeffPackage.Literals.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION,
						ParameterFactory.eINSTANCE.createVariableUsage()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == SeffPackage.Literals.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION
				|| childFeature == SeffPackage.Literals.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION;

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
