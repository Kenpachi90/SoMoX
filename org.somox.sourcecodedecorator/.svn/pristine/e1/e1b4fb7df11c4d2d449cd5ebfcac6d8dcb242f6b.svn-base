/**
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.ControlFlowLevelSourceCodeLink;
import org.somox.sourcecodedecorator.FileLevelSourceCodeLink;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorFactory;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceCodeDecoratorFactoryImpl extends EFactoryImpl implements SourceCodeDecoratorFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static SourceCodeDecoratorFactory init() {
        try {
            final SourceCodeDecoratorFactory theSourceCodeDecoratorFactory = (SourceCodeDecoratorFactory) EPackage.Registry.INSTANCE
                    .getEFactory(SourceCodeDecoratorPackage.eNS_URI);
            if (theSourceCodeDecoratorFactory != null) {
                return theSourceCodeDecoratorFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SourceCodeDecoratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceCodeDecoratorFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK:
            return this.createFileLevelSourceCodeLink();
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK:
            return this.createMethodLevelSourceCodeLink();
        case SourceCodeDecoratorPackage.CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK:
            return this.createControlFlowLevelSourceCodeLink();
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY:
            return this.createSourceCodeDecoratorRepository();
        case SourceCodeDecoratorPackage.INTERFACE_SOURCE_CODE_LINK:
            return this.createInterfaceSourceCodeLink();
        case SourceCodeDecoratorPackage.COMPONENT_IMPLEMENTING_CLASSES_LINK:
            return this.createComponentImplementingClassesLink();
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK:
            return this.createPCMSystemImplementatingClassesLink();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FileLevelSourceCodeLink createFileLevelSourceCodeLink() {
        final FileLevelSourceCodeLinkImpl fileLevelSourceCodeLink = new FileLevelSourceCodeLinkImpl();
        return fileLevelSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public MethodLevelSourceCodeLink createMethodLevelSourceCodeLink() {
        final MethodLevelSourceCodeLinkImpl methodLevelSourceCodeLink = new MethodLevelSourceCodeLinkImpl();
        return methodLevelSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ControlFlowLevelSourceCodeLink createControlFlowLevelSourceCodeLink() {
        final ControlFlowLevelSourceCodeLinkImpl controlFlowLevelSourceCodeLink = new ControlFlowLevelSourceCodeLinkImpl();
        return controlFlowLevelSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceCodeDecoratorRepository createSourceCodeDecoratorRepository() {
        final SourceCodeDecoratorRepositoryImpl sourceCodeDecoratorRepository = new SourceCodeDecoratorRepositoryImpl();
        return sourceCodeDecoratorRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InterfaceSourceCodeLink createInterfaceSourceCodeLink() {
        final InterfaceSourceCodeLinkImpl interfaceSourceCodeLink = new InterfaceSourceCodeLinkImpl();
        return interfaceSourceCodeLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComponentImplementingClassesLink createComponentImplementingClassesLink() {
        final ComponentImplementingClassesLinkImpl componentImplementingClassesLink = new ComponentImplementingClassesLinkImpl();
        return componentImplementingClassesLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMSystemImplementatingClassesLink createPCMSystemImplementatingClassesLink() {
        final PCMSystemImplementatingClassesLinkImpl pcmSystemImplementatingClassesLink = new PCMSystemImplementatingClassesLinkImpl();
        return pcmSystemImplementatingClassesLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceCodeDecoratorPackage getSourceCodeDecoratorPackage() {
        return (SourceCodeDecoratorPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SourceCodeDecoratorPackage getPackage() {
        return SourceCodeDecoratorPackage.eINSTANCE;
    }

} // SourceCodeDecoratorFactoryImpl
