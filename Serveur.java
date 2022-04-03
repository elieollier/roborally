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
	
	
	 static LinkedList<Bot>  listeBot = new  LinkedList<> ();
	 static LinkedList < ObjectOutputStream>  fluxsortants  = new LinkedList < ObjectOutputStream>();
	 static LinkedList < ObjectInputStream>  fluxentrants = new LinkedList < ObjectInputStream>();
	 public static final int PORT = 5056;
	
	  
	
	  
    public   static   void partager( Object o)  throws IOException {
       	Iterator<ObjectOutputStream> it =  fluxsortants.iterator();
       	while( it.hasNext()) {
       		it.next().writeObject(o);
       		
       		
       	}
       	
       	
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
                // socket object to receive incoming client requests
            	
                client = serveur.accept();
                  
                System.out.println("Youpi! Un nouveau joueur vient d'arriver! " + client);
                
               
                ObjectOutputStream out = new  ObjectOutputStream (client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                Bot robotClient  = (Bot) in.readObject();
                listeBot.add(robotClient );
                fluxsortants.add(out);
        		Serveur.partager(listeBot);
        	
                
                System.out.println("Un nouveau thread est assigné.");
                
                
                // On affecte le thread au client qui vient de se connecter. 
               Thread t  = new ThreadClient(client,out,in , (SetDeCartes) in.readObject(), robotClient );
               t.start();
                
         
                }
               
           
                   
                
                          
              
            
              
                  
            }
        catch (Exception e){
                client.close();
                e.printStackTrace();
                }
            
            
            

        
     
        
    

}
    
}

