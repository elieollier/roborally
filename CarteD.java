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
	

	public void effet(Bot r, int deplacement) {
		
					
		for (int i =0 ; i < deplacement; i++) {
				
			r.deplacement();}
		}
		
		
		
		
		
	




}
