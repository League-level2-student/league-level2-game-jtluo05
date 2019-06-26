import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int xchange = 0;
	int ychange = 0;
	int x = 375;
	int y = 635;
	
	static boolean stop = false;



	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 60, 60);
		if (x < 280 && y < 300) {
			stop = true;
		}

	}

	void update(String direction) {
		if (direction.equals("lefthigh")) {

			x = x - 4;
			y = y - 5;
			if (stop) {
				x = x + 4;
				y = y + 5;
			}

		}
		if (direction.equals("leftlow")) {

			x = x - 2;
			y = y - 4;
			if (stop) {
				x = x + 2;
				y = y + 4;
			}

		}
		if (direction.equals("middlehigh")) {

			
			y = y - 4;
			if (stop) {
				y = y + 4;
			}

		}
		if (direction.equals("middlelow")) {

			x = x - 2;
			y = y - 4;
			if (stop) {
				x = x + 2;
				y = y + 4;
			}

		}
		if (direction.equals("righthigh")) {

			x = x + 2;
			y = y + 4;
			if (stop) {
				x = x - 2;
				y = y - 4;
			}

		}
		if (direction .equals("rightlow")) {

			x = x + 2;
			y = y + 4;
			if (stop) {
				x = x - 2;
				y = y - 4;
			}

		}
		
		}

	}


