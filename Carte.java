import java.io.Serializable;

public abstract class Carte implements Serializable{
	private String nom;
	
	
	public Carte (String nom) {
		this.nom = nom;
	}	

	public abstract void effet(Bot r);
	public abstract void effet(Bot r, int deplacement);


	public abstract String getNom();
	
}
