package game.AttackStrategies;

import game.Enemies.Enemy;
import game.Projectiles.ProjectileFactory;
import game.Towers.Tower;

public class ST_Attack_Strategy implements IAttackStrategy {

	@Override
	public void attack(Tower tower, Enemy enemy) {
		if (tower.getCanShoot()) {
			tower.createProjectile(enemy);
			tower.setCanShoot(false);
		}
	}
}
