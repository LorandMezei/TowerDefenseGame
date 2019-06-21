package game.DetectStrategies;

import game.GameData;
import game.Enemies.Enemy;
import game.Towers.Tower;

public class Close_Detect_Strategy implements IDetectStrategy {

	private Enemy enemy = null;
	
	@Override
	public Enemy detect(Tower tower) {
		
		if (GameData.getGameData().getEnemies().size() != 0) 
		{
			double closestDistance = 100000;
			for (Enemy e: GameData.getGameData().getEnemies()) 
			{
				double distance  = Math.sqrt( (Math.pow(Math.abs(e.getXCoor() - tower.getXCoor()), 2)) + 
								   			  (Math.pow(Math.abs(e.getYCoor() - tower.getYCoor()), 2)));
				if (distance < closestDistance)
					this.enemy = e;
				
			}
		}
		
		return this.enemy;
	}

}

