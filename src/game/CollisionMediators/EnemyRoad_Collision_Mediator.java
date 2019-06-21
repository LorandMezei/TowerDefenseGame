package game.CollisionMediators;

import game.GameData;
import game.Enemies.Enemy;
import game.Maps.HorizontalRoad;
import game.Maps.Road;
import game.Maps.VerticalRoad;

public class EnemyRoad_Collision_Mediator implements IEnemyCollisionMediator {

	private Enemy enemy;
	private Road road;
	private int currentRoadIndex = 0;
	
	@Override
	public void register(Enemy enemy) {
		this.enemy = enemy;
		
		if (GameData.getGameData().getMap().getRoads().length != 0)
			road = GameData.getGameData().getMap().getRoads()[currentRoadIndex];
	}
	
	public void collision() {
		
		// Each enemy will only look at the next road it will go on,
		// never the current road it is on.
		int j = currentRoadIndex + 1;
	
		// Make sure that the next road exists.
		if (j < GameData.getGameData().getMap().getRoads().length && GameData.getGameData().getMap().getRoads().length != 0) 
		{
			this.road = GameData.getGameData().getMap().getRoads()[j];
			
			// Check if that enemy has collided with the road.
			checkRoadCollision(this.road);
		}	
	}
	
	public void checkRoadCollision(Road r) 
	{
		// Check horizontal collision with a vertical road.
		if (r instanceof VerticalRoad) 
		{
			// If enemy is moving in the positive x direction.
			if (enemy.getXCoor() >= r.getXCoor() && enemy.getXDirection() == 1) 
			{
				// If the vertical road travels in the negative y direction,
				// make enemy travel in that direction. 
				if (enemy.getYCoor() >= r.getHalfWayCoor()) 
				{
					enemy.setXCoor(r.getXCoor());
					enemy.setXDirection(0);
					enemy.setYDirection(-1);
					++currentRoadIndex;
				}
				// If the vertical road travels in the positive y direction,
				// make enemy travel in that direction.
				else if (enemy.getYCoor() <= r.getHalfWayCoor()) 
				{
					enemy.setXCoor(r.getXCoor());
					enemy.setXDirection(0);
					enemy.setYDirection(1);
					++currentRoadIndex;
				}		
			}
			// If enemy is moving in the negative x direction
			else if (enemy.getXCoor() <= r.getXCoor() && enemy.getXDirection() == -1) 
			{
				// If the vertical road travels in the negative y direction,
				// make enemy travel in that direction.
				if (enemy.getYCoor() >= r.getHalfWayCoor()) 
				{
					enemy.setXCoor(r.getXCoor());
					enemy.setXDirection(0);
					enemy.setYDirection(-1);
					++currentRoadIndex;
				}
				// If the vertical road travels in the positive y direction,
				// make enemy travel in that direction.
				else if (enemy.getYCoor() <= r.getHalfWayCoor()) 
				{
					enemy.setXCoor(r.getXCoor());
					enemy.setXDirection(0);
					enemy.setYDirection(1);
					++currentRoadIndex;
				}		
			}
		}
		// Check vertical collision with a horizontal road
		else if (r instanceof HorizontalRoad) 
		{
			// If enemy is moving in the positive y direction.
			if (enemy.getYCoor() >= r.getYCoor() && enemy.getYDirection() == 1) 
			{
				// If the horizontal road travels in the negative x direction,
				// make enemy travel in that direction.
				if (enemy.getXCoor() >= r.getHalfWayCoor()) 
				{
					enemy.setYCoor(r.getYCoor());
					enemy.setXDirection(-1);
					enemy.setYDirection(0);
					++currentRoadIndex;
				}
				// If the horizontal road travels in the positive x direction,
				// make enemy travel in that direction.
				else if (enemy.getXCoor() <= r.getHalfWayCoor()) 
				{
					enemy.setYCoor(r.getYCoor());
					enemy.setXDirection(1);
					enemy.setYDirection(0);
					++currentRoadIndex;
				}		
			}
			// If enemy is moving in the negative y direction.
			else if (enemy.getYCoor() <= r.getYCoor() && enemy.getYDirection() == -1) 
			{
				// If the horizontal road travels in the negative x direction,
				// make enemy travel in that direction.
				if (enemy.getXCoor() >= r.getHalfWayCoor()) 
				{
					enemy.setYCoor(r.getYCoor());
					enemy.setXDirection(-1);
					enemy.setYDirection(0);
					++currentRoadIndex;
				}
				// If the horizontal road travels in the positive x direction,
				// make enemy travel in that direction.
				else if (enemy.getXCoor() <= r.getHalfWayCoor()) 
				{
					enemy.setYCoor(r.getYCoor());
					enemy.setXDirection(1);
					enemy.setYDirection(0);
					++currentRoadIndex;
				}		
			}
		}
	}	
}
