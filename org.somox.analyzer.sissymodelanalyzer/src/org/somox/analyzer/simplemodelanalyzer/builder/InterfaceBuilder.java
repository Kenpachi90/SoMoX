package org.somox.analyzer.simplemodelanalyzer.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmt.modisco.java.ASTNode;
import org.eclipse.gmt.modisco.java.Type;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.builder.util.InterfacePortBuilderHelper;
import org.somox.analyzer.simplemodelanalyzer.detection.ComponentInterfaceStrategy;
import org.somox.analyzer.simplemodelanalyzer.detection.IComponentInterfaceStrategy;
import org.somox.analyzer.simplemodelanalyzer.detection.util.AccessFilter;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.filter.EClassBasedFilter;
import org.somox.kdmhelper.KDMHelper;
import org.somox.kdmhelper.metamodeladdition.Root;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorFactory;

/**
 * Builder used to create {@link Interface}s in the SAMM instance based on reverse engineered
 * code
 *
 * @author Steffen Becker, Michael Hauck, Klaus Krogmann
 */
public class InterfaceBuilder extends AbstractBuilder {

    /**
     * Maps GASTClasses which are interfaces (in case of Interfaces created directly from programming language
     * interfaces) or normal GASTClasses if the interface has been derived from all public methods
     * to their respective SAMM model interfaces
     */
    private final Map<Type, OperationInterface> alreadyCreatedInterfaces = new HashMap<Type, OperationInterface>();

    /**
     * Logger of this builder
     */
    private static Logger logger = Logger.getLogger(InterfaceBuilder.class);

    /**
     * Builder used to build methods and method signatures
     */
    private OperationBuilder operationBuilder = null;

    /**
     * Builder used to build GAST Behaviours for provided methods
     */
    private Seff2JavaASTBuilder behaviourBuilder = null;

    /**
     * Strategy for naming elements
     */
    private ComponentAndTypeNaming naming = null;

    /**
     * Strategy to identify classes as component interfaces
     */
    private IComponentInterfaceStrategy interfaceStrategy = null;

    /**
     * Constant indicating the case of a provided interface.
     */
    public static final boolean PROVIDED_INTERFACE = true;

    /**
     * Constructor of this interface builder
     * @param gastModel GAST model used in queries to the source code
     * @param configuration Somox configuration used to retrieve settings
     * @param result The analysis result containing the root nodes of the models in which this builder will store
     * the created model elements
     */
    public InterfaceBuilder(final Root gastModel,
            final SoMoXConfiguration configuration,
            final AnalysisResult result) {
        super(gastModel, configuration, result);

        logger.debug("Interface builder initialised");

        this.operationBuilder = new OperationBuilder(gastModel, configuration,
                result);
        this.behaviourBuilder = new Seff2JavaASTBuilder(gastModel, configuration,
                result);

        //TODO: extract to configurable strategy
        this.naming = new ComponentAndTypeNaming();

        //TODO: extract to configurable strategy
        this.interfaceStrategy = new ComponentInterfaceStrategy(result.getSourceCodeDecoratorRepository());
    }

