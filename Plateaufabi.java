import java.util.ArrayList;
import java.util.Random;

public class Plateaufabi {
    private static int taille = 10;
    private Case cases[][] = new Case[taille][taille];
    
//     public ArrayList<Case> remplissage(){
//         ArrayList <Case> lis_carte =  new ArrayList <Case>();
//        lis_carte.add(new CaseBroyeur());
//        lis_carte.add(new CaseCheckpoint(0));
//        lis_carte.add(new CaseNormale());
//        lis_carte.add(new CaseTapisRoulant(Orientation.bas));
//        lis_carte.add(new CaseTrou());
//        lis_carte.add(new CaseLaser());
//        return lis_carte;
//        }
     
        
//    public Plateau() {
//    
//         cases = new Case[taille][taille];
//         ArrayList <Case> lis_carte = remplissage();
//         
//         for (int i =0 ; i < taille; i++) {
//             for (int j = 0; j < taille; j++) {
//                 cases[i][j] = lis_carte.get(rand.nextInt(lis_carte.size())); 
//             }
//        }
//    }
     
    
    
     public Plateaufabi() {
          for (int  i = 0 ; i < cases.length; i++) {
              for(int j = 0; j < Plateaufabi.taille; j++ ) {
                  cases[i][j] = new CaseNormale();
              }
          }
          //Tapis roulants
          cases[0][2]= new CaseTapisRoulant(Orientation.droite);
          cases[1][0]= new CaseTapisRoulant(Orientation.haut);
          cases[2][0]= new CaseTapisRoulant(Orientation.haut);
          cases[3][0]= new CaseTapisRoulant(Orientation.haut);
          cases[2][2]= new CaseTapisRoulant(Orientation.gauche);
          cases[2][3]= new CaseTapisRoulant(Orientation.gauche);
          cases[5][2]= new CaseTapisRoulant(Orientation.bas);
          cases[9][0]= new CaseTapisRoulant(Orientation.gauche);
          cases[5][6]= new CaseTapisRoulant(Orientation.bas);
          cases[4][7]= new CaseTapisRoulant(Orientation.gauche);
          cases[4][8]= new CaseTapisRoulant(Orientation.gauche);
          cases[4][9]= new CaseTapisRoulant(Orientation.gauche);
          cases[8][9]= new CaseTapisRoulant(Orientation.droite);
          
          //mur
          cases[1][1]  = new CaseMur();
          cases[8][2]  = new CaseMur();
          cases[2][7]  = new CaseMur();
          cases[4][4]  = new CaseMur();
          cases[7][7]  = new CaseMur();
          
          //broyeur
          cases[2][1]  = new CaseBroyeur();
          cases[3][1]  = new CaseBroyeur();
          cases[3][6]  = new CaseBroyeur();
          
          //trou
          cases[6][2]  = new CaseTrou();
          cases[0][6]  = new CaseTrou();
          cases[3][7]  = new CaseTrou();
          cases[7][4]  = new CaseTrou();
          
          //laser
          cases[5][7]  = new CaseLaser();
          cases[5][8]  = new CaseLaser();
          cases[5][9]  = new CaseLaser();
          cases[8][7]  = new CaseLaser();
          cases[9][7]  = new CaseLaser();
          
          //drapeau
          cases[0][0]  = new CaseCheckpoint(1);
          cases[4][6]  = new CaseCheckpoint(2);
          cases[9][9]  = new CaseCheckpoint(3);
          
          //reparation
          //cases[0][9] = new CaseRepa()
          //cases[7][0] = new CaseRepa()
          
          
          
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
