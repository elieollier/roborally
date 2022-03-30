public class CarteO extends Carte{
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private Orientation o;
	
	public CarteO(Orientation o) {
		this.o = o;
		this.nom = String.valueOf(o);
	}
	
   public String getNom() {
		return nom;
	}

   public Orientation getO() {
		return o;
   }

   public void effet(Bot r) {
	   if(o == Orientation.gauche) {
			switch(r.getO()) {
				case haut:
					r.setO(Orientation.droite);
					break;
				case bas:
					r.setO(Orientation.gauche);
					break;
				case droite:
					r.setO(Orientation.bas);
					break;
				case gauche:
					r.setO(Orientation.haut);
					break;
			}
	   }
	   else { //(o == Orientation.droite)
		   switch(r.getO()) {
				case haut:
					r.setO(Orientation.gauche);
					break;
				case bas:
					r.setO(Orientation.droite);
					break;
				case droite:
					r.setO(Orientation.haut);
					break;
				case gauche:
					r.setO(Orientation.bas);
					break;
		}
	  }
   }
}
