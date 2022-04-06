

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

public class Client
{
	

 
	
    public static void main(String[] args) throws Exception 
    {
    
    	

        Plateau plateauClient   = new Plateau();
        Bot robotClient   = new  Bot(plateauClient );
         System.out.println(robotClient.getID());
        ArrayList  <Bot> robotsAutresJoueurs =  new ArrayList <Bot>() ;
        SetDeCartes cartesClient = new SetDeCartes();
       
       
        

    	      
    try  {
        
              
            
            InetAddress ip = InetAddress.getByName("localhost");
      
           
            Socket s = new Socket(ip, 5056);
      
            // On récupère les flux du client ;
            
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in   = new ObjectInputStream(s.getInputStream());
            
            
            out.writeObject(robotClient);
            out.writeObject(plateauClient);
            robotsAutresJoueurs  = ( ArrayList <Bot> ) in.readObject();	
            
            for (int i =0 ; i < robotsAutresJoueurs.size() ; i++ ) {
            System.out.println( robotsAutresJoueurs.get(i).getID());
            }
            
       
       	 GraphicWindow fenetreJoueur  = new GraphicWindow(plateauClient,robotsAutresJoueurs,robotClient.getID());
       	 fenetreJoueur.setVisible(true);
//       	 
       	
   
     
     
      // 	while (robotClient.getVie() > 0  )    {
       		
       		
       		fenetreJoueur.setSetDeCartes(new SetDeCartes());
        	          	
            while(fenetreJoueur.getListeDesCartesCliquees().size() != 5) {
           	 System.out.println(fenetreJoueur.getListeDesCartesCliquees().size());
           	 
            }
            
            
            System.out.println(fenetreJoueur.getListeDesCartesCliquees());
            
            out.writeObject(fenetreJoueur.getListeDesCartesCliquees());
            fenetreJoueur.setListeDesBots(( ArrayList <Bot> ) in.readObject());
            
            
            
           

         
     
        
         
         
            	//  }  ;
            

            
            
            
   
   

            
           
            
          
          
           
        }catch(Exception e){
            e.printStackTrace();
         
              
        }  
        
   
    
    }
    
}
    
    
