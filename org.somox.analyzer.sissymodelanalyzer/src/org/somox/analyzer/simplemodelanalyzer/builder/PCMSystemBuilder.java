package org.somox.analyzer.simplemodelanalyzer.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.allocation.AllocationFactory;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.builder.util.DefaultResourceEnvironment;
import org.somox.analyzer.simplemodelanalyzer.builder.util.InterfacePortBuilderHelper;
import org.somox.analyzer.simplemodelanalyzer.builder.util.SubComponentInformation;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.kdmhelper.metamodeladdition.Root;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorFactory;

//import de.fzi.gast.core.Root;

/**
 * Builder for SAMM system + architecture model structures. Additionally creates
 * default allocation.
 *
 * @author Klaus Krogmann
 */
public class PCMSystemBuilder extends AbstractBuilder {

    private static Logger logger = Logger.getLogger(PCMSystemBuilder.class);

    private final ComponentAndTypeNaming namingStrategy;
    private final ComponentBuilder componentBuilder;
    private final NonDuplicatingInterfacePortBuilder providedRoleBuilder;

    /**
     * Main builder used to create model elements of the SAMM during component
     * detection with SoMoX.
     *
     * @param gastModel
     *            The GAST model containing the analyzed source code
     * @param somoxConfiguration
     *            SoMoX configuration object
     * @param analysisResult
     *            Object holding the root elements of the models to create
     */
    public PCMSystemBuilder(final Root gastModel,
            final SoMoXConfiguration somoxConfiguration,
            final AnalysisResult analysisResult, final ComponentBuilder componentBuilder) {
        super(gastModel, somoxConfiguration, analysisResult);

        logger.debug("Initialising PCM system builder");

        this.componentBuilder = componentBuilder;
        this.namingStrategy = componentBuilder
                .getComponentAndTypeNamingStrategy();

        this.providedRoleBuilder = new NonDuplicatingInterfacePortBuilder(gastModel, somoxConfiguration, analysisResult, namingStrategy);
    }

    /**
     * Replicates roles of inner components and establishes delegation
     * connectors for them. Updates the PCM system. Creates a PCM for the last
     * composite component of the repository model. Creates a default allocation
     * with to a default target environment.
     */
    public void buildSystemModel() {
        buildSystemModel(getNonContainedComponents());
    }

    /**
     * Returns all components which are not used (subcomponent) in another
     * composite component.
     *
     * @return List of non-contained components
     */
    private List<ComponentImplementingClassesLink> getNonContainedComponents() {

        final ArrayList<ComponentImplementingClassesLink> nonContainedComponents = new ArrayList<ComponentImplementingClassesLink>();

        final EList<ComponentImplementingClassesLink> componentImplementingClassesLinks = this.analysisResult
                .getSourceCodeDecoratorRepository()
                .getComponentImplementingClassesLink();

        for (final ComponentImplementingClassesLink compLinkToCheckWhetherContained : componentImplementingClassesLinks) {

            boolean isComponentLinkToCheckContained = false;
            for (final ComponentImplementingClassesLink potentialOuterCompLink : componentImplementingClassesLinks) {
                if (potentialOuterCompLink.getSubComponents().contains(compLinkToCheckWhetherContained)) {
                    isComponentLinkToCheckContained = true;
                    break; // contained; no more looping required
                }
            }
            if (!isComponentLinkToCheckContained) {
                nonContainedComponents.add(compLinkToCheckWhetherContained);
                logger.debug("non-contained component: "
                        + compLinkToCheckWhetherContained.getComponent()
                        .getEntityName() + " used for the system level");
            }
        }

        return nonContainedComponents;
    }

