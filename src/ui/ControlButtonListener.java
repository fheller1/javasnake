package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javasnake.*;

public class ControlButtonListener implements ActionListener {

	private int direction;
	private GameBoard[] gb;

	public ControlButtonListener(GameBoard gb[], int direction) {
		this.gb = gb;
		this.direction = direction;
	}

	public void actionPerformed(ActionEvent arg0) {
		gb[0].setCurrentDirection(direction);
	}

}
