public class CaseCheckpoint implements Case {
	int ordre;
	private String nom = "checkpoint";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases Checkpoint.\n"
			+ "Les cases Checkpoint sont les cases où votre robot doit aller dans\n"
			+ "l'ordre pour gagner, il ne risque rien pour sa vie, il peut donc y\n"
			+ "aller en toute tranquillité.";
	
	public String getDescription() {
		return description;
	}
	
	public String getNom() {
		return nom;
	}
	
	public  CaseCheckpoint( int ordre) {
		setOrdre(ordre);
	}
	
	public void effet(Bot r) {
		if(  this.ordre - r.getOrdre() == 1) {
		r.setxCheck(r.getX());
		r.setyCheck(r.getY());
		r.setOrdre(ordre);
		}
	}

	public  int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		System.out.println(ordre);
		if( ordre >= 0) {
		this.ordre = ordre;}
		else
			System.out.println("L'ordre doit être positif. ");
	}
}
