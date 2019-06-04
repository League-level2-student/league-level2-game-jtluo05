import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PKGamePanel extends JPanel {

	Graphics g;
	final int GAME_STATE = 1;
	int currentState =GAME_STATE;
	
BufferedImage goal;
PKGamePanel(){
	setPreferredSize(new Dimension(PKRunner.WIDTH, 765));
		 try {

             goal = ImageIO.read(this.getClass().getResourceAsStream("goal.jpg"));

       

     } catch (IOException e) {

             // TODO Auto-generated catch block

           JOptionPane.showMessageDialog(null, "Can't find goal.jpg");

     }
		
		
	}
@Override

public void paintComponent(Graphics g) {
	g.fillRect(10, 10, 100, 100);
 if (currentState == GAME_STATE) {

		drawGameState(g);

	}

}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

	
	}

	void drawGameState(Graphics g) {
	g.drawImage(goal, 0, 0, 800,800,null);
g.setColor(Color.BLACK);
	g.fillRect(75, 595, 70, 200);
	g.setColor(Color.BLUE);
	g.fillRect(350, 314, 125, 200);
g.setColor(Color.GREEN);
g.fillOval(275, 635, 60, 60);

	}

	void drawEndState(Graphics g) {
		
	}

}
