public class CaseTapisRoulant extends Case {
	private Orientation o ;
	
	private String nom = "tapisroulant";
	
	public String getNom() {
		return nom;
	}
	
	public CaseTapisRoulant(Orientation o) {
	   this.o = o;
	}

	public Orientation getO() {
		return o;
	}

	public void effet(Bot r) {
	   if( r.getO() != o) {
		   r.mourir();
	   }
	   else {
		   r.deplacement();
	   }

	}
}
