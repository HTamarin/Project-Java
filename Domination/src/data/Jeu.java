package data;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu monJeu = new Jeu();
		
		//Etape 1: Charger fichier
		monJeu.chargerFichierDomino("src/ressources/dominos.csv");
		
		//Etape 2: Nombre de joueurs et sélection des rois. Choix couleur
		
		monJeu.definirNombreJoueurs();
		
		monJeu.creerDesJoueurs(); //creer le plateau
		
		monJeu.definirOrdreDesJoueurs(); 
		
		while (monJeu.enCour()) {
			
			monJeu.joueurSuivant(); //tant qu'on peut joueur , joueur suivant
			
					
		}
		
		monJeu.afficheResultat(); //calcul resultat
		

	}

}
