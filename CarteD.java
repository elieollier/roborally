import java.util.Random;

public class CarteD  extends Carte{
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private int deplacement;
	private int vitesse;
	
	public CarteD(int deplacement) {
		this.deplacement  = deplacement;
		this.nom = "deplacement"+String.valueOf(deplacement);
		this.vitesse = new Random().nextInt(500);
	}
	
	public String getNom() {
		return nom;
	}
	 
	public int getVitesse() {
		return vitesse;
	}

	public void effet(Bot r) {
		for (int i =0 ; i < deplacement; i++) {	
			r.deplacement();}
		}
}
