package game.Projectiles;

import game.Enemies.Enemy;
import game.Towers.Tower;

public class ProjectileFactory {
	
	public static Projectile create(Tower tower, Enemy enemy) {
		
		return new Bullet(tower, enemy);
	}
}
