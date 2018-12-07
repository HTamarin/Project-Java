package data;

import java.util.*;
import javax.swing.*;


public class Player {
	static Scanner scanner = new Scanner(System.in);


	/**
	 * Cette fonction permet de decider le nombre de joueurs
	 * 
	 * @return
	 */

	public static int setPlayerCount(int h) {

		int NombreJoueurs = 0;
		int g = 0;
		while (NombreJoueurs < 2 || NombreJoueurs > 4) {
			try {
				System.out.println("Combien de joueurs?");
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
	
	public static void coloR() {
		String[] answers = {"Rouge","Rose","Orange","Violet"};
		ArrayList<String> Answer = new ArrayList<>();
		String [] a = answers;
		
		for(int j=0; j<answers.length; j++) {
			Answer.add(answers[j]);
		}
		
		int s = Player.setPlayerCount(0);
		Map<String, String> Joueurs = new TreeMap<String,String>();
		
		for (int i=1; i<=s; i++) {
			String answer = (String)JOptionPane.showInputDialog(null, "Choisissez une couleur !","Choix couleur",JOptionPane.QUESTION_MESSAGE,null,a,null);
			Joueurs.put("Joueur "+String.valueOf(i), answer);

			
			for(int j=0; j<answer.length();j++) {
				int u=0;
				Answer.remove(answer);
				System.out.println(Answer);
				}
			}
		   
		System.out.println(Joueurs);
		}
	}
