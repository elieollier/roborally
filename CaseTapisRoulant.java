public class CaseTapisRoulant implements Case{


public class CaseTapisRoulant implements Case {
		   private Orientation o ;
	   
	   public CaseTapisRoulant(Orientation o) {
		   this.o = o;
		   
		   
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
