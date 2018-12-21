package dato;

import java.util.*;

import javax.swing.JOptionPane;

public class Turn {

	public static void turn(int s) {

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
			int k = 0;
			numeroTour = numeroTour + 1;
			System.out.println("tour " + (numeroTour) + " : " + tourlist);
			ArrayList<String> reponse = new ArrayList<String>();
			while (k < players) {			
				// System.out.println(random);
				String[] tourtable = new String[tourlist.size()];
				for (int q = 0; q < tourlist.size(); q++)
					tourtable[q] = tourlist.get(q);
				int[] joueur = new int[players];
				for (int g=0;g<players;g++) {
					joueur[g]=g+1;
				}
				String answer = (String) JOptionPane.showInputDialog(null, "Joueur ="+joueur[k] + " Choisissez un domino ?",
						"Choix", JOptionPane.QUESTION_MESSAGE, null, tourtable, null);
				
				while(reponse.contains(answer)){
					answer = (String)JOptionPane.showInputDialog(null, "Choisissez un domino disponible !","Choix",JOptionPane.QUESTION_MESSAGE,null,tourtable,null);
					

				}
				System.out.println(answer);
				reponse.add(answer);

				k++;

			}
		}

	}

}
