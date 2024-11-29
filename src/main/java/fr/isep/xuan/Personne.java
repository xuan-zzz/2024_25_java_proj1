package fr.isep.xuan;

public abstract class Personne {
    String identifiant;
    String nom;
    String adresse;
    String contacte;

    Personne(String identifiant, String nom, String adresse,
             String contacte){
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        return "Identifiant:'" + identifiant + '\'' +
                "\nNom:'" + nom + '\'' +
                "\nAdresse:'" + adresse + '\'' +
                "\nContacte:'" + contacte;
    }

    void obtenirInfos(){
        System.out.println(this.toString());
    };
}
