

import java.io.Serializable;

public  abstract class Carte  implements Serializable{
	private String nom,description;
	private String img;
	
	
	public Carte (String nom, String description  ) {
		this.nom = nom;
		this.description = description;
	}
	
	
	


	public abstract void effet(Bot r);


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



	
	
	
	

}
