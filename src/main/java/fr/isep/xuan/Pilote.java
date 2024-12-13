package fr.isep.xuan;

import java.time.LocalDate;
import java.util.Random;

public class Pilote extends Employe{
    private int licence;
    private int heuresDeVol;

    Pilote(){
        super("Pilote");
        Random rdm = new Random();
        this.licence = rdm.nextInt(100000000);
        this.heuresDeVol = 1500 + rdm.nextInt(15000);
    }

    Pilote(String nom, String prenom, String adresse, String contacte,
           int numeroEmploye, LocalDate dateEmbauche, int licence, int heuresDeVol){
        super("Pilote", nom, prenom, adresse, contacte, numeroEmploye, dateEmbauche);
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

    public int getLicence() {
        return licence;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    public void setLicence(int licence) {
        this.licence = licence;
    }
}