    /**
     * Method used to find for a given component the set of required interfaces. Currently
     * interfaces are detected using a {@link IComponentInterfaceStrategy}.
     * @param componentCandidate The component for which this method should create
     * required interfaces
     * @return true if a interface was added; false else
     */
    public boolean findAndAddRequiredInterfaces(
            final ComponentImplementingClassesLink componentCandidate) {
        boolean addedARequiredInterface = false;

        // Filter used to remove inheritance type relations from the list of accesses
        final EClassBasedFilter<ASTNode> accessFilter = new EClassBasedFilter<ASTNode>(
                new EClass[] {
                        /**accessesPackage.eINSTANCE.getInheritanceTypeAccess()**///SOMOXTODOCHANGE
                        JavaPackage.eINSTANCE.getThisExpression(), //remove class-internal accesses//SOMOXTODOCHANGE
                        JavaPackage.eINSTANCE.getSuperFieldAccess()//REALLYADDED//SOMOXTODOCHANGE
                });

        // Get all accessed classes from all implementation classes of this
        // component
        final List<Type> filteredAccessedClasses = new LinkedList<Type>();
        final List<Type> componentClasses = new LinkedList<Type>();
        for (final Type clazz : componentCandidate.getImplementingClasses()) {
            filteredAccessedClasses.addAll(AccessFilter.filterAccessList(KDMHelper.getAllAccesses(clazz)
                    , accessFilter));
            componentClasses.add(clazz);
        }

        // remove self accesses inside component (NOT equal to a self access)
        filteredAccessedClasses.removeAll(componentClasses);

        for (final Type accessedClass : this.somoxConfiguration.getBlacklistFilter().filter(filteredAccessedClasses)) {
            if (interfaceStrategy.isComponentInterface(accessedClass)) {

                // Setting null here since the interface implementation is not generally known; i. e. there could be multiple
                // implementations.
                final OperationInterface reqInterface = createInterface(null,accessedClass);

                // If the interface has already been added to component, do not
                // add it again
                if (!doesComponentAlreadyRequireInterface(reqInterface,
                        componentCandidate.getComponent())) {
                    createRequiredPort(componentCandidate.getComponent(),
                            reqInterface);
                    //update source code decorator:
                    updateInterfacesInSourceCodeDecorator(componentCandidate, reqInterface, accessedClass, !PROVIDED_INTERFACE);

                    addedARequiredInterface = true;
                }
            }
        }

        // for potentially existing interfaces of the component: avoid self accesses
        // to interfaces provided by the component
        if(!componentCandidate.isCompositeComponent()) {
            removeInterfaceSelfAccesses(componentCandidate);
        }

        return addedARequiredInterface;
    }

    /**
     * Create provided roles and their interfaces if they do not exist for the given component
     * @param componentCandidate Source code annotation of the detected component for which the
     * provided interfaces should be created. It has to point to a {@link PrimitiveComponent}.
     */
    public void addProvidedInterfaces(
            final ComponentImplementingClassesLink componentCandidate) {

        // Check precondition
        if (componentCandidate.isCompositeComponent()) {
            throw new IllegalArgumentException("This method can only be called on primitive components");
        }

        for (final Type gastClass : componentCandidate.getImplementingClasses()) {
            for (final Type superType : this.somoxConfiguration.getBlacklistFilter().filter(KDMHelper.getSuperTypes(gastClass))) {
                createInterfaceForSupertype(componentCandidate, gastClass,
                        superType);
            }
        }

        if (componentCandidate.getComponent().getProvidedRoles_InterfaceProvidingEntity().isEmpty()) {
            assignPublicMethodsAsInterfaceForComponentsWithoutInterface(componentCandidate);
        }
    }

    /**
     * Add the given interface in a required role to the given component
     * @param component The component which gets the interface as required role
     * @param reqInterface The interface which is part of the required role
     */
    private void createRequiredPort(final RepositoryComponent component,
            final OperationInterface reqInterface) {
        final OperationRequiredRole requiredRole = RepositoryFactory.eINSTANCE.createOperationRequiredRole();
        requiredRole.setEntityName(naming.createRequiredPortName(reqInterface, component));
        requiredRole.setRequiredInterface__OperationRequiredRole(reqInterface);
        component.getRequiredRoles_InterfaceRequiringEntity().add(requiredRole);
    }

    private ProvidedRole createProvidedPort(final OperationInterface theInterface,
            final RepositoryComponent component) {
        final OperationProvidedRole providedRole = RepositoryFactory.eINSTANCE.createOperationProvidedRole();
        providedRole.setEntityName(naming.createProvidedPortName(theInterface, component));
        providedRole.setProvidedInterface__OperationProvidedRole(theInterface);
        component.getProvidedRoles_InterfaceProvidingEntity().add(providedRole);
        return providedRole;
    }

    /**
     * Checks whether the given component requires the given interface.
     *
     * @param theInterface
     * @param component
     * @return true if already required; false else
     */
    private boolean doesComponentAlreadyRequireInterface(
            final Interface theInterface, final RepositoryComponent component) {

        for(final RequiredRole role : component.getRequiredRoles_InterfaceRequiringEntity()){

            if(role instanceof OperationRequiredRole){

                final OperationRequiredRole opReqRole = (OperationRequiredRole) role;
                final OperationInterface opInterface = opReqRole.getRequiredInterface__OperationRequiredRole();
                if(opInterface.equals(theInterface)){
                    return true;
                }

            } else {
                logger.warn("Role type not yet supported: "+role.getClass().getSimpleName());
            }
        }

        return false;
    }

