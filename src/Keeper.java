import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.imageio.ImageIO;

public class Keeper extends PKGameObject implements ImageObserver {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	static final int LEFTHIGH = 0;
	static final int LEFTLOW = 1;
	static final int MIDDLEHIGH = 2;
	static final int MIDDLELOW = 3;
	static final int RIGHTHIGH = 4;
	static final int RIGHTLOW = 5;
	int direction = 0;
boolean stop=false;
	Keeper(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("goalie.png");
		}
		randomDirection();
	}

	void draw(Graphics g) {
		drawCollisionBox(g);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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
	void stop() {
		stop = true;
		
	}
	void randomDirection() {
		direction = new Random().nextInt(6);
		if (direction == LEFTHIGH) {
			if (x < 280 && y < 300) {
				stop();
							}

			x = x - 4;
			y = y - 5;
			if (stop) {
				x = x + 4;
				y = y + 5;
			}
		}
		if (direction == LEFTLOW) {
			if (x < 64 && y < 630) {
				stop();
			}
			x = x - 7;
			y = y - 4;
			if (stop) {
				x = x + 7;
				y = y + 4;
			}
		}
		if (direction == MIDDLEHIGH) {
			if (y < 300) {
				stop();
			}

			y = y - 7;
			if (stop) {
				y = y + 7;
			}

		}
		if (direction == MIDDLELOW) {
			if (y < 470) {
				stop();
			}

			y = y - 4;
			if (stop) {
				y = y + 4;
			}
		}
		if (direction == RIGHTHIGH) {
			if (y < 295) {
				stop();
			}
			x = x + 5;
			y = y - 6;
			if (stop) {
				x = x - 5;
				y = y + 6;
			}

		}
		if (direction == RIGHTLOW) {
			if (y < 440) {
				stop();
			}
			x = x + 6;
			y = y - 4;
			if (stop) {
				x = x - 6;
				y = y + 4;
			}
		}
	}

	public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

		double rads = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
		int w = img.getWidth();
		int h = img.getHeight();
		int newWidth = (int) Math.floor(w * cos + h * sin);
		int newHeight = (int) Math.floor(h * cos + w * sin);

		BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotated.createGraphics();
		AffineTransform at = new AffineTransform();
		at.translate((newWidth - w) / 2, (newHeight - h) / 2);

		int x = w / 2;
		int y = h / 2;

		at.rotate(rads, x, y);
		g2d.setTransform(at);
		g2d.drawImage(img, 0, 0, this);
		// g2d.setColor(Color.RED);
		// g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
		g2d.dispose();

		return rotated;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
