import java.awt.GridLayout;

import javax.swing.JPanel;

public class Terrain extends JPanel {
	public static Case[][] terrain = new Case[9][9];

	
	
	public void initGame(int NombreJoueurs) {
		
	}
	
	public Terrain() {
		 this.setLayout(new GridLayout(9,9));
			for (int i = 0; i<9; i++) {
				for (int j=0; j<9; j++) {
					terrain[i][j]= new Case();
		 this.add(terrain[i][j]);
			}
			}
	
}
}
