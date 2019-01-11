package dato;

import java.awt.Container;
import java.util.*;

import javax.swing.JOptionPane;

public class Turn {

	public static ArrayList<ArrayList<String>> turn(int s) {
		
		int r = 0;
		int players = s; // Pour recuperer la valeur et ne pas lancer des cases
		if (players == 2 || players == 4) {
			r = 4;
		}
		if (players == 3) {
			r = 3;
		}

		Map<String, ArrayList<String>> ListeDomRed = Regle.regleJoueur(players);
		Set<String> keys = ListeDomRed.keySet();
		ArrayList<ArrayList<String>> listTour = new ArrayList<ArrayList<String>>();
		ArrayList<String> cles = new ArrayList<String>(keys);
		List<String> newcles = new ArrayList<String>(cles);
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(newcles);
		}
		System.out.println("clés : " + cles);
		System.out.println("newclés : " + newcles);
		int numeroTour = 0;
		for (int i = 0; i < ListeDomRed.size(); i = i + r) {

			Map<String, ArrayList<String>> tour = new HashMap<String, ArrayList<String>>();
			int[] tourtab = new int[r];
			for (int j = 0; j < r; j++) {
				tour.put(cles.get(i + j), ListeDomRed.get(newcles.get(i + j)));
				int q = Integer.parseInt(newcles.get(i + j));
				tourtab[j] = q;

			}

			Arrays.sort(tourtab);

			ArrayList<String> tourlist = new ArrayList<String>();
			for (int j = 0; j < r; j++) {
				String q = String.valueOf(tourtab[j]);
				tourlist.add(q);
			}
			numeroTour = numeroTour + 1;
			System.out.println("tour " + (numeroTour) + " : " + tourlist);
			listTour.add(tourlist);
			
		}
		return listTour;
	}
	
	public static Map<String, String[][]> choixDomino(int i, int n , ArrayList<String> ordrejoueur, ArrayList<ArrayList<String>> dominotour  , Map<String, String[][]> plateau) {
		int k = 0;
		Map<String, String[][]> mapPlateau = new HashMap<String, String[][]>();

		 ArrayList<String> joueurs = ordrejoueur;
			Collections.shuffle(joueurs);
			Collections.shuffle(joueurs);
			System.out.println("joueurs = "+joueurs);
		 ArrayList<ArrayList<String>> dominos=dominotour;
		 int players = n;
		 if (n==2) {
			 players =4;
		 }
		 System.out.println(dominos);
			ArrayList<String> reponse = new ArrayList<String>();
			ArrayList<String>tourlist = dominos.get(i);
		while (k < players) {
			// System.out.println(random);
			ArrayList<String> tourDominoJoueur = new ArrayList<String>();
			String[] tourtable = new String[tourlist.size()];
			for (int q = 0; q < tourlist.size(); q++)
				tourtable[q] = tourlist.get(q);
			int[] joueur = new int[players];
			for (int g = 0; g < players; g++) {
				joueur[g] = g + 1;
			}
			String answer = (String) JOptionPane.showInputDialog(null,
					joueurs.get(k) + " Choisissez un domino ?", "Choix", JOptionPane.QUESTION_MESSAGE, null,
					tourtable, null);
			String joueurnbr = joueurs.get(k); 
			

			while (reponse.contains(answer)) {
				answer = (String) JOptionPane.showInputDialog(null, "Domino déja pris , Choisissez un domino disponible !", "Choix",
						JOptionPane.QUESTION_MESSAGE, null, tourtable, null);
				if (Turn.isNullOrEmpty(answer)) {
					System.exit(0);
				}

			}
			if (Turn.isNullOrEmpty(answer)) {
				System.exit(0);
			}
			System.out.println(joueurnbr);
			tourDominoJoueur.add(joueurnbr);
			tourDominoJoueur.add(answer);
			mapPlateau = Matrice.ajouterDominoPlateau(tourDominoJoueur,plateau);
			reponse.add(answer);

			k++;
		}
		
		
		
		return mapPlateau;
		
	}
	public static ArrayList<String> ordreJoueur(int n) {
		ArrayList<String> joueurs = new ArrayList<String>();
		if (n==2) {
			joueurs.add("joueur1");
			joueurs.add("joueur2");
			joueurs.add("joueur1");
			joueurs.add("joueur2");
		}
		if (n==3) {
			joueurs.add("joueur1");
			joueurs.add("joueur2");
			joueurs.add("joueur3");
		}
		if (n==4) {
			joueurs.add("joueur1");
			joueurs.add("joueur2");
			joueurs.add("joueur3");
			joueurs.add("joueur4");
		}

		return joueurs;
		
	}
	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

}
