package fr.univrouen.cv24v1.Model;

import fr.univrouen.cv24v1.Model.cv24.Cv24;
import fr.univrouen.cv24v1.Model.cv24.CompetencesType;
import fr.univrouen.cv24v1.Model.cv24.IdentiteType;
import fr.univrouen.cv24v1.Model.cv24.ObjectifType;
import fr.univrouen.cv24v1.Model.cv24.ProfType;
import fr.univrouen.cv24v1.Model.cv24.DiversType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@Document(collection = "cv24")
public class Cv24id {

    @Id
    private String id;

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    private Cv24 cv;

    public Cv24id() {}

    public Cv24 getCv24(){
        return this.cv;
    }

    public void setCv24(Cv24 cv){
        this.cv=cv;

    }

    public Cv24id(Cv24 cv) {
        this.cv = cv;
    }

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    public IdentiteType getIdentite() {
        return cv.getIdentite();
    }

    public void setIdentite(IdentiteType value) {
        this.cv.setIdentite(value);
    }

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    public ObjectifType getObjectif() {
        return cv.getObjectif();
    }

    public void setObjectif(ObjectifType value) {
        this.cv.setObjectif(value);
    }

    @XmlElement(namespace = "http://univ.fr/cv24")
    public ProfType getProf() {
        return cv.getProf();
    }

    public void setProf(ProfType value) {
        this.cv.setProf(value);
    }

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    public CompetencesType getCompetences() {
        return cv.getCompetences();
    }

    public void setCompetences(CompetencesType value) {
        this.cv.setCompetences(value);
    }

    @XmlElement(namespace = "http://univ.fr/cv24")
    public DiversType getDivers() {
        return cv.getDivers();
    }

    public void setDivers(DiversType value) {
        this.cv.setDivers(value);
    }
 }
