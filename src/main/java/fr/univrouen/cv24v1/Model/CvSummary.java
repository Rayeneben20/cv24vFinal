package fr.univrouen.cv24v1.Model;

import fr.univrouen.cv24v1.Model.cv24.GenreType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CvSummary")
public class CvSummary {

    private String id;
    private GenreType genre;
    private String prenom;
    private String nom;
    private String objectif;
    private String diplome;

    public CvSummary() {}

    public CvSummary(String id, GenreType genre, String prenom, String nom, String objectif, String diplome) {
        this.id = id;
        this.genre = genre;
        this.prenom = prenom;
        this.nom = nom;
        this.objectif = objectif;
        this.diplome = diplome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
}
