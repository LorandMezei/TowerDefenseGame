package game.MoveStrategies;

import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public interface IProjectileMoveStrategy {
	
	void move(Projectile projectile, Enemy enemy);
}
