package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import game.Enemies.Enemy;

public class Round {
	
	static int totalRounds = 0;
	static int currentRound = 0;
	int currentIndex = 0;
	
	public ArrayList<Enemy> roundEnemies = new ArrayList<>();
	
	public Round() {
		createRandomEnemies();
		
		totalRounds++;
	}
	
	
	public void createRandomEnemies() {
		Random rng = new Random();
		
		int numEnemies = rng.nextInt(10) + 5;
		
		for (int i = 0; i < numEnemies; i++) {
			Enemy e = new Enemy();
			
			int color = rng.nextInt(5);
			
			switch(color) {
				case 1: e.setColor(Color.blue);
				roundEnemies.add(e);
				break;
				
				case 2: e.setColor(Color.red);
				roundEnemies.add(e);
				break;
				
				case 3: e.setColor(Color.orange);
				roundEnemies.add(e);
				break;
				
				case 4: e.setColor(Color.green);
				roundEnemies.add(e);
				break;
				
				case 5: e.setColor(Color.cyan);
				roundEnemies.add(e);
				break;
			}	
		}
		// Final enemy is white to signal end of round.
		Enemy e1 = new Enemy();
		e1.setColor(Color.white);
		roundEnemies.add(e1);
	}
}
