package game.Projectiles;

import game.IScreenData;
import game.AttackStrategies.IAttackStrategy;
import game.DamageStrategies.IDamageStrategy;
import game.DetectStrategies.IDetectStrategy;
import game.Enemies.Enemy;
import game.MoveStrategies.IEnemyMoveStrategy;
import game.MoveStrategies.IProjectileMoveStrategy;
import game.Projectiles.Projectile;

public abstract class Projectile {
	
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth / 4;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight / 4;
	public static final int DEFAULT_XCOOR = IScreenData.screenWidth / 2;
	public static final int DEFAULT_YCOOR = IScreenData.screenHeight / 2;
	public static final int DEFAULT_XDIRECTION = 1;
	public static final int DEFAULT_YDIRECTION = 0;
	public static final int DEFAULT_MOVESPEED = 3;
	
	private int xCoor, yCoor, width, height;
	
	private int xDirection, yDirection, moveSpeed;
	
	private IProjectileMoveStrategy moveStrategy;
	private IDamageStrategy damageStrategy;
	private Enemy enemy;
	
	public Projectile() {};
	
	public void update() {
		move();
	}
	
	public void move() {
		moveStrategy.move(this, enemy);
	}
	
	public Projectile XCoor(int xCoor) { this.xCoor = xCoor; return this; }
	public Projectile YCoor(int yCoor) { this.yCoor = yCoor; return this; }
	public Projectile Width(int width) { this.width = width; return this; }
	public Projectile Height(int height) { this.height = height; return this; }
	public Projectile XDirection(int xDirection) { this.xDirection = xDirection; return this; }
	public Projectile YDirection(int yDirection) { this.yDirection = yDirection; return this; }
	public Projectile MoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; return this; }
	public Projectile MoveStrategy(IProjectileMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; return this; }
	public Projectile DamageStrategy(IDamageStrategy damageStrategy) { this.damageStrategy = damageStrategy; return this; }
	public Projectile Enemy(Enemy enemy) { this.enemy = enemy; return this; }
	
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setXDirection(int xDirection) { this.xDirection = xDirection; }
	public void setYDirection(int yDirection) { this.yDirection = yDirection; }
	public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }
	public void setMoveStrategy(IProjectileMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; }
	public void setDamageStrategy(IDamageStrategy damageStrategy) { this.damageStrategy = damageStrategy; }
	public void setEnemy(Enemy enemy) { this.enemy = enemy; }
	
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getXDirection() { return this.xDirection; }
	public int getYDirection() { return this.yDirection; }
	public int getMoveSpeed() { return this.moveSpeed; }
	public IDamageStrategy getDamageStrategy() { return this.damageStrategy; }
	public IProjectileMoveStrategy getMoveStrategy() { return this.moveStrategy; }
	public Enemy getEnemy() { return this.enemy; }
}
