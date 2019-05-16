import java.awt.Dimension;

import javax.swing.JFrame;

public class PKRunner {
	int WIDTH=800;
int HEIGHT=800;
JFrame frame=new JFrame();

public static void main(String[] args) {
	
	PKRunner pkr=new PKRunner();
	pkr.setup();
}



void setup() {
	
	frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));

		frame.pack();
		
}
}
