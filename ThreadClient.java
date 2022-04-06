import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ThreadClient extends Thread {
	

	
final Socket s ;
ObjectInputStream in ;
ObjectOutputStream out;

Bot r;
Plateau p;
ArrayList <Bot> listeBots;

	
	public ThreadClient ( Socket s,ObjectOutputStream out,ObjectInputStream in, Bot r,ArrayList <Bot> listeBots, Plateau p) throws IOException {
		this.s = s;
		this.out = out;
		this.in = in;
		this.r = r;
		this.p = p;
		this.listeBots = listeBots;
		
		
	}
	
public void run() {
	
		
	try {
		
		
	while( true) {
		
		// On reçoit les cartes jouées et on activent leurs effets. 
        List <Carte> cartesJouees  =  (List <Carte>) in.readObject();
        System.out.println(cartesJouees);
    
        System.out.println(r.getX());
        for (int i =0 ; i < cartesJouees.size(); i++) {
        	cartesJouees.get(i).effet(r);
        	p.caseEnIJ(r.getX(),r.getY()).effet(r);
        }
        System.out.println(r.getX());
        
    
        Serveur.partager(listeBots);
        
	}
		
	} catch (IOException e) {
		System.out.println("la connexion ne fonctionne pas");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("L'objet n'est jamais arrivé.");
	}
}
	
}

