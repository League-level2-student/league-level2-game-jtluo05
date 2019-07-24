import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PKButtonPanel extends JPanel {
	static JButton b1 = new JButton();
	static JButton b2 = new JButton();
	static JButton b3 = new JButton();

	PKGamePanel gamePanel;

	PKButtonPanel(PKGamePanel gamePanel) {
		setPreferredSize(new Dimension(PKRunner.WIDTH, 35));
		b1.setText("left");
		b2.setText("middle");
		b3.setText("right");

		b1.addMouseListener(gamePanel);
		b2.addMouseListener(gamePanel);
		b3.addMouseListener(gamePanel);

		add(b1);
		add(b2);
		add(b3);

		this.gamePanel = gamePanel;
	}

}