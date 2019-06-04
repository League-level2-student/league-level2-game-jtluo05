import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PKButtonPanel extends JPanel implements ActionListener {
	JButton left=new JButton();
	JButton right=new JButton();
	JButton middle=new JButton();
	
	PKButtonPanel(){
		setPreferredSize(new Dimension(PKRunner.WIDTH,35));
		left.setText("left");
		right.setText("right");
		
		middle.setText("middle");

		add(left);
		add(right);
		add(middle);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
left.setText("high");
right.setText("low");
PKRunner.frame.pack();

repaint();
	}
}
