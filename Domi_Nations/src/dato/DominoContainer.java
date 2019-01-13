package dato;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class DominoContainer extends JPanel {
	

	public static DominoGraoh[] dominoTour(int n) {
		n= Turn.tour;
		ArrayList<String> dominoAffiche =Turn.listTour.get((Turn.tour)-1);
		DominoGraoh a = new DominoGraoh(dominoAffiche.get(0));
		DominoGraoh b = new DominoGraoh(dominoAffiche.get(1));
		DominoGraoh c = new DominoGraoh(dominoAffiche.get(2));
		DominoGraoh d = new DominoGraoh(dominoAffiche.get(3));
		DominoGraoh[] x = {a,b,c,d};
		return x;
	}
	public static DominoGraoh[] dominoSelectionTour(int n) {
		n= Turn.tour;
		ArrayList<String> dominoSelectionAffiche = Turn.listTour.get((Turn.tour));
		DominoGraoh e = new DominoGraoh(dominoSelectionAffiche.get(0));
		DominoGraoh f = new DominoGraoh(dominoSelectionAffiche.get(1));
		DominoGraoh g = new DominoGraoh(dominoSelectionAffiche.get(2));
		DominoGraoh h = new DominoGraoh(dominoSelectionAffiche.get(3));
		DominoGraoh[] z = {e,f,g,h};
		return z;
	}
	
	public DominoContainer(int n) {
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setRows(4);
		gl.setHgap(1);
		gl.setVgap(1);;
	this.setLayout(gl);
	for (int i=0;i<4;i++) {
		this.add(dominoTour(n)[i]);
		this.add(dominoSelectionTour(n)[i]);
		
	}
	
	}

	
	

}

