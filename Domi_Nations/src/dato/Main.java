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
		
		//Etape 2: Nombre de joueurs et sÃ©lection des rois. Choix couleur
		
		monJeu.definirNombreJoueurs();
		
		monJeu.creerDesJoueurs(); //creer le plateau
		
		monJeu.definirOrdreDesJoueurs(); 
		
		while (monJeu.enCour()) {
			
			monJeu.joueurSuivant(); //tant qu'on peut joueur , joueur suivant
			
					
		}
		
		monJeu.afficheResultat(); //calcul resultat
		
*/

		Map<String, ArrayList<String>> full = Domino.domino();
		Map<String, String[][]> plateauJoueur = null;
		Map<String, Integer> score = new TreeMap<String, Integer>();
		System.out.println(full);
		System.out.println(CalculScore.calculScore());
		int n=Player.setPlayerCount();
		
		Player.coloR(n);
		
		ArrayList<ArrayList<String>> listTour = Turn.turn(n); // renvoit la liste composé de chaque tour de jeu ( domino qu'on peut choisir ) 
		
		ArrayList<String> ordretour = Turn.ordreJoueur(n); // renvoit la liste des joueurs 
		//int nombretour = listTour.size();
		//System.out.println("nombretour = "+nombretour);
		
		for (int i=0;i<listTour.size();i++) {
			
		plateauJoueur = Turn.choixDomino(i,n,ordretour, listTour, plateau); //tu mets plateauJoueur.get(joueur1) ça te donne le plateau du joueur 1 par exemple
		//choixDomino est aussi 
		}
		
		for (int j=0;j<n;j++) {
			String joueur="joueur"+String.valueOf(j+1);
			Matrice.affichePlateau(plateauJoueur.get(joueur));	
			//score.put(joueur,CalculScore.calculScore(joueur,plateauJoueur));
		}
		//System.out.println("score =" + score);
		//int scorejoueur = CalculScore.affichescore(joueur,plateauJoueur);
		//System.out.println("score" +joueur +" = "+scorejoueur  );
		
		//CA MARCHE !
		//le plateau est dispo 
	}
	

}
