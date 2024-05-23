//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour competencesType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="competencesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="diplome" type="{http://univ.fr/cv24}diplomeType" maxOccurs="5"/&gt;
 *         &lt;element name="certif" type="{http://univ.fr/cv24}certifType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competencesType", propOrder = {
    "diplome",
    "certif"
})
public class CompetencesType {

    @XmlElement(required = true)
    protected List<DiplomeType> diplome;
    @XmlElement(required = true)
    protected List<CertifType> certif;

    /**
     * Gets the value of the diplome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the diplome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiplome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiplomeType }
     * 
     * 
     */
    public List<DiplomeType> getDiplome() {
        if (diplome == null) {
            diplome = new ArrayList<DiplomeType>();
        }
        return this.diplome;
    }

    /**
     * Gets the value of the certif property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the certif property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertif().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertifType }
     * 
     * 
     */
    public List<CertifType> getCertif() {
        if (certif == null) {
            certif = new ArrayList<CertifType>();
        }
        return this.certif;
    }

}
