public class CaseCheckpoint extends Case {
	private String nom = "checkpoint";
	int ordre;
	
	public String getNom() {
		return nom;
	}
	
	
	public  CaseCheckpoint( int ordre) {
		setOrdre(ordre);
	}
	
	
	public void effet(Bot r) {
		if(  this.ordre - r.getOrdre() == 1) {
		r.setxCheck(r.getX());
		r.setyCheck(r.getY());
		r.setOrdre(ordre);
		}
	}

	public  int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		System.out.println(ordre);
		if( ordre >= 0) {
		this.ordre = ordre;}
		else
			System.out.println("L'ordre doit être positif. ");
		
	}
}
