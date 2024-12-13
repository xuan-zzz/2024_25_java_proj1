package fr.isep.xuan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

import static fr.isep.xuan.Main.*;

public class Vol {
    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private LocalDateTime date;
    private String etat;
    private Map<String, LinkedList<Employe>> employeMap;
    private Map<String, Passager> passagerMap;
    private Avion avion;

    Vol(String numeroVol, Aeroport origine, Aeroport destination, LocalDateTime date){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.etat = "A l'heure";
        this.date = date;
        if (avionsLibres.isEmpty()) avionsLibres.add(new Avion());
        avionsLibres.getFirst().affecterVol(this);
        this.employeMap = new HashMap<String, LinkedList<Employe>>()    {{
            put("Pilotes", new LinkedList<Employe>());
            put("Personnel de Cabine", new LinkedList<Employe>());      }};
        this.passagerMap = new HashMap<String, Passager>();
    }

    Vol(String numeroVol, Aeroport origine, Aeroport destination,
        int jour, int mois, int heure, int minute){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.etat = "A l'heure";
        this.employeMap = new HashMap<String, LinkedList<Employe>>()    {{
            put("Pilotes", new LinkedList<Employe>());
            put("Personnel de Cabine", new LinkedList<Employe>());      }};
        this.passagerMap = new HashMap<String, Passager>();
        if (avionsLibres.isEmpty()) avionsLibres.add(new Avion());
        avionsLibres.getFirst().affecterVol(this);
        this.date = LocalDateTime.of(2024, mois, jour, heure, minute);
        if (!volMap.containsKey(numeroVol)) volMap.put(this.numeroVol, this);
    }

    void modifierVol(int minutes){
        this.etat = "Retard de " + minutes + "min.";
        date.plusMinutes(minutes);
    }

    public void obtenirVol(){
        System.out.println("Numéro de vol: " + this.numeroVol);
        System.out.println("De " + this.origine.getVille() + " a " + this.destination.getVille());
        DateTimeFormatter format = new DateTimeFormatterBuilder()
                .appendPattern("dd MMMM") // Day and Month
                .appendLiteral(", ") // Comma and space
                .appendPattern("HH:mm") // Hour and minute
                .toFormatter();
        int placesRestantes = this.avion.getCapacite()-this.getPassagerMap().size();
        System.out.println("Places restantes: " + placesRestantes + " sur " + this.avion.getCapacite());
        System.out.println("Départ prévu à: " + format.format(this.getDate()));
        System.out.println(this.getEtat());
    }

    static void planifierVol(List<Vol> lv){
        for (Vol v: lv){
            volMap.put(v.getNumeroVol(), v);
        }
    }

    public void annulerVol (){
        for (Employe e: this.employeMap.get("Pilotes")){
            pilotes.add((Pilote) e);
            this.employeMap.get("Pilotes").remove(e);
        }
        for (Employe e: this.employeMap.get("Personnel de Cabine")){
            personnelCabines.add((PersonnelCabine) e);
            this.employeMap.get("Personnel de Cabine").remove(e);
        }
        avionsLibres.add(this.getAvion());
        volMap.remove(this.getNumeroVol());
    }

    public void ListingPassager(){
        for (Passager p: this.passagerMap.values()){
            System.out.println(p.getPasseport() + ", " + p.getNom() + ", " + p.getPrenom());
        }
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

    public Map<String, Passager> getPassagerMap() {
        return passagerMap;
    }

    public void setPassagerMap(Map<String, Passager> passagerMap) {
        this.passagerMap = passagerMap;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
