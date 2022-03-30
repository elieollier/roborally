public class CaseBroyeur extends Case{
	private String nom = "broyeur";
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.mourir();
	}
}
