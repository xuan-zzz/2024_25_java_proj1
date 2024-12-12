package fr.isep.xuan;

import java.time.LocalDate;

public class Reservation {
    private int numeroReservation;
    private LocalDate dateReservation;
    private String statut;

    Reservation(int numeroReservation, LocalDate dateReservation, String statut){
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public int getNumeroReservation() {
        return numeroReservation;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
