package dato;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Domino {


	public static Map<String, ArrayList<String>> domino() {
		
		Map<String, ArrayList<String>> mapdomino = new TreeMap<String, ArrayList<String>>();
		try {
			File fichier = new File("src/ressources/dominos.csv"); // On charge le fichier des dominos

			BufferedReader buff = new BufferedReader(new FileReader(fichier));

			String separation = ","; // On indique que le separateur entre deux arguments est une virgule

			String ligne;
			ligne = (buff).readLine();

			int i = 1;
			while ((ligne = (buff).readLine()) != null) {
				ArrayList<String> dominoString = new ArrayList<String>();
				String[] domino = ligne.split(separation); // On fait une table "domino" qui prend en arguments les
															// valeurs des lignes du csv

				for (int j = 0; j < 5; j++) {
					dominoString.add(String.valueOf(domino[j])); // On converti chaque argument en String
				}
				String s = String.valueOf(i);
				mapdomino.put(s, dominoString); // On met chaque argument dans une bibliothèque
												// (String,ArrayList<String>)
				i++;

			}

		} catch (Exception e) {

		}
		return (mapdomino);
	}

	public static Map<String, ArrayList<String>> splitDomino() {
		
		Map<String, ArrayList<String>> FullDomino = Domino.domino();
		Map<String, ArrayList<String>> SplitDomino = new TreeMap<String, ArrayList<String>>();
		Set<String> keys = FullDomino.keySet();
		ArrayList<String> cles = new ArrayList<String>(keys);
		System.out.println(cles);
		for (int i = 0; i < cles.size(); i++) {
			String s = String.valueOf(cles.get(i));
			ArrayList<String> list = FullDomino.get(s);
			ArrayList<String> PartieDominoG = new ArrayList<String>();
			ArrayList<String> PartieDominoD = new ArrayList<String>();
			PartieDominoG.add(list.get(0));// On recupère les deux premiers argument de chaque ligne
			PartieDominoG.add(list.get(1));
			String g = s + "g"; // g correspond à partie droite ( 2 premiers arguments)
			SplitDomino.put(g, PartieDominoG); // On insère chaque partie dans un bibliotheque 2 fois plus grande que
												// "domino"
			PartieDominoD.add(list.get(2));
			PartieDominoD.add(list.get(3));
			String d = s + "d"; // d correspond à partie gauche ( 2 derniers arguments)
			SplitDomino.put(d, PartieDominoD);

		}
		return SplitDomino;

	}
	public static String domaine(String a) {
		Map<String, ArrayList<String>> mapDominos = splitDomino();
		ArrayList<String> domino= mapDominos.get(a);
		String domaine = domino.get(1);
		return domaine;
		
	}
	public static String couronne(String a) {
		Map<String, ArrayList<String>> mapDominos = splitDomino();
		ArrayList<String> domino= mapDominos.get(a);

		String couronne = domino.get(0);
		return couronne;
		
	}

}
