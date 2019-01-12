import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficheRegle extends JPanel {

	
	public AfficheRegle() {
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(2);
		gl.setHgap(1);
		gl.setVgap(1);;
	this.setLayout(gl);
		JLabel m = new JLabel("Manche "+ 1);
		Font d = new Font("Dialog", Font.ITALIC, 75);
	    m.setHorizontalAlignment(JLabel.CENTER);
	    m.setFont(d);
		JLabel t = new JLabel("Au tour du joueur "+1);
		t.setHorizontalAlignment(JLabel.CENTER);
		t.setFont(d);
		this.add(m);
		this.add(t);
	}

}

