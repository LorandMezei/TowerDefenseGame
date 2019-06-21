package game.Enemies;

import game.GameData;
import game.CollisionMediators.EnemyRoad_Collision_Mediator;
import game.CollisionMediators.IEnemyCollisionMediator;
import game.MoveStrategies.*;
import game.Projectiles.Projectile;

public class EnemyFactory {
	public static Enemy create(int round) {
		switch (1) {
		case 1:
			return new BasicEnemy().XCoor(GameData.getGameData().getMap().getRoads()[0].getXCoor())
								   .YCoor(GameData.getGameData().getMap().getRoads()[0].getYCoor())
								   .Width(Enemy.DEFAULT_WIDTH)
								   .Height(Enemy.DEFAULT_HEIGHT)
								   .Health(Enemy.DEFAULT_HEALTH)
								   .XDirection(Enemy.DEFAULT_XDIRECTION)
						   		   .YDirection(Enemy.DEFAULT_YDIRECTION)
						   		   .MoveSpeed(Enemy.DEFAULT_MOVESPEED)
								   .MoveStrategy(new BasicEnemy_Move_Strategy())
								   .EnemyCollisionMediator(new EnemyRoad_Collision_Mediator());
		default:
			System.out.println("Error in TowerFactory");
	    }
	
		return null;
	}
}
