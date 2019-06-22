package game.Towers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import game.DetectStrategies.*;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;
import game.Projectiles.ProjectileFactory;
import game.IScreenData;

public abstract class Tower {	
	
	// Default values for a Tower.
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight;
	
	// Used for displaying graphics.
	private int xCoor, yCoor;
	private int width, height;
	private Color color;
		
	// Used to determine how to detect an enemy.
	private IDetectStrategy detectStrategy;
	
	// Used for attacking enemies.
	private int attackSpeed; 
    private int attackRadius;
	private boolean canShoot;
	private Timer attackEnemyTimer; 
	private ArrayList<Projectile> projectiles = new ArrayList<>();

	// Super class constructor only needs to be passed values for xCoor and yCoor.
	public Tower(int xCoor, int yCoor) {
		setXCoor(xCoor);
		setYCoor(yCoor);
		
		setColor(Color.BLUE);
		
		setAttackSpeed(500);
		setAttackRadius((DEFAULT_WIDTH + DEFAULT_HEIGHT)*5);
		setCanShoot(false);
		setAttackEnemyTimer();
	}
	
	// Used to update current state of tower.
	public void update() {
		attack();
	}
	
	// Used to call the detect strategy's implementation.
	public Enemy detect() { 
		return getDetectStrategy().detect(this); }
	
	// Used to attack enemies.
	public void attack() {
		Enemy enemy = detect();
		if (enemy != null) {
			if (getCanShoot()) {
				createProjectile(enemy);
				setCanShoot(false);
			}
		}
	}
	
	// Used to create a projectile.
	public void createProjectile(Enemy enemy) {
		getProjectiles().add(ProjectileFactory.create(this, enemy));
	}
		
	// Setter methods for superclass variables.
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setColor(Color color) { this.color = color; }
	public void setAttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; }
	public void setAttackRadius(int attackRadius) { this.attackRadius = attackRadius; }
	public void setAttackEnemyTimer() { this.attackEnemyTimer = new Timer(this.attackSpeed, new AttackEvent()); this.attackEnemyTimer.start(); }
	public void setCanShoot(boolean canShoot) { this.canShoot = canShoot; }
	public void setDetectStrategy(IDetectStrategy detectStrategy) { this.detectStrategy = detectStrategy; }
	
	// Getter methods for superclass variables.
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public Color getColor() { return this.color; }
	public int getAttackSpeed() { return this.attackSpeed; }
	public int getAttackRadius() { return this.attackRadius; }
	public Timer getAttackEnemyTimer() { return this.attackEnemyTimer; }
	public boolean getCanShoot() { return this.canShoot; }
	public IDetectStrategy getDetectStrategy() { return this.detectStrategy; }
	public ArrayList<Projectile> getProjectiles() { return this.projectiles; }
	
	//-------------------------------------------------
	private class AttackEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setCanShoot(true);
		}
	}
	//-------------------------------------------------
}
