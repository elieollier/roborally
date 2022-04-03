import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient extends Thread {
	

	
final Socket s ;
ObjectInputStream in ;
ObjectOutputStream out;
SetDeCartes cartesClient;
Bot r;


	
	public ThreadClient ( Socket s,ObjectOutputStream out,ObjectInputStream in,SetDeCartes cartesClient , Bot r) throws IOException {
		this.s = s;
		this.out = out;
		this.in = in;
		this.cartesClient = cartesClient;
		
		this.r = r;
		
		
	}
	
public void run() {
	
		
	try {
		
	while( true) {
		
         out.writeObject("Quelle carte voulez vous jouer ?");
         int  cartejouee = (int) in.readObject();
         if( cartejouee != -1) {
        cartesClient.get(cartejouee -1 ).effet(r);
        Serveur.partager(r);
        }
        else {
        	Serveur.fluxsortants.remove(out);
        	break;
        }
	}
		
	} catch (IOException e) {
		System.out.println("la connexion ne fonctionne pas");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("L'objet n'est jamais arrivé.");
	}
}
	
}