    /**
     * @param theInterface Interface to search
     * @param component Component whose provided roles are checked
     * @return true if the given interface is referenced in any of the provided ports of the component
     */
    private boolean componentProvidesInterface(final Interface theInterface,
            final RepositoryComponent component) {
        for (final ProvidedRole provRole : component.getProvidedRoles_InterfaceProvidingEntity()) {
            if( provRole.getId().equals(theInterface.getId())){
                return true;
            }
        }
        return false;
    }

    private void createInterfaceForSupertype(
            final ComponentImplementingClassesLink componentCandidate,
            final Type gastClass, final Type superType) {

        // Recursively traverse all supertypes
        for (final Type ownSuperType : this.somoxConfiguration.getBlacklistFilter().filter(KDMHelper.getSuperTypes(superType))) {
            createInterfaceForSupertype(componentCandidate, gastClass, ownSuperType);
        }

        if (interfaceStrategy.isComponentInterface(superType)) {
            logger.debug("Found interface "+KDMHelper.computeFullQualifiedName(superType)+" for component "+
                    componentCandidate.getComponent().getEntityName());
            final OperationInterface providedInterface = createInterface(gastClass,superType);

            if (!componentProvidesInterface(providedInterface,
                    componentCandidate.getComponent())) {
                createProvidedPortAndBehaviour(componentCandidate,
                        providedInterface, superType);
            }
        }
    }

    private void createProvidedPortAndBehaviour(
            final ComponentImplementingClassesLink componentCandidate,
            final OperationInterface providedInterface,
            final Type gastClass) {

        final ProvidedRole providedRole = createProvidedPort(providedInterface, componentCandidate.getComponent());
        //TODO burkha 23.05.2013 why are for CoCoMe 5 Refreshable Operation Provided Roles created
        updateInterfacesInSourceCodeDecorator(
                componentCandidate,
                providedInterface,
                gastClass,
                true //provided interface
                );

        if (!componentCandidate.isCompositeComponent()) {
            // add behaviour
            behaviourBuilder.addSeffsToPrimitiveComponent((BasicComponent) componentCandidate.getComponent(), providedRole);
        }
    }

    /**
     * Finally, check if components exist that do not provide any interfaces. This components should
     * then provide an interface with all public methods
     * @param myComponentsGast Map of existing components
     */
    private void assignPublicMethodsAsInterfaceForComponentsWithoutInterface(
            final ComponentImplementingClassesLink componentCandidate) {
        logger.debug("Assigning public methods as interfaces");

        //TODO langhammer 3.6.2013 If there are several classes in one basic component
        // that implement the same interface, then the model is invalid, because several
        // SEFFs in the compoment reference the same operation signature
        // In addition multiple provided roles are created
        final List<Type> gastClasses = componentCandidate.getImplementingClasses();

        if( !gastClasses.isEmpty() ) {
            for(final Type gastClass : gastClasses) {

                final OperationInterface compInterface = createInterfaceBasedOnPublicMethods(gastClass);

                if (compInterface != null) {
                    createProvidedPortAndBehaviour(componentCandidate,
                            compInterface,gastClass);
                } else {
                    logger.warn("Failed to create interface by using public methods for class without real interfaces");
                }
            }
        } else {
            logger.warn("No gast classes found for component: " + componentCandidate.getComponent().getEntityName() + " id: "
                    + componentCandidate.getComponent().getId());
        }
    }

    /**
     * Creates a new interface for the given gastClass if it was
     * not present in allInterfaces before.
     * @param gastClass interface is created for the public methods of this class
     * @return A new interface if a interface for gastClass did not exist;
     * otherwise the existing interface is returned
     */
    private OperationInterface createInterfaceBasedOnPublicMethods(
            final Type gastClass) {

        if (interfaceStrategy.isComponentInterface(gastClass)) {
            logger.info(KDMHelper.computeFullQualifiedName(gastClass) + " used as interface but is a pseudo-interface.");
        }

        if(this.alreadyCreatedInterfaces.containsKey(gastClass)) {
            return this.alreadyCreatedInterfaces.get(gastClass);
        }

        final OperationInterface compInterface = RepositoryFactory.eINSTANCE.createOperationInterface();
        compInterface.setEntityName(naming.createInterfaceNameForClass(gastClass));
        //compInterface.setDocumentation(gastClass.getName());

        this.operationBuilder.createOperations(gastClass, gastClass,compInterface);

        this.alreadyCreatedInterfaces.put(gastClass, compInterface);
        this.analysisResult.getInternalArchitectureModel().getInterfaces__Repository().add(compInterface);

        return compInterface;
    }

