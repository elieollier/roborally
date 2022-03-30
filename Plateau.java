import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	private int taille = 12;
	private Case cases[][];

	Random  rand  = new Random();
	
	
	 public ArrayList<Case> remplissage(){
		 ArrayList <Case> lis_carte =  new ArrayList <Case>();
		lis_carte.add(new CaseBroyeur());
		lis_carte.add(new CaseCheckpoint(0));
		lis_carte.add(new CaseNormale());
		lis_carte.add(new CaseTapisRoulant(Orientation.bas));
		lis_carte.add(new CaseTrou());
		return lis_carte;
		}
	 
		
	public Plateau() {
	
		 cases = new Case[taille][taille];
		 ArrayList <Case> lis_carte = remplissage();
		 
		 for (int i =0 ; i < taille; i++) {
			 for (int j = 0; j < taille; j++) {
				 cases[i][j] = lis_carte.get(rand.nextInt(5)); 
			 }
		}
	}
	
	public Case caseEnIJ(int i, int j) {
		if ((0 > i) && (0 >= j) && (i>taille) && (j>taille))
			return cases[i][j];
		
		System.err.print("[Plateau] Erreur");
		return new CaseLaser();  // Pas optimal, il faudra rajouter une erreur
	}

}
