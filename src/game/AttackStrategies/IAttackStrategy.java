package game.AttackStrategies;

import game.Enemies.Enemy;
import game.Towers.Tower;

public interface IAttackStrategy {
	public void attack(Tower tower, Enemy enemy);
}
