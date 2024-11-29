package fr.isep.xuan;

public class PersonnelCabine extends Employe{
    String qualification;

    PersonnelCabine(String identifiant, String nom, String adresse,
           String contacte, int numeroEmploye, String dateEmbauche,
           String qualification){
        super("Personnel de Cabine", nom, adresse, contacte, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nQualification:" + qualification;
    }
}
