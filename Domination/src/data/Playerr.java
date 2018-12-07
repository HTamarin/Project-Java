package domination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Playerr {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		coloR();
	}
	public static int setPlayerCount(int h) {

		int NombreJoueurs = 0;
		int g = 0;
		while (NombreJoueurs < 2 || NombreJoueurs > 4) {
			try {
				System.out.println("Combien de joueurs?");
				NombreJoueurs = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Nombre de joueurs invalide");
			}
		}
		return NombreJoueurs;
	}

	public static void coloR() {
		String[] tabCouleurs = {"Rouge","Rose","Orange","Violet"};
		String [] a = tabCouleurs;
		ArrayList<String> reponse = new ArrayList<String>();

		int s = Player.setPlayerCount(0);
		Map<String, String> Joueurs = new TreeMap<String,String>();

		for (int i=1; i<=s; i++) {

			
			String answer = (String)JOptionPane.showInputDialog(null, "Choisissez une couleur !","Choix couleur",JOptionPane.QUESTION_MESSAGE,null,a,null);
			
			while(reponse.contains(answer)){
			answer = (String)JOptionPane.showInputDialog(null, "Choisissez une couleur !","Choix couleur",JOptionPane.QUESTION_MESSAGE,null,a,null);

			
		}
			Joueurs.put("Joueur "+String.valueOf(i), answer);
			reponse.add(answer);
		//	else {
				//answer = (String)JOptionPane.showInputDialog(null, "Choisissez une autre couleur !","Choix couleur",JOptionPane.QUESTION_MESSAGE,null,a,null);
				//Joueurs.put("Joueur "+String.valueOf(i), answer);
			//}

		System.out.println(Joueurs);
		}
	}
}
