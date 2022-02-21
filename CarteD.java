public class CarteD  extends Carte{
	private int vitesse;
	
	
	
	public CarteD(String nom, String description ,int vitesse) {
		super(nom,description);
		this.vitesse  = vitesse;
	}


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	


}
