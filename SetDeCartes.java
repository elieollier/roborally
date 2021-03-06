import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SetDeCartes {
	private List<Carte> deck;
	
	
	
	SetDeCartes() {
		deck = new ArrayList<Carte>();

		for (int i = 0; i < 9; i++ ) {
			this.addRandomCarte();
		}
	}
	
	public void addRandomCarte() {
		Carte listeDesCartesDuJeu [] = {new CarteO(Orientation.gauche), new CarteO(Orientation.droite),
				new CarteD(-1), new CarteD(1), new CarteD(2), new CarteD(3)};
		// listeDesCartesDuJeu n'est pas un attribut pour que la vitesse en soit pas la même
		// pour toutes les cartes déplacement du même type
		
		deck.add( listeDesCartesDuJeu[new Random().nextInt( listeDesCartesDuJeu.length )] );
	}
	
	public Carte get(int i) {
		return deck.get(i);
	}
	
	public void remove(Carte carte) {
		deck.remove(carte);
	}
	
	public int size() {
		return deck.size();
	}

}
