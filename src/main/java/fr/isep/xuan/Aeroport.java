package fr.isep.xuan;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    Aeroport(String nom, String ville, String description){
        this.nom = nom;
        this.ville = ville;
        this. description = description;
        System.out.println();
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
