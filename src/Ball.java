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
		
		 
		 
	
		
		 
		

		
		

	}

	void update(String direction) {
		if (direction.equals("lefthigh")) {
if (x < 280 && y < 300) {
			stop = true;
		}
			x = x - 4;
			y = y - 5;
			if (stop) {
				x = x + 4;
				y = y + 5;
			}

		}
		if (direction.equals("leftlow")) {
if (x < 64 && y < 630) {
			stop = true;
		}
			x = x - 6;
			y = y - 4;
			if (stop) {
				x = x + 6;
				y = y + 4;
			}

		}
		if (direction.equals("middlehigh")) {
if ( y < 300) {
			stop = true;
		}
			
			y = y - 4;
			if (stop) {
				y = y + 4;
			}

		}
		if (direction.equals("middlelow")) {
 if (y < 470) {
			stop = true;
		}
			
			y = y - 4;
			if (stop) {
				y = y + 4;
			}

		}
		if (direction.equals("righthigh")) {
 if (y < 295) {
			stop = true;
		}
			x = x + 5;
			y = y - 6;
			if (stop) {
				x = x - 5;
				y = y + 6;
			}

		}
		if (direction .equals("rightlow")) {
if (y < 440) {
			stop = true;
}
			x = x + 6;
			y = y - 4;
			if (stop) {
				x = x - 6;
				y = y + 4;
			}

		}
		
		}

	}


