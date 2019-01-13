package dato;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class DominoContainer extends JPanel {
	
	public static ArrayList<String> rangeTour(int n) {
		ArrayList<String> resultlist=new ArrayList<String>();
	switch (n) {
	case 1 :  resultlist=Turn.listTour.subList(0,4); break;
	case 2 : resultlist= Turn.listTour.subList(4,8); break;
	case 3 :  resultlist=Turn.listTour.subList(8,12); break;
	case 4 :  resultlist=Turn.listTour.subList(12,16); break;
	case 5 :  resultlist=Turn.listTour.subList(16,20); break;
	case 6 :  resultlist=Turn.listTour.subList(20,24); break;
	case 7 :  resultlist=Turn.listTour.subList(24,28); break;
	case 8 :  resultlist=Turn.listTour.subList(28,32); break;
	case 9 :  resultlist=Turn.listTour.subList(32,36); break;
	case 10 : resultlist= Turn.listTour.subList(36,40); break;
	case 11:  resultlist=Turn.listTour.subList(40,44); break;
	case 12:  resultlist=Turn.listTour.subList(44,48); break;
	case 13: resultlist= Turn.listTour.subList(48,52); break;

	}
	return  resultlist;
	}
	public static DominoGraoh[] dominoTour(int n) {
		n= Turn.tour;
		ArrayList<String> dominoAffiche = rangeTour(n);
		DominoGraoh a = new DominoGraoh(dominoAffiche.get(0));
		DominoGraoh b = new DominoGraoh(dominoAffiche.get(1));
		DominoGraoh c = new DominoGraoh(dominoAffiche.get(2));
		DominoGraoh d = new DominoGraoh(dominoAffiche.get(3));
		DominoGraoh[] x = {a,b,c,d};
		return x;
	}
	public static DominoGraoh[] dominoSelectionTour(int n) {
		n= Turn.tour;
		ArrayList<String> dominoSelectionAffiche = rangeTour(n+1);
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

