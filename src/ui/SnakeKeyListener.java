package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javasnake.*;

public class SnakeKeyListener implements KeyListener{

	private JFrame frame;
	private JLabel imgLabel;
	private JSlider sizeSlider;
	private int size;
	private GameBoard gb;
	
	public SnakeKeyListener(JFrame frame, JLabel imgLabel, JSlider sizeSlider, GameBoard gb) {
		this.frame = frame;
		this.imgLabel = imgLabel;
		this.sizeSlider = sizeSlider;
		this.gb = gb;
	}
	
	public void keyPressed(KeyEvent e) {
		size = sizeSlider.getValue();
		
		ImageIcon img = new ImageIcon();
		int direction = 0;
		boolean valid = false;
		if(e.getKeyCode() == KeyEvent.VK_W) direction = 0; valid = true;
		if(e.getKeyCode() == KeyEvent.VK_D) direction = 1; valid = true;
		if(e.getKeyCode() == KeyEvent.VK_S) direction = 2; valid = true;
		if(e.getKeyCode() == KeyEvent.VK_A) direction = 3; valid = true;
		
		if(valid) {
			img.setImage(gb.generate(direction, size, frame.getWidth(), frame.getHeight()-100));
			imgLabel.setIcon(img);
			frame.repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
