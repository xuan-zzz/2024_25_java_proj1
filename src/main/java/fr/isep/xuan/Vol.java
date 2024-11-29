package fr.isep.xuan;

public class Vol {
    private int numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;

    Vol(int numeroVol, Aeroport origine, Aeroport destination,
        String dateHeureDepart, String dateHeureArrivee, String etat){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
    }

    public Aeroport getDestination() {
        return destination;
    }

    public Aeroport getOrigine() {
        return origine;
    }

    public int getNumeroVol() {
        return numeroVol;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public String getEtat() {
        return etat;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNumeroVol(int numeroVol) {
        this.numeroVol = numeroVol;
    }

    public void setOrigine(Aeroport origine) {
        this.origine = origine;
    }
}
