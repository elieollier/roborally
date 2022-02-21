
public class CarteO  extends Carte{
	private Orientation o;
	
	public Orientation getO() {
		return o;
	}

	public void setO(Orientation o) {
		this.o = o;
	}

	public CarteO(String nom,String description, Orientation o) {
		super(nom,description);
		this.o = o;
	}
		
}