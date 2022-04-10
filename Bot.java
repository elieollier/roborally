package Projet;

import java.io.Serializable;
import java.util.Random;

public class Bot implements Serializable {

private int x,y,xCheck,yCheck;
	private int ordre= 0;
	private int vie= 3;
	private final String ID;
	private Orientation o ;
	
	 static   Orientation  orientations [] =  new  Orientation[4];
	 
	
	
	    public static  void remplissage0() {

	    	   orientations[0] = Orientation.haut;
	    	   orientations[1] = Orientation.bas;
	    	   orientations[2] = Orientation.droite;
	    	   orientations[3] = Orientation.gauche;
	    	   
	    }
    
	  
	public Bot(Plateau p) {
		Bot.remplissage0();
		
	    setX(new Random().nextInt(10));
		setY(new Random().nextInt(10));
		setxCheck(x);
		setyCheck(y);
		this.o = orientations [new Random().nextInt(4)];
		
		
		while( !( p.caseEnIJ(x, y)  instanceof CaseNormale) ) {
	    setX(new Random().nextInt(10));
		setY(new Random().nextInt(10));
		setxCheck(x);
		setyCheck(y);
		}

		ID = String.valueOf(new Random().nextInt() * 1000);
	}

	public void deplacement() {
	
		switch(getO()) {	
			case haut:
				setX(getX() + 1);
				break;
			case bas:
				setX(getX() - 1);
				break;
			case droite:
				setY(getY() + 1);
				break;
			case gauche:
				setY(getY() - 1);
				break;
		}
		
		// si le robot sort de la matrice théorique, il meurt...
		if(x<0 || x > 9 || y<0 || y > 9
				&& x != -1 && y != -1) {
			mourir();
		}
		
		// deux robots ne peuvent pas etre sur la même case	
		if(Serveur.botDansLaCase(x, y) && x != -1 && y != -1) {
			deplacementInverse();
		}
	}
	
	public void deplacementInverse() { 
		// Annule le deplacement() / Fait reculer le robot dans le sens inverse de son orientation
		
		switch(getO()) {	
			case haut:
				setX(getX() - 1);
				break;
			case bas:
				setX(getX() + 1);
				break;
			case droite:
				setY(getY() - 1);
				break;
			case gauche:
				setY(getY() + 1);
				break;
		}
	}
	
	

    

    
    

	public void laser() {
		if(o == Orientation.haut || o == Orientation.bas) {
			Serveur.faireMourirTousLesBotsColonne(x);
		}
		else { //(o == Orientation.gauche || o == Orientation.droite)
			Serveur.faireMourirTousLesBotsLigne(y);
		}
	}

	public void mourir() {
		if(vie>0) { // le robot reprend sa copie de sauvegarde
			vie-=1;
			setX(xCheck);
			setY(yCheck);
		}
		if(vie==0) { // le robot ne réapparait pas
			setX(-1);
			setY(-1);
		}
	}

	
	
	
	public String getNom() {
	return "Bot" + String.valueOf(o);
	}
	
	
	
	public int getVie() {
		return vie;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getxCheck() {
		return xCheck;
	}
	
	public void setxCheck(int xCheck) {
		this.xCheck = xCheck;
	}
	
	public int getyCheck() {
		return yCheck;
	}
	
	public void setyCheck(int yCheck) {
		this.yCheck = yCheck;
	}
	
	public int getOrdre() {
		return ordre;
	}
	
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Orientation getO() {
		return o;
	}
	
	public void setO(Orientation o) {
		this.o = o;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public String getID() {
		return ID;
	}

	
	
}
