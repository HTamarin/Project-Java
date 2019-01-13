package dato;

import java.util.*;
import javax.swing.*;

public class Player {
static int playercount;
	/**
	 * Cette fonction permet de decider le nombre de joueurs
	 * 
	 * @return
	 */
	static int setPlayerCount() {
		String[] answers = { "2", "3", "4" };

		ArrayList<String> Answer = new ArrayList<>();
		for (int j = 0; j < answers.length; j++) {
			Answer.add(answers[j]);
		}

		String answer = (String) JOptionPane.showInputDialog(null, "Nombre de joueurs ?", "Choix",
				JOptionPane.QUESTION_MESSAGE, null, answers, null);
		if (Turn.isNullOrEmpty(answer)) {
			System.exit(0);
		}

		int nombrejoueurs = Integer.parseInt(answer);
		playercount=nombrejoueurs;
		//System.out.println(NombreJoueurs);
		
		return nombrejoueurs;
	}

	public static void coloR(int s) {
		String[] answers = { "Rouge", "Rose", "Orange", "Violet" };
		ArrayList<String> Answer = new ArrayList<>();
		String[] a = answers;
		ArrayList<String> reponse = new ArrayList<String>();

		for (int j = 0; j < answers.length; j++) {
			Answer.add(answers[j]);
		}

		Map<String, String> Joueurs = new TreeMap<String, String>();

		for (int i = 1; i <= s; i++) {
			String answer = (String) JOptionPane.showInputDialog(null, "Choisissez une couleur !", "Choix couleur",
					JOptionPane.QUESTION_MESSAGE, null, a, null);
			if (Turn.isNullOrEmpty(answer)) {
				System.exit(0);
			}
			while(reponse.contains(answer)){
				answer = (String)JOptionPane.showInputDialog(null, "Choisissez une couleur !","Choix couleur",JOptionPane.QUESTION_MESSAGE,null,a,null);
				if (Turn.isNullOrEmpty(answer)) {
					System.exit(0);
				}
				
			}
			Joueurs.put("Joueur " + String.valueOf(i), answer);
			reponse.add(answer);
			
		}

		System.out.println(Joueurs);
	}
}
