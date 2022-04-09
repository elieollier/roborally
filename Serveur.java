
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
public class Serveur 
{
		
		
		 static ArrayList<Bot>  listeBot = new  ArrayList<> ();
		 static ArrayList< ObjectOutputStream>  fluxsortants  = new ArrayList< ObjectOutputStream>();
		 public static final int PORT = 5056;
		static int nombreJoueurs = 2;
		// on crée autant de classe client qu'il n'y a de joueurs.
		  
		 
		 public static boolean botDansLaCase(int x, int y) {
		        for(int i = 0; i < listeBot.size(); i++) {
		            if(listeBot.get(i).getX() == x && listeBot.get(i).getY() == y)
		                return true;
		            
		        }
		        return false;
		    }

		    public static void faireMourirTousLesBotsColonne(int x) {
		        for(int i = 0; i < listeBot.size(); i++) {
		            if(listeBot.get(i).getX() == x)
		                listeBot.get(i).mourir();
		        }
		    }

		    public static void faireMourirTousLesBotsLigne(int y) {
		        for(int i = 0; i < listeBot.size(); i++) {
		            if(listeBot.get(i).getY() == y)
		                listeBot.get(i).mourir();
		        }
		    }
		
		  
	    public   static   void partager(ArrayList <Bot> l )  throws IOException {
	       	Iterator<ObjectOutputStream> it =  fluxsortants.iterator();
	       	while( it.hasNext()) {
	       		it.next().writeObject(l);}
	       		
	       		
	       	
	       	
	       }
	    
	   
	    
	    


		
	    public static void main(String[] args) throws IOException 
	    {
	        // server is listening on port 5056
	        ServerSocket serveur = new ServerSocket(PORT);
	     
	            Socket client = null;
	              
	            try 
	            {
	            	
	            	while (true) 
	                {
	                // Le serveur attend la connexion d'un client. 	            	
	              
	                  
	                while( listeBot.size() != nombreJoueurs) {
	                	
	                 	  client = serveur.accept();

	  	                System.out.println("Youpi! Un nouveau joueur vient d'arriver! " + client);
  
	                    ObjectOutputStream out = new  ObjectOutputStream (client.getOutputStream());
	   	                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
	   	                
	                    Bot robotClient  =  (Bot) in.readObject();
	   	                Plateau plateauClient   = (Plateau) in.readObject();
	   	                System.out.println(robotClient.getID());
	   	                fluxsortants.add(out);
	   	             
	   	             // On affecte le thread au client qui vient de se connecter. 
	   	             Thread t  = new ThreadClient(client,out,in,robotClient , plateauClient);
		              t.start();
		              System.out.println("Un nouveau thread est assigné.");
	   	               
	                }
	              	                
	               
	             
	  
	             
	            
	                
	                
	                Serveur.partager(listeBot);   
	               
	               
	                
	   
	                }
	               
	           
	            	  
	                
	                          
	              
	            
	              
	                  
	            }
	        catch (Exception e){
	                client.close();
	                e.printStackTrace();
	                }
	            
	            
	            

	        
	     
	        
	    

	}
	    
	}
