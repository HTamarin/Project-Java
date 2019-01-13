import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DominoContainer extends JPanel {
	private ButtonGroup bg = new ButtonGroup();

	
	DominoGraoh a = new DominoGraoh();
	DominoGraoh b = new DominoGraoh();
	DominoGraoh c = new DominoGraoh();
	DominoGraoh d = new DominoGraoh();
	DominoGraoh e = new DominoGraoh();
	DominoGraoh f = new DominoGraoh();
	DominoGraoh g = new DominoGraoh();
	DominoGraoh h = new DominoGraoh();
	
	public DominoContainer() {
		
		
		   JRadioButton ba = new JRadioButton();
		   JRadioButton bb = new JRadioButton(); 
		   JRadioButton bc = new JRadioButton();
		   JRadioButton bd = new JRadioButton();
		    ba.addActionListener(new StateListener());
		    bb.addActionListener(new StateListener());
		    bc.addActionListener(new StateListener());
		    bd.addActionListener(new StateListener());
		    //On ajoute les boutons au groupe
		    bg.add(ba);
		    bg.add(bb);
		    bg.add(bc);
		    bg.add(bd);
		
		
		
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
		this.add(e,ba);
		this.add(f,bb);
		this.add(g,bc);
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
	this.add(e);
	this.add(f);
	this.add(g);
	this.add(h);
	}

	}
	 class StateListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
}
}

