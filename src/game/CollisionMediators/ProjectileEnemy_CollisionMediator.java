package game.CollisionMediators;

import game.GameData;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public class ProjectileEnemy_CollisionMediator implements IProjectileEnemyCollisionMediator {
	
	@Override
	public void collision(Projectile projectile) {
		
		for (Enemy enemy: GameData.getGameData().getEnemies()) {
			
			double distanceFromCenters = 
				Math.abs(Math.sqrt( (Math.pow(enemy.getXCoor() - projectile.getXCoor(), 2)) + 
					    	        (Math.pow(enemy.getYCoor() - projectile.getYCoor(), 2)) ));
					
			if (distanceFromCenters <= enemy.getWidth()) {
				GameData.getGameData().getEnemies().remove(enemy);
				
				return;
			}
		}
	}
}

