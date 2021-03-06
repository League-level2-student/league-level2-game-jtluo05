import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Ball {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int xchange = 0;
	int ychange = 0;
	int x = 375;
	int y = 635;
	static String direction = "";
	boolean stop = false;
	boolean isMoving = false;
	boolean shotFired = false;
//test
	Ball() {
		if (needImage) {
			loadImage("soccerball.png");
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, 60, 60, null);
		} else {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 60, 60);
		}
	}

	void move() {
		if (!isMoving) {
			isMoving = true;
		}
	}

	void stop() {
			isMoving = false;
		if (!stop) {
			System.out.println("stop");
			
		}	stop = true;


	}

	

	void update() {
		if (direction.equals("lefthigh")) {
			move();
			if (x < 280 && y < 315) {
				stop();
			}
			shotFired = true;
			x = x - 4;
			y = y - 5;
			if (stop) {
				x = x + 4;
				y = y + 5;
			}

		}
		if (direction.equals("leftlow")) {
			move();
			if (x < 85 && y < 630) {
				stop();
			}
			shotFired = true;
			x = x - 7;
			y = y - 4;
			if (stop) {
				x = x + 7;
				y = y + 4;
			}

		}
		if (direction.equals("middlehigh")) {
			move();
			if (y < 300) {
				stop();
			}
			shotFired = true;
			y = y - 7;
			if (stop) {
				y = y + 7;
			}

		}
		if (direction.equals("middlelow")) {
			move();
			if (y < 470) {
				stop();
			}
			shotFired = true;
			y = y - 4;
			if (stop) {
				y = y + 4;
			}

		}
		if (direction.equals("righthigh")) {
			move();
			if (y < 290) {
				stop();
			}
			shotFired = true;
			x = x + 5;
			y = y - 6;
			if (stop) {
				x = x - 5;
				y = y + 6;
			}

		}
		if (direction.equals("rightlow")) {
			move();
			if (y < 440) {
				stop();
			}
			shotFired = true;
			x = x + 6;
			y = y - 4;
			if (stop) {
				x = x - 6;
				y = y + 4;
			}

		}

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
