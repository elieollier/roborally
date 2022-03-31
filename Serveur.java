
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Serveur 
{
	
	
	 static ArrayList <Bot>  listeBot = new  <Bot> ArrayList ();
	  static ArrayList < ObjectOutputStream> listefluxSortant = new <ObjectOutputStream> ArrayList ();
	  static ArrayList < ObjectInputStream> listefluxEntrant = new <ObjectInputStream> ArrayList ();
	  
    public static void main(String[] args) throws IOException 
    {
        // server is listening on port 5056
        ServerSocket ss = new ServerSocket(5056);
        
        
        
        
        
    
          
        // running infinite loop for getting
        // client request
        while (true) 
        {
            Socket s = null;
              
            try 
            {
                // socket object to receive incoming client requests
                s = ss.accept();
                  
                System.out.println("A new client is connected : " + s);
                  
                // obtaining input and out streams
                ObjectInputStream dis = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream dos = new  ObjectOutputStream(s.getOutputStream());
                listefluxSortant.add(dos);
                Bot robotClient = (Bot) dis.readObject();
                listeBot.add(robotClient);
                envoiObjet(listefluxSortant,listeBot);
                
                
                
                System.out.println("Assigning new thread for this client");
  
                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);
  
                // Invoking the start() method
                t.start();
                  
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
    
    
  public static void envoiObjet ( ArrayList <ObjectOutputStream> listeflux,  ArrayList <Bot> lisBot  ) throws IOException  {
	  
	  for (int i = 0 ; i < listeflux.size() ; i++) {
		  
		  listeflux.get(i).writeObject(lisBot);
	  }
  }
    
    
    
  public static void recevoirObjet ( ArrayList <ObjectInputStream> listeflux ) throws IOException, ClassNotFoundException  {
	  
	  for (int i = 0 ; i < listeflux.size() ; i++) {
		  
		  listeflux.get(i).readObject();
	  }
  }
   
    
   
}
  
// ClientHandler class
class ClientHandler extends Thread 
{
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final ObjectInputStream dis;
    final  ObjectOutputStream dos;
    final Socket s;
      
  
    // Constructor
    public ClientHandler(Socket s, ObjectInputStream dis, ObjectOutputStream dos) 
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
  
    @Override
    public void run() 
    {
        String received;
        String toreturn;
        while (true) 
        {
            try {
  
                // Ask user what he wants
                dos.writeUTF("What do you want?[Date | Time]..\n"+
                            "Type Exit to terminate connection.");
                  
                // receive the answer from client
                received = dis.readUTF();
                  
                if(received.equals("Exit"))
                { 
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                  
                // creating Date object
                Date date = new Date();
                  
                // write on output stream based on the
                // answer from the client
                switch (received) {
                  
                    case "Date" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;
                          
                    case "Time" :
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;
                          
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();
              
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
