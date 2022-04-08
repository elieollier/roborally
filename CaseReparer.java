public class CaseReparer extends Case{
    private String nom = "reparer";
	private String description = 
			"Ci-contre vous trouverez l’image qui représente les cases de Réparation.\n"
			+ "Les cases de Réparation, sont des cases qui réparent un des dégâts que\n"
			+ "votre robot a subi, donc il peut y aller en toute tranquillité.";
	
	public String getDescription() {
		return description;
	}
    
    public String getNom() {
        return nom;
    }
    
    public void effet(Bot r) {
        r.setVie(r.getVie()+1);

    }
}
