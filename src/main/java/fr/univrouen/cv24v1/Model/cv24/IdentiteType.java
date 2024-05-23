//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Description
 * 
 * <p>Classe Java pour identiteType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="identiteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://univ.fr/cv24}Genre"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}nom"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}prenom"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}tel" minOccurs="0"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}mel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identiteType", propOrder = {
    "genre",
    "nom",
    "prenom",
    "tel",
    "mel"
})
public class IdentiteType {

    @XmlElement(name = "Genre", required = true)
    @XmlSchemaType(name = "string")
    protected GenreType genre;
    @XmlElement(required = true)
    protected String nom;
    @XmlElement(required = true)
    protected String prenom;
    protected String tel;
    protected String mel;

    /**
     * Obtient la valeur de la propriété genre.
     * 
     * @return
     *     possible object is
     *     {@link GenreType }
     *     
     */
    public GenreType getGenre() {
        return genre;
    }

    /**
     * Définit la valeur de la propriété genre.
     * 
     * @param value
     *     allowed object is
     *     {@link GenreType }
     *     
     */
    public void setGenre(GenreType value) {
        this.genre = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit la valeur de la propriété prenom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Obtient la valeur de la propriété tel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel() {
        return tel;
    }

    /**
     * Définit la valeur de la propriété tel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel(String value) {
        this.tel = value;
    }

    /**
     * Obtient la valeur de la propriété mel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMel() {
        return mel;
    }

    /**
     * Définit la valeur de la propriété mel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMel(String value) {
        this.mel = value;
    }

}
