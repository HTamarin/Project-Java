package dato;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Map<String, String[][]> plateau = new TreeMap<String, String[][]>();
		plateau.put("joueur1",Matrice.matrix());
		plateau.put("joueur2",Matrice.matrix());
		plateau.put("joueur3",Matrice.matrix());
		plateau.put("joueur4",Matrice.matrix());
		

		
		// TODO Auto-generated method stub

		/*Jeu monJeu = new Jeu();
		
		//Etape 1: Charger fichier
		 * File fichier = new File("src/ressources/dominos.csv");
		monJeu.chargerFichierDomino(fichier);
		
		//Etape 2: Nombre de joueurs et s√©lection des rois. Choix couleur
		
		monJeu.definirNombreJoueurs();
		
		monJeu.creerDesJoueurs(); //creer le plateau
		
		monJeu.definirOrdreDesJoueurs(); 
		
		while (monJeu.enCour()) {
			
			monJeu.joueurSuivant(); //tant qu'on peut joueur , joueur suivant
			
					
		}
		
		monJeu.afficheResultat(); //calcul resultat
		
*/
		Map<String, ArrayList<String>> full = Domino.domino();
		System.out.println(full);
		int n=Player.setPlayerCount();
		Player.coloR(n);
		Map<String, String[][]> PlateauJoueur = Turn.turn(n,plateau); //tu mets plateau.get(joueur1) Áa te donne le plateau du jour 1 par exemple
	}

}
