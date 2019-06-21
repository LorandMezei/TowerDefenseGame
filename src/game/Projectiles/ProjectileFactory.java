package game.Projectiles;

import game.DamageStrategies.*;
import game.Enemies.Enemy;
import game.MoveStrategies.*;
import game.Towers.Tower;
import game.AttackStrategies.*;

public class ProjectileFactory {
	public static Projectile create(Tower tower, Enemy enemy) {
		
		if (tower.getAttackStrategy() instanceof ST_Attack_Strategy) {
			return new Bullet().XCoor(tower.getXCoor())
					   		   .YCoor(tower.getYCoor())
					   		   .Width(Projectile.DEFAULT_WIDTH)
					   		   .Height(Projectile.DEFAULT_HEIGHT)
					   		   .XDirection(Projectile.DEFAULT_XDIRECTION)
					   		   .YDirection(Projectile.DEFAULT_YDIRECTION)
					   		   .MoveSpeed(Projectile.DEFAULT_MOVESPEED)
					   		   .MoveStrategy(new BasicProjectile_Move_Strategy())
					   		   .DamageStrategy(new Pierce_Damage_Strategy())
					   		   .Enemy(enemy);
		}
		
		else if (tower.getAttackStrategy() instanceof AOE_Attack_Strategy) {
			return new Bomb().XCoor(tower.getXCoor())
			   		   	     .YCoor(tower.getYCoor())
			   		   	     .Width(Projectile.DEFAULT_WIDTH)
			   		   	     .Height(Projectile.DEFAULT_HEIGHT)
			   		   	     .XDirection(Projectile.DEFAULT_XDIRECTION)
			   		   	     .YDirection(Projectile.DEFAULT_XDIRECTION)
			   		   	     .MoveSpeed(Projectile.DEFAULT_MOVESPEED)
			   		   	     .MoveStrategy(new BasicProjectile_Move_Strategy())
			   		   	     .DamageStrategy(new Explosion_Damage_Strategy())
			   		   	     .Enemy(enemy);
		}
		
		return null;
	}
}
