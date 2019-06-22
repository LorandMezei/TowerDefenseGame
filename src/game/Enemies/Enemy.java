package game.Enemies;

import game.IScreenData;
import game.CollisionMediators.EnemyRoad_Collision_Mediator;
import game.CollisionMediators.IEnemyCollisionMediator;
import game.MoveStrategies.BasicEnemy_Move_Strategy;
import game.MoveStrategies.IEnemyMoveStrategy;

import game.GameData;

public abstract class Enemy {
	
	// Default values for an Enemy.
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight;
	public static final int DEFAULT_XCOOR = GameData.getGameData().getMap().getRoads()[0].getXCoor();
	public static final int DEFAULT_YCOOR = GameData.getGameData().getMap().getRoads()[0].getYCoor();
	public static final int DEFAULT_HEALTH = 100;
	public static final int DEFAULT_XDIRECTION = 1;
	public static final int DEFAULT_YDIRECTION = 0;
	public static final int DEFAULT_MOVESPEED = 1;

	// Used for displaying graphics.
	private int xCoor, yCoor;
	private int width, height;
	
	// Used for health.
	private int health;
	
	// Used for movement of enemy.
	private int xDirection, yDirection, moveSpeed;
	
	// Used to determine how to move enemy.
	private IEnemyMoveStrategy moveStrategy;
	// Used to determine how to collide with road.
	private IEnemyCollisionMediator enemyCollisionMediator;
	
	// Super class constructor with no values passed.
	public Enemy() {
		setXCoor(DEFAULT_XCOOR);
		setYCoor(DEFAULT_YCOOR);
		
		setWidth(DEFAULT_WIDTH);
		setHeight(DEFAULT_HEIGHT);
		
		setXDirection(DEFAULT_XDIRECTION);
		setYDirection(DEFAULT_YDIRECTION);
		setMoveSpeed(DEFAULT_MOVESPEED);
		
		setMoveStrategy(new BasicEnemy_Move_Strategy());
		setEnemyCollisionMediator(new EnemyRoad_Collision_Mediator());
		
	}
	
	// Used to update current state of enemy.
	public void update() {
		checkCollision();
		move();
	}
	
	// Used to call the collision mediator's implementation.
	public void checkCollision() {
		enemyCollisionMediator.register(this);
		enemyCollisionMediator.collision();
	}
	
	// Used to call the move strategy's implementation.
	public void move() {
		moveStrategy.move(this);
	}
	
	// Setter methods for superclass variables.
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setXDirection(int xDirection) { this.xDirection = xDirection; }
	public void setYDirection(int yDirection) { this.yDirection = yDirection; }
	public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }
	public void setMoveStrategy(IEnemyMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; }
	public void setEnemyCollisionMediator(IEnemyCollisionMediator enemyCollisionMediator) { this.enemyCollisionMediator = enemyCollisionMediator; }

	// Setter methods for superclass variables.
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getHealth() { return this.health; }
	public int getXDirection() { return this.xDirection; }
	public int getYDirection() { return this.yDirection; }
	public int getMoveSpeed() { return this.moveSpeed; }
	public IEnemyMoveStrategy getMoveStrategy() { return this.moveStrategy; }
}
