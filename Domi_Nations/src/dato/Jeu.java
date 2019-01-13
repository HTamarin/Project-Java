package dato;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Jeu {
public static void monJeu() {
	Map<String, String[][]> plateau = new TreeMap<String, String[][]>();
	plateau.put("joueur1",Matrice.matrix());
	plateau.put("joueur2",Matrice.matrix());
	plateau.put("joueur3",Matrice.matrix());
	plateau.put("joueur4",Matrice.matrix());
	Map<String, String[][]> plateauJoueur = null;
	Map<String, Integer> score = new TreeMap<String, Integer>();

	int n = Player.playercount; 	
	ArrayList<ArrayList<String>> listTour = Turn.turn(n); // renvoit la liste composé de chaque tour de jeu ( domino qu'on peut choisir ) 
	
	ArrayList<String> ordretour = Turn.ordreJoueur(n); // renvoit la liste des joueurs 
	
	for (int i=0;i<listTour.size();i++) {
		
	plateauJoueur = Turn.choixDomino(i,n,ordretour, listTour, plateau); //tu mets plateauJoueur.get(joueur1) ça te donne le plateau du joueur 1 par exemple
	//choixDomino est aussi 
	}
	
	for (int j=0;j<n;j++) {
		String joueur="joueur"+String.valueOf(j+1);
		Matrice.affichePlateau(plateauJoueur.get(joueur));	
		score.put(joueur,CalculScore.calculScore(joueur,plateauJoueur));
	}
	System.out.println("score =" + score);
}
}
