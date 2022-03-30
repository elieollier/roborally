import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphicWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public GraphicWindow() throws Exception {
		super("~ RoboRally en multijoueur ! ~");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/logo.png"));  
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // En cas de fermeture de la fenetre, coupe l'execution du programme
		this.setSize(1200, 650); // Taille de la fenetre
		//this.setExtendedState(this.MAXIMIZED_BOTH); // Taille de la fenetre = Plein Ecran
		this.setLocationRelativeTo(null); // Centre la fenetre
		this.setVisible(true);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
	
		//-- MENU --\\	
		this.setJMenuBar( creationMenu() );
		
		//-- CENTER --\\
		contentPane.add( creationPlateau(), BorderLayout.CENTER);
		
		//-- SOUTH --\\
		contentPane.add( new JCheckBox("STATISTIQUES        |        TEMPS JOUE : 10min 30        |"
				+ "        Nombre de joueurs : n        "), BorderLayout.SOUTH);
	
		//-- WEST --\\
		contentPane.add( creationCoteGauche(), BorderLayout.WEST);
	}
	
	private JPanel creationPlateau() throws IOException {
		Plateau plateau = new Plateau();
		ArrayList<Bot> listeDesBots = new ArrayList<Bot>();
		listeDesBots.add(new Bot(2,3));
		listeDesBots.add(new Bot(3,3));
		listeDesBots.add(new Bot(4,3));
		
		JPanel jpanel = new JPanel(new GridLayout(10,10,0,0));
		
		for (int i=0; i < 10 ;i++) {
			for (int j=0; j < 10 ;j++) {
					
					String fichier = "Images/Cases/"+plateau.caseEnIJ(i, j).getNom()+".png";
					System.out.print(plateau.caseEnIJ(i, j).getNom());
				
					ImageIcon img = new ImageIcon(fichier);
					
					for (int k = 0; k < listeDesBots.size(); k++) {
						
						if(i == listeDesBots.get(k).getX() && j == listeDesBots.get(k).getY() ) {
					    	BufferedImage large=null;
						    large = ImageIO.read(new File(fichier));
					    	BufferedImage small=null;
						    small = ImageIO.read(new File("bot3.png"));
						    int w = Math.max(large.getWidth(), small.getWidth());
						    int h = Math.max(large.getHeight(), small.getHeight());
					
						    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
					
						    //paint both images, preserving the alpha channels
						    Graphics g = combined.getGraphics();
						    g.drawImage(large, 0, 0, null);
						    g.drawImage(small, 10, 10, null);
					
						    ImageIO.write(combined, "PNG", new File("newImg.png"));
						    
						    img = new ImageIcon(combined);
				    }
				}
				    
				jpanel.add(new JLabel(img, JLabel.CENTER));
				}
			}
		jpanel.setBackground(new Color(175, 175, 175));
		return jpanel;
	}
	
	
	
	
	int tour =0;
	boolean envoyerCarte = true;//false;
	private JPanel creationCoteGauche() throws Exception {
		/*-- Le côté gauche est composé d'un tableau de cartes que le joueur peut choisir --*/

			List<Carte> listeDesCartes = new ArrayList<Carte>();
					listeDesCartes.add(new CarteO(Orientation.gauche));
					listeDesCartes.add(new CarteO(Orientation.droite));
					listeDesCartes.add(new CarteD(-1));
					listeDesCartes.add(new CarteD(1));
					listeDesCartes.add(new CarteD(2));
					listeDesCartes.add(new CarteD(3));				
			
			JPanel jpanelCartes = new JPanel(new GridLayout(listeDesCartes.size()/3, 3, 0, 0));
			
			for (int i=0; i < listeDesCartes.size() ;i++) {
				
				Carte carte = listeDesCartes.get(i);
				String image = "Images/Cartes/"+carte;
				
				JButton bouton = new JButton(new ImageIcon(image));
					bouton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							if (envoyerCarte) {
								//envoyerCarte = false;
								tour++;
								if (tour <= 5) {
									 System.out.println("Envoi de l'objet Carte grâce à la sérilisation : "+e.getSource());
									
									 System.out.println(carte);
									 
									//serialise(Carte carte)
									 bouton.setIcon(null);
									 bouton.setVisible(false);
									 listeDesCartes.remove(carte);
								}
								if (listeDesCartes.size() == 5) {
//									for (int i=0; i < listeDesCartes.size() ;i++) {
//										//suprimer(Carte carte)
//									}
									listeDesCartes.removeAll(listeDesCartes);
									//tour = 0;
								}	
							}
						}
					});
				bouton.setContentAreaFilled(false);
				bouton.setBorderPainted(false);
				
				jpanelCartes.add(bouton);
			}
		
		return jpanelCartes;	
	}
	
	public static void affichage(String msg) {
		   System.out.println(msg);
	}
	
	private JMenuBar creationMenu() {
		JMenuBar barreDeMenu = new JMenuBar();
		
		JMenu options = new JMenu("Menu des Options du jeu");
		barreDeMenu.add(options);
			
			JMenuItem bruits = new JMenuItem("Couper les Bruitages et la Musique");
			bruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(GraphicWindow.this, "Les bruits et les musiques ont bien été coupées.");
				}
			} );
			options.add(bruits);
			
			
		JMenu credits = new JMenu("Les Crédits sans lesquels ce jeu ne serait pas possible");
		barreDeMenu.add(credits);
			credits.add(new JMenuItem("Création Originelle"));
			credits.add(new JMenuItem("Musiques"));
			credits.add(new JMenuItem("Images"));
			
		return barreDeMenu;
	}
	
	public static void main(String[] args) throws Exception {
		GraphicWindow window = new GraphicWindow();
		//window.setVisible(true);
	}
}
