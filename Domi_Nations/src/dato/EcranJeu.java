package dato;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranJeu extends JFrame {
	
	 private JPanel container = new JPanel();
	 public static Terrain t = new Terrain();
	 public static AfficheRegle a = new AfficheRegle();
	 public static Paneau p = new Paneau();
	 public static DominoContainer d = new DominoContainer(Turn.tour);
	 
	
	public EcranJeu() {
		this.setTitle("DOMINATION");
	    this.setSize(1800, 1094);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setLayout(new GridLayout(2, 2));
	    container.add(a);
	    container.add(t);
	    container.add(p);
	    container.add(d);
	    this.setContentPane(container);

	    

	}
public static void refreshTour(EcranJeu e) {
	e.remove(a);
	a=new AfficheRegle();
	e.add(a);
	e.repaint();
	
	
}
public static void refreshManche(EcranJeu e) {
	e.remove(d);
	d=new DominoContainer(Turn.tour);
	e.add(d);
	e.repaint();
}
	public static void lancerLeJeu() {
			EcranJeu screenGame = new EcranJeu();
		    screenGame.setVisible(true);    

		
	}

}

