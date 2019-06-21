package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import game.Enemies.Enemy;
import game.Enemies.EnemyFactory;
import game.Maps.Map;
import game.Projectiles.Projectile;
import game.Towers.Tower;

public class GameData {
	private static GameData gameData = null;
	
	private Player player = new Player(100, 1000);
	private Map map = new Map();
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Tower> towers = new ArrayList<>();
	
	private Timer addEnemyTimer;

	private GameData() {
		addEnemyTimer = new Timer(1000, new AddEnemyEvent());
		addEnemyTimer.start();
	}
	
	public static GameData getGameData() {
		if (gameData == null) 
			gameData = new GameData(); 
  
        return gameData;
	}
	
	public void addEnemy() {
		getEnemies().add(EnemyFactory.create(1));
	}
	
	public Player getPlayer() { return this.player; }
	public Map getMap() { return this.map; }
	public ArrayList<Enemy> getEnemies() { return this.enemies; }
	public ArrayList<Tower> getTowers() { return this.towers; }
	
	//---------------------------------------------------
		private class AddEnemyEvent implements ActionListener 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addEnemy();
			}
		}
		//---------------------------------------------------
}
