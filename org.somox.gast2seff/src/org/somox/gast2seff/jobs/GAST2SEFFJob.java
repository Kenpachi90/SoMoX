/**
 *
 */
package org.somox.gast2seff.jobs;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.gmt.modisco.java.AbstractMethodDeclaration;
import org.eclipse.gmt.modisco.java.Block;
import org.eclipse.gmt.modisco.java.Statement;
import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.jobs.SoMoXBlackboard;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.gast2seff.visitors.BasicFunctionClassificationStrategy;
import org.somox.gast2seff.visitors.FunctionCallClassificationVisitor;
import org.somox.gast2seff.visitors.GastStatementVisitor;
import org.somox.seff2javaast.SEFF2JavaAST;
import org.somox.seff2javaast.SEFF2MethodMapping;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
//import de.fzi.gast.statements.BlockStatement;//GAST2SEFFCHANGE
//import eu.qimpress.samm.behaviour.Behaviour;
//import eu.qimpress.samm.behaviour.BehaviourFactory;
//import eu.qimpress.samm.behaviour.GastBehaviourStub;
//import eu.qimpress.samm.behaviour.SeffBehaviourStub;
//import eu.qimpress.samm.qosannotation.QosAnnotations;
//import eu.qimpress.samm.staticstructure.PrimitiveComponent;
//import eu.qimpress.samm.staticstructure.ServiceArchitectureModel;
//import eu.qimpress.seff.AbstractAction;
//import eu.qimpress.seff.ResourceDemandingBehaviour;
//import eu.qimpress.seff.ResourceDemandingSEFF;
//import eu.qimpress.seff.SeffRepository;
//import eu.qimpress.seff.StartAction;
//import eu.qimpress.seff.StopAction;
//import eu.qimpress.seff.seffFactory;

/**
 * Transformation Job transforming a SAM instance with GAST Behaviours into a SAM instance with SEFF
 * behaviours
 *
 * @author Steffen Becker, Klaus Krogmann
 */
public class GAST2SEFFJob  implements IBlackboardInteractingJob<SoMoXBlackboard> {


    private final Logger logger = Logger.getLogger(GAST2SEFFJob.class);

    /** The SoMoX blackboard to interact with. */
    private SoMoXBlackboard blackboard = null;

    /**
     * The resource set used to load and store all resources needed for the transformation
     */
    private final ResourceSet resourceSet = new ResourceSetImpl();

    /**
     * Resources containing the models
     */
    //	private Resource sammInstance = null;
    private Resource gastInstance = null; //required to load only
    //	private Resource gastBehaviourRepository = null;
    //	private Resource seffBehaviourRepository = null;
    //	private Resource sammQosAnnotations = null;
    private SEFF2JavaAST gastBehaviourRepositoryModel = null;
    private final Resource sourceCodeDecorator = null;
    private SourceCodeDecoratorRepository sourceCodeDecoratorModel = null;
    private QoSAnnotations sammQosAnnotationsModel = null;

    /** The SoMoX configuration. */
    private SoMoXConfiguration somoxConfiguration = null;

    private FunctionCallClassificationVisitor typeVisitor = null;

    private final HashMap<String, EObject> idToeObjectMap;

    private final HashMap<Object,Object> xmlNameToFeatureMap;

    public GAST2SEFFJob(final SoMoXConfiguration somoxConfiguration) {
        super();

        // performance optimisation:
        //final Map<URI, Resource> cache = new HashMap<URI, Resource>();
        /** Changed by Falko Hansch*/
        //((ResourceSetImpl)resourceSet).setURIResourceMap(cache);
        idToeObjectMap = new HashMap<String, EObject>();
        xmlNameToFeatureMap = new HashMap<Object,Object>();
        this.somoxConfiguration = somoxConfiguration;
    }

    /* (non-Javadoc)
     * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException,
    UserCanceledException {

        //		//check preconditons:
        //		if(sammInstanceURI.isEmpty() || !sammInstanceURI.isFile() ||
        //				gastBehaviourRepositoryURI.isEmpty() || !gastBehaviourRepositoryURI.isFile()) {
        //			String error = "missing model files (samm or gast behaviour repository) to apply GAST2SEFF";
        //			logger.error(error);
        //			throw new JobFailedException(error);
        //		}
        //
        //		monitor.subTask("loading models from resources");
        //
        //		this.sammInstance = loadResource(sammInstanceURI, false);
        //
        //TODO adapt to MoDisco Java
        //FIXME
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final String basePath = workspace.getRoot().getRawLocation().toOSString();
        /** Changed by Falko Hansch*/
        // final String gastModelPath = somoxConfiguration.getFileLocations().getAnalyserInputFile();
        
