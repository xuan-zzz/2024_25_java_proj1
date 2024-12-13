package fr.isep.xuan;

import java.util.Random;

import static fr.isep.xuan.Main.*;

public abstract class Personne {
    private String identifiant;
    private String nom;
    private String prenom;
    private String adresse;
    private String contacte;

    Personne(String identifiant){
        this.identifiant = identifiant;
        Random rdm = new Random();
        this.nom = noms[rdm.nextInt(noms.length)];
        this.prenom = prenoms[rdm.nextInt(prenoms.length)];
        this.contacte = this.prenom + "." + this.nom + "@gmail.com";
        String[] rues = readNames("rues.txt");
        String[] villes = readNames("villes.txt");
        this.adresse = rdm.nextInt(100) + " " + rues[rdm.nextInt(rues.length)] + ", " +
                villes[rdm.nextInt(villes.length)] + ", France";
    }

    Personne(String identifiant, String nom, String prenom, String adresse, String contacte){
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        return "Identifiant:" + identifiant +
                "\nNom:" + nom + " " +prenom +
                "\nAdresse:" + adresse +
                "\nContacte:" + contacte;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
