import java.applet.AudioClip;
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
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//add sound for miss
//make shots not infinite
//other

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
	BufferedImage black;
	int keeperDive = 0;
	int timeLeft = 8;
	static boolean play = false;
	Ball ball ;
	boolean randomcalled = false;
	boolean saveChecked=false;
	Leg leg = new Leg(0, 475, 140, 265);
	Keeper keeper ;
int totalSaves=0;
int totalGoals=0;
AudioClip sound;

	PKGamePanel() {
		setPreferredSize(new Dimension(PKRunner.WIDTH, 765));
		try {

			goal = ImageIO.read(this.getClass().getResourceAsStream("goal.jpg"));
			black = ImageIO.read(this.getClass().getResourceAsStream("black.jpg"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			JOptionPane.showMessageDialog(null, "Can't find goal.jpg");

		}

		
		newPlay();
		gameTimer.start();

		

	}

	static void setPlay(boolean go) {
		play = go;

	}

	@Override

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == GAME_STATE) {

			drawGameState(g);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("Time Left:" + timeLeft, 500, 75);
			
			g.setColor(Color.red);
			g.drawString("Total saves: "+ totalSaves, 20, 50);
			g.drawString("Total goals: "+ totalGoals, 20, 100);
			if (keeper.timeup) {

				g.setColor(Color.black);
				g.drawRect(0, 0, 900, 900);
				g.drawImage(black, 0, 0, 800, 800, null);
				g.setColor(Color.RED);
				g.drawString("Times Up! You have taken too", 20, 125);
				g.drawString("much time and skip your shooting turn", 20, 175);
				g.drawString("GAME OVER!", 20, 225);
				g.drawString("You have lost the game for your team. :(", 20, 275);
			}
			else if (totalSaves==3) {
				gameTimer.stop();
				g.setColor(Color.black);
				g.fillRect(0, 0, 900, 900);
				g.setColor(Color.RED);
				g.drawString("The goalie has won.", 20, 125);
				g.drawString("GAME OVER!:(", 20, 175);
				playerTimer.stop();
			}
			else if (totalGoals==10) {
				gameTimer.stop();
				g.setColor(Color.green);
				g.fillRect(0, 0, 900, 900);
				g.drawImage(black, 0, 0, 800, 800, null);
				g.setColor(Color.black);
				g.drawString("YOU WON!", 20, 125);
				g.drawString("Good job. :)", 20, 175);
				playerTimer.stop();
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

	void checkSave() {
		
		if ((Ball.direction.equals("lefthigh") || Ball.direction.equals("leftlow")) 
				&& keeper.direction == 0) {
			playSound("booing.mp3");playSound("booing.mp3");playSound("booing.mp3");
			JOptionPane.showMessageDialog(null,"Ball has been saved!!! MISS!!!");
			totalSaves++;
			newPlay();
		}
	
		else	if ((Ball.direction.equals("middlehigh") || Ball.direction.equals("middlelow")) 
				&& keeper.direction == 1) {
			playSound("booing.mp3");
			JOptionPane.showMessageDialog(null,"Ball has been saved!!! MISS!!!");
			totalSaves++;
			newPlay();
		}
		
		else	if ((Ball.direction.equals("righthigh") || Ball.direction.equals("rightlow")) 
				&& keeper.direction == 2) {
			playSound("booing.mp3");
			JOptionPane.showMessageDialog(null,"Ball has been saved!!! MISS!!!");
			totalSaves++;
			newPlay();
		}
		else {
		playSound("cheer.wav");	
		JOptionPane.showMessageDialog(null, "GOOOOOAAAAL!!! You scored!!!");
		totalGoals++;
		sound.stop();
	newPlay();
		}
		
	}

	void newPlay() {
		isKicked=false;
		saveChecked=false;
		isMoving=false;
		randomcalled=false;
		keeper.direction=0;
		saveChecked=false;
		
		ball= new Ball();
		keeper=new Keeper(288, 307, (int) (1.65 * 125), (int) (1.15 * 200));
		
		playerTimer.restart();
		PKButtonPanel.b1.setText("left");
		PKButtonPanel.b2.setText("middle");
		PKButtonPanel.b3.setVisible(true);
		PKButtonPanel.b3.setText("right");
		repaint();
		ball.direction="";

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

			// System.out.println(ballDirection);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == playerTimer) {
			timeLeft--;
			if (timeLeft == -1) {
				
				keeper.timeup = true;

				timeLeft = 8;
				playerTimer.stop();
			
			}
		}
		if (ball.shotFired) {
			timeLeft = 8;
			playerTimer.stop();
			keeperDive = 1;
			if (!randomcalled) {
				keeper.randomDirection();
				randomcalled = true;
				
				
			}

		}
		
		if (isKicked) {
			setPlay(true);

			ball.update();
			if (ball.stop) {
				
				if (!saveChecked) {
					
					
					saveChecked=true;
					checkSave();
				}
				
				
			}
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
	private void playSound(String fileName) {
		 sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
