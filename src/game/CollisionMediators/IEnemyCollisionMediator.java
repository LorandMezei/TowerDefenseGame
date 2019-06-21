package game.CollisionMediators;

import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public interface IEnemyCollisionMediator {
	void register(Enemy object);
	void collision();
}
