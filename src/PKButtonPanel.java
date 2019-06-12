import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PKButtonPanel extends JPanel implements ActionListener {
	JButton b1=new JButton();
	JButton b2=new JButton();
	JButton b3=new JButton();
	
	PKGamePanel gamePanel;
	
	PKButtonPanel(PKGamePanel gamePanel){
		setPreferredSize(new Dimension(PKRunner.WIDTH,35));
		b1.setText("left");
		b2.setText("right");
		b3.setText("middle");

		b1.addMouseListener(gamePanel);
		b2.addMouseListener(gamePanel);
		b3.addMouseListener(gamePanel);
		
		add(b1);
		add(b2);
		add(b3);
		
		this.gamePanel=gamePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if (e.getSource().equals("left")) {
	
	b1.setText("high");
	b2.setText("low");
	remove(b3);
	repaint();
}
		

b1.setText("high");
b2.setText("low");
remove(b3);
repaint();



	}
}
