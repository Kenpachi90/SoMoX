/**
 * 
 * Copyright (c) 2009 Hatha Systems.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nikolai Mansourov (Hatha Systems) - initial API and implementation
 *     Gabriel Barbier (Mia-Software) - minor evolutions for version 1.1
 */
package org.eclipse.gmt.modisco.omg.kdm.ui.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.gmt.modisco.omg.kdm.ui.util.UiAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UiItemProviderAdapterFactory extends UiAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIResourceItemProvider uiResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIResourceAdapter() {
		if (uiResourceItemProvider == null) {
			uiResourceItemProvider = new UIResourceItemProvider(this);
		}

		return uiResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIDisplay} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIDisplayItemProvider uiDisplayItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIDisplay}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIDisplayAdapter() {
		if (uiDisplayItemProvider == null) {
			uiDisplayItemProvider = new UIDisplayItemProvider(this);
		}

		return uiDisplayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.Screen} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScreenItemProvider screenItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.Screen}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScreenAdapter() {
		if (screenItemProvider == null) {
			screenItemProvider = new ScreenItemProvider(this);
		}

		return screenItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.Report} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReportItemProvider reportItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.Report}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReportAdapter() {
		if (reportItemProvider == null) {
			reportItemProvider = new ReportItemProvider(this);
		}

		return reportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIModelItemProvider uiModelItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIModelAdapter() {
		if (uiModelItemProvider == null) {
			uiModelItemProvider = new UIModelItemProvider(this);
		}

		return uiModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UILayout} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UILayoutItemProvider uiLayoutItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UILayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUILayoutAdapter() {
		if (uiLayoutItemProvider == null) {
			uiLayoutItemProvider = new UILayoutItemProvider(this);
		}

		return uiLayoutItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIField} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIFieldItemProvider uiFieldItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIField}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIFieldAdapter() {
		if (uiFieldItemProvider == null) {
			uiFieldItemProvider = new UIFieldItemProvider(this);
		}

		return uiFieldItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.DisplaysImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplaysImageItemProvider displaysImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.DisplaysImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDisplaysImageAdapter() {
		if (displaysImageItemProvider == null) {
			displaysImageItemProvider = new DisplaysImageItemProvider(this);
		}

		return displaysImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.Displays} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplaysItemProvider displaysItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.Displays}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDisplaysAdapter() {
		if (displaysItemProvider == null) {
			displaysItemProvider = new DisplaysItemProvider(this);
		}

		return displaysItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIFlowItemProvider uiFlowItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIFlowAdapter() {
		if (uiFlowItemProvider == null) {
			uiFlowItemProvider = new UIFlowItemProvider(this);
		}

		return uiFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIElementItemProvider uiElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIElementAdapter() {
		if (uiElementItemProvider == null) {
			uiElementItemProvider = new UIElementItemProvider(this);
		}

		return uiElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIRelationshipItemProvider uiRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIRelationshipAdapter() {
		if (uiRelationshipItemProvider == null) {
			uiRelationshipItemProvider = new UIRelationshipItemProvider(this);
		}

		return uiRelationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIActionItemProvider uiActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIActionAdapter() {
		if (uiActionItemProvider == null) {
			uiActionItemProvider = new UIActionItemProvider(this);
		}

		return uiActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIEventItemProvider uiEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.UIEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUIEventAdapter() {
		if (uiEventItemProvider == null) {
			uiEventItemProvider = new UIEventItemProvider(this);
		}

		return uiEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.ReadsUI} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadsUIItemProvider readsUIItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.ReadsUI}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReadsUIAdapter() {
		if (readsUIItemProvider == null) {
			readsUIItemProvider = new ReadsUIItemProvider(this);
		}

		return readsUIItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.WritesUI} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WritesUIItemProvider writesUIItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.WritesUI}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWritesUIAdapter() {
		if (writesUIItemProvider == null) {
			writesUIItemProvider = new WritesUIItemProvider(this);
		}

		return writesUIItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.ui.ManagesUI} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagesUIItemProvider managesUIItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.ui.ManagesUI}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createManagesUIAdapter() {
		if (managesUIItemProvider == null) {
			managesUIItemProvider = new ManagesUIItemProvider(this);
		}

		return managesUIItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (uiResourceItemProvider != null) uiResourceItemProvider.dispose();
		if (uiDisplayItemProvider != null) uiDisplayItemProvider.dispose();
		if (screenItemProvider != null) screenItemProvider.dispose();
		if (reportItemProvider != null) reportItemProvider.dispose();
		if (uiModelItemProvider != null) uiModelItemProvider.dispose();
		if (uiLayoutItemProvider != null) uiLayoutItemProvider.dispose();
		if (uiFieldItemProvider != null) uiFieldItemProvider.dispose();
		if (displaysImageItemProvider != null) displaysImageItemProvider.dispose();
		if (displaysItemProvider != null) displaysItemProvider.dispose();
		if (uiFlowItemProvider != null) uiFlowItemProvider.dispose();
		if (uiElementItemProvider != null) uiElementItemProvider.dispose();
		if (uiRelationshipItemProvider != null) uiRelationshipItemProvider.dispose();
		if (uiActionItemProvider != null) uiActionItemProvider.dispose();
		if (uiEventItemProvider != null) uiEventItemProvider.dispose();
		if (readsUIItemProvider != null) readsUIItemProvider.dispose();
		if (writesUIItemProvider != null) writesUIItemProvider.dispose();
		if (managesUIItemProvider != null) managesUIItemProvider.dispose();
	}

}
