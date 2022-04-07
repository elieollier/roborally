public class CaseTapisRoulant implements Case {
	private Orientation o ;
	private String description =
			"Ci-contre vous trouverez l'image qui représente les cases Tapis roulant.\n"
			+ "Les cases Tapis roulants, vous permettent d'avancer d'une case suivant\n"
			+ "le sens du tapis tout en conservant l'orientation de votre robot, vous\n"
			+ "pouvez donc les utiliser mais attention à où ils vont amener votre robot !";

	public String getNom() {
		return "tapisroulant"+String.valueOf(o);
	}
	
	public String getDescription() {
		return description;
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
