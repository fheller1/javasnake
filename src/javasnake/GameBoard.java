package javasnake;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import objects.Coordinate;
import objects.Fruit;
import objects.GameObject;
import objects.SnakePiece;
import objects.Wall;

public class GameBoard {
	private int size;
	private boolean end;
	
	private int currentDirection;
	
	private ArrayList<Fruit> fruits;
	private ArrayList<Wall> walls;
	private ArrayList<SnakePiece> pieces;
	private SnakePiece head;
	
	private char fruitChar = 'a';
	private char wallChar = '#';
	private char snakeChar = 'x';
	Color fruitColor = Color.RED;
	Color wallColor = Color.BLACK;
	Color snakeColor = Color.GREEN;
	Color airColor = Color.WHITE;
	
	private BufferedImage I;
	
	private ArrayList<GameObject> things = new ArrayList<GameObject>();
	
	public GameBoard(int size) {
		this.size = size;
		end = false;
		currentDirection = 0;
		
		walls = new ArrayList<Wall>();
		pieces = new ArrayList<SnakePiece>();
		fruits = new ArrayList<Fruit>();
		
		for(int i = 0; i<size; i++) {
			walls.add(new Wall(wallChar, new Coordinate(i, 0)));
			walls.add(new Wall(wallChar, new Coordinate(i, size-1)));
		}
		for(int i = 1; i<size-1; i++ ) {
			walls.add(new Wall(wallChar, new Coordinate(0, i)));
			walls.add(new Wall(wallChar, new Coordinate(size-1, i)));
		}
		head = new SnakePiece(snakeChar, new Coordinate(1,0));
		pieces.add(head);
		
		things.addAll(fruits);
		things.addAll(walls);
		things.addAll(pieces);
		
		fruitSpawn();
	}
	
	public BufferedImage generate(int width, int height) {
		ArrayList<GameObject> things = tick();
		I = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				int realY = height-y;
				GameObject currentGameObject = null;
				Color currentColor;
				for(GameObject o:things) if(o.getCoordinate().getX() == x/(width/this.size) && o.getCoordinate().getY() == realY/(height/this.size)) currentGameObject = o;
				if(currentGameObject == null) currentColor = airColor;
				else if(currentGameObject.getSign() == fruitChar) currentColor = fruitColor;
				else if(currentGameObject.getSign() == wallChar) currentColor = wallColor;
				else if(currentGameObject.getSign() == snakeChar) currentColor = snakeColor;
				else currentColor = Color.PINK;	//color for unknown char
				
				I.setRGB(x, y, currentColor.getRGB());
			}
		}
		return I;
	}
	
	public ArrayList<GameObject> tick() {
		if(end) return things;
		Coordinate nextHead;
		GameObject next;
		switch(currentDirection) {
		case 0: //snake goes up
			nextHead = new Coordinate(head.getCoordinate().getX(), head.getCoordinate().getY()+1);
			next = null;
			for(GameObject o:things) {
				if(o.getCoordinate().getX() == nextHead.getX() && o.getCoordinate().getY() == nextHead.getY()) next = o;
			}
			
			if(next == null) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				pieces.remove(0);
			}
			else if(next.getSign() == fruitChar) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				Fruit toRemove = null;
				for(Fruit f:fruits) 
					if(f.getCoordinate().getX() == nextHead.getX() && f.getCoordinate().getY() == nextHead.getY()) 
						toRemove = f;
				fruits.remove(toRemove);
			}
			else if(next.getSign() == wallChar || next.getSign() == snakeChar) {
				end = true;
			}
			break;
			
		case 1: //snake goes right
			nextHead = new Coordinate(head.getCoordinate().getX()+1, head.getCoordinate().getY());
			next = null;
			for(GameObject o:things) {
				if(o.getCoordinate().getX() == nextHead.getX() && o.getCoordinate().getY() == nextHead.getY()) next = o;
			}
			
			if(next == null) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				pieces.remove(0);
			}
			else if(next.getSign() == fruitChar) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				Fruit toRemove = null;
				for(Fruit f:fruits) 
					if(f.getCoordinate().getX() == nextHead.getX() && f.getCoordinate().getY() == nextHead.getY()) 
						toRemove = f;
				fruits.remove(toRemove);
			}
			else if(next.getSign() == wallChar || next.getSign() == snakeChar) {
				end = true;
			}
			break;
			
		case 2: //snake goes down
			nextHead = new Coordinate(head.getCoordinate().getX(), head.getCoordinate().getY()-1);
			next = null;
			for(GameObject o:things) {
				if(o.getCoordinate().getX() == nextHead.getX() && o.getCoordinate().getY() == nextHead.getY()) next = o;
			}
			
			if(next == null) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				pieces.remove(0);
			}
			else if(next.getSign() == fruitChar) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				Fruit toRemove = null;
				for(Fruit f:fruits) 
					if(f.getCoordinate().getX() == nextHead.getX() && f.getCoordinate().getY() == nextHead.getY()) 
						toRemove = f;
				fruits.remove(toRemove);
			}
			else if(next.getSign() == wallChar || next.getSign() == snakeChar) {
				end = true;
			}
			break;
			
		case 3: //snake goes left
			nextHead = new Coordinate(head.getCoordinate().getX()-1, head.getCoordinate().getY());
			next = null;
			for(GameObject o:things) {
				if(o.getCoordinate().getX() == nextHead.getX() && o.getCoordinate().getY() == nextHead.getY()) next = o;
			}

			if(next == null) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				pieces.remove(0);
			}
			else if(next.getSign() == fruitChar) {
				pieces.add(new SnakePiece(snakeChar, nextHead));
				head = pieces.get(pieces.size()-1);
				Fruit toRemove = null;
				for(Fruit f:fruits) 
					if(f.getCoordinate().getX() == nextHead.getX() && f.getCoordinate().getY() == nextHead.getY()) 
						toRemove = f;
				fruits.remove(toRemove);
			}
			else if(next.getSign() == wallChar || next.getSign() == snakeChar) {
				end = true;
			}
			break;
		}
		
		if(end) return things;
		if(fruits.isEmpty()) {
			fruitSpawn();
		}
		things.clear();
		things.addAll(fruits);
		things.addAll(walls);
		things.addAll(pieces);
		return things;
	}
	
	public void fruitSpawn() {
		int pos = ThreadLocalRandom.current().nextInt(0, 100);
		int i = 0;
		while(i < (size*size)) {
			boolean occupied = false;
			for(GameObject o:things) if(o.getCoordinate().getX() == pos%size && o.getCoordinate().getY() == pos/size) occupied = true;
			if(occupied) {
				pos = (pos+1)%(size*size);
				i++;
				continue;
			}
			Fruit spawnedFruit = new Fruit(fruitChar, new Coordinate(pos%size, pos/size));
			fruits.add(spawnedFruit);
			things.add(spawnedFruit);
			break;
		}
		if(i == (size*size)) end = true;
	}
	
	public boolean getEnd() {
		return end;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}
}
