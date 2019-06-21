package game.MoveStrategies;

import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public class BasicProjectile_Move_Strategy implements IProjectileMoveStrategy {
	
	private boolean setTracking = false;

	@Override
	public void move(Projectile projectile, Enemy enemy) {
		
		try {
			if (setTracking == false) {

				// If x has to move in a positive or negative direction
				if ((enemy.getXCoor() - projectile.getXCoor()) > 0) 
					projectile.setXDirection(1);
				else projectile.setXDirection(-1);
					
				// If y has to move in a positive or negative direction
				if ((enemy.getYCoor() - projectile.getYCoor()) > 0) 
					projectile.setYDirection(1);
				else projectile.setYDirection(-1);
				
				setTracking = true;
			}
			
			projectile.setXCoor(projectile.getXCoor() + projectile.getXDirection()*projectile.getMoveSpeed());
			projectile.setYCoor(projectile.getYCoor() + projectile.getYDirection()*projectile.getMoveSpeed());
		}
		catch (ArithmeticException e) {
			
		}
	}
}