    /**
     *
     * @param interfaceClass
     *            the interface to add for gastClass
     * @param interfaces
     *            a list of interfaces in which the interface should be put. If
     *            the interface is already contained in the list, this interface
     *            is returned
     * @param repository
     *            the SAMM repository in which the interface should be contained
     * @return the interface
     */
    private OperationInterface createInterface(final Type implementingClass, final Type interfaceClass) {

        // check for existing interface:
        OperationInterface operationInterface = getExistingInterface(interfaceClass);

        // new interface
        if (operationInterface == null) {
            operationInterface = RepositoryFactory.eINSTANCE.createOperationInterface();
            for (final TypeAccess inheritanceTypeAccess : KDMHelper.getInheritanceTypeAccesses(interfaceClass)
                    ) {
                final Type superType = inheritanceTypeAccess
                        .getType();
                if (this.somoxConfiguration.getBlacklistFilter().passes(superType) &&
                        interfaceStrategy.isComponentInterface(superType)) {
                    final Interface parentInterface = createInterface(implementingClass, superType);
                    operationInterface.getParentInterfaces__Interface().add(parentInterface);
                }
            }
            operationInterface.setEntityName(naming.createInterfaceName(interfaceClass));
            //result.setDocumentation(KDMHelper.computeFullQualifiedName(interfaceClass));

            operationBuilder.createOperations(implementingClass, interfaceClass, operationInterface);

            this.alreadyCreatedInterfaces.put(interfaceClass, operationInterface);
            this.analysisResult.getInternalArchitectureModel().getInterfaces__Repository()
            .add(operationInterface);
        }
        return operationInterface;
    }

    /**
     * Checks whether the interface is already present (created before)
     *
     * @param gastClass
     * @param interfaces
     * @return null if no interface could not be found
     */
    private OperationInterface getExistingInterface(final Type gastClass) {
        OperationInterface returnInterface = null;

        if (this.alreadyCreatedInterfaces.containsKey(gastClass)) {
            returnInterface = this.alreadyCreatedInterfaces.get(gastClass);
        }

        return returnInterface;
    }

    /**
     * save source information to a interface link of the sourceCodeDecorator
     *
     * @param component
     *            write target
     * @param interf The interface to add
     * @param gastClass
     *            an GAST <b>interface</b>
     * @param isProvidedInterface set to true when adding a provided interface;
     * vice versa for required interface
     */
    private void updateInterfacesInSourceCodeDecorator(
            final ComponentImplementingClassesLink component,
            final Interface interf,
            final Type gastClass,
            final boolean isProvidedInterface) {
        final InterfaceSourceCodeLink interfaceLink = SourceCodeDecoratorFactory.eINSTANCE.createInterfaceSourceCodeLink();
        if (gastClass != null) {
            interfaceLink.setGastClass(gastClass);
        }
        interfaceLink.setInterface(interf);

        this.analysisResult.getSourceCodeDecoratorRepository()
        .getInterfaceSourceCodeLink().add(interfaceLink);
        if(isProvidedInterface) {
            component.getProvidedInterfaces().add(interfaceLink);
        } else {
            component.getRequiredInterfaces().add(interfaceLink);
        }
    }

    /**
     * Updates the component interfaces of all interface
     * existing until now in the source code decorator. The interfaces
     * might have changed due to newly discovered interfaces during reverse
     * engineering.
     */
    public void updateRequiredInterfacesOfExistingPrimitiveComponents() {
        boolean addedANewInterface = false;

        for(final ComponentImplementingClassesLink compLink : analysisResult.getSourceCodeDecoratorRepository().getComponentImplementingClassesLink()) {
            if(!compLink.isCompositeComponent()) {
                addedANewInterface = findAndAddRequiredInterfaces(compLink);
                addedANewInterface = true;
            }
        }

        // assembly connector builder: for new interfaces (assembly connectors for surrounding composites)
        final IAssemblyConnectorStrategy assemblyConnectorStrategy = new AssemblyConnectorsInsideCompositeComponentStrategy();
        if(addedANewInterface) {
            for(final ComponentImplementingClassesLink compLink : analysisResult.getSourceCodeDecoratorRepository().getComponentImplementingClassesLink()) {
                if(compLink.isCompositeComponent()) {
                    final ComposedProvidingRequiringEntity composite = (ComposedProvidingRequiringEntity) compLink.getComponent();
                    assemblyConnectorStrategy.buildAssemblyConnectors(composite, compLink.getSubComponents());
                }
            }
        }

        //FIXME: can ripple through entire architecture
    }

