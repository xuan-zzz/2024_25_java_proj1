package fr.isep.xuan;

public class Pilote extends Employe{
    String licence;
    int heuresDeVol;

    Pilote(String nom, String adresse, String contacte,
           int numeroEmploye, String dateEmbauche,
           String licence, int heuresDeVol){
        super("Pilote", nom, adresse, contacte, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLicence:" + licence +
                "\nHeures de Vol: " + heuresDeVol;
    }
}
