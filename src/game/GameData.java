package game;

import java.util.ArrayList;
import game.Enemies.Enemy;
import game.Maps.Map;
import game.Towers.Tower;

public class GameData 
{
	// Holds the data values for in-game. 
	private Player player = new Player(100, 1000);
	private Map    map = new Map();
	
	private ArrayList<Round> rounds      = new ArrayList<>();
	private ArrayList<Enemy> tempEnemies = new ArrayList<>();
	
	private ArrayList<Tower> towers      = new ArrayList<>();

	//------------ Singleton----------------
	private static GameData gameData = null;
	
	private GameData() 
	{
		createRounds();
	}
	
	public static GameData getGameData() 
	{
		if (gameData == null) 
			gameData = new GameData(); 
  
        return gameData;
	}
	//--------------------------------------
	
	public void createRounds() 
	{	
		for (int i = 0; i < 3; i++) 
		{
			Round r = new Round();
			rounds.add(r);	
		}
	}
	// Add an enemy to the enemies arraylist.
	public void addEnemy(Enemy enemy) {
		tempEnemies.add(enemy);
	}
	
	// Add a tower to the towers arraylist.
	public void addTower(Tower tower) {
		towers.add(tower);
	}
	
	// Getter methods.
	public Player getPlayer() { 
		return this.player; 
	}
	public Map getMap() { 
		return this.map; 
	}
	public ArrayList<Round> getRounds() { 
		return this.rounds; 
	}
	public ArrayList<Enemy> getEnemies() { 
		return tempEnemies; 
	}
	public ArrayList<Tower> getTowers() { 
		return this.towers; 
	}
}
