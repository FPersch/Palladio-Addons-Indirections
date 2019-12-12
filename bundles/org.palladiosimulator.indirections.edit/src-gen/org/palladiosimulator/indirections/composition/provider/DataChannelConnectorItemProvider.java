/**
 */
package org.palladiosimulator.indirections.composition.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.indirections.composition.CompositionPackage;
import org.palladiosimulator.indirections.composition.DataChannelConnector;
import org.palladiosimulator.pcm.core.composition.provider.ConnectorItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.indirections.composition.DataChannelConnector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DataChannelConnectorItemProvider extends ConnectorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public DataChannelConnectorItemProvider(final AdapterFactory adapterFactory) {
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

            this.addSourcePropertyDescriptor(object);
            this.addSinkPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Source feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addSourcePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannelConnector_source_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannelConnector_source_feature",
                        "_UI_DataChannelConnector_type"),
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SOURCE, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Sink feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addSinkPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_DataChannelConnector_sink_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_DataChannelConnector_sink_feature",
                        "_UI_DataChannelConnector_type"),
                CompositionPackage.Literals.DATA_CHANNEL_CONNECTOR__SINK, true, false, true, null, null, null));
    }

    /**
     * This returns DataChannelConnector.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/DataChannelConnector"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((DataChannelConnector) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_DataChannelConnector_type")
                : this.getString("_UI_DataChannelConnector_type") + " " + label;
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
    }

}
