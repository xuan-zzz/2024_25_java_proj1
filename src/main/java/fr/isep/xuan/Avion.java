package fr.isep.xuan;

public class Avion {
    private int immatriculation;
    private String modele;
    private int capacite;

    Avion(int immatriculation, String modele, int capacite){
        this.immatriculation =immatriculation;
        this. modele = modele;
        this.capacite = capacite;
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
