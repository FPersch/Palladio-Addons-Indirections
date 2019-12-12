/**
 */
package org.palladiosimulator.indirections.system.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.indirections.partitioning.PartitioningFactory;
import org.palladiosimulator.indirections.system.DataChannel;
import org.palladiosimulator.indirections.system.SystemPackage;
import org.palladiosimulator.pcm.core.composition.provider.EventChannelItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.indirections.system.DataChannel} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DataChannelItemProvider extends EventChannelItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DataChannelItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addCapacityPropertyDescriptor(object);
            this.addSourceEventGroupPropertyDescriptor(object);
            this.addSinkEventGroupPropertyDescriptor(object);
            this.addDataChannelSourceConnectorPropertyDescriptor(object);
            this.addDataChannelSinkConnectorPropertyDescriptor(object);
            this.addOutgoingDistributionPropertyDescriptor(object);
            this.addSchedulingPropertyDescriptor(object);
            this.addPutPolicyPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Capacity feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addCapacityPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_capacity_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_capacity_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__CAPACITY, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Source Event Group feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSourceEventGroupPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_sourceEventGroup_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_sourceEventGroup_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__SOURCE_EVENT_GROUP, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Sink Event Group feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSinkEventGroupPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_sinkEventGroup_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_sinkEventGroup_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__SINK_EVENT_GROUP, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Data Channel Source Connector feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataChannelSourceConnectorPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_dataChannelSourceConnector_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_DataChannel_dataChannelSourceConnector_feature", "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SOURCE_CONNECTOR, true, false, true, null, null,
                null));
    }

    /**
     * This adds a property descriptor for the Data Channel Sink Connector feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataChannelSinkConnectorPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_dataChannelSinkConnector_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_dataChannelSinkConnector_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__DATA_CHANNEL_SINK_CONNECTOR, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Outgoing Distribution feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addOutgoingDistributionPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_outgoingDistribution_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_outgoingDistribution_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__OUTGOING_DISTRIBUTION, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Scheduling feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addSchedulingPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_scheduling_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_scheduling_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__SCHEDULING, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Put Policy feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addPutPolicyPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannel_putPolicy_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannel_putPolicy_feature",
                        "_UI_DataChannel_type"),
                SystemPackage.Literals.DATA_CHANNEL__PUT_POLICY, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(SystemPackage.Literals.DATA_CHANNEL__PARTITIONING);
            this.childrenFeatures.add(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING);
            this.childrenFeatures.add(SystemPackage.Literals.DATA_CHANNEL__JOINS);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns DataChannel.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/DataChannel"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((DataChannel) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_DataChannel_type")
                : this.getString("_UI_DataChannel_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(DataChannel.class)) {
        case SystemPackage.DATA_CHANNEL__CAPACITY:
        case SystemPackage.DATA_CHANNEL__OUTGOING_DISTRIBUTION:
        case SystemPackage.DATA_CHANNEL__SCHEDULING:
        case SystemPackage.DATA_CHANNEL__PUT_POLICY:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case SystemPackage.DATA_CHANNEL__PARTITIONING:
        case SystemPackage.DATA_CHANNEL__TIME_GROUPING:
        case SystemPackage.DATA_CHANNEL__JOINS:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(SystemPackage.Literals.DATA_CHANNEL__PARTITIONING,
                PartitioningFactory.eINSTANCE.createPartitioning()));

        newChildDescriptors.add(this.createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
                PartitioningFactory.eINSTANCE.createWindowing()));

        newChildDescriptors.add(this.createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
                PartitioningFactory.eINSTANCE.createConsumeAllAvailable()));

        newChildDescriptors.add(this.createChildParameter(SystemPackage.Literals.DATA_CHANNEL__TIME_GROUPING,
                PartitioningFactory.eINSTANCE.createCollectWithHoldback()));

        newChildDescriptors.add(this.createChildParameter(SystemPackage.Literals.DATA_CHANNEL__JOINS,
                PartitioningFactory.eINSTANCE.createJoining()));
    }

}
