

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
	


     static Plateau plateauClient   = new Plateau();
   static Bot robotClient   = Bot.apparition(plateauClient);
    static  LinkedList  <Bot> robotsAutresJoueurs  ;
    static SetDeCartes cartesClient = new SetDeCartes();
  
    
  

 	
 	public static void remplacerRobots(Bot r) throws ClassNotFoundException, IOException {
 		Iterator < Bot > it  = robotsAutresJoueurs.iterator();
 		boolean rechercheFinie = false;
 	
 		while(it.hasNext() && !rechercheFinie) {
 			Bot robotRemplace = it.next();
 			if(robotRemplace.getID().equals(r.getID())) {
 				robotRemplace = r;
 				rechercheFinie = true;}}
  		
 		 	} 
 		
 	
 	
 	
 	
  	
    public static void main(String[] args) throws Exception 
    {
    	

     
 
  	
   

    	
        try
        {
        	
            Scanner scn = new Scanner(System.in);
              
            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");
      
            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);
      
            // obtaining input and out streams
            
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in   = new ObjectInputStream(s.getInputStream());
          
          out.writeObject(robotClient);
          out.writeObject(cartesClient);
          robotsAutresJoueurs  = ( LinkedList <Bot>) in.readObject();
          
          
           String msgRecu;
           int commande;
           boolean jouer;
           
            // the following loop performs the exchange of
            // information between client and client handler
            while (true) 
            {
            	 jouer = false;
            	
             
            	msgRecu = (String) in.readObject();
            	System.out.println(msgRecu);
        	
           
            while( !jouer) {
            	commande  = scn.nextInt();
            	if( commande <= 9 && commande >= 1) {
            		out.writeObject(commande);
            		
            		System.out.println("ok");
            		jouer = true;
            		
            	}
            	else {
            		System.out.println(msgRecu);
            		
            	}
            	  }
   
           
            System.out.println(in.readObject());
            
            
            if( robotClient.getVie() <= 0  || robotClient.getNbdrapeaux() == 0) {
            	// Si le joueur n'a plus de vie alors la partie s'achève.
            	out.writeObject(-1);
            	s.close();
            	scn.close();
            	System.out.println("Tu à perdu!");
            	
            	break;
            }
        
          
              
   
            	
  }
            
           
            
          
          
           
        }catch(Exception e){
            e.printStackTrace();
          
              
        }
        
    }
    
}
    
