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
package org.eclipse.gmt.modisco.omg.kdm.platform.provider;

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
import org.eclipse.gmt.modisco.omg.kdm.platform.util.PlatformAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PlatformItemProviderAdapterFactory extends PlatformAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public PlatformItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformModelItemProvider platformModelItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformModelAdapter() {
		if (platformModelItemProvider == null) {
			platformModelItemProvider = new PlatformModelItemProvider(this);
		}

		return platformModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.ResourceType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTypeItemProvider resourceTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceTypeAdapter() {
		if (resourceTypeItemProvider == null) {
			resourceTypeItemProvider = new ResourceTypeItemProvider(this);
		}

		return resourceTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.NamingResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamingResourceItemProvider namingResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.NamingResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNamingResourceAdapter() {
		if (namingResourceItemProvider == null) {
			namingResourceItemProvider = new NamingResourceItemProvider(this);
		}

		return namingResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.MarshalledResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarshalledResourceItemProvider marshalledResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.MarshalledResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMarshalledResourceAdapter() {
		if (marshalledResourceItemProvider == null) {
			marshalledResourceItemProvider = new MarshalledResourceItemProvider(this);
		}

		return marshalledResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.MessagingResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessagingResourceItemProvider messagingResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.MessagingResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessagingResourceAdapter() {
		if (messagingResourceItemProvider == null) {
			messagingResourceItemProvider = new MessagingResourceItemProvider(this);
		}

		return messagingResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.FileResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileResourceItemProvider fileResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.FileResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileResourceAdapter() {
		if (fileResourceItemProvider == null) {
			fileResourceItemProvider = new FileResourceItemProvider(this);
		}

		return fileResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.ExecutionResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionResourceItemProvider executionResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.ExecutionResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionResourceAdapter() {
		if (executionResourceItemProvider == null) {
			executionResourceItemProvider = new ExecutionResourceItemProvider(this);
		}

		return executionResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.LockResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LockResourceItemProvider lockResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.LockResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLockResourceAdapter() {
		if (lockResourceItemProvider == null) {
			lockResourceItemProvider = new LockResourceItemProvider(this);
		}

		return lockResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.StreamResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamResourceItemProvider streamResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.StreamResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStreamResourceAdapter() {
		if (streamResourceItemProvider == null) {
			streamResourceItemProvider = new StreamResourceItemProvider(this);
		}

		return streamResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.DataManager} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataManagerItemProvider dataManagerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.DataManager}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataManagerAdapter() {
		if (dataManagerItemProvider == null) {
			dataManagerItemProvider = new DataManagerItemProvider(this);
		}

		return dataManagerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformEventItemProvider platformEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformEventAdapter() {
		if (platformEventItemProvider == null) {
			platformEventItemProvider = new PlatformEventItemProvider(this);
		}

		return platformEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformActionItemProvider platformActionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformActionAdapter() {
		if (platformActionItemProvider == null) {
			platformActionItemProvider = new PlatformActionItemProvider(this);
		}

		return platformActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.ExternalActor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalActorItemProvider externalActorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.ExternalActor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExternalActorAdapter() {
		if (externalActorItemProvider == null) {
			externalActorItemProvider = new ExternalActorItemProvider(this);
		}

		return externalActorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.BindsTo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindsToItemProvider bindsToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.BindsTo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBindsToAdapter() {
		if (bindsToItemProvider == null) {
			bindsToItemProvider = new BindsToItemProvider(this);
		}

		return bindsToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Requires} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiresItemProvider requiresItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Requires}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRequiresAdapter() {
		if (requiresItemProvider == null) {
			requiresItemProvider = new RequiresItemProvider(this);
		}

		return requiresItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.ManagesResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagesResourceItemProvider managesResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.ManagesResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createManagesResourceAdapter() {
		if (managesResourceItemProvider == null) {
			managesResourceItemProvider = new ManagesResourceItemProvider(this);
		}

		return managesResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.ReadsResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadsResourceItemProvider readsResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.ReadsResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReadsResourceAdapter() {
		if (readsResourceItemProvider == null) {
			readsResourceItemProvider = new ReadsResourceItemProvider(this);
		}

		return readsResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.WritesResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WritesResourceItemProvider writesResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.WritesResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWritesResourceAdapter() {
		if (writesResourceItemProvider == null) {
			writesResourceItemProvider = new WritesResourceItemProvider(this);
		}

		return writesResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.DefinedBy} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinedByItemProvider definedByItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.DefinedBy}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDefinedByAdapter() {
		if (definedByItemProvider == null) {
			definedByItemProvider = new DefinedByItemProvider(this);
		}

		return definedByItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployedComponentItemProvider deployedComponentItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeployedComponentAdapter() {
		if (deployedComponentItemProvider == null) {
			deployedComponentItemProvider = new DeployedComponentItemProvider(this);
		}

		return deployedComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedSoftwareSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployedSoftwareSystemItemProvider deployedSoftwareSystemItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedSoftwareSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeployedSoftwareSystemAdapter() {
		if (deployedSoftwareSystemItemProvider == null) {
			deployedSoftwareSystemItemProvider = new DeployedSoftwareSystemItemProvider(this);
		}

		return deployedSoftwareSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Machine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineItemProvider machineItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Machine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMachineAdapter() {
		if (machineItemProvider == null) {
			machineItemProvider = new MachineItemProvider(this);
		}

		return machineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployedResourceItemProvider deployedResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.DeployedResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeployedResourceAdapter() {
		if (deployedResourceItemProvider == null) {
			deployedResourceItemProvider = new DeployedResourceItemProvider(this);
		}

		return deployedResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.RuntimeResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimeResourceItemProvider runtimeResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.RuntimeResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRuntimeResourceAdapter() {
		if (runtimeResourceItemProvider == null) {
			runtimeResourceItemProvider = new RuntimeResourceItemProvider(this);
		}

		return runtimeResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Process} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessItemProvider processItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Process}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProcessAdapter() {
		if (processItemProvider == null) {
			processItemProvider = new ProcessItemProvider(this);
		}

		return processItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Thread} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadItemProvider threadItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Thread}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createThreadAdapter() {
		if (threadItemProvider == null) {
			threadItemProvider = new ThreadItemProvider(this);
		}

		return threadItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Loads} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadsItemProvider loadsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Loads}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLoadsAdapter() {
		if (loadsItemProvider == null) {
			loadsItemProvider = new LoadsItemProvider(this);
		}

		return loadsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.Spawns} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpawnsItemProvider spawnsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.Spawns}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSpawnsAdapter() {
		if (spawnsItemProvider == null) {
			spawnsItemProvider = new SpawnsItemProvider(this);
		}

		return spawnsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformElementItemProvider platformElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformElementAdapter() {
		if (platformElementItemProvider == null) {
			platformElementItemProvider = new PlatformElementItemProvider(this);
		}

		return platformElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformRelationshipItemProvider platformRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.gmt.modisco.omg.kdm.platform.PlatformRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformRelationshipAdapter() {
		if (platformRelationshipItemProvider == null) {
			platformRelationshipItemProvider = new PlatformRelationshipItemProvider(this);
		}

		return platformRelationshipItemProvider;
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
		if (platformModelItemProvider != null) platformModelItemProvider.dispose();
		if (resourceTypeItemProvider != null) resourceTypeItemProvider.dispose();
		if (namingResourceItemProvider != null) namingResourceItemProvider.dispose();
		if (marshalledResourceItemProvider != null) marshalledResourceItemProvider.dispose();
		if (messagingResourceItemProvider != null) messagingResourceItemProvider.dispose();
		if (fileResourceItemProvider != null) fileResourceItemProvider.dispose();
		if (executionResourceItemProvider != null) executionResourceItemProvider.dispose();
		if (lockResourceItemProvider != null) lockResourceItemProvider.dispose();
		if (streamResourceItemProvider != null) streamResourceItemProvider.dispose();
		if (dataManagerItemProvider != null) dataManagerItemProvider.dispose();
		if (platformEventItemProvider != null) platformEventItemProvider.dispose();
		if (platformActionItemProvider != null) platformActionItemProvider.dispose();
		if (externalActorItemProvider != null) externalActorItemProvider.dispose();
		if (bindsToItemProvider != null) bindsToItemProvider.dispose();
		if (requiresItemProvider != null) requiresItemProvider.dispose();
		if (managesResourceItemProvider != null) managesResourceItemProvider.dispose();
		if (readsResourceItemProvider != null) readsResourceItemProvider.dispose();
		if (writesResourceItemProvider != null) writesResourceItemProvider.dispose();
		if (definedByItemProvider != null) definedByItemProvider.dispose();
		if (deployedComponentItemProvider != null) deployedComponentItemProvider.dispose();
		if (deployedSoftwareSystemItemProvider != null) deployedSoftwareSystemItemProvider.dispose();
		if (machineItemProvider != null) machineItemProvider.dispose();
		if (deployedResourceItemProvider != null) deployedResourceItemProvider.dispose();
		if (runtimeResourceItemProvider != null) runtimeResourceItemProvider.dispose();
		if (processItemProvider != null) processItemProvider.dispose();
		if (threadItemProvider != null) threadItemProvider.dispose();
		if (loadsItemProvider != null) loadsItemProvider.dispose();
		if (spawnsItemProvider != null) spawnsItemProvider.dispose();
		if (platformElementItemProvider != null) platformElementItemProvider.dispose();
		if (platformRelationshipItemProvider != null) platformRelationshipItemProvider.dispose();
	}

}
