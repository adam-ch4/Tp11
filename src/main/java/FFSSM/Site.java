package FFSSM;

public class Site {
	private String nom;
	private String details;
	private int profondeurMaximale;

	public Site(String nom, String details, int profondeurMaximale) {
		this.nom = nom;
		this.details = details;
		this.profondeurMaximale = profondeurMaximale;
	}

	public String getNom() {
		return nom;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getProfondeurMaximale() {
		return profondeurMaximale;
	}

	public void setProfondeurMaximale(int profondeurMaximale) {
		this.profondeurMaximale = profondeurMaximale;
	}

	@Override
	public String toString() {
		return nom;
	}
}