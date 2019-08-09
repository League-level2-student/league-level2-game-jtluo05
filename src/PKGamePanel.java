import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//https://stackoverflow.com/questions/4787066/how-to-resize-and-rotate-an-image
public class PKGamePanel extends JPanel implements ActionListener, MouseListener {

	boolean isMoving = false;
	final int GAME_STATE = 1;
	int currentState = GAME_STATE;
	static boolean isKicked = false;
	Timer gameTimer = new Timer(1000 / 60, this);
	Timer playerTimer = new Timer(1000, this);
	Font titleFont = new Font("Arial", Font.PLAIN, 43);
	BufferedImage goal;
	
	int timeLeft = 8;
	static boolean play = false;
	Ball ball = new Ball();

	Leg leg = new Leg(0, 475, 140, 265);
	Keeper keeper = new Keeper(288, 307, (int) (1.65 * 125), (int) (1.15 * 200));
	

	PKGamePanel() {
		setPreferredSize(new Dimension(PKRunner.WIDTH, 765));
		try {

			goal = ImageIO.read(this.getClass().getResourceAsStream("goal.jpg"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			JOptionPane.showMessageDialog(null, "Can't find goal.jpg");

		}

		gameTimer.start();
		playerTimer.restart();
		if (ball.y < 50) {
			ball.stop = true;
		}
		keeper.randomDirection();
	}

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == GAME_STATE) {

			drawGameState(g);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("Time Left:" + timeLeft, 500, 75);
		if (keeper.timeup) {
				g.setColor(Color.RED);
			g.drawString("Times Up! You have taken too", 20,125);
			g.drawString("much time and skip your shooting turn", 20, 175);
		}
				}

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

	}

	void drawGameState(Graphics g) {
		g.drawImage(goal, 0, 0, 800, 800, null);

		keeper.draw(g);
		ball.draw(g);
		leg.draw(g);

	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!ball.isMoving) {

			isKicked = true;

			JButton button;

			button = (JButton) e.getSource();

			ball.direction += button.getText();

			PKButtonPanel.b1.setText("high");
			PKButtonPanel.b2.setText("low");
			PKButtonPanel.b3.setVisible(false);
			repaint();

		//	System.out.println(ballDirection);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == playerTimer) {
			timeLeft--;
			if (timeLeft == -1) {
				timeLeft++;
				keeper.timeup=true;
				
				timeLeft = 8;
				playerTimer.stop();
			}
		} else if (isKicked) {
			play=true;
		
			timeLeft = 8;
			playerTimer.stop();
	
			
				ball.update();
				repaint();
				
			

		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
