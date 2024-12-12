package fr.isep.xuan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static fr.isep.xuan.Main.avionLibre;
import static fr.isep.xuan.Main.volMap;

public class Vol {
    private int numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Map<String, LinkedList<Employe>> employeMap;
    private Map<Integer, Passager> passagerMap;
    private Avion avion;

    Vol(int numeroVol, Aeroport origine, Aeroport destination,
        String dateHeureDepart, String dateHeureArrivee){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "A l'heure";
        this.employeMap = new HashMap<String, LinkedList<Employe>>()    {{
            put("Pilotes", new LinkedList<Employe>());
            put("Personnel de Cabine", new LinkedList<Employe>());      }};
        this.passagerMap = new HashMap<Integer, Passager>();
        avionLibre.getFirst().affecterVol(this);
    }

    void modifierVol(String s){
        this.etat = s;
    }

    static void obtenirVol(int numeroVol){
        Vol v = volMap.get(numeroVol);
        System.out.println("Numéro de vol: " + numeroVol);
        System.out.println("De " + v.origine.getNom() + " a " + v.destination.getNom());
        System.out.println("Départ prévu à: " + v.getDateHeureDepart());
        System.out.println("Arrivée prévue à: " + v.getDateHeureArrivee());
        System.out.println(v.getEtat());
    }

    static void planifierVol(List<Vol> lv){
        for (Vol v: lv){
            volMap.put(v.getNumeroVol(), v);
        }
    }

    static void annulerVol (Vol v){
        volMap.remove(v.getNumeroVol());
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

    public Map<String, LinkedList<Employe>> getEmployeMap() {
        return employeMap;
    }

    public void setEmployeMap(Map<String, LinkedList<Employe>> employeMap) {
        this.employeMap = employeMap;
    }

    public Map<Integer, Passager> getPassagerMap() {
        return passagerMap;
    }

    public void setPassagerMap(Map<Integer, Passager> passagerMap) {
        this.passagerMap = passagerMap;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
