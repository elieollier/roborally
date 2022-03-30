public class CaseTrou extends Case {
	private String nom = "trou";
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.mourir();
	}

}
