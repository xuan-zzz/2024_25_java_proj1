package fr.isep.xuan;

import java.util.Random;

public class Passager extends Personne{
    private String passeport;

    Passager(){
        super("Passager");
        Random rdm = new Random();
        String nums1 = String.format("%02d", rdm.nextInt(100));
        char lettre1 = (char) ('A' + rdm.nextInt(26));
        char lettre2 = (char) ('A' + rdm.nextInt(26));
        String nums2 = String.format("%05d", rdm.nextInt(100000));
        this.passeport = nums1 + lettre1 + "" + lettre2 + nums2;
    }

    Passager(String nom, String prenom, String adresse, String contacte, String passeport){
        super("Passager", nom, prenom, adresse, contacte);
        this.passeport = passeport;
    }

    public boolean reserverVol(Vol v){
        if (v.getPassagerMap().size()<v.getAvion().getCapacite()){
            v.getPassagerMap().put(this.passeport, this);
            return true;
        }
        else return false;
    }

    public String toString() {
        return super.toString() +
                "\nNuméro de passeport:" + passeport;
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }
}
