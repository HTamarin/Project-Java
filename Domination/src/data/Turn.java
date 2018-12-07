package data;

import java.util.*;

public class Turn {
	public static void main(String[] args) {
		turn();
	}

	public static void turn() {
		int condition = 0;
		int r = 0;
		int players = Player.setPlayerCount(condition); // Pour recuperer la valeur et ne pas lancer des cases
		if (players == 2 || players == 4) {
			r = 4;
		}
		if (players == 3) {
			r = 3;
		}

		Map<String, ArrayList<String>> ListeDomRed = Regle.RegleJoueur(players);
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
			numeroTour = numeroTour + 1;
			System.out.println("tour " + (numeroTour) + " : " + tourlist);

		}

	}
}
