public class CaseTapisRoulant extends Case {
	private Orientation o ;
	
	public String getNom() {
		return "tapisroulant"+String.valueOf(o);
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
