package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {
    private int niveau;
    private List<Licence> licences = new ArrayList<>();
    private List<DiplomeDeMoniteur> diplomes = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom,
            String adresse, String telephone, LocalDate naissance,
            int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public Plongeur(String numeroINSEE, String nom, String prenom,
            String adresse, String telephone, LocalDate naissance,
            int niveau, GroupeSanguin groupeSanguin, String allergie) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,
                groupeSanguin, allergie);
        this.niveau = niveau;
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club club) {
        Licence licence = new Licence(this, numero, delivrance, club);
        licences.add(licence);
    }

    public Licence derniereLicence() {
        if (licences.isEmpty()) {
            return null;
        }
        return licences.get(licences.size() - 1);
    }

    public boolean aUneLicenceValide(LocalDate date) {
        Licence derniereLicence = derniereLicence();
        return derniereLicence != null && derniereLicence.estValide(date);
    }

    public void ajouterDiplome(DiplomeDeMoniteur diplome) {
        diplomes.add(diplome);
    }

    public boolean estMoniteur() {
        return !diplomes.isEmpty();
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public List<DiplomeDeMoniteur> getDiplomes() {
        return diplomes;
    }
}