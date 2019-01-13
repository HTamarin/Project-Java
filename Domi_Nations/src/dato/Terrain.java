package dato;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Terrain extends JPanel {
	
	public static Case[][] terrain = new Case[9][9];
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
			System.out.println("Veuillez posez le château");
}
	public static void placeDomino1(Case c) {//Une fois qu'un domino est place
		
		if(terrain[c.getx()+1][c.gety()].isFree) {terrain[c.getx()+1][c.gety()].setEnabled(true);terrain[c.getx()+1][c.gety()].addActionListener(new clic2Case1());}
		if(terrain[c.getx()-1][c.gety()].isFree) {terrain[c.getx()-1][c.gety()].setEnabled(true);terrain[c.getx()-1][c.gety()].addActionListener(new clic2Case1());}
		if(terrain[c.getx()][c.gety()+1].isFree) {terrain[c.getx()][c.gety()+1].setEnabled(true);terrain[c.getx()][c.gety()+1].addActionListener(new clic2Case1());}
		if(terrain[c.getx()][c.gety()-1].isFree) {terrain[c.getx()][c.gety()-1].setEnabled(true);terrain[c.getx()][c.gety()-1].addActionListener(new clic2Case1());}

	}
public static void placeDomino2(Case c) {//Une fois qu'un domino est place
		
		if(terrain[c.getx()+1][c.gety()].isFree) {terrain[c.getx()+1][c.gety()].setEnabled(true);terrain[c.getx()+1][c.gety()].addActionListener(new clic2Case2());}
		if(terrain[c.getx()-1][c.gety()].isFree) {terrain[c.getx()-1][c.gety()].setEnabled(true);terrain[c.getx()-1][c.gety()].addActionListener(new clic2Case2());}
		if(terrain[c.getx()][c.gety()+1].isFree) {terrain[c.getx()][c.gety()+1].setEnabled(true);terrain[c.getx()][c.gety()+1].addActionListener(new clic2Case2());}
		if(terrain[c.getx()][c.gety()-1].isFree) {terrain[c.getx()][c.gety()-1].setEnabled(true);terrain[c.getx()][c.gety()-1].addActionListener(new clic2Case2());}

	}


	public static void debChateau() {
		terrain[3][4].setEnabled(true);
		terrain[5][4].setEnabled(true);
		terrain[4][3].setEnabled(true);
		terrain[4][5].setEnabled(true);
		terrain[3][4].addActionListener(new clicCase1());
		terrain[5][4].addActionListener(new clicCase1());
		terrain[4][3].addActionListener(new clicCase1());
		terrain[4][5].addActionListener(new clicCase1());
	}
	public static void allCase() {
		for (int i = 0; i<9; i++) {
			for (int j=0; j<9; j++) {
				terrain[i][j].setEnabled(false);
			}
			}
	}
	public static void paintCase1(String nom,Case c) {
		c.setColor(Domino.getDomaine1(nom));
		Case.paintCase(c);
		
	}
	public static void paintCase2(String nom,Case c) {
		c.setColor(Domino.getDomaine2(nom));
		Case.paintCase(c);
		
	}
	public static void caseDispo(String nom) {
		for (int i = 0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (terrain[i][j].getColor()==Domino.getDomaine1(nom) && terrain[i+1][j].isFree ==true )
				{terrain[i+1][j].setEnabled(true);terrain[i+1][j].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==Domino.getDomaine1(nom) && terrain[i-1][j].isFree ==true )
				{terrain[i-1][j].setEnabled(true);terrain[i-1][j].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==Domino.getDomaine1(nom) && terrain[i][j+1].isFree ==true )
				{terrain[i][j+1].setEnabled(true);terrain[i][j+1].addActionListener(new clicCase1());
				}
				if (terrain[i][j].getColor()==Domino.getDomaine1(nom) && terrain[i][j-1].isFree ==true )
				{terrain[i][j-1].setEnabled(true);terrain[i][j-1].addActionListener(new clicCase1());
				}
				
			if (terrain[i][j].getColor()==Domino.getDomaine2(nom) && terrain[i+1][j].isFree ==true )
			{terrain[i+1][j].setEnabled(true);{terrain[i+1][j].addActionListener(new clicCase2());}
			
			if (terrain[i][j].getColor()==Domino.getDomaine2(nom) && terrain[i-1][j].isFree ==true )
			{terrain[i-1][j].setEnabled(true);terrain[i-1][j].addActionListener(new clicCase2());}
			if (terrain[i][j].getColor()==Domino.getDomaine2(nom) && terrain[i][j+1].isFree ==true )
			{terrain[i][j+1].setEnabled(true);terrain[i][j+1].addActionListener(new clicCase2());}
			if (terrain[i][j].getColor()==Domino.getDomaine2(nom) && terrain[i][j-1].isFree ==true )
			{terrain[i][j-1].setEnabled(true);terrain[i][j-1].addActionListener(new clicCase2());}
			}
		}
		}
	}
	public static void limiteTerrain() {
		for (int i = 0; i<9; i++) {
			int compteur =0;
		if(terrain[1][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[1][i].setFree();}	
		compteur =0;
		if(terrain[2][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[2][i].setFree();}	
		compteur =0;
		if(terrain[3][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[3][i].setFree();}	
		compteur =0;
		if(terrain[4][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[4][i].setFree();}	
		compteur =0;
		if(terrain[5][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[5][i].setFree();}	
		compteur =0;
		if(terrain[6][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[6][i].setFree();}	
		compteur =0;
		if(terrain[7][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[7][i].setFree();}	
		compteur =0;
		if(terrain[8][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[8][i].setFree();}	
		compteur =0;
		if(terrain[9][i].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[9][i].setFree();}	
		compteur =0;
		if(terrain[i][1].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][1].setFree();}	
		compteur =0;
		if(terrain[i][2].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][2].setFree();}	
		compteur =0;
		if(terrain[i][3].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][3].setFree();}	
		compteur =0;
		if(terrain[i][4].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][4].setFree();}	
		compteur =0;
		if(terrain[i][5].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][5].setFree();}	
		compteur =0;
		if(terrain[i][6].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][6].setFree();}	
		compteur =0;
		if(terrain[i][7].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][7].setFree();}	
		compteur =0;
		if(terrain[i][8].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][8].setFree();}	
		compteur =0;
		if(terrain[i][9].getFree()) {compteur+=1;}
		if (compteur==5) {terrain[i][9].setFree();}	
		
		
		
	}
	}
	static class clicCase1 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    ((Case) e.getSource()).setFree();
	    Terrain.limiteTerrain();
	    ((Case) e.getSource()).setEnabled(false);
	    
	    Terrain.paintCase1(Turn.dominoselectionne,((Case) e.getSource()));
	    Terrain.placeDomino1((Case) e.getSource());
	    }
}
	static class clicCase2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    ((Case) e.getSource()).setFree();
	    Terrain.limiteTerrain();
	    ((Case) e.getSource()).setEnabled(false);
	    
	   Terrain.paintCase2(Turn.dominoselectionne,((Case) e.getSource()));
	    Terrain.placeDomino2((Case) e.getSource());
	    }
}
	static class clic2Case1 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	((Case) e.getSource()).setFree();
	    	Terrain.limiteTerrain();
	    	((Case) e.getSource()).setEnabled(false);
	    	Terrain.paintCase1(Turn.dominoselectionne,((Case) e.getSource()));
	    	Terrain.allCase();
	    }
	    }
	static class clic2Case2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	((Case) e.getSource()).setFree();
	    	Terrain.limiteTerrain();
	    	((Case) e.getSource()).setEnabled(false);
	    	Terrain.paintCase2(Turn.dominoselectionne,((Case) e.getSource()));
	    	Terrain.allCase();
	    }
	    }
	
	public class l implements ActionListener{
		public ImageIcon n = new ImageIcon("Chateau.png");
		
		    public void actionPerformed(ActionEvent e) {
		    	((Case) e.getSource()).setEnabled(false);
		    	((Case) e.getSource()).setIcon(n);
		    	((Case) e.getSource()).setFree();
		    	Terrain.debChateau();
		    }

			
			}
	
		
	}
	


