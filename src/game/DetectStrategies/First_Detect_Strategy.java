package game.DetectStrategies;

import game.Enemies.Enemy;
import game.Towers.Tower;
import game.GameData;

public class First_Detect_Strategy implements IDetectStrategy {

	@Override
	public Enemy detect(Tower tower) {
		
		Enemy enemy = null;
		
		
		// Look through each enemy in enemies arraylist and see if
		// it is within the tower's attack radius
		for (Enemy e : GameData.getGameData().getEnemies()) {
			// Distance between the tower and the current enemy in enemy arraylist.
			double distanceFromCenters = 
					Math.abs(Math.sqrt( (Math.pow(e.getXCoor() - tower.getXCoor(), 2)) + 
						    (Math.pow(e.getYCoor() - tower.getYCoor(), 2)) ));
			
			// If current enemy is within the tower's attack radius, 
			// then return the first enemy.
			if (distanceFromCenters <= tower.getAttackRadius()) {
				if (GameData.getGameData().getEnemies().size() != 0) {
					enemy = GameData.getGameData().getEnemies().get(0);
					return enemy;
				}
			}
			
		}
		
		return enemy;
	}
}
