

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	
	
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serveur = new ServerSocket(5056);
		
	
		while (true ) {
			
		
		
		Socket client  = serveur.accept();
		System.out.println("Un nouveau client s'est connecté. ");
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());
		
		Thread t  =  new ClientHandler(client,out,in) ;
		t.start();
		
		}


		
	
	
	
		
	}
}


