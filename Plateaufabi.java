import java.util.ArrayList;
import java.util.Random;

public class Plateaufabi {
	private static int taille = 10;
	private Case cases[][] = new Case[taille][taille];
	
//	 public ArrayList<Case> remplissage(){
//		 ArrayList <Case> lis_carte =  new ArrayList <Case>();
//		lis_carte.add(new CaseBroyeur());
//		lis_carte.add(new CaseCheckpoint(0));
//		lis_carte.add(new CaseNormale());
//		lis_carte.add(new CaseTapisRoulant(Orientation.bas));
//		lis_carte.add(new CaseTrou());
//		lis_carte.add(new CaseLaser());
//		return lis_carte;
//		}
	 
		
//	public Plateau() {
//	
//		 cases = new Case[taille][taille];
//		 ArrayList <Case> lis_carte = remplissage();
//		 
//		 for (int i =0 ; i < taille; i++) {
//			 for (int j = 0; j < taille; j++) {
//				 cases[i][j] = lis_carte.get(rand.nextInt(lis_carte.size())); 
//			 }
//		}
//	}
	 
	
	
	 public Plateaufabi() {
		  for (int  i = 0 ; i < cases.length; i++) {
			  for(int j = 0; j < Plateaufabi.taille; j++ ) {
				  cases[i][j] = new CaseNormale();
			  }
		  }
		  //Tapis roulants
		  cases[2][0]= new CaseTapisRoulant(Orientation.droite);
		  cases[0][1]= new CaseTapisRoulant(Orientation.haut);
		  cases[0][2]= new CaseTapisRoulant(Orientation.haut);
		  cases[0][3]= new CaseTapisRoulant(Orientation.haut);
		  cases[2][2]= new CaseTapisRoulant(Orientation.gauche);
		  cases[3][2]= new CaseTapisRoulant(Orientation.gauche);
		  cases[2][5]= new CaseTapisRoulant(Orientation.bas);
		  cases[0][9]= new CaseTapisRoulant(Orientation.gauche);
		  cases[6][5]= new CaseTapisRoulant(Orientation.bas);
		  cases[7][4]= new CaseTapisRoulant(Orientation.gauche);
		  cases[8][4]= new CaseTapisRoulant(Orientation.gauche);
		  cases[9][4]= new CaseTapisRoulant(Orientation.gauche);
		  cases[9][8]= new CaseTapisRoulant(Orientation.droite);
		  
		  //mur
		  cases[1][1]  = new CaseMur();
		  cases[2][8]  = new CaseMur();
		  cases[7][2]  = new CaseMur();
		  cases[4][4]  = new CaseMur();
		  cases[7][7]  = new CaseMur();
		  
		  //broyeur
		  cases[1][2]  = new CaseBroyeur();
		  cases[1][3]  = new CaseBroyeur();
		  cases[6][3]  = new CaseBroyeur();
		  
		  //trou
		  cases[2][6]  = new CaseTrou();
		  cases[6][0]  = new CaseTrou();
		  cases[7][3]  = new CaseTrou();
		  cases[4][7]  = new CaseTrou();
		  
		  //laser
		  cases[7][5]  = new CaseLaser();
		  cases[8][5]  = new CaseLaser();
		  cases[9][5]  = new CaseLaser();
		  cases[7][8]  = new CaseLaser();
		  cases[7][9]  = new CaseLaser();
		  
		  //drapeau
		  cases[0][0]  = new CaseCheckpoint(1);
		  cases[6][4]  = new CaseCheckpoint(2);
		  cases[9][9]  = new CaseCheckpoint(3);
		  
		  //reparation
		  //cases[9][0] = new CaseRepa()
		  //cases[0][7] = new CaseRepa()
		  
		  
		  
	 } 

	
	public static int getTaille() {
		return taille;
	}

	public Case caseEnIJ(int i, int j) {
		if ((i >= 0) && (j >= 0) && (i < taille) && (j < taille))
			return cases[i][j];
		
		System.err.print("[Plateau] Erreur");
		return new CaseLaser();  // Pas optimal, il faudra rajouter une erreur
	}

}
