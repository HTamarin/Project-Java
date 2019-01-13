import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Launcher extends JFrame{
		  private Paneau pan = new Paneau();
		  private PlayBouton bouton = new PlayBouton("Jouer");
		  bouton.addActionListener(new PlayListener());
		  private JPanel container = new JPanel();
		  
		  public Launcher(){                
				    this.setTitle("DOMINATION");
				    this.setSize(854, 481);
				    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    this.setLocationRelativeTo(null);
				    container.setLayout(new BorderLayout());				    
				    container.add(pan, BorderLayout.CENTER);
				    container.add(bouton, BorderLayout.SOUTH);
				    this.setContentPane(container);
				    this.setVisible(true);    
			    
}
		  
		  class PlayListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				EcranJeu.lancerLeJeu();
			}
		  }
		 
}
