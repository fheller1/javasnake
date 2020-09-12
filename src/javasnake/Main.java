package javasnake;
import java.util.ArrayList;
import java.util.Scanner;

import objects.GameObject;

public class Main {
	public static void main(String[] args) {
		int size = 15;
		GameBoard board = new GameBoard(size);
		int userInput;
		Scanner input = new Scanner(System.in);
		ArrayList<GameObject> things;
		
		while (!board.getEnd()) {
			System.out.println("Next direction, 0 up, 1 right, 2 down, 3 left");
			userInput = input.nextInt();
			board.setCurrentDirection(userInput);
			things = board.tick();
			for(int y=size-1; y>-1; y--) {
				for(int x=0; x<size; x++) {
					boolean printed = false;
					for (GameObject o:things) {
						if(o.getCoordinate().getX() == x && o.getCoordinate().getY() == y) {
							System.out.print(o.getSign());
							printed = true;
						}
					}
					if(!printed) System.out.print(" ");
				}
				System.out.print("\n");
			}
		}
		
		input.close();
		System.out.println("Game Over");
	}
}
