package FFSSM;

import java.time.LocalDate;

public class DiplomeDeMoniteur {
    public enum Niveau {
        E1,
        E2,
        E3,
        E4
    }

    private Niveau niveau;
    private LocalDate dateDelivrance;
    private Plongeur detenteur;

    public DiplomeDeMoniteur(Niveau niveau, LocalDate dateDelivrance, Plongeur detenteur) {
        this.niveau = niveau;
        this.dateDelivrance = dateDelivrance;
        this.detenteur = detenteur;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    public Plongeur getDetenteur() {
        return detenteur;
    }

    public int getNiveauMaxEncadrement() {
        switch (niveau) {
            case E1:
                return 1;
            case E2:
                return 2;
            case E3:
                return 3;
            case E4:
                return 4;
            default:
                return 0;
        }
    }
}