import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DominoGraoh extends JPanel {
	public static BufferedImage doColor1;
	public static BufferedImage doColor2;
	
	public DominoGraoh(Domino d) {
		switch (d.domaine1) { // Definis la couleur de la première moitié
		
		case champs : try { doColor1 = ImageIO.read(new File("champs.png"));
			  }
		  catch(Exception e) {}break;
		case foret : try { doColor1 = ImageIO.read(new File("foret.png"));
		  }
		  catch(Exception e) {}break;
		case mer : try { doColor1 = ImageIO.read(new File("mer.png"));
		  }
		  catch(Exception e) {}break;
		case prairie : try { doColor1 = ImageIO.read(new File("prairie.png"));
		  }
		  catch(Exception e) {}break;
		case mine : try { doColor1 = ImageIO.read(new File("mine.png"));
		  }
		  catch(Exception e) {}break;
		case montagne : try { doColor1 = ImageIO.read(new File("montagne.png"));
		  }
		  catch(Exception e) {}break;
	}
		
		switch (d.domaine2) { // Couleur de la deuxième moitié
		
		case champs : try { doColor2 = ImageIO.read(new File("champs.png"));
			  }
		  catch(Exception e) {}break;
		case foret : try { doColor2 = ImageIO.read(new File("foret.png"));
		  }
		  catch(Exception e) {}break;
		case mer : try { doColor2 = ImageIO.read(new File("mer.png"));
		  }
		  catch(Exception e) {}break;
		case prairie : try { doColor2 = ImageIO.read(new File("prairie.png"));
		  }
		  catch(Exception e) {}break;
		case mine : try { doColor2 = ImageIO.read(new File("mine.png"));
		  }
		  catch(Exception e) {}break;
		case montagne : try { doColor2 = ImageIO.read(new File("montagne.png"));
		  }
		  catch(Exception e) {}break;
	}
	}
	
	public void paintComponent(Graphics g, Domino d){ // Dessine le domino
		 g.drawRect(9, 9, 326, 101);
		 try {
			  g.drawImage(doColor1,10,10,325/2,100, null);
			  g.drawImage(doColor2,325/2+10,10,325/2,100, null);
			  }
		  catch(Exception e) {}
		 g.setColor(Color.BLACK);
		 Font f = new Font("Dialog", Font.BOLD, 24);
		 g.setFont(f);
		 g.drawString(d.couronne, 275, 40);
		 g.drawString(d.couronne, 40, 40);


		 



}
	
}
