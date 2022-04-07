public class CaseLaser implements Case {
	private String nom = "laser";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases Laser.\n"
			+ "Les cases Laser, sont des cases qui tueront automatiquement votre\n"
			+ "robot, il perdra donc une vie immédiatement s'il va sur ces cases,\n"
			+ "évitez-les donc !\n";
	
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
