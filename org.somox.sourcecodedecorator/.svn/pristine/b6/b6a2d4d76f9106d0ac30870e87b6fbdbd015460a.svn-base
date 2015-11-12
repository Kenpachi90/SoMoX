/**
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionPackage;
import org.eclipse.gmt.modisco.omg.kdm.build.BuildPackage;
import org.eclipse.gmt.modisco.omg.kdm.code.CodePackage;
import org.eclipse.gmt.modisco.omg.kdm.conceptual.ConceptualPackage;
import org.eclipse.gmt.modisco.omg.kdm.core.CorePackage;
import org.eclipse.gmt.modisco.omg.kdm.data.DataPackage;
import org.eclipse.gmt.modisco.omg.kdm.event.EventPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.platform.PlatformPackage;
import org.eclipse.gmt.modisco.omg.kdm.source.SourcePackage;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructurePackage;
import org.eclipse.gmt.modisco.omg.kdm.ui.UiPackage;
import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.system.SystemPackage;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceCodeDecoratorPackageImpl extends EPackageImpl implements SourceCodeDecoratorPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass fileLevelSourceCodeLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass methodLevelSourceCodeLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass controlFlowLevelSourceCodeLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass sourceCodeDecoratorRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass interfaceSourceCodeLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentImplementingClassesLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pcmSystemImplementatingClassesLinkEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SourceCodeDecoratorPackageImpl() {
        super(eNS_URI, SourceCodeDecoratorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link SourceCodeDecoratorPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SourceCodeDecoratorPackage init() {
        if (isInited) {
            return (SourceCodeDecoratorPackage) EPackage.Registry.INSTANCE
                    .getEPackage(SourceCodeDecoratorPackage.eNS_URI);
        }

        // Obtain or create and register package
        final SourceCodeDecoratorPackageImpl theSourceCodeDecoratorPackage = (SourceCodeDecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof SourceCodeDecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new SourceCodeDecoratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        JavaPackage.eINSTANCE.eClass();
        CorePackage.eINSTANCE.eClass();
        KdmPackage.eINSTANCE.eClass();
        SourcePackage.eINSTANCE.eClass();
        CodePackage.eINSTANCE.eClass();
        ActionPackage.eINSTANCE.eClass();
        PlatformPackage.eINSTANCE.eClass();
        BuildPackage.eINSTANCE.eClass();
        ConceptualPackage.eINSTANCE.eClass();
        DataPackage.eINSTANCE.eClass();
        EventPackage.eINSTANCE.eClass();
        StructurePackage.eINSTANCE.eClass();
        UiPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theSourceCodeDecoratorPackage.createPackageContents();

        // Initialize created meta-data
        theSourceCodeDecoratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSourceCodeDecoratorPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SourceCodeDecoratorPackage.eNS_URI, theSourceCodeDecoratorPackage);
        return theSourceCodeDecoratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getFileLevelSourceCodeLink() {
        return this.fileLevelSourceCodeLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getFileLevelSourceCodeLink_RepositoryComponent() {
        return (EReference) this.fileLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getFileLevelSourceCodeLink_File() {
        return (EReference) this.fileLevelSourceCodeLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMethodLevelSourceCodeLink() {
        return this.methodLevelSourceCodeLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMethodLevelSourceCodeLink_Operation() {
        return (EReference) this.methodLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMethodLevelSourceCodeLink_Function() {
        return (EReference) this.methodLevelSourceCodeLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getControlFlowLevelSourceCodeLink() {
        return this.controlFlowLevelSourceCodeLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getControlFlowLevelSourceCodeLink_AbstractAction() {
        return (EReference) this.controlFlowLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getControlFlowLevelSourceCodeLink_Statement() {
        return (EReference) this.controlFlowLevelSourceCodeLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSourceCodeDecoratorRepository() {
        return this.sourceCodeDecoratorRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSourceCodeDecoratorRepository_FileLevelSourceCodeLink() {
        return (EReference) this.sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSourceCodeDecoratorRepository_MethodLevelSourceCodeLink() {
        return (EReference) this.sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSourceCodeDecoratorRepository_ControlFlowLevelSourceCodeLink() {
        return (EReference) this.sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSourceCodeDecoratorRepository_InterfaceSourceCodeLink() {
        return (EReference) this.sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSourceCodeDecoratorRepository_ComponentImplementingClassesLink() {
        return (EReference) this.sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInterfaceSourceCodeLink() {
        return this.interfaceSourceCodeLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInterfaceSourceCodeLink_Interface() {
        return (EReference) this.interfaceSourceCodeLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInterfaceSourceCodeLink_GastClass() {
        return (EReference) this.interfaceSourceCodeLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentImplementingClassesLink() {
        return this.componentImplementingClassesLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentImplementingClassesLink_IsCompositeComponent() {
        return (EAttribute) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentImplementingClassesLink_Component() {
        return (EReference) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentImplementingClassesLink_ImplementingClasses() {
        return (EReference) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentImplementingClassesLink_SubComponents() {
        return (EReference) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentImplementingClassesLink_ProvidedInterfaces() {
        return (EReference) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentImplementingClassesLink_RequiredInterfaces() {
        return (EReference) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentImplementingClassesLink_IsInitialComponent() {
        return (EAttribute) this.componentImplementingClassesLinkEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPCMSystemImplementatingClassesLink() {
        return this.pcmSystemImplementatingClassesLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPCMSystemImplementatingClassesLink_SystemModel() {
        return (EReference) this.pcmSystemImplementatingClassesLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SourceCodeDecoratorFactory getSourceCodeDecoratorFactory() {
        return (SourceCodeDecoratorFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.fileLevelSourceCodeLinkEClass = this.createEClass(FILE_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.fileLevelSourceCodeLinkEClass, FILE_LEVEL_SOURCE_CODE_LINK__REPOSITORY_COMPONENT);
        this.createEReference(this.fileLevelSourceCodeLinkEClass, FILE_LEVEL_SOURCE_CODE_LINK__FILE);

        this.methodLevelSourceCodeLinkEClass = this.createEClass(METHOD_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.methodLevelSourceCodeLinkEClass, METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION);
        this.createEReference(this.methodLevelSourceCodeLinkEClass, METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION);

        this.controlFlowLevelSourceCodeLinkEClass = this.createEClass(CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.controlFlowLevelSourceCodeLinkEClass,
                CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__ABSTRACT_ACTION);
        this.createEReference(this.controlFlowLevelSourceCodeLinkEClass,
                CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__STATEMENT);

        this.sourceCodeDecoratorRepositoryEClass = this.createEClass(SOURCE_CODE_DECORATOR_REPOSITORY);
        this.createEReference(this.sourceCodeDecoratorRepositoryEClass,
                SOURCE_CODE_DECORATOR_REPOSITORY__FILE_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.sourceCodeDecoratorRepositoryEClass,
                SOURCE_CODE_DECORATOR_REPOSITORY__METHOD_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.sourceCodeDecoratorRepositoryEClass,
                SOURCE_CODE_DECORATOR_REPOSITORY__CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK);
        this.createEReference(this.sourceCodeDecoratorRepositoryEClass,
                SOURCE_CODE_DECORATOR_REPOSITORY__INTERFACE_SOURCE_CODE_LINK);
        this.createEReference(this.sourceCodeDecoratorRepositoryEClass,
                SOURCE_CODE_DECORATOR_REPOSITORY__COMPONENT_IMPLEMENTING_CLASSES_LINK);

        this.interfaceSourceCodeLinkEClass = this.createEClass(INTERFACE_SOURCE_CODE_LINK);
        this.createEReference(this.interfaceSourceCodeLinkEClass, INTERFACE_SOURCE_CODE_LINK__INTERFACE);
        this.createEReference(this.interfaceSourceCodeLinkEClass, INTERFACE_SOURCE_CODE_LINK__GAST_CLASS);

        this.componentImplementingClassesLinkEClass = this.createEClass(COMPONENT_IMPLEMENTING_CLASSES_LINK);
        this.createEAttribute(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__IS_COMPOSITE_COMPONENT);
        this.createEReference(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__COMPONENT);
        this.createEReference(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__IMPLEMENTING_CLASSES);
        this.createEReference(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__SUB_COMPONENTS);
        this.createEReference(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__PROVIDED_INTERFACES);
        this.createEReference(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__REQUIRED_INTERFACES);
        this.createEAttribute(this.componentImplementingClassesLinkEClass,
                COMPONENT_IMPLEMENTING_CLASSES_LINK__IS_INITIAL_COMPONENT);

        this.pcmSystemImplementatingClassesLinkEClass = this.createEClass(PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK);
        this.createEReference(this.pcmSystemImplementatingClassesLinkEClass,
                PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK__SYSTEM_MODEL);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        final SourcePackage theSourcePackage = (SourcePackage) EPackage.Registry.INSTANCE
                .getEPackage(SourcePackage.eNS_URI);
        final JavaPackage theJavaPackage = (JavaPackage) EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
        final SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.methodLevelSourceCodeLinkEClass.getESuperTypes().add(this.getFileLevelSourceCodeLink());
        this.controlFlowLevelSourceCodeLinkEClass.getESuperTypes().add(this.getMethodLevelSourceCodeLink());
        this.pcmSystemImplementatingClassesLinkEClass.getESuperTypes().add(this.getComponentImplementingClassesLink());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.fileLevelSourceCodeLinkEClass, FileLevelSourceCodeLink.class, "FileLevelSourceCodeLink",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getFileLevelSourceCodeLink_RepositoryComponent(),
                theRepositoryPackage.getRepositoryComponent(), null, "repositoryComponent", null, 0, 1,
                FileLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getFileLevelSourceCodeLink_File(), theSourcePackage.getSourceFile(), null, "file",
                null, 0, 1, FileLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.methodLevelSourceCodeLinkEClass, MethodLevelSourceCodeLink.class,
                "MethodLevelSourceCodeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getMethodLevelSourceCodeLink_Operation(), theRepositoryPackage.getSignature(), null,
                "operation", null, 0, 1, MethodLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getMethodLevelSourceCodeLink_Function(), theJavaPackage.getAbstractMethodDeclaration(),
                null, "function", null, 0, 1, MethodLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.controlFlowLevelSourceCodeLinkEClass, ControlFlowLevelSourceCodeLink.class,
                "ControlFlowLevelSourceCodeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getControlFlowLevelSourceCodeLink_AbstractAction(), theSeffPackage.getAbstractAction(),
                null, "abstractAction", null, 0, 1, ControlFlowLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getControlFlowLevelSourceCodeLink_Statement(), theJavaPackage.getStatement(), null,
                "statement", null, 0, 1, ControlFlowLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.sourceCodeDecoratorRepositoryEClass, SourceCodeDecoratorRepository.class,
                "SourceCodeDecoratorRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSourceCodeDecoratorRepository_FileLevelSourceCodeLink(),
                this.getFileLevelSourceCodeLink(), null, "fileLevelSourceCodeLink", null, 0, -1,
                SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSourceCodeDecoratorRepository_MethodLevelSourceCodeLink(),
                this.getMethodLevelSourceCodeLink(), null, "methodLevelSourceCodeLink", null, 0, -1,
                SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSourceCodeDecoratorRepository_ControlFlowLevelSourceCodeLink(),
                this.getControlFlowLevelSourceCodeLink(), null, "controlFlowLevelSourceCodeLink", null, 0, -1,
                SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSourceCodeDecoratorRepository_InterfaceSourceCodeLink(),
                this.getInterfaceSourceCodeLink(), null, "interfaceSourceCodeLink", null, 0, -1,
                SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getSourceCodeDecoratorRepository_ComponentImplementingClassesLink(),
                this.getComponentImplementingClassesLink(), null, "componentImplementingClassesLink", null, 0, -1,
                SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.interfaceSourceCodeLinkEClass, InterfaceSourceCodeLink.class, "InterfaceSourceCodeLink",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getInterfaceSourceCodeLink_Interface(), theRepositoryPackage.getInterface(), null,
                "interface", null, 0, 1, InterfaceSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getInterfaceSourceCodeLink_GastClass(), theJavaPackage.getType(), null, "gastClass",
                null, 0, 1, InterfaceSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.componentImplementingClassesLinkEClass, ComponentImplementingClassesLink.class,
                "ComponentImplementingClassesLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getComponentImplementingClassesLink_IsCompositeComponent(),
                this.ecorePackage.getEBoolean(), "isCompositeComponent", null, 1, 1,
                ComponentImplementingClassesLink.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE,
                !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getComponentImplementingClassesLink_Component(),
                theRepositoryPackage.getRepositoryComponent(), null, "component", null, 1, 1,
                ComponentImplementingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getComponentImplementingClassesLink_ImplementingClasses(), theJavaPackage.getType(),
                null, "implementingClasses", null, 1, -1, ComponentImplementingClassesLink.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        this.initEReference(this.getComponentImplementingClassesLink_SubComponents(),
                this.getComponentImplementingClassesLink(), null, "subComponents", null, 0, -1,
                ComponentImplementingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getComponentImplementingClassesLink_ProvidedInterfaces(),
                this.getInterfaceSourceCodeLink(), null, "providedInterfaces", null, 0, -1,
                ComponentImplementingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getComponentImplementingClassesLink_RequiredInterfaces(),
                this.getInterfaceSourceCodeLink(), null, "requiredInterfaces", null, 0, -1,
                ComponentImplementingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getComponentImplementingClassesLink_IsInitialComponent(),
                this.ecorePackage.getEBoolean(), "isInitialComponent", null, 1, 1,
                ComponentImplementingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.pcmSystemImplementatingClassesLinkEClass, PCMSystemImplementatingClassesLink.class,
                "PCMSystemImplementatingClassesLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPCMSystemImplementatingClassesLink_SystemModel(), theSystemPackage.getSystem(),
                null, "systemModel", null, 0, 1, PCMSystemImplementatingClassesLink.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // SourceCodeDecoratorPackageImpl
