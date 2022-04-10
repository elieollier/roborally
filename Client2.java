import java.io.DataInputStream;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Client2
{
	
	
	

	
 

	 
	 
	 
	 
	 
	 
	 
	
    public static void main(String[] args) throws Exception 
    {
    
    	

        

   	 Plateau plateauClient   = new Plateau();
         Bot robotClient   = new  Bot( plateauClient );
        ArrayList  <Bot> robotsPartie =  new ArrayList <Bot>() ;
          SetDeCartes cartesClient = new SetDeCartes();

       

    	
        
     

    	      
    try  {
        
    	
    	
           

              
            
            InetAddress ip = InetAddress.getByName("localhost");
      
           
            Socket s = new Socket(ip, 5056);
      
            // On récupère les flux du client ;
            
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in   = new ObjectInputStream(s.getInputStream());
            out.writeObject(robotClient);
            out.writeObject(plateauClient);
            
            
           
       
           robotsPartie  = (ArrayList <Bot>) in.readObject();
           System.out.println(robotsPartie);
       	 GraphicWindow fenetreJoueur  = new GraphicWindow(plateauClient,robotsPartie,robotClient.getID());
       	 fenetreJoueur.setSetDeCartes(cartesClient);
       	
       	 fenetreJoueur.setVisible(true);      	 
       	
     
      while (robotClient.getVie() > 0  || robotClient.getOrdre() < 3 )    {
       		
       		
       		
        	          	
            while(fenetreJoueur.getListeDesCartesCliquees().size() != 5) {
           	 System.out.println(fenetreJoueur.getListeDesCartesCliquees().size());
           	
            }
            System.out.println(fenetreJoueur.getListeDesCartesCliquees());
            
            
        
       ArrayList <Carte> cartesJouees = (ArrayList<Carte>) fenetreJoueur.getListeDesCartesCliquees();

            Iterator <Carte> it = cartesJouees.iterator();
       
            
            robotsPartie.remove(robotClient);
            
             while( it.hasNext()) {
              Carte carteUtilise = it.next();
          
          	   carteUtilise.effet(robotClient);
          	   plateauClient.caseEnIJ(robotClient.getX(), robotClient.getY()).effet(robotClient);
          	
          	   
             }
            
             robotsPartie.add(robotClient);
             
             
             
             out.writeObject(robotClient);
             
            robotsPartie = (ArrayList <Bot>) in.readObject();
            
            fenetreJoueur.setListeDesBots(robotsPartie);
            
            fenetreJoueur.setSetDeCartes(new SetDeCartes());        
            
            
                     if(robotClient.getVie() < 0) {
                fenetreJoueur.mourir();}

  else if (robotClient.getOrdre() == 3) {
                fenetreJoueur.gagner();}
            
            
            
            }  
      
      
      
      
      
  
            
            
            
   
   

            
           
            
          
          
           
        }catch(Exception e){
            e.printStackTrace();
         
              
        }  
        
   
    
    }
    
}
