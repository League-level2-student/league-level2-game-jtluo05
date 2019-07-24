import java.awt.Color;
import java.awt.Graphics;

public class PKGameObject {
	int x;
	int y;
	int width;
	int height;

	PKGameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}
	void drawCollisionBox(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect(x, y, width, height);
	}
}
