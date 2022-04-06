public class CaseReparer extends Case{
    private String nom = "reparer";
    
    public String getNom() {
        return nom;
    }
    
    public void effet(Bot r) {
        r.setVie(r.getVie()+1);

    }
}
