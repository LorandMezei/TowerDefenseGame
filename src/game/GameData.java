package game;

import java.util.ArrayList;
import game.Enemies.Enemy;
import game.Maps.Map;
import game.Towers.Tower;

public class GameData 
{
	// Holds the data values for in-game. 
	private Player player = new Player(100, 1000);
	private Map map = new Map();
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Tower> towers = new ArrayList<>();

	//------------ Singleton----------------
	private static GameData gameData = null;
	private GameData() {}
	public static GameData getGameData() {
		if (gameData == null) 
			gameData = new GameData(); 
  
        return gameData;
	}
	//--------------------------------------
	
	// Add an enemy to the enemies arraylist.
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	// Add a tower to the towers arraylist.
	public void addTower(Tower tower) {
		towers.add(tower);
	}
	
	// Getter methods.
	public Player getPlayer() { return this.player; }
	public Map getMap() { return this.map; }
	public ArrayList<Enemy> getEnemies() { return this.enemies; }
	public ArrayList<Tower> getTowers() { return this.towers; }
}
