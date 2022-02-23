public class CaseTapisRoulant implements Case{

private Orientation o  = Orientation.haut;



public void effet(Bot r) {
		if (o == Orientation.droite)
			r.setX( r.getX()+ 1);
		else if(o== Orientation.gauche)
			r.setX( r.getX()- 1);
		else if (o == Orientation.haut)
			r.setY( r.getY()- 1);
		else
			r.setY( r.getY()+ 1);
}
}
