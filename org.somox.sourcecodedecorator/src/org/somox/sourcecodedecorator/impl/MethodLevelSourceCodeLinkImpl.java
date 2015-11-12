/**
 */
package org.somox.sourcecodedecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmt.modisco.java.AbstractMethodDeclaration;
import org.palladiosimulator.pcm.repository.Signature;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Method Level Source Code Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.somox.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl#getOperation
 * <em>Operation</em>}</li>
 * <li>{@link org.somox.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl#getFunction
 * <em>Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodLevelSourceCodeLinkImpl extends FileLevelSourceCodeLinkImpl implements MethodLevelSourceCodeLink {
    /**
     * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOperation()
     * @generated
     * @ordered
     */
    protected Signature operation;

    /**
     * The cached value of the '{@link #getFunction() <em>Function</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFunction()
     * @generated
     * @ordered
     */
    protected AbstractMethodDeclaration function;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected MethodLevelSourceCodeLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SourceCodeDecoratorPackage.Literals.METHOD_LEVEL_SOURCE_CODE_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getOperation() {
        if (this.operation != null && ((EObject) this.operation).eIsProxy()) {
            final InternalEObject oldOperation = (InternalEObject) this.operation;
            this.operation = (Signature) this.eResolveProxy(oldOperation);
            if (this.operation != oldOperation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION, oldOperation,
                            this.operation));
                }
            }
        }
        return this.operation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetOperation() {
        return this.operation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperation(final Signature newOperation) {
        final Signature oldOperation = this.operation;
        this.operation = newOperation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION, oldOperation, this.operation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractMethodDeclaration getFunction() {
        if (this.function != null && this.function.eIsProxy()) {
            final InternalEObject oldFunction = (InternalEObject) this.function;
            this.function = (AbstractMethodDeclaration) this.eResolveProxy(oldFunction);
            if (this.function != oldFunction) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION, oldFunction,
                            this.function));
                }
            }
        }
        return this.function;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AbstractMethodDeclaration basicGetFunction() {
        return this.function;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFunction(final AbstractMethodDeclaration newFunction) {
        final AbstractMethodDeclaration oldFunction = this.function;
        this.function = newFunction;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION, oldFunction, this.function));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION:
            if (resolve) {
                return this.getOperation();
            }
            return this.basicGetOperation();
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION:
            if (resolve) {
                return this.getFunction();
            }
            return this.basicGetFunction();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION:
            this.setOperation((Signature) newValue);
            return;
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION:
            this.setFunction((AbstractMethodDeclaration) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION:
            this.setOperation((Signature) null);
            return;
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION:
            this.setFunction((AbstractMethodDeclaration) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__OPERATION:
            return this.operation != null;
        case SourceCodeDecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK__FUNCTION:
            return this.function != null;
        }
        return super.eIsSet(featureID);
    }

} // MethodLevelSourceCodeLinkImpl
