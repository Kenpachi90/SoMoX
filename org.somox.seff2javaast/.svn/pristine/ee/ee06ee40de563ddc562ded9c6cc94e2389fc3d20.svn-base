/**
 */
package org.somox.seff2javaast.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.somox.seff2javaast.SEFF2JavaAST;
import org.somox.seff2javaast.SEFF2MethodMapping;
import org.somox.seff2javaast.Seff2methodFactory;
import org.somox.seff2javaast.Seff2methodPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class Seff2methodFactoryImpl extends EFactoryImpl implements Seff2methodFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static Seff2methodFactory init() {
        try {
            final Seff2methodFactory theSeff2methodFactory = (Seff2methodFactory) EPackage.Registry.INSTANCE
                    .getEFactory(Seff2methodPackage.eNS_URI);
            if (theSeff2methodFactory != null) {
                return theSeff2methodFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Seff2methodFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Seff2methodFactoryImpl() {
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
        case Seff2methodPackage.SEFF2_METHOD_MAPPING:
            return this.createSEFF2MethodMapping();
        case Seff2methodPackage.SEFF2_JAVA_AST:
            return this.createSEFF2JavaAST();
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
    public SEFF2MethodMapping createSEFF2MethodMapping() {
        final SEFF2MethodMappingImpl seff2MethodMapping = new SEFF2MethodMappingImpl();
        return seff2MethodMapping;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SEFF2JavaAST createSEFF2JavaAST() {
        final SEFF2JavaASTImpl seff2JavaAST = new SEFF2JavaASTImpl();
        return seff2JavaAST;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Seff2methodPackage getSeff2methodPackage() {
        return (Seff2methodPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Seff2methodPackage getPackage() {
        return Seff2methodPackage.eINSTANCE;
    }

} // Seff2methodFactoryImpl
