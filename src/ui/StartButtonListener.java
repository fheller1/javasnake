package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javasnake.*;

public class StartButtonListener implements ActionListener {

	private JFrame frame;
	private JLabel imgLabel;
	private JSlider sizeSlider;
	private JButton step;
	private JButton start;
	private int size;
	private GameBoard[] gb;

	public StartButtonListener(JFrame frame, JLabel imgLabel, JSlider sizeSlider, JButton step, JButton start, GameBoard[] gb) {
		this.frame = frame;
		this.imgLabel = imgLabel;
		this.sizeSlider = sizeSlider;
		this.step = step;
		this.start = start;
		this.gb = gb;
	}

	public void actionPerformed(ActionEvent arg0) {
		size = sizeSlider.getValue();
		gb[0] = new GameBoard(size);
		size = sizeSlider.getValue();		
		sizeSlider.setEnabled(false);
		step.setEnabled(true);
		start.setEnabled(false);
		
		ImageIcon img = new ImageIcon();
		img.setImage(gb[0].generate(frame.getWidth()-50, frame.getHeight()-120));
		imgLabel.setIcon(img);
		frame.repaint();
	}
}
