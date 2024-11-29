package fr.isep.xuan;

public class Reservation {
    private int numeroReservation;
    private String dateReservation;
    private String statut;

    Reservation(int numeroReservation, String dateReservation, String statut){
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public int getNumeroReservation() {
        return numeroReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setNumeroReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
