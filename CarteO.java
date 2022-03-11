public class CarteO  extends Carte{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Orientation o;
	
	public CarteO(String nom,String description, Orientation o) {
		super(nom,description);
		this.o = o;
		
	}
	
   public void effet(Bot r) {
	   r.setO(o);
   }
	
	
	
	
	
	
	
	

}
