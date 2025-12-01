package FFSSM;

import java.time.LocalDate;

public class Licence {
    private Plongeur possesseur;
    private String numero;
    private LocalDate delivrance;
    private Club club;
    private LocalDate finValidite;

    public Licence(Plongeur possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
        // Une licence est valide un an
        this.finValidite = delivrance.plusYears(1);
    }

    public Plongeur getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    public boolean estValide(LocalDate date) {
        return !date.isBefore(delivrance) && !date.isAfter(finValidite);
    }

    public LocalDate getFinValidite() {
        return finValidite;
    }
}