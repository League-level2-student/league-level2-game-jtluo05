//https://stackoverflow.com/questions/21429246/java-how-to-move-a-rectangle-thats-drawn-by-graphics2d



import java.awt.Dimension;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PKRunner {
static	int WIDTH=800;
static int HEIGHT=800;
static JFrame frame=new JFrame();
PKGamePanel gamePanel=new PKGamePanel();
static JPanel panel=new JPanel();
PKButtonPanel buttons=new PKButtonPanel(gamePanel);
public static void main(String[] args) {
	
	PKRunner pkr=new PKRunner();
	pkr.setup();
}



void setup() {
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	panel.setLayout(new BoxLayout(panel, SwingConstants.VERTICAL));
	panel.add(gamePanel) ;
	panel.add(buttons);
	frame.add(panel);
	frame.setSize(WIDTH, HEIGHT);

	

		
}

private JLabel createLabelImage(String fileName) {
    try {
         URL imageURL = getClass().getResource(fileName);
         if (imageURL == null) {
              System.err.println("Could not find image " + fileName);
              return new JLabel();
         } else {
              Icon icon = new ImageIcon(imageURL);
              JLabel imageLabel = new JLabel(icon);
              return imageLabel;
         }
    } catch (Exception e) {
         System.err.println("Could not find image " + fileName);
         return new JLabel();
    }
}
private void showPicture(String fileName) { 
    try {
         JLabel imageLabel = createLabelImage(fileName);
        
         frame.add(imageLabel);
        
    } catch (Exception e) {
         e.printStackTrace();
    }
}
}








