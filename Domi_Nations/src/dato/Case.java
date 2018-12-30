import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Case extends JButton implements MouseListener{ 
	
	public static boolean isFree = true;
	public static String color = new String();
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color1) {
		color = color1;
				}
		
	public boolean getFree() {
		return isFree;
	}
	public void setFree() {
	   isFree = false;
	}

	 public Case(){
		this.addMouseListener(this);
		Dimension d = new Dimension();
		d.setSize(30,30);
		this.setPreferredSize(d);
	 }

	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.setFree();
		this.setColor("domino.color");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
