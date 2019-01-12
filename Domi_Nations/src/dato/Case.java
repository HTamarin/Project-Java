import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Case extends JButton { 
	
	public  boolean isFree = true;
	public  String color = new String();
	private int x;
	private int y;
	
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
	public int getx() {
		return x;
	}
	public void setx(int xx) {
	   x = xx;
	}
	public int gety() {
		return y;
	}
	public void sety(int yy) {
	   y = yy;
	}
	

	 public Case(int x,int y){
		 this.x=x;
		 this.y=y;
		Dimension d = new Dimension();
		d.setSize(30,30);
		this.setPreferredSize(d);
		this.setEnabled(false);
	 }
	
	 
	    
	    
	    	
	    
	 
}

