package fr.isep.xuan;

public abstract class Personne {
    private String identifiant;
    private String nom;
    private String adresse;
    private String contacte;

    Personne(String identifiant, String nom, String adresse, String contacte){
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        return "Identifiant:'" + identifiant +
                "\nNom:'" + nom +
                "\nAdresse:'" + adresse +
                "\nContacte:'" + contacte;
    }

    void obtenirInfos(){
        System.out.println(this.toString());
    };

    public String getAdresse() {
        return adresse;
    }

    public String getContacte() {
        return contacte;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setContacte(String contacte) {
        this.contacte = contacte;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
