import java.util.ArrayList;
import java.util.Random;




public class Plateau {
	

Random  rand  = new Random();



 public 	ArrayList<Case> remplissage(){
	 ArrayList <Case> lis_carte =  new ArrayList <Case>();
	lis_carte.add(new CaseBroyeur());
	lis_carte.add(new CaseCheckpoint(0));
	lis_carte.add(new CaseNormale());
	lis_carte.add(new CaseTapisRoulant(Orientation.bas));
	lis_carte.add(new CaseTrou());
	return lis_carte;
	}
 
	
public Plateau() {

 Case cases[][] = new Case[12][12] ;
 ArrayList <Case> lis_carte = remplissage();
 
 for (int i =0 ; i < 12; i++) {
	 for (int j = 0; j < 12; j++) {
		 cases[i][j] = lis_carte.get(rand.nextInt(5));
		 
	 }
 }
 

 
 
	}

}