        //final URI gastURI = URI.createFileURI(basePath + File.separator + gastModelPath);
        //final URI gastURI = URI.createFileURI(gastModelPath);
        //logger.debug(gastURI);
        //URI gastURI = sammInstanceURI.trimFileExtension().path() + "testsomoxgast2seff_java2kdm.xmi".appendFileExtension(GAST_EXTENSION);
        //   this.gastInstance = loadResource(gastURI, true); //FIXME: implement automated search for GAST file
        //
        //		this.gastBehaviourRepository = loadResource(gastBehaviourRepositoryURI, false);
        //		this.gastBehaviourRepositoryModel = (GASTBehaviourRepository) this.gastBehaviourRepository.getContents().get(0);
        //		this.sammQosAnnotations = loadResource(sammQosAnnotationsURI, false);
        //		this.sammQosAnnotationsModel = (QosAnnotations) this.sammQosAnnotations.getContents().get(0);
        //		this.sourceCodeDecorator = loadResource(sourceCodeDecoratorURI, false);
        //		this.sourceCodeDecoratorModel = (SourceCodeDecoratorRepository) this.sourceCodeDecorator.getContents().get(0);

        monitor.subTask("loading models from blackboard");

        //		this.sammInstance = loadResource(sammInstanceURI, false);
        //		this.gastBehaviourRepository = loadResource(gastBehaviourRepositoryURI, false);
        //		this.sammQosAnnotations = loadResource(sammQosAnnotationsURI, false);
        //		this.sourceCodeDecorator = loadResource(sourceCodeDecoratorURI, false);

  
        final AnalysisResult result = blackboard.getAnalysisResult();
        final org.palladiosimulator.pcm.system.System samm = result.getSystemModel();
        this.gastBehaviourRepositoryModel = result.getSeff2JavaAST();
        this.sammQosAnnotationsModel = result.getQosAnnotationModel();
        this.sourceCodeDecoratorModel = result.getSourceCodeDecoratorRepository();

        // resource to write to
        // this.seffBehaviourRepository = createResource(seffBehaviourRepositoryURI);

        //		Repository seffRepository = RepositoryFactory.eINSTANCE.createRepository();

