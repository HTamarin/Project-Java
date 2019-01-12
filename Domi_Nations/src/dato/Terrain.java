import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Terrain extends JPanel {
	
	
	public static Case[][] terrain = new Case[9][9];

	
	
	public void initGame() {
		
	}
	
	public Terrain() {
		 this.setLayout(new GridLayout(9,9));
			for (int i = 0; i<9; i++) {
				for (int j=0; j<9; j++) {
					terrain[i][j]= new Case(i,j);
		 this.add(terrain[i][j]);
			}
			}
			terrain[4][4].addActionListener(new l());
			terrain[4][4].setEnabled(true);
}
	public static void placeDomino1(Case c) {//Une fois qu'un domino est placé
		
		if(terrain[c.getx()+1][c.gety()].isFree) {terrain[c.getx()+1][c.gety()].setEnabled(true);terrain[c.getx()+1][c.gety()].addActionListener(new clic2Case1());}
		if(terrain[c.getx()-1][c.gety()].isFree) {terrain[c.getx()-1][c.gety()].setEnabled(true);terrain[c.getx()-1][c.gety()].addActionListener(new clic2Case1());}
		if(terrain[c.getx()][c.gety()+1].isFree) {terrain[c.getx()][c.gety()+1].setEnabled(true);terrain[c.getx()][c.gety()+1].addActionListener(new clic2Case1());}
		if(terrain[c.getx()][c.gety()-1].isFree) {terrain[c.getx()][c.gety()-1].setEnabled(true);terrain[c.getx()][c.gety()-1].addActionListener(new clic2Case1());}

	}


	public static void debChateau() {
		terrain[3][4].setEnabled(true);
		terrain[5][4].setEnabled(true);
		terrain[4][3].setEnabled(true);
		terrain[4][5].setEnabled(true);
	}
	public static void allCase() {
		for (int i = 0; i<9; i++) {
			for (int j=0; j<9; j++) {
				terrain[i][j].setEnabled(false);
			}
			}
	}
	public static void paintCase1(Domino d,Case c) {
		c.setColor(d.domaine1);
		
	}
	public static void paintCase2(Domino d,Case c) {
		c.setColor(d.domaine2);
		
	}
	public static void caseDispo(Domino d) {
		for (int i = 0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (terrain[i][j].getColor()==d.domaine1 && terrain[i+1][j].isFree ==true )
				{terrain[i+1][j].setEnabled(true);terrain[i+1][j].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==d.domaine1 && terrain[i-1][j].isFree ==true )
				{terrain[i-1][j].setEnabled(true);terrain[i-1][j].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==d.domaine1 && terrain[i][j+1].isFree ==true )
				{terrain[i][j+1].setEnabled(true);terrain[i][j+1].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==d.domaine1 && terrain[i][j-1].isFree ==true )
				{terrain[i][j-1].setEnabled(true);terrain[i][j-1].addActionListener(new clicCase1());
				}
				
			if (terrain[i][j].getColor()==d.domaine2 && terrain[i+1][j].isFree ==true )
			{terrain[i+1][j].setEnabled(true);{terrain[i+1][j].addActionListener(new clicCase2());}
			
			if (terrain[i][j].getColor()==d.domaine2 && terrain[i-1][j].isFree ==true )
			{terrain[i-1][j].setEnabled(true);terrain[i-1][j].addActionListener(new clicCase2());}
			if (terrain[i][j].getColor()==d.domaine2 && terrain[i][j+1].isFree ==true )
			{terrain[i][j+1].setEnabled(true);terrain[i][j+1].addActionListener(new clicCase2());}
			if (terrain[i][j].getColor()==d.domaine2 && terrain[i][j-1].isFree ==true )
			{terrain[i][j-1].setEnabled(true);terrain[i][j-1].addActionListener(new clicCase2());}
			}
		}
		}
	}
	class clicCase1 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    ((Case) e.getSource()).setFree();
	    ((Case) e.getSource()).setEnabled(false);
	    
	    paintcase1(d,((Case) e.getSource()));
	    ((Case) e.getSource()).setForeground(null);
	    Terrain.placeDomino1((Case) e.getSource());
	    }
}
	class clicCase2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    ((Case) e.getSource()).setFree();
	    ((Case) e.getSource()).setEnabled(false);
	    
	   paintcase2(d,((Case) e.getSource()));
	    ((Case) e.getSource()).setForeground(null);
	    Terrain.placeDomino2((Case) e.getSource());
	    }
}
	class clic2Case1 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	((Case) e.getSource()).setFree();
	    	((Case) e.getSource()).setEnabled(false);
	    	paintcase1(d,((Case) e.getSource()));
	    	allCase();
	    }
	    }
	class clic2Case2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	((Case) e.getSource()).setFree();
	    	((Case) e.getSource()).setEnabled(false);
	    	paintcase2(d,((Case) e.getSource()));
	    	allCase();
	    }
	    }
	
	public class l implements ActionListener{
		public ImageIcon n = new ImageIcon("Chateau.png");
		
		    public void actionPerformed(ActionEvent e) {
		    	((Case) e.getSource()).setEnabled(false);
		    	((Case) e.getSource()).setIcon(n);
		    	((Case) e.getSource()).setFree();
		    }

			
			}
	
		
	}
	


