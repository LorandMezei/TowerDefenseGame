package game.DetectStrategies;

import game.Enemies.Enemy;
import game.Towers.Tower;
import game.GameData;

public class First_Detect_Strategy implements IDetectStrategy {

	@Override
	public Enemy detect(Tower tower) {
		
		Enemy enemy = null;
		
		if (GameData.getGameData().getEnemies().size() != 0) {
			enemy = GameData.getGameData().getEnemies().get(0);
		}
		
		return enemy;
	}
}
