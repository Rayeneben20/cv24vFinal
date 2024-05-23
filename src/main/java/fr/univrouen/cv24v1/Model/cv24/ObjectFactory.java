//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:21:26 AM CEST 
//


package fr.univrouen.cv24v1.Model.cv24;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.univ.cv24 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Identite_QNAME = new QName("http://univ.fr/cv24", "identite");
    private final static QName _Objectif_QNAME = new QName("http://univ.fr/cv24", "objectif");
    private final static QName _Prof_QNAME = new QName("http://univ.fr/cv24", "prof");
    private final static QName _Competences_QNAME = new QName("http://univ.fr/cv24", "competences");
    private final static QName _Divers_QNAME = new QName("http://univ.fr/cv24", "divers");
    private final static QName _Genre_QNAME = new QName("http://univ.fr/cv24", "Genre");
    private final static QName _Nom_QNAME = new QName("http://univ.fr/cv24", "nom");
    private final static QName _Prenom_QNAME = new QName("http://univ.fr/cv24", "prenom");
    private final static QName _Tel_QNAME = new QName("http://univ.fr/cv24", "tel");
    private final static QName _Mel_QNAME = new QName("http://univ.fr/cv24", "mel");
    private final static QName _Detail_QNAME = new QName("http://univ.fr/cv24", "detail");
    private final static QName _Datedeb_QNAME = new QName("http://univ.fr/cv24", "datedeb");
    private final static QName _Datefin_QNAME = new QName("http://univ.fr/cv24", "datefin");
    private final static QName _Titre_QNAME = new QName("http://univ.fr/cv24", "titre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.univ.cv24
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cv24 }
     * 
     */
    public Cv24 createCv24() {
        return new Cv24();
    }

    /**
     * Create an instance of {@link IdentiteType }
     * 
     */
    public IdentiteType createIdentiteType() {
        return new IdentiteType();
    }

    /**
     * Create an instance of {@link ObjectifType }
     * 
     */
    public ObjectifType createObjectifType() {
        return new ObjectifType();
    }

    /**
     * Create an instance of {@link ProfType }
     * 
     */
    public ProfType createProfType() {
        return new ProfType();
    }

    /**
     * Create an instance of {@link CompetencesType }
     * 
     */
    public CompetencesType createCompetencesType() {
        return new CompetencesType();
    }

    /**
     * Create an instance of {@link DiversType }
     * 
     */
    public DiversType createDiversType() {
        return new DiversType();
    }

    /**
     * Create an instance of {@link DetailType }
     * 
     */
    public DetailType createDetailType() {
        return new DetailType();
    }

    /**
     * Create an instance of {@link DiplomeType }
     * 
     */
    public DiplomeType createDiplomeType() {
        return new DiplomeType();
    }

    /**
     * Create an instance of {@link CertifType }
     * 
     */
    public CertifType createCertifType() {
        return new CertifType();
    }

    /**
     * Create an instance of {@link LvType }
     * 
     */
    public LvType createLvType() {
        return new LvType();
    }

    /**
     * Create an instance of {@link AutreType }
     * 
     */
    public AutreType createAutreType() {
        return new AutreType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentiteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentiteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "identite")
    public JAXBElement<IdentiteType> createIdentite(IdentiteType value) {
        return new JAXBElement<IdentiteType>(_Identite_QNAME, IdentiteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectifType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjectifType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "objectif")
    public JAXBElement<ObjectifType> createObjectif(ObjectifType value) {
        return new JAXBElement<ObjectifType>(_Objectif_QNAME, ObjectifType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProfType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "prof")
    public JAXBElement<ProfType> createProf(ProfType value) {
        return new JAXBElement<ProfType>(_Prof_QNAME, ProfType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompetencesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompetencesType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "competences")
    public JAXBElement<CompetencesType> createCompetences(CompetencesType value) {
        return new JAXBElement<CompetencesType>(_Competences_QNAME, CompetencesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiversType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DiversType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "divers")
    public JAXBElement<DiversType> createDivers(DiversType value) {
        return new JAXBElement<DiversType>(_Divers_QNAME, DiversType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenreType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenreType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "Genre")
    public JAXBElement<GenreType> createGenre(GenreType value) {
        return new JAXBElement<GenreType>(_Genre_QNAME, GenreType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "nom")
    public JAXBElement<String> createNom(String value) {
        return new JAXBElement<String>(_Nom_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "prenom")
    public JAXBElement<String> createPrenom(String value) {
        return new JAXBElement<String>(_Prenom_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "tel")
    public JAXBElement<String> createTel(String value) {
        return new JAXBElement<String>(_Tel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "mel")
    public JAXBElement<String> createMel(String value) {
        return new JAXBElement<String>(_Mel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetailType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "detail")
    public JAXBElement<DetailType> createDetail(DetailType value) {
        return new JAXBElement<DetailType>(_Detail_QNAME, DetailType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "datedeb")
    public JAXBElement<String> createDatedeb(String value) {
        return new JAXBElement<String>(_Datedeb_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "datefin")
    public JAXBElement<String> createDatefin(String value) {
        return new JAXBElement<String>(_Datefin_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "titre")
    public JAXBElement<String> createTitre(String value) {
        return new JAXBElement<String>(_Titre_QNAME, String.class, null, value);
    }

}
