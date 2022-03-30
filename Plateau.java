import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	private int taille = 10;
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
	 
	 public Plateau() {
		  for (int  i = 0 ; i < cases.length; i++) {
			  cases[i][0] = new CaseNormale();
		  }
		  
		  
		  for (int i = 0 ; i < cases.length; i++) {
			  cases[i][9] = new CaseNormale();
		  }
		  
		  cases[0][1] = new CaseNormale();
		  cases[1][1] = new CaseTrou();
		  cases[2][1] = new CaseNormale();
		  cases[3][1] = new CaseNormale();
		  cases[4][1] = new CaseNormale();
		  cases[5][1] = new CaseMur();
		  cases[6][1] = new CaseNormale();
		  cases[7][1] = new CaseNormale();
		  cases[8][1] = new CaseTrou();
		  cases[9][1] = new CaseNormale();
		  
		  
		  for (int i = 0 ; i < cases.length; i++) {
			  if( i != 5 || i != 6) {
				  cases [i][2] = new CaseNormale();
			  }
		  }
		  cases[5][2] = new CaseMur();
		  cases[6][2] = new CaseBroyeur();
		  
		  
		  
		  for (int i = 0 ; i < cases.length; i++) {
			  if( i != 5 || i != 9) {
				  cases [i][3] = new CaseNormale();
			  }
		  }
		  
		  cases[5][3] = new CaseMur();
		  cases[9][3] = new CaseBroyeur();
		  
		  for (int i = 0; i < cases.length ; i++) {
			  if( i  <=  5) {
				  cases[i][4] = new CaseTapisRoulant(Orientation.bas);		  
			  }
			  else {
				  cases[i][4] = new CaseNormale();	
			  }
		  }
		  
		  
		  for (int i = 0 ; i < cases.length; i++) {
			 
				  cases [i][5] = new CaseNormale();
			 
		  }
		  
		  for (int i = 0 ; i < cases.length; i++) {
				 
			  cases [i][5] = new CaseNormale();
		 
		}
		  
		  
		  for (int i  = 0 ; i < cases.length ; i++) {
			  if( i != 1  || i != 4  || i != 5 || i!= 6) {
			  cases[i][6]  = new CaseNormale();
					  
			  }
			  else {
				  cases[i][6]  = new CaseMur();
			  }
		  }
		  
		  
		  for (int i  = 0 ; i < cases.length ; i++) {
			  if( i != 3) {
			  cases[i][7]  = new CaseNormale();
					  
			  }
			  else {
				  cases[i][7]  = new CaseBroyeur();
			  }
		  }
			  
		  
		  
		  for (int i  = 0 ; i < cases.length ; i++) {
			  if( i != 1  ||  i != 8) {
			  cases[i][8]  = new CaseNormale();
					  
			  }
			  else {
				  cases[i][8]  = new CaseTrou();
			  }
		  }
		  
		  for( int  i =0 ; i < cases.length ;  i++) {
			  cases[i][9]  = new CaseNormale();
		  }		  
		}
	
	public Case caseEnIJ(int i, int j) {
		if ((i >= 0) && (j >= 0) && (i < taille) && (j < taille))
			return cases[i][j];
		
		System.err.print("[Plateau] Erreur");
		return new CaseLaser();  // Pas optimal, il faudra rajouter une erreur
	}

}
