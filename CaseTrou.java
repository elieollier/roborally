public class CaseTrou extends Case {
	private String nom = "trou";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases Trous.\n"
			+ "Les cases Trous sont des cases qui tueront immédiatement votre\n"
			+ "robot, il perdra donc une vie automatiquement s'il va sur ces\n"
			+ "cases, ce sont donc des cases à éviter !";
	
	public String getDescription() {
		return description;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.mourir();
	}

}
