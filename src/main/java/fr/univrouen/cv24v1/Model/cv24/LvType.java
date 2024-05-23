//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour lvType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="lvType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="lang" use="required" type="{http://univ.fr/cv24}ISO69" /&gt;
 *       &lt;attribute name="cert" use="required" type="{http://univ.fr/cv24}certtype" /&gt;
 *       &lt;attribute name="nivs" type="{http://univ.fr/cv24}nivstype" /&gt;
 *       &lt;attribute name="nivi" type="{http://univ.fr/cv24}nivitype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lvType")
public class LvType {

    @XmlAttribute(name = "lang", required = true)
    protected String lang;
    @XmlAttribute(name = "cert", required = true)
    protected Certtype cert;
    @XmlAttribute(name = "nivs")
    protected String nivs;
    @XmlAttribute(name = "nivi")
    protected Integer nivi;

    /**
     * Obtient la valeur de la propriété lang.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Définit la valeur de la propriété lang.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Obtient la valeur de la propriété cert.
     * 
     * @return
     *     possible object is
     *     {@link Certtype }
     *     
     */
    public Certtype getCert() {
        return cert;
    }

    /**
     * Définit la valeur de la propriété cert.
     * 
     * @param value
     *     allowed object is
     *     {@link Certtype }
     *     
     */
    public void setCert(Certtype value) {
        this.cert = value;
    }

    /**
     * Obtient la valeur de la propriété nivs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivs() {
        return nivs;
    }

    /**
     * Définit la valeur de la propriété nivs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivs(String value) {
        this.nivs = value;
    }

    /**
     * Obtient la valeur de la propriété nivi.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNivi() {
        return nivi;
    }

    /**
     * Définit la valeur de la propriété nivi.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNivi(Integer value) {
        this.nivi = value;
    }

}
