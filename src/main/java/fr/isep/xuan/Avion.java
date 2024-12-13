package fr.isep.xuan;

import java.util.Random;

import static fr.isep.xuan.Main.avionsLibres;
import static fr.isep.xuan.Main.immatriculations;

public class Avion {
    private int immatriculation;
    private String modele;
    private int capacite;

    Avion(){ //genere un avion en choisisant aleatoirement un modele et un numero d'immatriculation
        Random rdm = new Random();
        int randomImmatriculation = rdm.nextInt(10000);
        while (immatriculations.contains(randomImmatriculation))
            randomImmatriculation = rdm.nextInt(10000);
        this.immatriculation = randomImmatriculation;
        String[] defaultModels = {"Boeing 737", "Airbus A320", "Boeing 747", "Airbus A330"};
        int modeleRandom = rdm.nextInt(defaultModels.length);
        this.modele = defaultModels[modeleRandom];
        int[] defaultCapacity = {130, 180, 500, 370};
        this.capacite = defaultCapacity[modeleRandom];
    }

    Avion(int immatriculation, String modele, int capacite){
        this.immatriculation =immatriculation;
        this. modele = modele;
        this.capacite = capacite;
    }

    void affecterVol(Vol v){
        if (v.getAvion() != null){
            avionsLibres.add(v.getAvion());
        }
        v.setAvion(this);
        avionsLibres.remove(this);
    }

    public int getCapacite() {
        return capacite;
    }

    public int getImmatriculation() {
        return immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}
