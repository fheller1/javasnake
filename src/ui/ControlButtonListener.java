package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javasnake.*;

public class ControlButtonListener implements ActionListener {

	private JFrame frame;
	private JLabel imgLabel;
	private JSlider sizeSlider;
	private int size;
	private int direction;
	private GameBoard[] gb;

	public ControlButtonListener(JFrame frame, JLabel imgLabel, JSlider sizeSlider, GameBoard gb[], int direction) {
		this.frame = frame;
		this.imgLabel = imgLabel;
		this.sizeSlider = sizeSlider;
		this.gb = gb;
		this.direction = direction;
	}

	public void actionPerformed(ActionEvent arg0) {
		size = sizeSlider.getValue();
		
		ImageIcon img = new ImageIcon();
		img.setImage(gb[0].generate(direction, size, frame.getWidth()-50, frame.getHeight()-120));
		imgLabel.setIcon(img);
		frame.repaint();
	}

}
