package game.Projectiles;

import game.IScreenData;
import game.Enemies.Enemy;
import game.MoveStrategies.BresenhamProjectile_Move_Strategy;
import game.MoveStrategies.IProjectileMoveStrategy;
import game.Projectiles.Projectile;
import game.Towers.Tower;

public abstract class Projectile {
	
	// Default values for a Projectile.
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth / 4;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight / 4;
	
	// Used for communication to the Tower object THIS projectile originated from.
	private Tower tower;
	// Used to get data from the enemy the projectile is targetting.
	private Enemy enemy;
	
	// Used for displaying graphics.
	private int xCoor, yCoor;
	private int width, height;
	
	// Used to determine how to move the projectile.
	private IProjectileMoveStrategy moveStrategy;
	private int maxDisplacement;
	
	// Super class constructor only needs to be passed values for tower and enemy.
	public Projectile(Tower tower, Enemy enemy) {
		setTower(tower);
		setEnemy(enemy);
		
		setXCoor(tower.getXCoor());
		setYCoor(tower.getYCoor());
		
		setWidth(DEFAULT_WIDTH);
		setHeight(DEFAULT_HEIGHT);
		
		setMaxDisplacement(300);
		setMoveStrategy(new BresenhamProjectile_Move_Strategy());
	}
	
	// Used to update current state of projectile.
	public void update() {
		move();
	}
	
	// Used to call the move strategy's implementation.
	public void move() {
		moveStrategy.move(this, enemy);
	}
	
	// Setter methods for superclass variables.
	public void setTower(Tower tower) { this.tower = tower; }
	public void setEnemy(Enemy enemy) { this.enemy = enemy; }
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setMaxDisplacement(int maxDisplacement) { this.maxDisplacement = maxDisplacement; }
	public void setMoveStrategy(IProjectileMoveStrategy moveStrategy) { this.moveStrategy = moveStrategy; }
	
	// Getter methods for superclass variables.
	public Tower getTower() { return this.tower; }
	public Enemy getEnemy() { return this.enemy; }
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getMaxDisplacement() { return this.maxDisplacement; }
	public IProjectileMoveStrategy getMoveStrategy() { return this.moveStrategy; }
}
