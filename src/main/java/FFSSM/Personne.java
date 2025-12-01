package FFSSM;

import java.time.LocalDate;

public class Personne {
	private String numeroINSEE;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private LocalDate naissance;
	private GroupeSanguin groupeSanguin;
	private String allergie;

	public Personne(String numeroINSEE, String nom, String prenom,
			String adresse, String telephone, LocalDate naissance) {
		this.numeroINSEE = numeroINSEE;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.naissance = naissance;
	}

	public Personne(String numeroINSEE, String nom, String prenom,
			String adresse, String telephone, LocalDate naissance,
			GroupeSanguin groupeSanguin, String allergie) {
		this(numeroINSEE, nom, prenom, adresse, telephone, naissance);
		this.groupeSanguin = groupeSanguin;
		this.allergie = allergie;
	}

	// Getters et Setters
	public String getNumeroINSEE() {
		return numeroINSEE;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
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

	public LocalDate getNaissance() {
		return naissance;
	}

	public GroupeSanguin getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(GroupeSanguin groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}

	@Override
	public String toString() {
		return "Personne{" + "nom=" + nom + ", prenom=" + prenom + '}';
	}
}