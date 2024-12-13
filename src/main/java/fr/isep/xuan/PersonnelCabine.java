package fr.isep.xuan;

import java.time.LocalDate;

public class PersonnelCabine extends Employe{
    private String qualification;

    PersonnelCabine(){
        super("Personnel de Cabine");
        this.qualification = "Bac+3";
    }

    PersonnelCabine(String identifiant, String nom, String prenom, String adresse,
           String contacte, int numeroEmploye, LocalDate dateEmbauche,
           String qualification){
        super("Personnel de Cabine", nom, prenom, adresse, contacte, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nQualification:" + qualification;
    }

    @Override
    String obtenirRole() { return "Personnel de Cabine"; }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
