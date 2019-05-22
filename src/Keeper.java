import java.awt.Graphics;

public class Keeper extends GameObject {

	
	Keeper(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}


void draw(Graphics g) {
	g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
}
}
