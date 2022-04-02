public class CaseMur extends Case{
	private String nom = "murH";
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
		r.deplacementInverse();
    }
}
