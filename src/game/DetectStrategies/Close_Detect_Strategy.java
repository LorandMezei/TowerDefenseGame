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
			double closestDistance = Math.abs( 
					Math.sqrt( (Math.pow(GameData.getGameData().getEnemies().get(0).getXCoor() - tower.getXCoor(), 2)) + 
							   (Math.pow(GameData.getGameData().getEnemies().get(0).getYCoor() - tower.getYCoor(), 2)) ) );
			
			for (Enemy e: GameData.getGameData().getEnemies()) 
			{
				double distance = Math.abs( 
						Math.sqrt( (Math.pow(e.getXCoor() - tower.getXCoor(), 2)) + 
								   (Math.pow(e.getYCoor() - tower.getYCoor(), 2)) ) );
				
				if (distance <= closestDistance && distance <= tower.getAttackRadius())
					enemy = e;
			}
		}
		
		return enemy;
	}
}

