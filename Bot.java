public class Bot {
	
	
private int vie,x,y;;
private String nom;
private String img;
private Orientation o  = Orientation.haut;



public Bot( String nom,int vie,int x, int y) {
	setNom( nom);
	setVie(vie);
	setX(x);
	setY(y);
	
}



public Bot() {
	setNom( this.nom);
	setVie(this.vie);
    setX(this.x);
    setY(this.y);
 
 

}




public int getVie() {
	return vie;
}

public void setVie(int vie) {
	this.vie = vie;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
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






}
