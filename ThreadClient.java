package Projet;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadClient extends Thread {
	

	
final Socket s ;
ObjectInputStream in ;
ObjectOutputStream out;
Bot r ;
Plateau p;

	
	public ThreadClient ( Socket s,ObjectOutputStream out,ObjectInputStream in, Bot r, Plateau p) throws IOException {
		this.s = s;
		this.out = out;
		this.in = in;
		this.r = r;
		this.p = p;
		
		
		
	}
	
public void run() {
	
		
	try {
		
		
		
		Serveur.listeBot.add(r);
	 Serveur.partager(Serveur.listeBot);
		
	while( true ) {
		

        
        
   Bot robotClient  = (Bot) in.readObject();
  
   int indice = -1;
        	
    for (int i = 0 ; i < Serveur.listeBot.size() ; i++) {
    if(  Serveur.listeBot.get(i).getID().equals(robotClient.getID())) {
   indice = i;
   break;
    }}
    
    if( indice != -1) {
    Serveur.listeBot.set(indice, robotClient);
    
    }
    	
    
     
    
        Serveur.partager(Serveur.listeBot);
        
	}
		
	} catch (IOException e) {
		System.out.println("la connexion ne fonctionne pas");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("L'objet n'est jamais arrivé.");
	}
}
	
}
