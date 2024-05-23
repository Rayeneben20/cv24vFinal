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
 * <p>Classe Java pour detailType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="detailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://univ.fr/cv24}datedeb"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}datefin" minOccurs="0"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}titre"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailType", propOrder = {
    "datedeb",
    "datefin",
    "titre"
})
public class DetailType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected String datedeb;
    @XmlSchemaType(name = "date")
    protected String datefin;
    @XmlElement(required = true)
    protected String titre;

    /**
     * Obtient la valeur de la propriété datedeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatedeb() {
        return datedeb;
    }

    /**
     * Définit la valeur de la propriété datedeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatedeb(String value) {
        this.datedeb = value;
    }

    /**
     * Obtient la valeur de la propriété datefin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatefin() {
        return datefin;
    }

    /**
     * Définit la valeur de la propriété datefin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatefin(String value) {
        this.datefin = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

}
