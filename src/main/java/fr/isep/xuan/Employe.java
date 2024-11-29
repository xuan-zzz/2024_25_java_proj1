package fr.isep.xuan;

public abstract class Employe extends Personne {
    int numeroEmploye;
    String dateEmbauche;

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
}
