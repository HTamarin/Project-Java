package dato;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Jeu monJeu = new Jeu();
		
		//Etape 1: Charger fichier
		 * File fichier = new File("src/ressources/dominos.csv");
		monJeu.chargerFichierDomino(fichier);
		
		//Etape 2: Nombre de joueurs et sélection des rois. Choix couleur
		
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
		Turn.turn(n);
	}

}
