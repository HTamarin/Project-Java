
import java.util.*;
import javax.swing.*;

public class Player{

	/**
	 * Cette fonction permet de decider le nombre de joueurs
	 * 
	 * @return
	 */
	public void main(String[] args) {
		setPlayerCount();
	}

	static int setPlayerCount() {
		String[] answers = { "2", "3", "4" };

		ArrayList<String> Answer = new ArrayList<>();
		for (int j = 0; j < answers.length; j++) {
			Answer.add(answers[j]);
		}

		String answer = (String) JOptionPane.showInputDialog(null, "Nombre de joueurs ?", "Choix",
				JOptionPane.QUESTION_MESSAGE, null, answers, null);

		int NombreJoueurs = Integer.parseInt(answer);
		System.out.println("Il y a " + NombreJoueurs + " joueurs");
		return NombreJoueurs;
	}

	public static void coloR() {
		String[] answers = { "Rouge", "Rose", "Orange", "Violet" };
		ArrayList<String> Answer = new ArrayList<>();
		String[] a = answers;

		for (int j = 0; j < answers.length; j++) {
			Answer.add(answers[j]);
		}

		int s = Player.setPlayerCount();
		Map<String, String> Joueurs = new TreeMap<String, String>();

		for (int i = 1; i <= s; i++) {
			String answer = (String) JOptionPane.showInputDialog(null, "Choisissez une couleur !", "Choix couleur",
					JOptionPane.QUESTION_MESSAGE, null, a, null);
			Joueurs.put("Joueur " + String.valueOf(i), answer);

			for (int j = 0; j < answer.length(); j++) {
				int u = 0;
				Answer.remove(answer);
				System.out.println(Answer);
			}
		}

		System.out.println(Joueurs);
	}
}