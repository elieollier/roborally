public class CaseBroyeur implements Case{
	private String nom = "broyeur";
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.mourir();
	}
}
