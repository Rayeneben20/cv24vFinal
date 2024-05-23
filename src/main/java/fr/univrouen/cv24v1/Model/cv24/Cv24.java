package fr.univrouen.cv24v1.Model.cv24;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
public class Cv24 {

    @XmlElement(required = true, namespace = "http://univ.fr/cv24")
    protected IdentiteType identite;

    @XmlElement(required = true, namespace = "http://univ.fr/cv24")
    protected ObjectifType objectif;

    @XmlElement(namespace = "http://univ.fr/cv24")
    protected ProfType prof;

    @XmlElement(required = true, namespace = "http://univ.fr/cv24")
    protected CompetencesType competences;

    @XmlElement(namespace = "http://univ.fr/cv24")
    protected DiversType divers;

    public IdentiteType getIdentite() {
        return identite;
    }

    public void setIdentite(IdentiteType identite) {
        this.identite = identite;
    }

    public ObjectifType getObjectif() {
        return objectif;
    }

    public void setObjectif(ObjectifType objectif) {
        this.objectif = objectif;
    }

    public ProfType getProf() {
        return prof;
    }

    public void setProf(ProfType prof) {
        this.prof = prof;
    }

    public CompetencesType getCompetences() {
        return competences;
    }

    public void setCompetences(CompetencesType competences) {
        this.competences = competences;
    }

    public DiversType getDivers() {
        return divers;
    }

    public void setDivers(DiversType divers) {
        this.divers = divers;
    }
}
