package game.Towers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import game.MoveStrategies.*;
import game.AttackStrategies.*;
import game.DetectStrategies.*;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;
import game.Projectiles.ProjectileFactory;
import game.IScreenData;

public abstract class Tower {	
	
	public static final int DEFAULT_WIDTH = IScreenData.tileWidth;
	public static final int DEFAULT_HEIGHT = IScreenData.tileHeight;
	public static final int DEFAULT_XCOOR = IScreenData.screenWidth / 2;
	public static final int DEFAULT_YCOOR = IScreenData.screenHeight / 2;
	public static final int DEFAULT_ATTACKSPEED = 1000;
	public static final int DEFAULT_ATTACKRADIUS = (DEFAULT_WIDTH + DEFAULT_WIDTH) * 3;
	
	private int xCoor, yCoor, width, height;
	private Color color;
	
	private int attackSpeed; 
    private int attackRadius;
	private boolean canShoot = false;
	
	private Timer attackEnemyTimer; 
	
	private IDetectStrategy detectStrategy;
	private IAttackStrategy attackStrategy;
	private ArrayList<Projectile> projectiles = new ArrayList<>();

	public Tower() {}
	
	public void update() {
		Enemy enemy = detect();
		if (enemy != null)
			attack(enemy);
	}
	
	public Enemy detect() { 
		return getDetectStrategy().detect(this); }
	
	public void attack(Enemy enemy) { 
		getAttackStrategy().attack(this, enemy); }
	
	public void createProjectile(Enemy enemy) {
		getProjectiles().add(ProjectileFactory.create(this, enemy));
	}
	public void removeProjectile(int index) {
		getProjectiles().remove(index);
	}
	
	public Tower XCoor(int xCoor) { this.xCoor = xCoor; return this; }
	public Tower YCoor(int yCoor) { this.yCoor = yCoor; return this; }
	public Tower Width(int width) { this.width = width; return this; }
	public Tower Height(int height) { this.height = height; return this; }
	public Tower Color(Color color) { this.color = color; return this; }
	public Tower AttackSpeed(int attackSpeed) { this.attackSpeed = attackSpeed; return this; }
	public Tower AttackRadius(int attackRadius) { this.attackRadius = attackRadius; return this; }
	public Tower AttackEnemyTimer() { this.attackEnemyTimer = new Timer(this.attackSpeed, new AttackEvent()); this.attackEnemyTimer.start(); return this; }
	public Tower CanShoot(boolean canShoot) { this.canShoot = canShoot; return this; }
	public Tower DetectStrategy(IDetectStrategy detectStrategy) { this.detectStrategy = detectStrategy; return this; }
	public Tower AttackStrategy(IAttackStrategy attackStrategy) { this.attackStrategy = attackStrategy; return this; }
	
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
	public void setAttackStrategy(IAttackStrategy attackStrategy) { this.attackStrategy = attackStrategy; }
	
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
	public IAttackStrategy getAttackStrategy() { return this.attackStrategy; }
	public ArrayList<Projectile> getProjectiles() { return this.projectiles; }
	
	//-------------------------------------------------
	private class AttackEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			canShoot = true;
		}
	}
	//-------------------------------------------------
}
