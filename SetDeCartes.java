import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SetDeCartes {
	private List<Carte> deck;
	
	private Carte listeDesCartesDuJeu [] = {new CarteO(Orientation.gauche), new CarteO(Orientation.droite),
			new CarteD(-1), new CarteD(1), new CarteD(2), new CarteD(3)};
	
	SetDeCartes() {
		deck = new ArrayList<Carte>();

		for (int i = 0; i < 9; i++ ) {
			this.addRandomCarte();
		}
	}
	
	public void addRandomCarte() {
		deck.add( listeDesCartesDuJeu[new Random().nextInt( 1+ deck.size() )] );
	}
	
	public void remove(Carte carte) {
		deck.remove(carte);
	}
	
	public int size() {
		return deck.size();
	}

}
