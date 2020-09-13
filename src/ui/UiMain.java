package ui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javasnake.*;


public class UiMain {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Snake");
		JLabel imgLabel = new JLabel();
		JSlider sizeSlider = new JSlider(7, 35, 10);
		GameBoard[] gb = new GameBoard[1];
		JButton start = new JButton("Start!");
		JButton step = new JButton("Step");
		JButton up = new JButton("^");
		JButton left = new JButton("<");
		JButton down = new JButton("_");
		JButton right = new JButton(">");
		
		start.addActionListener(new StartButtonListener(frame, imgLabel, sizeSlider, gb));
		step.addActionListener(new StepButtonListener(frame, imgLabel, gb));
		up.addActionListener(new ControlButtonListener(gb, 0));
		left.addActionListener(new ControlButtonListener(gb, 3));
		down.addActionListener(new ControlButtonListener(gb, 2));
		right.addActionListener(new ControlButtonListener(gb, 1));
		
		frame.setSize(new Dimension(550, 620));
		
		JPanel panel = new JPanel();

		panel.add(sizeSlider);
		panel.add(start);
		panel.add(step);
		panel.add(imgLabel);
		panel.add(up);
		panel.add(left);
		panel.add(down);
		panel.add(right);
		sizeSlider.setEnabled(false);
				
		frame.add(panel);
		
		ImageIcon img = new ImageIcon();
		img.setImage(new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB));
		imgLabel.setIcon(img);
		
		frame.setVisible(true);
		
		
	}
	
}
