package ui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import javasnake.GameBoard;

public class ControlKeyAction implements Action {
	
	private int direction;
	private GameBoard[] gb;

	public ControlKeyAction(GameBoard gb[], int direction) {
		this.gb = gb;
		this.direction = direction;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gb[0].setCurrentDirection(direction);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
