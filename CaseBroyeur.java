public class CaseBroyeur implements Case {
	private String nom = "broyeur";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases Broyeurs.\n"
			+ "Les cases Broyeurs sont des cases qui tueront immédiatement votre robot,\n"
			+ "il perdra donc une vie automatiquement s'il va sur ces cases,\n"
			+ "ce sont donc des cases à éviter !";
	
	public String getNom() {
		return nom;
	}
	
	public String getDescription() {
		return description;
	}

	public void effet(Bot r) {
		r.mourir();
	}
}
