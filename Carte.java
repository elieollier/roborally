
public  abstract class Carte {
	private String nom,description;
	private boolean used = false;
	private String img;
	
	
	public Carte (String nom, String description  ) {
		this.nom = nom;
		this.description = description;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isUsed() {
		return used;
	}


	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
	
	
	

}
