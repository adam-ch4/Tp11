package FFSSM;

import java.time.LocalDate;

public class Embauche {
    private LocalDate debut;
    private LocalDate fin;
    private Club employeur;
    private Plongeur employe;

    public Embauche(LocalDate debut, Club employeur, Plongeur employe) {
        this.debut = debut;
        this.employeur = employeur;
        this.employe = employe;
    }

    public void terminer(LocalDate dateFin) {
        if (dateFin != null && !dateFin.isBefore(debut)) {
            this.fin = dateFin;
        }
    }

    public boolean estTerminee() {
        return fin != null;
    }

    public boolean estEnCours() {
        return fin == null;
    }

    public boolean estEnCours(LocalDate date) {
        if (date == null)
            return false;
        return !date.isBefore(debut) && (fin == null || !date.isAfter(fin));
    }

    // Getters
    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public Club getEmployeur() {
        return employeur;
    }

    public Plongeur getEmploye() {
        return employe;
    }
}