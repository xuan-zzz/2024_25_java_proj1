package fr.isep.xuan;

import java.time.LocalDateTime;
import java.util.*;

import static fr.isep.xuan.Main.avions;
import static fr.isep.xuan.Main.volMap;

public class Vol {
    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private LocalDateTime date;
    private String etat;
    private Map<String, LinkedList<Employe>> employeMap;
    private Map<Integer, Passager> passagerMap;
    private Avion avion;

    Vol(String numeroVol, Aeroport origine, Aeroport destination,
        int jour, int mois, int heure, int minute){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.etat = "A l'heure";
        this.employeMap = new HashMap<String, LinkedList<Employe>>()    {{
            put("Pilotes", new LinkedList<Employe>());
            put("Personnel de Cabine", new LinkedList<Employe>());      }};
        this.passagerMap = new HashMap<Integer, Passager>();
        //avions.getFirst().affecterVol(this);
        this.date = LocalDateTime.of(2024, mois, jour, heure, minute);
        //volMap.put(this.numeroVol, this);
    }

    void modifierVol(int minutes){
        this.etat = "Retard de " + minutes + "min.";
        date.plusMinutes(minutes);
    }

    static void obtenirVol(String numeroVol){
        Vol v = volMap.get(numeroVol);
        System.out.println("Numéro de vol: " + numeroVol);
        System.out.println("De " + v.origine.getNom() + " a " + v.destination.getNom());
        System.out.println("Départ prévu à: " + v.getDate());
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

    public String getNumeroVol() {
        return numeroVol;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNumeroVol(String numeroVol) {
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
