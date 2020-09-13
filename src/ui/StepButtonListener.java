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
		if(gb[0].getEnd()) return;
		ImageIcon img = new ImageIcon();
		img.setImage(gb[0].generate(frame.getWidth()-50, frame.getHeight()-120));
		if(gb[0].getEnd()) img = new ImageIcon("img/end.jpg");
		imgLabel.setIcon(img);
		frame.repaint();
	}
}
