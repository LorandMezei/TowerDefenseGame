package game.MoveStrategies;

import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public class StraightLineProjectile_MoveStrategy implements IProjectileMoveStrategy {
	
	boolean setTracking = false;
	
	double angle;
	
	@Override
	public void move(Projectile projectile, Enemy enemy) {
	
		if (setTracking == false) {		
			int opposite = enemy.getYCoor() - projectile.getYCoor(); // y1 - y0 = deltaY
			int adjacent = enemy.getXCoor() - projectile.getXCoor(); // x1 - x0 = deltaX
			
			angle = Math.atan2(opposite, adjacent); 
		
			setTracking = true;
		}
	
		projectile.setXCoor( (int) (projectile.getXCoor() + (projectile.getMoveSpeed() * Math.cos(angle))) );
		projectile.setYCoor( (int) (projectile.getYCoor() + (projectile.getMoveSpeed() * Math.sin(angle))) );
	}
}
