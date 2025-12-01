package FFSSM;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Plongee {
	private Site lieu;
	private LocalDate date;
	private LocalTime heure;
	private int profondeur;
	private int duree;
	private Plongeur chefDePalanquee;
	private Club organisateur;
	private List<Plongeur> participants = new ArrayList<>();
	private boolean estConforme;

	public Plongee(Site lieu, Club organisateur, LocalDate date,
			LocalTime heure, int profondeur, int duree) {
		this.lieu = lieu;
		this.organisateur = organisateur;
		this.date = date;
		this.heure = heure;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Plongeur participant) {
		if (participant != null && !participants.contains(participant)) {
			participants.add(participant);
		}
	}

	public boolean estConforme() {
		// Vérifie si le chef est un moniteur
		if (chefDePalanquee == null || !chefDePalanquee.estMoniteur()) {
			return false;
		}

		// Vérifie si tous les participants ont une licence valide
		for (Plongeur p : participants) {
			if (!p.aUneLicenceValide(date)) {
				return false;
			}
		}

		// Vérifie si la profondeur ne dépasse pas celle du site
		if (profondeur > lieu.getProfondeurMaximale()) {
			return false;
		}

		return true;
	}

	public void setChefDePalanquee(Plongeur chef) {
		this.chefDePalanquee = chef;
	}

	// Getters
	public Site getLieu() {
		return lieu;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public int getDuree() {
		return duree;
	}

	public Plongeur getChefDePalanquee() {
		return chefDePalanquee;
	}

	public Club getOrganisateur() {
		return organisateur;
	}

	public List<Plongeur> getParticipants() {
		return participants;
	}
}