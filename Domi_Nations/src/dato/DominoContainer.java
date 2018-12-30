import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DominoContainer extends JPanel {
	
	Dominos a = new Dominos();
	Dominos b = new Dominos();
	Dominos c = new Dominos();
	Dominos d = new Dominos();
	
	public DominoContainer() {
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		
		if (nombreJoueur == 3) { //3 joueurs -> 2 rangées de 3 dominos
			gl.setRows(3);
			gl.setHgap(1);
			gl.setVgap(1);;
		this.setLayout(gl);
		this.add(a);
		this.add(b);
		this.add(c);
		}
		else { // 2 ou 4 joueurs -> 2 rangées de 4 dominos
		gl.setRows(4);
		gl.setHgap(1);
		gl.setVgap(1);;
	this.setLayout(gl);
	this.add(a);
	this.add(b);
	this.add(c);
	this.add(d);
	}

	}
}

