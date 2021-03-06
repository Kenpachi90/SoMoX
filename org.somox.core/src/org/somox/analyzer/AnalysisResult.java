package org.somox.analyzer;

import java.util.List;

import org.palladiosimulator.pcm.allocation.Allocation;
import org.palladiosimulator.pcm.qosannotations.QoSAnnotations;
import org.palladiosimulator.pcm.repository.Repository;
import org.somox.common.Message;
import org.somox.seff2javaast.SEFF2JavaAST;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * The result of an analysis iteration.
 *
 * This result object contains all information about the last
 * model analyzer result like the status or the analyzed model
 *
 * @author Benjamin Klatt
 *
 */
public interface AnalysisResult {

    // ---------------------------------
    // Static Data Fields
    // ---------------------------------

    /**
     * The result status of the analysis step
     */
    public enum ResultStatus {/**
     * @uml.property  name="nOT_EXECUTED"
     * @uml.associationEnd
     */
        NOT_EXECUTED,/**
         * @uml.property  name="sUCCESS"
         * @uml.associationEnd
         */
        SUCCESS,/**
         * @uml.property  name="fAILED"
         * @uml.associationEnd
         */
        FAILED}

    // ---------------------------------
    // Business Methods
    // ---------------------------------

    // ---------------------------------
    // Getters / Setters
    // ---------------------------------

    /**
     * The result status of the extraction.
     * Will be one of the constants AnalysisResult.ResultStatus
     * @return The status of the analysis
     */
    public AnalysisResult.ResultStatus getResultStatus();


    /**
     * Get the PCM allocation model
     * @return the PCM allocation
     */
    public Allocation getAllocation();

    /**
     * Get  the Model Analyzer that was performed
     * @return The model analyzer that has been executed
     */
    public ModelAnalyzer getModelAnalyzer();

    /**
     * Get the resulting internal architectural model
     * @return PCM model repository.
     */
    public Repository getInternalArchitectureModel();

    /**
     * SEFF2JavaAST repository to create
     */
    public SEFF2JavaAST getSeff2JavaAST();

    /**
     * Source code decorator to update
     * @return
     */
    public SourceCodeDecoratorRepository getSourceCodeDecoratorRepository();

    /**
     * PCM System (outer most component encapsulated).
     */
    public org.palladiosimulator.pcm.system.System getSystemModel();

    /**
     * QoS Annotation model
     */
    public QoSAnnotations getQosAnnotationModel();

    /**
     * Add a message object to the result
     *
     * @param message The message object
     */
    public void addMessage(Message message);

    /**
     * Get a list of all message objects assigned to this result
     * @return List of all assigned message objects
     */
    public List<Message> getMessages();

}
