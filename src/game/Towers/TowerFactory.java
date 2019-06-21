package game.Towers;

import java.awt.Color;

import game.AttackStrategies.*;
import game.DetectStrategies.*;
import game.MoveStrategies.*;

public class TowerFactory {
	public static Tower create(int buttonIndex, int xCoor, int yCoor) {
		switch(buttonIndex) {
		case 1: 
			return new Gunner().XCoor(xCoor)
							   .YCoor(yCoor)
							   .Width(Tower.DEFAULT_WIDTH)
							   .Height(Tower.DEFAULT_HEIGHT)
							   .Color(Color.MAGENTA)
							   .AttackSpeed(Tower.DEFAULT_ATTACKSPEED)
							   .AttackRadius(Tower.DEFAULT_ATTACKRADIUS)
							   .AttackEnemyTimer()
							   .CanShoot(false)
							   .DetectStrategy(new First_Detect_Strategy())
							   .AttackStrategy(new ST_Attack_Strategy());
		case 2:
			return new Cannoneer().XCoor(xCoor)
					   	          .YCoor(yCoor)
					   	          .Width(Tower.DEFAULT_WIDTH)
					   	          .Height(Tower.DEFAULT_HEIGHT)
					   	          .Color(Color.ORANGE)
					   	          .AttackSpeed(Tower.DEFAULT_ATTACKSPEED)
					   	          .AttackRadius(Tower.DEFAULT_ATTACKRADIUS)
					   	          .AttackEnemyTimer()
					   	          .CanShoot(false)
					   	          .DetectStrategy(new Close_Detect_Strategy())
					   	          .AttackStrategy(new ST_Attack_Strategy());
		default:
			System.out.println("Error in TowerFactory");
			}
		
		return null;
	}
}
