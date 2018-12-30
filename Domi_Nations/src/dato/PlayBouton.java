import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class PlayBouton extends JButton implements MouseListener{
	
	
	 private String name;
	 private Image img;
		
		  public PlayBouton(String str){
			    super(str);
			    this.name = str;

		    this.addMouseListener(this);
		  
		  
		  try {
		      img = ImageIO.read(new File("yellow-rectangle-button-hi.png"));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
		  



		public void paintComponent(Graphics g){
		    Graphics2D g2d = (Graphics2D)g;
		    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    g2d.setColor(Color.black);
		    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 /4), (this.getHeight() / 2) + 5);
		  }

		  
		@Override
		public void mouseClicked(MouseEvent arg0) {
			EcranJeu.lancerLeJeu();
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			 try {
			     img = ImageIO.read(new File("images.jpg"));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			try {
			     img = ImageIO.read(new File("yellow-rectangle-button-hi.png"));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}
