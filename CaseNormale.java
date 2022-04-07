public class CaseNormale implements Case{
	private String nom = "normale";
	private String description = 
			"Ci-contre vous trouverez l'image qui représente les cases normales.\n"
			+ "Les cases Normales sont des cases où votre robot ne risque rien\n"
			+ "pour sa vie, il peut donc y aller en toute tranquillité.";
	
	public String getDescription() {
		return description;
	}
	
	public CaseNormale() {}
	
	public String getNom() {
		return nom;
	}
	
	public void effet(Bot r) {
	}
}
