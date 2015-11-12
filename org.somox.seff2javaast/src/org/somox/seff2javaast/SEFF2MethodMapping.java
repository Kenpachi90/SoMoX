/**
 */
package org.somox.seff2javaast;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmt.modisco.java.Block;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>SEFF2 Method Mapping</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.somox.seff2javaast.SEFF2MethodMapping#getBlockstatement <em>Blockstatement</em>}
 * </li>
 * <li>{@link org.somox.seff2javaast.SEFF2MethodMapping#getSeff <em>Seff</em>}</li>
 * </ul>
 *
 * @see org.somox.seff2javaast.Seff2methodPackage#getSEFF2MethodMapping()
 * @model
 * @generated
 */
public interface SEFF2MethodMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Blockstatement</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blockstatement</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Blockstatement</em>' reference.
     * @see #setBlockstatement(Block)
     * @see org.somox.seff2javaast.Seff2methodPackage#getSEFF2MethodMapping_Blockstatement()
     * @model required="true" ordered="false"
     * @generated
     */
    Block getBlockstatement();

    /**
     * Sets the value of the '{@link org.somox.seff2javaast.SEFF2MethodMapping#getBlockstatement
     * <em>Blockstatement</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Blockstatement</em>' reference.
     * @see #getBlockstatement()
     * @generated
     */
    void setBlockstatement(Block value);

    /**
     * Returns the value of the '<em><b>Seff</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Seff</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Seff</em>' reference.
     * @see #setSeff(ServiceEffectSpecification)
     * @see org.somox.seff2javaast.Seff2methodPackage#getSEFF2MethodMapping_Seff()
     * @model required="true" ordered="false"
     * @generated
     */
    ServiceEffectSpecification getSeff();

    /**
     * Sets the value of the '{@link org.somox.seff2javaast.SEFF2MethodMapping#getSeff <em>Seff</em>
     * }' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Seff</em>' reference.
     * @see #getSeff()
     * @generated
     */
    void setSeff(ServiceEffectSpecification value);

} // SEFF2MethodMapping
