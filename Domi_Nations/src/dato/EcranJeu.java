import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranJeu extends JFrame {
	
	 private JPanel container = new JPanel();
	 public Terrain t = new Terrain();
	 public DominoContainer d = new DominoContainer();
	 
	
	public EcranJeu() {
		this.setTitle("DOMINATION");
	    this.setSize(1800, 1094);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setLayout(new GridLayout(2, 2));
	    container.add(t);
	    container.add(d);
	    this.setContentPane(container);

	    

	}

	public static void lancerLeJeu() {
			EcranJeu screenGame = new EcranJeu();
		    screenGame.setVisible(true);    

		
	}

}
