package fr.isep.xuan;

public abstract class Employe extends Personne {
    private int numeroEmploye;
    private String dateEmbauche;

    Employe(String identifiant, String nom, String adresse, String contacte,
            int numeroEmploye, String dateEmbauche){
        super(identifiant, nom, adresse, contacte);
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

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setNumeroEmploye(int numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
}
