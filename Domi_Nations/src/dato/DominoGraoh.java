package dato;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DominoGraoh extends JPanel {
	public static BufferedImage doColor1;
	public static BufferedImage doColor2;
	private String numero;
	
	public DominoGraoh(String nom) {
		this.numero=nom;
		switch (Domino.getDomaine1(nom)) { // Definis la couleur de la premiere moitie
		
		case "champs" : try { doColor1 = ImageIO.read(new File("champs.png"));
			  }
		  catch(Exception e) {}break;
		case "foret" : try { doColor1 = ImageIO.read(new File("foret.png"));
		  }
		  catch(Exception e) {}break;
		case "mer" : try { doColor1 = ImageIO.read(new File("mer.png"));
		  }
		  catch(Exception e) {}break;
		case "prairie" : try { doColor1 = ImageIO.read(new File("prairie.png"));
		  }
		  catch(Exception e) {}break;
		case "mine" : try { doColor1 = ImageIO.read(new File("mine.png"));
		  }
		  catch(Exception e) {}break;
		case "montagne" : try { doColor1 = ImageIO.read(new File("montagne.png"));
		  }
		  catch(Exception e) {}break;
	}
		
		switch (Domino.getDomaine2(nom)) { // Couleur de la deuxieme moitie
		
		case "champs" : try { doColor2 = ImageIO.read(new File("champs.png"));
			  }
		  catch(Exception e) {}break;
		case "foret" : try { doColor2 = ImageIO.read(new File("foret.png"));
		  }
		  catch(Exception e) {}break;
		case "mer" : try { doColor2 = ImageIO.read(new File("mer.png"));
		  }
		  catch(Exception e) {}break;
		case "prairie" : try { doColor2 = ImageIO.read(new File("prairie.png"));
		  }
		  catch(Exception e) {}break;
		case "mine" : try { doColor2 = ImageIO.read(new File("mine.png"));
		  }
		  catch(Exception e) {}break;
		case "montagne" : try { doColor2 = ImageIO.read(new File("montagne.png"));
		  }
		  catch(Exception e) {}break;
	}
	}
	
	public void paintComponent(Graphics g){ // Dessine le domino
		 g.drawRect(9, 9, 326, 101);
		 try {
			  g.drawImage(doColor1,10,10,325/2,100, null);
			  g.drawImage(doColor2,325/2+10,10,325/2,100, null);
			  }
		  catch(Exception e) {}
		 g.setColor(Color.BLACK);
		 Font f = new Font("Dialog", Font.BOLD, 24);
		 g.setFont(f);
		 g.drawString(Domino.getCouronne1(numero), 275, 40);
		 g.drawString(Domino.getCouronne2(numero), 40, 40);


		 



}
	
}
