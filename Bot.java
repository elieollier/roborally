public class Bot {

	
private int x,y,xCheck,yCheck;
private int ordre;
private int vie=3;
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

public void Deplacement(Carte c) {
	
	switch(getO()) {
	
	
	case haut:
		setY(getY() + 1);
		break;
	case bas:
		setY(getY() - 1);
		break;
	case droite:
		setX(getX() + 1);
		break;
	case gauche:
		setX(getX() - 1);
		break;}
	// deux robots ne peuvent pas etre sur la même case	
	// si le robot sort de la matrice théorique, il meurt...
}


public void Mourir() {
	if(vie>0) {
		vie-=1;
		setX(xCheck);
		setY(yCheck);
	}if(vie==0) {
		// le robot ne réapparait pas
	}
}


public int getVie() {
	return vie;
}
public void setVie(int vie) {
	this.vie = vie;
}

public void reaparition(boolean dead , int vie) {
	if(dead=true && vie>=1) {
		// on réutilise la classe check-point
	}if(vie==0) {
		// on supprime le robot de la liste des Bot qui est dans le serveur que malo doit coder
	}
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
