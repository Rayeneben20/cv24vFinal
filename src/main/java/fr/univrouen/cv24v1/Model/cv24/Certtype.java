//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour certtype.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="certtype"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MAT"/&gt;
 *     &lt;enumeration value="CLES"/&gt;
 *     &lt;enumeration value="TOEIC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "certtype")
@XmlEnum
public enum

Certtype {

    MAT,
    CLES,
    TOEIC;

    public String value() {
        return name();
    }

    public static Certtype fromValue(String v) {
        return valueOf(v);
    }

}
