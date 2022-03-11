public class CaseTapisRoulant implements Case{




public void effet(Bot r,Orientation o) {
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
