import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int xchange = 0;
	int ychange = 0;
	int x = 275;
	int y = 635;
	PKGamePanel gp = new PKGamePanel();
	static boolean stop = false;

	Ball() {

	}

	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 60, 60);
		if (x < 150 && y < 300) {
			stop = true;
		}

	}

	void update() {
		if (gp.direction == "lefthigh") {

			x = x - 2;
			y = y - 4;
			if (stop) {
				x = x + 2;
				y = y + 4;
			}

		}
		else {
			
			}	
		}

	}


