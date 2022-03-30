public class CaseLaser implement case {
	private String nom = "laser";
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.mourir();
	}
}
