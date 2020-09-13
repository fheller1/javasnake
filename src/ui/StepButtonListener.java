package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javasnake.GameBoard;

public class StepButtonListener implements ActionListener {

	private JFrame frame;
	private JLabel imgLabel;
	private GameBoard[] gb;

	public StepButtonListener(JFrame frame, JLabel imgLabel, GameBoard[] gb) {
		this.frame = frame;
		this.imgLabel = imgLabel;
		this.gb = gb;
	}

	public void actionPerformed(ActionEvent arg0) {
		ImageIcon img = new ImageIcon();
		img.setImage(gb[0].generate(frame.getWidth()-50, frame.getHeight()-120));
		imgLabel.setIcon(img);
		frame.repaint();
	}
}
