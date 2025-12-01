package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private String nom;
    private String adresse;
    private String telephone;
    private Plongeur president;
    private List<Plongeur> membres = new ArrayList<>();
    private List<Plongee> plongeesOrganisees = new ArrayList<>();
    private List<Embauche> embauches = new ArrayList<>();

    public Club(String nom, String adresse, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public void organisePlongee(Plongee plongee) {
        if (!plongeesOrganisees.contains(plongee)) {
            plongeesOrganisees.add(plongee);
        }
    }

    public void ajouteMembre(Plongeur plongeur) {
        if (plongeur != null && !membres.contains(plongeur)) {
            membres.add(plongeur);
        }
    }

    public void nouvelleEmbauche(Plongeur moniteur, LocalDate debut) {
        if (moniteur != null && moniteur.estMoniteur()) {
            Embauche embauche = new Embauche(debut, this, moniteur);
            embauches.add(embauche);
        }
    }

    public List<Embauche> embauches() {
        return embauches;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Plongeur getPresident() {
        return president;
    }

    public void setPresident(Plongeur president) {
        this.president = president;
    }

    public List<Plongeur> getMembres() {
        return membres;
    }

    public List<Plongee> getPlongeesOrganisees() {
        return plongeesOrganisees;
    }
}