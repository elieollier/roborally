import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GraphicWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Plateau plateau;
	private ArrayList<Bot> listeDesBots;
	private String idHisBot;
	
	private List<Carte> listeDesCartesCliquees = new ArrayList<Carte>();
	private SetDeCartes listeDesCartes = new SetDeCartes();
	
	private JPanel contentPane;
	private boolean bruitages = true;
	private boolean bruitageCase = true;

	public GraphicWindow(Plateau plateau, ArrayList<Bot> listeDesBots,  String idHisBot) throws Exception {
		super("~ RoboRally en multijoueur ! ~");
			this.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/logo.png"));  
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // En cas de fermeture de la fenetre, coupe l'execution du programme
			this.setExtendedState(this.MAXIMIZED_BOTH); // Taille de la fenetre = Plein Ecran
			this.setLocationRelativeTo(null); // Centre la fenetre
			this.setJMenuBar( creationMenu() ); //-- MENU --\\
		
		this.plateau = plateau;
		this.idHisBot = idHisBot;
		this.listeDesBots = listeDesBots;
		
		contentPane = (JPanel) this.getContentPane();
			contentPane.setLayout(new BorderLayout());
			this.remplissageBorderLayout();
	}
	
	private void remplissageBorderLayout() throws Exception {
		//-- CENTER --\\
		contentPane.add(creationPlateau(), BorderLayout.CENTER);
		
		Bot hisBot = null;
		for (int i = 0; i < listeDesBots.size(); i++) {
			if(listeDesBots.get(i).getID().equals(idHisBot)) {
				hisBot = listeDesBots.get(i);
				break;
			}
		}
		
		//-- SOUTH --\\
		JLabel label;
		if (hisBot != null && hisBot.getX() != -1 && hisBot.getY() != -1) {
			label= new JLabel("Nombre de joueurs : "+listeDesBots.size()+"    |    "
					+ "Copies de sauvegarde restantes : "+hisBot.getVie()+"    |    "
					+ "Coordonnées du robot : Ligne "+(hisBot.getX()+1)+", Colonne "+(hisBot.getY()+1)+"    |    "
					+ "CheckPoint validés : "+hisBot.getOrdre()+"    |    "
					+ "");
			
			if (bruitageCase == true) {
				try {
					Case caseIJ = plateau.caseEnIJ(hisBot.getX(), hisBot.getY());
					if(hisBot.getOrdre()==3) {
						GraphicWindow.this.musique("Sons/gagner.wav");
						JOptionPane.showMessageDialog(GraphicWindow.this,
							    "Félicitations, votre mission est reussie !\n"
							    + "Vous avez gagné, mais à un détail près, vous auriez pu perdre.\n"
							    + "Quelle chance, et quel talent !",
							    "Fin de partie : Vous avez pu sauver l'humanité",
							    JOptionPane.INFORMATION_MESSAGE,
							    new ImageIcon("Images/gagner.png") );
					}
					else if(caseIJ instanceof CaseCheckpoint)
						GraphicWindow.this.musique("Sons/checkpoint.wav");
					else
						GraphicWindow.this.musique("Sons/deplacement.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				bruitageCase = false;
			}
		}
		else {
			try {
				GraphicWindow.this.musique("Sons/mourir.wav");
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(GraphicWindow.this,
				    "Mission échouée...\n"
				    + "Votre robot est détruit, malheureusement il est impossible de le réanimer.",
				    "Fin de partie : Vous n'avez pas pu sauver l'humanité",
				    JOptionPane.INFORMATION_MESSAGE,
				    new ImageIcon("Images/mourir.png") );
			bruitages = false;
			label = new JLabel("Mission échouée...  Votre robot est détruit, malheureusement il est impossible de le réanimer.");
		}
			
		label.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
		contentPane.add(label, BorderLayout.SOUTH);
		
		
		//-- WEST --\\
		contentPane.add( creationCoteGauche(), BorderLayout.WEST);
	}

	public void setListeDesBots(ArrayList<Bot> listeDesBots) throws Exception {
		this.listeDesBots = listeDesBots;
		contentPane.removeAll();
		
		this.remplissageBorderLayout();
		contentPane.repaint();
		contentPane.revalidate();
		
		bruitageCase = true;
	}
	
	public void setSetDeCartes(SetDeCartes listeDesCartes) throws Exception {
		this.listeDesCartes = listeDesCartes;
		listeDesCartesCliquees.removeAll(listeDesCartesCliquees);
		contentPane.removeAll();
		
		this.remplissageBorderLayout();
		contentPane.repaint();
		contentPane.revalidate();
	}

	private JPanel creationPlateau() throws IOException {
		
		JPanel jpanel = new JPanel(new GridLayout(10,10,0,0));
		
		for (int i=0; i < 10 ;i++) {
			for (int j=0; j < 10 ;j++) {
					
					Case caseIJ = plateau.caseEnIJ(i, j);					
					BufferedImage imgCase = ImageIO.read(new File("Images/Cases/"+caseIJ.getNom()+".png"));
					
					if (caseIJ instanceof CaseTapisRoulant) {
						imgCase = ImageIO.read(new File("Images/Cases/"+caseIJ.getNom()+
								((CaseTapisRoulant)caseIJ).getO()+".png"));
					}
					
					for (int k = 0; k < listeDesBots.size(); k++) {
						if(i == listeDesBots.get(k).getX() && j == listeDesBots.get(k).getY() ) {
					    	BufferedImage imgBot = ImageIO.read(new File("Images/bot.png"));
					    	
						    int w = Math.max(imgCase.getWidth(), imgBot.getWidth());
						    int h = Math.max(imgCase.getHeight(), imgBot.getHeight());
						    BufferedImage imgCaseEtBot = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			
						    Graphics g = imgCaseEtBot.getGraphics();
						    g.drawImage(imgCase, 0, 0, null);
						    g.drawImage(imgBot, 10, 10, null);
					
						    imgCase = imgCaseEtBot;
						}
					}
				
				jpanel.add(new JLabel(new ImageIcon(imgCase), JLabel.CENTER));
				}
			}
		jpanel.setBackground(new Color(175, 175, 175));
		return jpanel;
	}
	
	
	
	private JPanel creationCoteGauche() throws Exception {
		/*-- Le côté gauche est composé d'un tableau de cartes que le joueur peut choisir --*/
		
			JPanel jpanelCartes = new JPanel(new GridLayout(3, 3, 0, 0));
			
			for (int i=0; i < listeDesCartes.size() ;i++) {
				Carte carteI = listeDesCartes.get(i);
				
				String vitesse = " ";
				if(carteI instanceof CarteD) {
					CarteD carteD = (CarteD) carteI;
					vitesse = carteD.getDeplacement()<0 ? 
							"RECULER ("+String.valueOf(carteD.getVitesse())+")":
							"AVANCER ("+String.valueOf(carteD.getVitesse())+")";	
				}
				else if(carteI instanceof CarteO) {
					CarteO carteO = (CarteO) carteI;
					vitesse = "TOURNER "+String.valueOf(carteO.getO()).toUpperCase();
				}
				JButton bouton = new JButton(vitesse, new ImageIcon("Images/Cartes/"+carteI.getNom()+".png"));
				bouton.setVerticalTextPosition(SwingConstants.BOTTOM);
				bouton.setHorizontalTextPosition(SwingConstants.CENTER);
				
				bouton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
							if (listeDesCartesCliquees.size() < 5) {								
								listeDesCartesCliquees.add(carteI);
								
								bouton.setIcon(null);
								bouton.setVisible(false);
								listeDesCartes.remove(carteI);
								try {
									GraphicWindow.this.musique("Sons/carte.wav");
								} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
									e1.printStackTrace();
								}
							}
					} // Fin actionPerformed(){}
					}); // Fin addActionListener(){}
				
				bouton.setContentAreaFilled(false);
				bouton.setBorderPainted(false);
				jpanelCartes.add(bouton);
			}
		
		return jpanelCartes;	
	}
	
	private JMenuBar creationMenu() {
		JMenuBar barreDeMenu = new JMenuBar();
		
		JMenu options = new JMenu("Menu des Options et Fonctionnalités");
		barreDeMenu.add(options);
		
			JMenuItem fermer = new JMenuItem("Arrêter le jeu");
			fermer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(GraphicWindow.this, 
							"Êtes-vous sûr de vouloir fermer le jeu ?"
							+ "\nVotre partie sera définitivement perdue.", "Confirmation de votre action", 
							JOptionPane.YES_NO_CANCEL_OPTION)==0)
						GraphicWindow.this.dispose();
				}
			} );
			options.add(fermer);
		
			JMenuItem bruits = new JMenuItem("Couper/Mettre les bruitages");
			bruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(GraphicWindow.this, 
							"Les bruitages ont bien été "+(bruitages==true? "coupés." : "activés."));
					bruitages = bruitages==true? false : true;
				}
			} );
			options.add(bruits);
			
			
		JMenu regles = new JMenu("C'est quoi RoboRally ?");
		barreDeMenu.add(regles);			
			
			JMenuItem trailer = new JMenuItem("Voir la vidéo de Trailer");
			trailer.addActionListener(e->{
	            try {
	                Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1xOBId6opgvzcXl9K2sEGk1gi_gLKYUqW/view?usp=sharing"));
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            } catch (URISyntaxException e1) {
	                e1.printStackTrace();
	            }
	        });
			regles.add(trailer);
			
			JMenuItem jeu = new JMenuItem("Comprendre le But du jeu");
			jeu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(GraphicWindow.this,
						    "En règle générale, le but d’une partie de RoboRally, en plus de garder\n"
						    + "son robot en état de marche, est d’être le premier à rallier un nombre\n"
						    + "prédéfini de checkpoints (drapeaux) dans le bon ordre. Les déplacements\n"
						    + "constituent la principale difficulté du jeu, car ils font appel à un\n"
						    + "système de cartes de programmation.\n"
						    + "Source : Wikipédia RoboRally.", 
						    "Comprendre le But du jeu",
						    JOptionPane.INFORMATION_MESSAGE,
						    new ImageIcon("Images/bot.png") );
				}
			} );
			regles.add(jeu);
			
			JMenuItem cartes = new JMenuItem("Les différents types de Cartes");
			cartes.addActionListener(e->{
				String[] choix={"Passer à la case suivante","Quitter"};
				int choixJoueur = JOptionPane.showOptionDialog(GraphicWindow.this, 
		                    "Carte de Déplacement :\n"
		                    +"Avance ou recule le robot d'un nombre de cases défini\n"
		                    + "sur la carte en prenant en compte son orientation.", 
		                    "Les différents types de cartes", 
		                    JOptionPane.YES_NO_OPTION, 
		                    JOptionPane.QUESTION_MESSAGE, 
		                    new ImageIcon("Images/Cartes/d2.png"), choix, choix[1]);
				
				String[] choix2 ={"Quitter"};
				if (1 != choixJoueur)
						JOptionPane.showOptionDialog(GraphicWindow.this, 
							 "Carte d'Orientation :\n"
							+"Change l'orientation du robot en le tournant de 90°\n"
							+ "vers le sens indiqué sur la carte (gauche ou droite).",
							"Les différents types de cartes", 
		                    JOptionPane.YES_NO_OPTION, 
		                    JOptionPane.QUESTION_MESSAGE, 
		                    new ImageIcon("Images/Cartes/gauche.png"), choix2, choix2[0]);
			});
			regles.add(cartes);
			
			
			JMenuItem cases = new JMenuItem("Les différents types de Cases");
				cases.addActionListener(e->{
					String[] choix={"Passer à la case suivante","Quitter"};
					Case[] diffCases = {new CaseNormale(), new CaseTrou(), new CaseBroyeur(), new CaseCheckpoint(10), new CaseLaser(), new CaseMur(), new CaseTapisRoulant(Orientation.gauche)};
					for (int i = 0; i < diffCases.length; i++) {
						int choixJoueur = JOptionPane.showOptionDialog(GraphicWindow.this, 
			                    "Case "+ diffCases[i].getNom()+" :\n"
			                    +"Votre Robot meurt avec de grosses souffrances.", 
			                    "Les différents types de Cases", 
			                    JOptionPane.YES_NO_OPTION, 
			                    JOptionPane.QUESTION_MESSAGE, 
			                    new ImageIcon("Images/Cases/"+diffCases[i].getNom()+".png"), choix, choix[1]);
						if (1 == choixJoueur)
							break;
						if (diffCases.length-1 == i) 
							i = -1;
					}
				});
			regles.add(cases);
			
		JMenu credits = new JMenu("Qu'es ce qui a permis de réaliser ce superbe jeu ?");
		barreDeMenu.add(credits);
			JMenuItem creation = new JMenuItem("Le comité de création");
			creation.addActionListener(e->{
				JOptionPane.showMessageDialog(GraphicWindow.this,
					    "Malo Ait Yahia, Thomas Ayrivié, Elie Cucurou–Ollier, \n"
					    + "Candice Déjean et Fabien Galle sont les réalisateurs\n"
					    + "de ce jeu créé en 2022 à l'université Paul Valéry.",
					    "Le comité de création",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("Images/bot.png") );
			});
			credits.add(creation);
			
			JMenuItem musiques = new JMenuItem("Les crédits des Musiques");
			musiques.addActionListener(e->{
				String[] choix = {"Se rendre sur le site", "Retourner en jeu"};
				int choixJoueur = JOptionPane.showOptionDialog(GraphicWindow.this,
					    "Les bruitages, tous libres de droit viennent de la bibliothèque Universal Soundbank,\n"
					    + "accessible au lien suivant : https://universal-soundbank.com/jeux-videos.htm.",
					    "Les crédits des Musiques",
					    JOptionPane.YES_NO_OPTION, 
	                    JOptionPane.QUESTION_MESSAGE,
					    new ImageIcon("Images/bot.png"), choix, choix[1]);
				
				if (0 == choixJoueur) {
					try {
		                Desktop.getDesktop().browse(new URI("https://universal-soundbank.com/jeux-videos.htm"));
		            } catch (IOException e1) {
		                e1.printStackTrace();
		            } catch (URISyntaxException e1) {
		                e1.printStackTrace();
		            }
				}
			});
			credits.add(musiques);
			
			JMenuItem images = new JMenuItem("Les crédits des Images");
			images.addActionListener(e->{
				JOptionPane.showMessageDialog(GraphicWindow.this,
					    "Les images des cases, et celles du robot ont été intégralement réalisés par\n"
					    + "Elie Cucurou–Ollier. Tandis que Thomas Ayrivié à réalisé celles des cartes.\n",
					    "Les crédits des Images",
					    JOptionPane.INFORMATION_MESSAGE,
					    new ImageIcon("Images/bot.png") );
			});
			credits.add(images);

		return barreDeMenu;
	}
	
	public void musique(String nom) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(bruitages == true) {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nom));
	    	Clip clip = AudioSystem.getClip();
	    	clip.open(audioInputStream);
	    	FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    	gainControl.setValue(-15.0f); // Réduction du volume !
	    	clip.start();
		}
	}
	
	
	public List<Carte> getListeDesCartesCliquees() {
		return listeDesCartesCliquees;
	}
}
