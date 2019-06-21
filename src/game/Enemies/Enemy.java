package game.Enemies;

import game.IScreenData;
import game.AttackStrategies.IAttackStrategy;
import game.CollisionMediators.IEnemyCollisionMediator;
import game.DetectStrategies.IDetectStrategy;
import game.MoveStrategies.IEnemyMoveStrategy;

import java.awt.Color;

import javax.swing.Timer;

import game.GameData;

public abstract class Enemy {
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight;
	public static final int DEFAULT_XCOOR = GameData.getGameData().getMap().getRoads()[0].getXCoor();
	public static final int DEFAULT_YCOOR = GameData.getGameData().getMap().getRoads()[0].getYCoor();
	public static final int DEFAULT_HEALTH = 100;
	public static final int DEFAULT_XDIRECTION = 1;
	public static final int DEFAULT_YDIRECTION = 0;
	public static final int DEFAULT_MOVESPEED = 3;

	private int xCoor, yCoor, width, height;
	private int health;
	
	private int xDirection, yDirection, moveSpeed;
	
	private IEnemyMoveStrategy moveStrategy;
	private IEnemyCollisionMediator enemyCollisionMediator;
	
	public Enemy() {}
	
	public void update() {
		checkCollision();
		move();
	}
	
	public void checkCollision() {
		enemyCollisionMediator.register(this);
		enemyCollisionMediator.collision();
	}
	
	public void move() {
		moveStrategy.move(this);
	}
	
	public void takeDamage(int damage) {
		this.health -= damage;
		
	}
	
	public Enemy XCoor(int xCoor) { this.xCoor = xCoor; return this; }
	public Enemy YCoor(int yCoor) { this.yCoor = yCoor; return this; }
	public Enemy Width(int width) { this.width = width; return this; }
	public Enemy Height(int height) { this.height = height; return this; }
	public Enemy Health(int health) { this.health = health; return this; }
	public Enemy XDirection(int xDirection) { this.xDirection = xDirection; return this; }
	public Enemy YDirection(int yDirection) { this.yDirection = yDirection; return this; }
	public Enemy MoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; return this; }
	public Enemy MoveStrategy(IEnemyMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; return this; }
	public Enemy EnemyCollisionMediator(IEnemyCollisionMediator enemyCollisionMediator) { this.enemyCollisionMediator = enemyCollisionMediator; return this; }
	
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setXDirection(int xDirection) { this.xDirection = xDirection; }
	public void setYDirection(int yDirection) { this.yDirection = yDirection; }
	public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }
	public void setMoveStrategy(IEnemyMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; }
	public void setEnemyCollisionMediator(IEnemyCollisionMediator enemyCollisionMediator) { this.enemyCollisionMediator = enemyCollisionMediator; }

	
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
