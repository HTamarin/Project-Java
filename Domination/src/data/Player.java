package data;

import java.util.Scanner;

public class Player {

	/**
	 * Cette fonction permet de decider le nombre de joueurs
	 * 
	 * @return
	 */

	public static int setPlayerCount(int h) {

		int NombreJoueurs = 0;
		while (NombreJoueurs < 2 || NombreJoueurs > 4) {
			try {
				System.out.println("Combien de joueurs?");
				Scanner scanner = new Scanner(System.in);
				NombreJoueurs = scanner.nextInt();
				if (h == 1) {
					if (NombreJoueurs>=2 && NombreJoueurs<=4) {
						Regle.RegleJoueur(NombreJoueurs);
					}
					else {
						System.out.println("Nombre de joueurs invalide");
					}

				}
			} catch (Exception e) {
				System.out.println("Nombre de joueurs invalide");
			}
		}
		return NombreJoueurs;
	}
}
