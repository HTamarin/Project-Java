package dato;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Regle {

	static int i = 0;
	boolean equals;

	/**
	 * Ce programme permet , en fonction du nombre de joueurs , de definir les
	 * dominos restant
	 * 
	 * @param e
	 * @return
	 */
	public static Map<String, ArrayList<String>> regleJoueur(int e) {
		Map<String, ArrayList<String>> FullDomino = Domino.domino();
		Map<String, ArrayList<String>> PoolDominos = new HashMap<String, ArrayList<String>>();
		ArrayList<String> fullDom = new ArrayList<String>();
		boolean equals;
		if (e == 2) {

			int MaxDominos = 24; // Nombre total de dominos
			int[] random = new int[MaxDominos];
			while (i != MaxDominos) {
				random[i] = ((int) (Math.random() * 47)) + 1; // Valeure aléatoire entre 1 et 48
				equals = false;
				for (int j = 0; j != i; j++) { // Verification des doublons
					if (random[j] == random[i]) {
						equals = true;
					}
				}
				if (!equals) {
					i++;
				}
			}

			for (int o = 0; o < random.length; o++) {
				String u = String.valueOf(random[o]); // Change chaque entier en String

				fullDom = FullDomino.get(u); // Renvoit la liste correspondant à l'indice u <String>
				PoolDominos.put(u, fullDom);
				// System.out.println(u);
				// jou.put("Joueur"+String.valueOf(random[o]),c)
			}

		}
		if (e == 3) {
			// même chose que precedement , sauf que MaxDominos = 36
			int MaxDominos = 36;
			int[] random = new int[MaxDominos];
			while (i != MaxDominos) {
				random[i] = ((int) (Math.random() * 47)) + 1;
				equals = false;
				for (int j = 0; j != i; j++) {
					if (random[j] == random[i]) {
						equals = true;
					}
				}
				if (!equals) {
					i++;
				}
			}

			for (int o = 0; o < random.length; o++) {

				String u = String.valueOf(random[o]);

				fullDom = FullDomino.get(u);
				PoolDominos.put(u, fullDom);
			}

		}

		if (e == 4) {

			PoolDominos = FullDomino;

		}
		System.out.println("Les dominos restants sont : " + PoolDominos);
		return PoolDominos;

	}

}
