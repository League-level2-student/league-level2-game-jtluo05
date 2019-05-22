import java.awt.Dimension;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PKRunner {
	int WIDTH=800;
int HEIGHT=800;
JFrame frame=new JFrame();
JPanel panel=new JPanel();


public static void main(String[] args) {
	
	PKRunner pkr=new PKRunner();
	pkr.setup();
}



void setup() {
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.show();
	frame.add(panel);
	

	
frame.pack();
		
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