/**
 */
package org.somox.sourcecodedecorator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.ControlFlowLevelSourceCodeLink;
import org.somox.sourcecodedecorator.FileLevelSourceCodeLink;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.PCMSystemImplementatingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.somox.sourcecodedecorator.SourceCodeDecoratorPackage
 * @generated
 */
public class SourceCodeDecoratorSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static SourceCodeDecoratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SourceCodeDecoratorSwitch() {
        if (modelPackage == null) {
            modelPackage = SourceCodeDecoratorPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case SourceCodeDecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK: {
            final FileLevelSourceCodeLink fileLevelSourceCodeLink = (FileLevelSourceCodeLink) theEObject;
            T result = this.caseFileLevelSourceCodeLink(fileLevelSourceCodeLink);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK: {
            final MethodLevelSourceCodeLink methodLevelSourceCodeLink = (MethodLevelSourceCodeLink) theEObject;
            T result = this.caseMethodLevelSourceCodeLink(methodLevelSourceCodeLink);
            if (result == null) {
                result = this.caseFileLevelSourceCodeLink(methodLevelSourceCodeLink);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK: {
            final ControlFlowLevelSourceCodeLink controlFlowLevelSourceCodeLink = (ControlFlowLevelSourceCodeLink) theEObject;
            T result = this.caseControlFlowLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
            if (result == null) {
                result = this.caseMethodLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
            }
            if (result == null) {
                result = this.caseFileLevelSourceCodeLink(controlFlowLevelSourceCodeLink);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY: {
            final SourceCodeDecoratorRepository sourceCodeDecoratorRepository = (SourceCodeDecoratorRepository) theEObject;
            T result = this.caseSourceCodeDecoratorRepository(sourceCodeDecoratorRepository);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.INTERFACE_SOURCE_CODE_LINK: {
            final InterfaceSourceCodeLink interfaceSourceCodeLink = (InterfaceSourceCodeLink) theEObject;
            T result = this.caseInterfaceSourceCodeLink(interfaceSourceCodeLink);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.COMPONENT_IMPLEMENTING_CLASSES_LINK: {
            final ComponentImplementingClassesLink componentImplementingClassesLink = (ComponentImplementingClassesLink) theEObject;
            T result = this.caseComponentImplementingClassesLink(componentImplementingClassesLink);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case SourceCodeDecoratorPackage.PCM_SYSTEM_IMPLEMENTATING_CLASSES_LINK: {
            final PCMSystemImplementatingClassesLink pcmSystemImplementatingClassesLink = (PCMSystemImplementatingClassesLink) theEObject;
            T result = this.casePCMSystemImplementatingClassesLink(pcmSystemImplementatingClassesLink);
            if (result == null) {
                result = this.caseComponentImplementingClassesLink(pcmSystemImplementatingClassesLink);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>File Level Source Code Link</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>File Level Source Code Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileLevelSourceCodeLink(final FileLevelSourceCodeLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Method Level Source Code Link</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Method Level Source Code Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMethodLevelSourceCodeLink(final MethodLevelSourceCodeLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Control Flow Level Source Code Link</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Control Flow Level Source Code Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseControlFlowLevelSourceCodeLink(final ControlFlowLevelSourceCodeLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Repository</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceCodeDecoratorRepository(final SourceCodeDecoratorRepository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Interface Source Code Link</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Interface Source Code Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInterfaceSourceCodeLink(final InterfaceSourceCodeLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Component Implementing Classes Link</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Component Implementing Classes Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentImplementingClassesLink(final ComponentImplementingClassesLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCM System Implementating Classes Link</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCM System Implementating Classes Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMSystemImplementatingClassesLink(final PCMSystemImplementatingClassesLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // SourceCodeDecoratorSwitch
