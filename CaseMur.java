public class CaseMur extends Case{
	private String nom = "murH";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases Mur.\n"
			+ "Les cases Murs vous bloquent sur la case où est votre robot,\n"
			+ "il est donc impossible d'aller sur une case Mur !";
	
	public String getDescription() {
		return description;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.deplacementInverse();
    }
}
