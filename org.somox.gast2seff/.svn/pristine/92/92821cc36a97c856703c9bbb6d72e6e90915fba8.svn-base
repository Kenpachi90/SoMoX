package org.somox.gast2seff.jobs;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.InternalAction;
import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand;
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformanceFactory;
import org.somox.analyzer.simplemodelanalyzer.builder.util.DefaultResourceEnvironment;
import org.somox.seff2javaast.SEFF2MethodMapping;
//import org.somox.resources.defaultmodels.DefaultModelLoader;

//import eu.qimpress.qualityannotationdecorator.seffdecorator.BranchProbability;
//import eu.qimpress.qualityannotationdecorator.seffdecorator.CpuResourceDemand;
//import eu.qimpress.qualityannotationdecorator.seffdecorator.LoopCount;
//import eu.qimpress.qualityannotationdecorator.seffdecorator.SeffdecoratorFactory;
//import eu.qimpress.samm.qosannotation.AnnotationType;
//import eu.qimpress.samm.qosannotation.ConstantNumber;
//import eu.qimpress.samm.qosannotation.ParametricFormula;
//import eu.qimpress.samm.qosannotation.QosAnnotations;
//import eu.qimpress.samm.qosannotation.QosannotationFactory;
//import eu.qimpress.seff.AbstractBranchTransition;
//import eu.qimpress.seff.BranchAction;
//import eu.qimpress.seff.InternalAction;
//import eu.qimpress.seff.LoopAction;
//import eu.qimpress.seff.ProbabilisticBranchTransition;
//import eu.qimpress.seff.SeffRepository;

/**
 * Creates default QoS annotations for behaviour. Same probabilities for
 * all branches and 1 execution per loop.
 * @author Klaus Krogmann
 *
 */
public class DefaultQosAnnotationsBuilder {

    private final Logger logger = Logger.getLogger(DefaultQosAnnotationsBuilder.class);

    //	private QoSAnnotations qosAnnotationsModel;
    //	private SeffRepository seffRepository;
    //	DefaultModelLoader defaultModelLoader;

    public DefaultQosAnnotationsBuilder(final QoSAnnotations qosAnnotationsModel) {
        //		this.qosAnnotationsModel = qosAnnotationsModel;
        //		this.seffRepository = seffRepository;
        //		this.defaultModelLoader = new DefaultModelLoader();
    }

    /**
     * Creates a QoS Annotation model with equal
     * branch probabilities and 1 fixed loop execution.
     * @param listofSEFF2MethodMappings
     *
     */
    public void buildDefaultQosAnnotations(final EList<SEFF2MethodMapping> listofSEFF2MethodMappings) {
        for(final SEFF2MethodMapping mapping : listofSEFF2MethodMappings){
            final ServiceEffectSpecification seff = mapping.getSeff();

            final TreeIterator<Object> elements = EcoreUtil.getAllContents(seff, true);
            while(elements.hasNext()) {
                final EObject eObject = (EObject)elements.next();

                if(eObject instanceof LoopAction) {
                    final LoopAction loopAction = (LoopAction)eObject;
                    createDefaultLoopCount(loopAction);
                }
                if(eObject instanceof BranchAction) {
                    final BranchAction branchAction = (BranchAction)eObject;
                    createDefaultBranchProbability(branchAction);
                }
                if(eObject instanceof InternalAction) {
                    final InternalAction internalAction = (InternalAction)eObject;
                    createDefaultCpuResourceDemand(internalAction);
                }
            }
        }

        //		this.qosAnnotationsModel.setEntityName("SoMoX Default QoS Annotations");
    }

    private void createDefaultBranchProbability(
            final BranchAction branchAction) {

        for(final AbstractBranchTransition branchTransition : branchAction.getBranches_Branch()) {
            if(branchTransition instanceof ProbabilisticBranchTransition) {

                final double probability = 1.0d / branchAction.getBranches_Branch().size();
                ((ProbabilisticBranchTransition)branchTransition).setBranchProbability(probability);
                //				BranchProbability branchProbability = SeffdecoratorFactory.eINSTANCE.createBranchProbability();
                //				ConstantNumber constantNumber = QosannotationsFactory.eINSTANCE.createConstantNumber();
                // equal probability
                //				constantNumber.setValue(probability);
                //				branchProbability.setConstantNumber(constantNumber);
                //				branchProbability.setAnnotationType(AnnotationType.REQUIREMENT);
                ((ProbabilisticBranchTransition)branchTransition).setEntityName("SoMoX default branch probability");
                //				branchProbability.setDocumentation("Replace this value with real measured or estimated values");
                //				branchProbability.setProbabilisticBranchTransition((de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition)branchTransition);

                //				qosAnnotationsModel.get Annotation().add(branchProbability);
            } else {
                logger.warn("Unsupported branch transition type. Only ProbabilisticBranchTransition supported");
            }
        }
    }

    private void createDefaultLoopCount(final LoopAction loopAction) {

        final PCMRandomVariable loopCount = CoreFactory.eINSTANCE.createPCMRandomVariable();
        loopCount.setSpecification("1");
        loopAction.setIterationCount_LoopAction(loopCount);
        loopAction.setEntityName("SoMoX default loop count value");
        //		ParametricFormula parametricFormula = QosannotationFactory.eINSTANCE.createParametricFormula();
        //		parametricFormula.setSpecification("1"); //constant default
        //		loopCount.setParametricFormula(parametricFormula);
        //		loopCount.setAnnotationType(AnnotationType.REQUIREMENT);
        //		loopCount.set("SoMoX default loop count value");
        //		loopCount.setDocumentation("Replace this value with real measured or estimated values");
        //		loopCount.setLoopAction(loopAction);

        //		qosAnnotationsModel.getAnnotation().add(loopCount);
    }

    private void createDefaultCpuResourceDemand(final InternalAction internalAction) {
        final ParametricResourceDemand prd = SeffPerformanceFactory.eINSTANCE.createParametricResourceDemand();
        final PCMRandomVariable randomVar = CoreFactory.eINSTANCE.createPCMRandomVariable();
        randomVar.setSpecification("0");
        prd.setSpecification_ParametericResourceDemand( randomVar);
        internalAction.getResourceDemand_Action().add(prd);
        prd.setRequiredResource_ParametricResourceDemand(DefaultResourceEnvironment.getCPUProcessingResourceType());



        //		CpuResourceDemand resourceDemand = SeffdecoratorFactory.eINSTANCE.createCpuResourceDemand();
        //		ParametricFormula parametricFormula = QosannotationFactory.eINSTANCE.createParametricFormula();
        //		parametricFormula.setSpecification("1"); //constant default
        //		resourceDemand.setParametricFormula(parametricFormula);
        //		resourceDemand.setAnnotationType(AnnotationType.REQUIREMENT);
        //Hauck: QoS annotation resource demand does not have reference to execution resource anymore
        //resourceDemand.setExecutionResource(defaultModelLoader.getDefaultExecutionResource());
        //		resourceDemand.setName("SoMoX default CPU resource demand");
        //		resourceDemand.setDocumentation("Replace this value with real measured or estimated values");
        prd.setAction_ParametricResourceDemand(internalAction);
        //		resourceDemand.setInternalAction(internalAction);

        //		qosAnnotationsModel.getAnnotation().add(resourceDemand);
    }
}