    /**
     * Adds interfaces from the GAST which have not yet been identified
     * as component interfaces to the SAMM repository.
     * @param analysisResult
     * @param gastModel
     */
    public void reverseEngineerRemainingInterfacesAsFreeFloatingInterfaces(
            final AnalysisResult analysisResult, final Root gastModel) {
        analysisResult.getSourceCodeDecoratorRepository();
        for(final Type currentClass : gastModel.getNormalClasses()) {
            if(interfaceStrategy.isComponentInterface(currentClass) &&
                    !alreadyCreatedInterfaces.containsKey(currentClass)) {

                //create a new interface
                final Interface newInterface = createInterface(currentClass, currentClass);
                analysisResult.getInternalArchitectureModel().getInterfaces__Repository().add(newInterface);

                //update source code decorator
                final InterfaceSourceCodeLink ifLink = SourceCodeDecoratorFactory.eINSTANCE.createInterfaceSourceCodeLink();
                ifLink.setGastClass(currentClass);
                analysisResult.getSourceCodeDecoratorRepository().getInterfaceSourceCodeLink().add(ifLink);
            }
        }
    }

    /**
     * Removes duplicate component interfaces which are provided AND required.
     * Cleans ups the required interface ports. Since provided ports could
     * be accessed from elsewhere, they are fully preserved.
     * @param primitiveComponent
     */
    public void removeInterfaceSelfAccesses(
            final ComponentImplementingClassesLink primitiveComponent) {

        final List<InterfaceSourceCodeInterfacePortTuple> requiredIfToRemove =
                identifyComponentInterfaceSelfAccess(primitiveComponent);

        for(final InterfaceSourceCodeInterfacePortTuple currentIfTupleToRemove : requiredIfToRemove) {
            logger.trace("removing self-access component interface " +
                    currentIfTupleToRemove.interfaceSourceCodeLink.getInterface().getEntityName() +
                    " of component " + primitiveComponent.getComponent().getEntityName());

            // model
            primitiveComponent.getComponent().getRequiredRoles_InterfaceRequiringEntity().remove(currentIfTupleToRemove.role);
            EcoreUtil.delete(currentIfTupleToRemove.role);
            //EcoreUtil.remove(requiredPortToRemove);

            // source code decorator
            primitiveComponent.getRequiredInterfaces().remove(currentIfTupleToRemove.interfaceSourceCodeLink);
            EcoreUtil.delete(currentIfTupleToRemove.interfaceSourceCodeLink);
            //EcoreUtil.remove(currentReqIfLink);

        }
    }

    /**
     * Queries interfaces which are provided AND required by a component.
     * @param primitiveComponent The component to check interface ports for.
     * @return Ports and source code decorator for the identified interfaces.
     */
    private List<InterfaceSourceCodeInterfacePortTuple> identifyComponentInterfaceSelfAccess(
            final ComponentImplementingClassesLink primitiveComponent) {

        final ArrayList<InterfaceSourceCodeInterfacePortTuple> requiredIfToRemove =
                new ArrayList<InterfaceSourceCodeInterfacePortTuple>();

        for(final InterfaceSourceCodeLink providedInterfaceLink : primitiveComponent.getProvidedInterfaces()) {
            for(final InterfaceSourceCodeLink requiredInterfaceLink : primitiveComponent.getRequiredInterfaces()) {
                if(providedInterfaceLink.getInterface().equals(
                        requiredInterfaceLink.getInterface() )) {

                    final InterfaceSourceCodeInterfacePortTuple ifToRemoveTuple =
                            new InterfaceSourceCodeInterfacePortTuple();

                    // model
                    ifToRemoveTuple.role = InterfacePortBuilderHelper.
                            getInterfacePort(primitiveComponent,requiredInterfaceLink, false);

                    // source code decorator
                    ifToRemoveTuple.interfaceSourceCodeLink = requiredInterfaceLink;

                    requiredIfToRemove.add(ifToRemoveTuple);
                }
            }
        }

        return requiredIfToRemove;
    }

    private class InterfaceSourceCodeInterfacePortTuple {
        public InterfaceSourceCodeLink interfaceSourceCodeLink;
        public Role role;
    }


}
