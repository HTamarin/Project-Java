import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DominoGraoh extends JPanel {
	
	public static BufferedImage doColor1;
	public static BufferedImage doColor2;
	
	switch (domino.color1) { // Definis la couleur de la première moitié
	
	case champs : try { doColor1 = ImageIO.read(new File("champs.png"));
		  }
	  catch(Exception e) {}
	case foret : try { doColor1 = ImageIO.read(new File("foret.png"));
	  }
	  catch(Exception e) {}
	case mer : try { doColor1 = ImageIO.read(new File("mer.png"));
	  }
	  catch(Exception e) {}
	case prairie : try { doColor1 = ImageIO.read(new File("prairie.png"));
	  }
	  catch(Exception e) {}
	case mine : try { doColor1 = ImageIO.read(new File("mine.png"));
	  }
	  catch(Exception e) {}
	case montagne : try { doColor1 = ImageIO.read(new File("montagne.png"));
	  }
	  catch(Exception e) {}
}
	
	switch (domino.color2) { // Couleur de la deuxième moitié
	
	case champs : try { doColor2 = ImageIO.read(new File("champs.png"));
		  }
	  catch(Exception e) {}
	case foret : try { doColor2 = ImageIO.read(new File("foret.png"));
	  }
	  catch(Exception e) {}
	case mer : try { doColor2 = ImageIO.read(new File("mer.png"));
	  }
	  catch(Exception e) {}
	case prairie : try { doColor2 = ImageIO.read(new File("prairie.png"));
	  }
	  catch(Exception e) {}
	case mine : try { doColor2 = ImageIO.read(new File("mine.png"));
	  }
	  catch(Exception e) {}
	case montagne : try { doColor2 = ImageIO.read(new File("montagne.png"));
	  }
	  catch(Exception e) {}
}
	
	
	
	 public void paintComponent(Graphics g){ // Dessine le domino
		 g.drawRect(9, 9, 326, 101);
		 try {
			  g.drawImage(doColor1,10,10,325/2,100, null);
			  g.drawImage(doColor2,325/2+10,10,325/2,100, null);
			  }
		  catch(Exception e) {}
	 }

}