        final IProgressMonitor subMonitor = new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN);
        subMonitor.setTaskName("Creating SEFF behaviour");
        // TreeIterator<EObject> iterator = sammInstance.getAllContents();
        //		TreeIterator<EObject> iterator = samm.eAllContents();
        final Iterator<SEFF2MethodMapping> iterator = this.gastBehaviourRepositoryModel.getSeff2MethodMappings().iterator();
        while (iterator.hasNext()) {
            final SEFF2MethodMapping astBehaviour = iterator.next();
            final ResourceDemandingSEFF seff = (ResourceDemandingSEFF) astBehaviour.getSeff();
            //TODO SAMM2PCM????
            final String name = seff.getId();
            logger.info("Found AST behaviour, generating SEFF behaviour for it: " + name);

            generateSEFFForGASTBehaviour(seff);
            //			seffRepository.g .getResourceDemandingSeff().add(resourceDemandingSEFF);
            monitor.worked(1);

            //			EObject eObject = iterator.next();
            //			if (eObject instanceof GastBehaviourStub) {
            //				String name = ((GastBehaviourStub) eObject).getName();
            //				logger.info("Found GAST behaviour, generating SEFF behaviour for it: " + name);
            //
            //				ResourceDemandingSEFF resourceDemandingSEFF = generateSEFFForGASTBehaviour((GastBehaviourStub) eObject);
            //				seffRepository.getResourceDemandingSeff().add(resourceDemandingSEFF);
            //				monitor.worked(1);
            //			}
        }

        // Create default annotations
        final DefaultQosAnnotationsBuilder qosAnnotationBuilder = new DefaultQosAnnotationsBuilder(
                this.sammQosAnnotationsModel);
        qosAnnotationBuilder.buildDefaultQosAnnotations(this.gastBehaviourRepositoryModel.getSeff2MethodMappings());

        subMonitor.done();

        monitor.subTask("saving models");

        //		blackboard.setSeffRepository(seffRepository);
        //saveResources(seffRepository);
    }

    //	/**
    //	 * FIXME: currently generates new IDs upon saving the models
    //	 * @param seffRepository
    //	 * @throws JobFailedException
    //	 */
    //	private void saveResources(SeffRepository seffRepository)
    //			throws JobFailedException {
    //		seffBehaviourRepository.getContents().add(seffRepository);
    //		saveResource(seffBehaviourRepository);
    //		saveResource(sammInstance);
    //		saveResource(sammQosAnnotations);
    //		saveResource(gastBehaviourRepository);
    //	}

    /* (non-Javadoc)
     * @see de.uka.ipd.sdq.workflow.IJob#getName()
     */
    @Override
    public String getName() {
        return "GAST2SEFF Transformation Job";
    }

    /**
     * Load an existing resource in this class' resource set
     * @param uri
     * @return
     * @throws JobFailedException
     */
    private Resource loadResource(final URI uri, final boolean loadFailAcceptable) throws JobFailedException {
        logger.debug("load start " + uri);

        final Resource resource = this.resourceSet.createResource(uri);
        // performance optimisation:
        final Map<Object, Object> loadOptions = ((XMIResourceImpl)resource).getDefaultLoadOptions();
        loadOptions.put(XMIResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
        loadOptions.put(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
        loadOptions.put(XMIResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
        loadOptions.put(XMIResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
        loadOptions.put(XMIResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, xmlNameToFeatureMap);

        ((ResourceImpl)resource).setIntrinsicIDToEObjectMap(idToeObjectMap);
        try {
            resource.load(loadOptions);
        } catch (final IOException e) {
            if(loadFailAcceptable) {
                logger.warn("Loading of a required resource failed. This could result in a reduced model loading performance.", e);
            } else {
                throw new JobFailedException("Loading of a required resource failed",e);
            }
        }
        logger.debug("load end");
        return resource;
    }

    /**
     * Create a new resource
     * @param uri
     * @return
     */
    private Resource createResource(final URI uri) {
        final Resource resource = this.resourceSet.createResource(uri);

        return resource;
    }

    /**
     * Save the given resource
     * @param resource
     * @throws JobFailedException
     */
    private void saveResource(final Resource resource) throws JobFailedException {
        try {
            resource.save(new HashMap<Object, Object>());
        } catch (final IOException e) {
            throw new JobFailedException("Saving model output failed",e);
        }
    }

    /**
     * Create a new PCM SEFF
     *
     * @param seff
     *            The SEFF which is filled by this method
     * @return The completed SEFF, returned for convenience
     * @throws JobFailedException
     */
    private ResourceDemandingSEFF createSeff(final ResourceDemandingSEFF seff) throws JobFailedException {
        final StartAction start = SeffFactory.eINSTANCE.createStartAction();
        final StopAction stop = SeffFactory.eINSTANCE.createStopAction();

        // initialise for new component / seff to reverse engineer:
        final BasicComponent basicComponent = (BasicComponent) seff.eContainer();
        typeVisitor = new FunctionCallClassificationVisitor(new BasicFunctionClassificationStrategy(
                sourceCodeDecoratorModel, basicComponent));

        seff.getSteps_Behaviour().add(start);

        final Block body = findBody(seff);// GAST2SEFFCHANGE
        logger.trace("visiting (seff entry): " + seff.getId());
        if (body != null) {

            // removelater for debug reasons
            final AbstractMethodDeclaration method = (AbstractMethodDeclaration) body.eContainer();
            if (method.getName().equals("orderProducts")) {
                int a = 0;
                a = a + 1;
            }
            // removelater


            // handle each statement

            final GastStatementVisitor visitor = new GastStatementVisitor(typeVisitor.getAnnotations(), seff,
                    this.sourceCodeDecoratorModel, basicComponent);

            for (final Statement st: body.getStatements()){
                typeVisitor.doSwitch(st);
                visitor.doSwitch(st);
            }

        } else {
            logger.warn("Found GAST behaviour (" + seff.getId() + ") without a method body... Skipping it...");
        }

        seff.getSteps_Behaviour().add(stop);

        connectActions(seff);

        return seff;
    }

    /**
     * Retrieve the matching GAST behaviour stub from the GAST Behaviour repository
     * @param seff The gast behaviour stub for which a matching GAST behaviour is needed
     * @return The GAST behaviour matching the gast behaviour stub
     * @throws JobFailedException Thrown if the gast behaviour is missing in the model file
     */
    private Block findBody(final ResourceDemandingSEFF seff) throws JobFailedException {//GAST2SEFFCHANGE

        //		assert onlyOnceAsGastBehaviour(this.gastBehaviourRepositoryModel.getSeff2MethodMappings(), seff);
        //TODO burkha 16.05.2013 remove this after checking
        onlyOnceAsGastBehaviour(this.gastBehaviourRepositoryModel.getSeff2MethodMappings(), seff);

        for (final SEFF2MethodMapping behaviour : this.gastBehaviourRepositoryModel.getSeff2MethodMappings()) {
            if (((ResourceDemandingSEFF)behaviour.getSeff()).getId().equals(seff.getId())) {
                logger.debug("Matching SEFF found "+ seff.getId());
                return behaviour.getBlockstatement();
            }
        }
        //TODO !!!!!!!!!!!! change
        logger.warn("Checked gastBehaviourRepository for " + seff.getId() + " but found none");
        return null; //FIXME: re-enable: exception
        //throw new JobFailedException("Unable to find operation body for given method");
    }

    /**
     * For assertion only
     * @param seff2MethodMappings
     * @param seff
     * @return
     */
    private boolean onlyOnceAsGastBehaviour(final EList<SEFF2MethodMapping> seff2MethodMappings,
            final ServiceEffectSpecification seff) {
        int i = 0;
        for (final SEFF2MethodMapping mapping : seff2MethodMappings) {
            final ResourceDemandingSEFF seffMapping= (ResourceDemandingSEFF) mapping.getSeff();
            final ResourceDemandingSEFF seffInput = (ResourceDemandingSEFF) seff;
            if (seffMapping.getId().equals(seffInput.getId())) {
                i++;
            }
        }

        if(i != 1){
            logger.error("Assertion fails - onlyOnceAsGastBehaviour: i = " + i + " for " + ((ResourceDemandingSEFF)seff).getId());
        }


        return i == 1; //must be exactly one
    }

    /**
     * Add connections to the SEFF actions assuming the actions are stored in a sequential order
     * @param seff The behaviour for which connections will be created
     */
    public static void connectActions(final ResourceDemandingBehaviour seff) {
        AbstractAction previous = null;
        for (final AbstractAction a : seff.getSteps_Behaviour()) {
            a.setPredecessor_AbstractAction(previous);
            previous = a;
        }
    }

    /**
     * Generate a SEFF for the given GAST behaviour
     * @param gastBehaviourStub The gast behaviour stub for whose behaviour a SEFF is generated
     * @return The generated SEFF
     * @throws JobFailedException
     */
    private ResourceDemandingSEFF generateSEFFForGASTBehaviour(
            final ResourceDemandingSEFF gastBehaviourStub) throws JobFailedException {
        //ResourceDemandingSEFF resourceDemandingSEFF = SeffFactory.eINSTANCE.createResourceDemandingSEFF();

        //		createSeff(gastBehaviourStub,resourceDemandingSEFF);
        createSeff(gastBehaviourStub);

        //		SeffBehaviourStub seffBehaviourStub = findOrCreateBehaviourStub(gastBehaviourStub);
        //		resourceDemandingSEFF.setSeffBehaviourStub(seffBehaviourStub);

        return gastBehaviourStub;
    }

    /**
     * Finds an existing SEFF behaviour stub and reuses it or creates a new SEFF behaviour stub if there
     * is none for the given GAST behaviour stub
     * @param gastBehaviourStub The GAST behaviour stub for which a matching SEFF behaviour stub is searched
     * @return The found or newly created SEFF behaviour stub
     */
    //	private SeffBehaviourStub findOrCreateBehaviourStub(ResourceDemandingSEFF gastBehaviourStub) {
    //		BasicComponent parentComponent = (BasicComponent) gastBehaviourStub.eContainer();
    //		SeffBehaviourStub seffBehaviourStub = null;
    //
    //		for (ServiceEffectSpecification behaviour : parentComponent.getServiceEffectSpecifications__BasicComponent()) {
    //			if (behaviour instanceof SeffBehaviourStub) {
    //				SeffBehaviourStub candidateStub = (SeffBehaviourStub) behaviour;
    //				if (candidateStub.getOperation() == gastBehaviourStub.getOperation) {
    //					logger.debug("Found SEFF behaviour stub, reusing it...");
    //					seffBehaviourStub = candidateStub;
    //					break;
    //				}
    //			}
    //		}
    //
    //		if (seffBehaviourStub == null)
    //			seffBehaviourStub = BehaviourFactory.eINSTANCE.createSeffBehaviourStub();
    //
    //		seffBehaviourStub.setOperation(gastBehaviourStub.getOperation());
    //		parentComponent.get.getOperationBehaviour().add(seffBehaviourStub);
    //
    //		return seffBehaviourStub;
    //	}

    /**
     * @param blackBoard the blackBoard to set
     */
    @Override
    public void setBlackboard(final SoMoXBlackboard blackBoard) {
        this.blackboard = blackBoard;
    }

    @Override
    public void cleanup(final IProgressMonitor monitor) throws CleanupFailedException {
        logger.warn("cleanup  called. Should not happen - nothing done.");
    }
}
