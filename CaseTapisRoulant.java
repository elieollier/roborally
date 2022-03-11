public class CaseTapisRoulant implements Case{


public class CaseTapisRoulant implements Case {
	  Orientation orientations [] =  {Orientation.haut,Orientation.bas,Orientation.gauche,Orientation.droite};
	  Random alea = new Random();
	
	public void effet(Bot r) {
	  Orientation o = orientations[alea.nextInt(4)];
		if ( o == Orientation.droite)
			r.setX( r.getX()+ 1);
		else if(o== Orientation.gauche)
			r.setX( r.getX()- 1);
		else if (o == Orientation.haut)
			r.setY( r.getY()- 1);
		else
			r.setY( r.getY()+ 1);
}
	
}
