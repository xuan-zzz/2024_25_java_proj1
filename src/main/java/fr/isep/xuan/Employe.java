package fr.isep.xuan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static fr.isep.xuan.Main.numEmploye;

public abstract class Employe extends Personne {
    private int numeroEmploye;
    private LocalDate dateEmbauche;

    Employe(String identifiant){
        super(identifiant);
        Random rdm = new Random();
        int rdmNumEmploye = rdm.nextInt(10000);
        while (numEmploye.contains(rdmNumEmploye))
            rdmNumEmploye = rdm.nextInt(10000);
        this.numeroEmploye = rdmNumEmploye;
        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2024, 12, 1);
        int days = (int) ChronoUnit.DAYS.between(start, end);
        this.dateEmbauche = start.plusDays(rdm.nextInt(days));
    }

    Employe(String identifiant, String nom, String prenom, String adresse, String contacte,
            int numeroEmploye, LocalDate dateEmbauche){
        super(identifiant, nom, prenom, adresse, contacte);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNumero d'employé:" + numeroEmploye +
                "\nDate d'embauche:'" + dateEmbauche;
    }

    String obtenirRole() { return "Employé"; }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getIdentifiant() {
        return super.getIdentifiant();
    }

    public int getNumeroEmploye() {
        return numeroEmploye;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setNumeroEmploye(int numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
}
