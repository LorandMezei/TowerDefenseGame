package game.DetectStrategies;

import game.Enemies.Enemy;
import game.Towers.Tower;

public interface IDetectStrategy {
	Enemy detect(Tower tower);
}