    /**
     * Replicates ports of inner components and establishes delegation
     * connectors for them. Updates the SAMM system.
     *
     * @param innerComponents
     *            List of Component which shall become instances of the SAMM
     *            system.
     */
    private void buildSystemModel(final List<ComponentImplementingClassesLink> innerComponents) {
        final org.palladiosimulator.pcm.system.System pcmSystem = analysisResult.getSystemModel();
        pcmSystem.setEntityName("SoMoX Reverse Engineered System");

        final PCMSystemImplementatingClassesLink pcmLink = SourceCodeDecoratorFactory.eINSTANCE
                .createPCMSystemImplementatingClassesLink();
        pcmLink.setSystemModel(pcmSystem);
        // FIXME: currently saving results in invalid serialisation
        // this.analysisResult.getSourceCodeDecoratorRepository().getComponentImplementingClassesLink().add(sammLink);

        final Set<SubComponentInformation> subComponentInformationSet = new HashSet<SubComponentInformation>();

        final ResourceEnvironment resourceEnvironment = DefaultResourceEnvironment
                .getDefaultResourceEnvironment();
        final ResourceContainer defaultContainer = resourceEnvironment
                .getResourceContainer_ResourceEnvironment().get(0);

        final Allocation allocation = analysisResult.getAllocation();
        allocation.setEntityName("SoMoX Reverse Engineered Allocation Model");
        allocation.setSystem_Allocation(pcmSystem);
        allocation.setTargetResourceEnvironment_Allocation(resourceEnvironment);

        for (final ComponentImplementingClassesLink compLink : innerComponents) {

            // create subcomponent instances
            final AssemblyContext assemblyContext = CompositionFactory.eINSTANCE
                    .createAssemblyContext();
            assemblyContext.setEncapsulatedComponent__AssemblyContext(compLink
                    .getComponent());
            assemblyContext.setEntityName(compLink.getComponent()
                    .getEntityName());
            pcmSystem.getAssemblyContexts__ComposedStructure().add(assemblyContext);
            pcmLink.getSubComponents().add(compLink);

            // create allocation context for system component
            final AllocationContext allocationContext = AllocationFactory.eINSTANCE
                    .createAllocationContext();
            allocation.getAllocationContexts_Allocation()
            .add(allocationContext);
            allocationContext
            .setAssemblyContext_AllocationContext(assemblyContext);
            allocationContext.setEntityName(compLink.getComponent()
                    .getEntityName());
            allocationContext
            .setResourceContainer_AllocationContext(defaultContainer);

            // create delegation connectors between system and inner component
            // provided roles
            for(final ProvidedRole role : compLink.getComponent().getProvidedRoles_InterfaceProvidingEntity()){
                if(role instanceof OperationProvidedRole){
                    final OperationProvidedRole opProvRole = (OperationProvidedRole) role;

                    createSystemProvidedRoleAndDelegationConnector(pcmSystem, compLink,
                            assemblyContext, opProvRole);

                } else {
                    logger.warn("Role type not yet supported: "+role.getClass().getSimpleName());
                }
            }
        }

        // create assembly connectors among system components
        // execute only once: possible since here no decorator is used
        componentBuilder.getInsideCompositeComponentAssemblyConnectorStrategy()
        .buildAssemblyConnectors(pcmSystem, innerComponents);

        // collect information on non-connected interfaces
        final Iterable<SubComponentInformation> subComponentInformation = InterfacePortBuilderHelper
                .collectInformationOnNonBoundInterfaces(pcmLink, pcmSystem,
                        false); // Link must be SAMM!
        final Iterator<SubComponentInformation> iterator = subComponentInformation
                .iterator();
        while (iterator.hasNext()) {
            subComponentInformationSet.add(iterator.next());
        }

        // required ports not allowed/supported for SAMM system thus capture by
        // dummy component
        /** Changed by Falko Hansch*/
        // create dummy components for non-connected interfaces and
        // build assembly connectors for the newly created dummy component:
        //final BasicComponent dummyComponent = DummyComponentBuilder
        //        .createDummyComponent(subComponentInformationSet, pcmSystem,
        //                resourceEnvironment, analysisResult);
        //this.analysisResult.getInternalArchitectureModel()
        //.getComponents__Repository().add(dummyComponent);
    }

    // TODO: Check in the svn history what this method was used for. Maybe
    // garbage
    // private Set<ComponentImplementingClassesLink>
    // listToSet(List<ComponentImplementingClassesLink> list) {
    // Set<ComponentImplementingClassesLink> set = new
    // HashSet<ComponentImplementingClassesLink>();
    // for(ComponentImplementingClassesLink link : list) {
    // boolean success = set.add(link);
    // assert (success == true);
    // }
    // return set;
    // }

    private void createSystemProvidedRoleAndDelegationConnector(
            final org.palladiosimulator.pcm.system.System pcmSystem, final ComponentImplementingClassesLink compLink,
            final AssemblyContext assemblyContext,
            final OperationProvidedRole innerProvidedRole) {

        final OperationInterface opInterface = innerProvidedRole.getProvidedInterface__OperationProvidedRole();

        if (opInterface == null) {
            logger.error("No interface set for role: "
                    + innerProvidedRole.getEntityName());
            return;
        }

        // create system provided role
        final OperationProvidedRole outerProvidedRole = RepositoryFactory.eINSTANCE
                .createOperationProvidedRole();
        outerProvidedRole.setProvidingEntity_ProvidedRole(pcmSystem);
        outerProvidedRole.setEntityName(namingStrategy.createProvidedSystemPortName(
                opInterface, compLink.getComponent()));
        outerProvidedRole.setProvidedInterface__OperationProvidedRole(opInterface);

        // create delegation connector for provided role
        final ProvidedDelegationConnector delegationConnector = CompositionFactory.eINSTANCE
                .createProvidedDelegationConnector();
        delegationConnector.setAssemblyContext_ProvidedDelegationConnector(assemblyContext);
        // TODO burkha 23.04.2013 the assembly context is not set correct
        // delegationConnector.setAssemblyContext_ProvidedDelegationConnector(innerProvidedRole
        // .getProvidingEntity_ProvidedRole());
        delegationConnector.setInnerProvidedRole_ProvidedDelegationConnector(innerProvidedRole);
        delegationConnector.setOuterProvidedRole_ProvidedDelegationConnector(outerProvidedRole);
        delegationConnector.setParentStructure__Connector(pcmSystem);
        delegationConnector.setEntityName(opInterface.getEntityName());

        // store connector in system
        pcmSystem.getConnectors__ComposedStructure().add(delegationConnector);
    }

}
