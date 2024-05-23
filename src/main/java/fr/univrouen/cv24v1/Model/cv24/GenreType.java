//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour genreType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="genreType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="M."/&gt;
 *     &lt;enumeration value="Mme"/&gt;
 *     &lt;enumeration value="Mrs"/&gt;
 *     &lt;enumeration value="Miss"/&gt;
 *     &lt;enumeration value="Mr"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "genreType")
@XmlEnum
public enum GenreType {

    @XmlEnumValue("M.")
    M("M."),
    @XmlEnumValue("Mme")
    MME("Mme"),
    @XmlEnumValue("Mrs")
    MRS("Mrs"),
    @XmlEnumValue("Miss")
    MISS("Miss"),
    @XmlEnumValue("Mr")
    MR("Mr");
    private final String value;

    GenreType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenreType fromValue(String v) {
        for (GenreType c: GenreType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
