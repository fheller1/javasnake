package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import javasnake.*;


public class UiMain {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Snake");
		JLabel imgLabel = new JLabel();
		JSlider sizeSlider = new JSlider(7, 35, 10);
		GameBoard[] gb = new GameBoard[1];
		JButton start = new JButton("Start!");
		JButton step = new JButton("Step");
		step.setVisible(false);
		JButton up = new JButton("^");
		up.setVisible(false);
		JButton left = new JButton("<");
		left.setVisible(false);;
		JButton down = new JButton("_");
		down.setVisible(false);
		JButton right = new JButton(">");
		right.setVisible(false);
		
		start.addActionListener(new StartButtonListener(frame, imgLabel, sizeSlider, step, start, gb));
		step.addActionListener(new StepButtonListener(frame, imgLabel, step, start, gb));
		step.setEnabled(false);
		up.addActionListener(new ControlButtonListener(gb, 0));
		left.addActionListener(new ControlButtonListener(gb, 3));
		down.addActionListener(new ControlButtonListener(gb, 2));
		right.addActionListener(new ControlButtonListener(gb, 1));
		
		frame.setSize(new Dimension(550, 590));
		
		JPanel panel = new JPanel();
		
		ImageIcon img = new ImageIcon("img/title.jpg");
		imgLabel.setIcon(img);
		
		panel.add(sizeSlider);
		panel.add(start);
		panel.add(step);
		panel.add(imgLabel);
		panel.add(up);
		panel.add(left);
		panel.add(down);
		panel.add(right);
		sizeSlider.setEnabled(false);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "forward");
        panel.getActionMap().put("forward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gb[0] != null) gb[0].setCurrentDirection(0);
            }
        });
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
        panel.getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(gb[0] != null) gb[0].setCurrentDirection(3);
            }
        });
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "backward");
        panel.getActionMap().put("backward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(gb[0] != null) gb[0].setCurrentDirection(2);
            }
        });
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");
        panel.getActionMap().put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(gb[0] != null) gb[0].setCurrentDirection(1);
            }
        });
        
        Timer timer = new Timer(500, new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				if(step.isEnabled()) step.doClick();
			}
        	
        });
        timer.setRepeats(true);
        timer.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		frame.setVisible(true);
		
	}
	
}
