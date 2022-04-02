public class Bot {

private int x,y,xCheck,yCheck;
	private int ordre= 0;
	private int vie= 3;
	private Orientation o  = Orientation.haut;

	public Bot(int x, int y) {
		xCheck=x;
		yCheck=y;
		setX(x);
		setY(y);
		
	}
	public Bot() {
		xCheck=x;
		yCheck=y;
	    setX(this.x);
	    setY(this.y);
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
		if(x<0 || x > Plateau.getTaille()-1 || y<0 || y > Plateau.getTaille()-1 
				&& x != -1 && y != -1) {
			mourir();
		}
		
		// deux robots ne peuvent pas etre sur la même case	
		// -> Méthode dans le serveur : Y'a il un robot sur la case ?
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
		
		// si le robot sort de la matrice théorique, il meurt...
		if(x<0 || x > Plateau.getTaille()-1 || y<0 || y > Plateau.getTaille()-1 
				&& x != -1 && y != -1) {
			mourir();
		}
		
		// deux robots ne peuvent pas etre sur la même case	
		// -> Méthode dans le serveur : Y'a il un robot sur la case ?
	}
	

	public void laser() {
		if(o == Orientation.haut || o == Orientation.bas) {
			// faire mourrir les robots sur la colonne getY()
			// Fonction du serveur
		}
		else { //(o == Orientation.gauche || o == Orientation.droite)
			// faire mourrir les robots sur la ligne getX()
			// Fonction du serveur
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
}
