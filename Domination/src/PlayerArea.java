package domination;

import java.io.*;


public class PlayerArea {
	public static void ini() {
		
	}
	public static void PlateauJeu(String[] args) {
		try{
			File file = new File ("src/dominos.csv");
			
			BufferedReader buff = new BufferedReader( new FileReader(file));
			
			String barre = ",";
			
			String ligne;
			
			while ((ligne = (buff).readLine()) != null) {
				
				
				Object domino = ligne.split(barre);
				System.out.println(domino);
				
				
			}
		}
		catch(Exception e){
			
		}
	}
}
