package fr.isep.xuan;

public class Passager extends Personne{
    private String passeport;

    Passager(String nom, String adresse, String contacte, String passeport){
        super("Passager", nom, adresse, contacte);
        this.passeport = passeport;
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
