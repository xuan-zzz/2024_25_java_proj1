package fr.isep.xuan;

public class Pilote extends Employe{
    private String licence;
    private int heuresDeVol;

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

    @Override
    String obtenirRole() { return "Pilote"; }

    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public String getLicence() {
        return licence;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
}
