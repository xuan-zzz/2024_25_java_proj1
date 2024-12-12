package fr.isep.xuan;

import java.util.List;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    Aeroport(String nom, String ville, String description){
        this.nom = nom;
        this.ville = ville;
        this. description = description;
    }

    void affecterVol(Vol v, Pilote p, List<PersonnelCabine> pc){
        v.getEmployeMap().get("Pilotes").add(p);
        for (PersonnelCabine e: pc){
            v.getEmployeMap().get("Personnel de Cabine").add(e);
        }
    }

    void affecterVol(Vol v, Pilote p){
        v.getEmployeMap().get("Pilotes").add(p);
    }

    void affecterVol(Vol v, List<PersonnelCabine> pc){
        for (PersonnelCabine e: pc){
            v.getEmployeMap().get("Personnel de Cabine").add(e);
        }
    }

    void affecterVol(Vol v, PersonnelCabine e){
        v.getEmployeMap().get("Personnel de Cabine").add(e);
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getVille() {
        return ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
