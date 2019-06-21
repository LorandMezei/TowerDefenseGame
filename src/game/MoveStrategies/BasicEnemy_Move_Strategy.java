package game.MoveStrategies;

import game.Enemies.Enemy;
import game.Maps.Road;
import game.GameData;

public class BasicEnemy_Move_Strategy implements IEnemyMoveStrategy {

	@Override
	public void move(Enemy enemy) {
		enemy.setXCoor(enemy.getXCoor() + enemy.getXDirection()*enemy.getMoveSpeed());
		enemy.setYCoor(enemy.getYCoor() + enemy.getYDirection()*enemy.getMoveSpeed());
	}
}
