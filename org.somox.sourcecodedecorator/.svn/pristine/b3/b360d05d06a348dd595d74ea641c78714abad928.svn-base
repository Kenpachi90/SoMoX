/**
 */
package org.somox.sourcecodedecorator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.ControlFlowLevelSourceCodeLink;
import org.somox.sourcecodedecorator.FileLevelSourceCodeLink;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage
 * @generated
 */
public class SourceCodeDecoratorAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static SourceCodeDecoratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceCodeDecoratorAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SourceCodeDecoratorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected SourceCodeDecoratorSwitch<Adapter> modelSwitch = new SourceCodeDecoratorSwitch<Adapter>() {
        @Override
        public Adapter caseFileLevelSourceCodeLink(final FileLevelSourceCodeLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createFileLevelSourceCodeLinkAdapter();
        }

        @Override
        public Adapter caseMethodLevelSourceCodeLink(final MethodLevelSourceCodeLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createMethodLevelSourceCodeLinkAdapter();
        }

        @Override
        public Adapter caseControlFlowLevelSourceCodeLink(final ControlFlowLevelSourceCodeLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createControlFlowLevelSourceCodeLinkAdapter();
        }

        @Override
        public Adapter caseSourceCodeDecoratorRepository(final SourceCodeDecoratorRepository object) {
            return SourceCodeDecoratorAdapterFactory.this.createSourceCodeDecoratorRepositoryAdapter();
        }

        @Override
        public Adapter caseInterfaceSourceCodeLink(final InterfaceSourceCodeLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createInterfaceSourceCodeLinkAdapter();
        }

        @Override
        public Adapter caseComponentImplementingClassesLink(final ComponentImplementingClassesLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createComponentImplementingClassesLinkAdapter();
        }

        @Override
        public Adapter casePCMSystemImplementatingClassesLink(final PCMSystemImplementatingClassesLink object) {
            return SourceCodeDecoratorAdapterFactory.this.createPCMSystemImplementatingClassesLinkAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return SourceCodeDecoratorAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.FileLevelSourceCodeLink
     * <em>File Level Source Code Link</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.FileLevelSourceCodeLink
     * @generated
     */
    public Adapter createFileLevelSourceCodeLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.MethodLevelSourceCodeLink
     * <em>Method Level Source Code Link</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.MethodLevelSourceCodeLink
     * @generated
     */
    public Adapter createMethodLevelSourceCodeLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.ControlFlowLevelSourceCodeLink
     * <em>Control Flow Level Source Code Link</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.ControlFlowLevelSourceCodeLink
     * @generated
     */
    public Adapter createControlFlowLevelSourceCodeLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.SourceCodeDecoratorRepository <em>Repository</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorRepository
     * @generated
     */
    public Adapter createSourceCodeDecoratorRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.InterfaceSourceCodeLink
     * <em>Interface Source Code Link</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.InterfaceSourceCodeLink
     * @generated
     */
    public Adapter createInterfaceSourceCodeLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.ComponentImplementingClassesLink
     * <em>Component Implementing Classes Link</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.ComponentImplementingClassesLink
     * @generated
     */
    public Adapter createComponentImplementingClassesLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink
     * <em>PCM System Implementating Classes Link</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink
     * @generated
     */
    public Adapter createPCMSystemImplementatingClassesLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // SourceCodeDecoratorAdapterFactory
