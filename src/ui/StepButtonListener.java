package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import javasnake.GameBoard;

public class StepButtonListener implements ActionListener {

	private JFrame frame;
	private JLabel imgLabel;
	private JButton step;
	private JButton start;
	private GameBoard[] gb;
	
	public StepButtonListener(JFrame frame, JLabel imgLabel, JButton step, JButton start, GameBoard[] gb) {
		this.frame = frame;
		this.imgLabel = imgLabel;
		this.step = step;
		this.start = start;
		this.gb = gb;
	}

	public void actionPerformed(ActionEvent arg0) {
		if(gb[0].getEnd()) return;
		
		ImageIcon img = new ImageIcon();
		img.setImage(gb[0].generate(500, 500));
		
		if(gb[0].getEnd()) {
			img = new ImageIcon("img/end.jpg"); 
			step.setEnabled(false);
			start.setEnabled(true);
		}
		
		imgLabel.setIcon(img);
		frame.repaint();
	}
}
