package game.Panels;

import game.GameData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

import game.GameData;
import game.IScreenData;
import game.Enemies.Enemy;
import game.Maps.Map;
import game.Maps.Road;
import game.Projectiles.Projectile;
import game.Towers.Tower;

public class DrawGraphics_Panel extends JPanel {
	
	private int width, height;
	private int mouseX, mouseY;
	
	private GameFrame gameFrame;
	
	public DrawGraphics_Panel(int width, int height, GameFrame gameFrame) {
		setWidth(width);
		setHeight(height);
		this.gameFrame = gameFrame;
		
		addMouseListener(new MouseClickEvent());
		addMouseMotionListener(new MouseMotionEvent());
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawMap(g);
		drawEnemies(g);
		drawTowers(g);
		drawProjectiles(g);
	}
	
	public void drawMap(Graphics g) {
		g.setColor(Color.BLACK);
		Map map = GameData.getGameData().getMap();
		for (Road road: map.getRoads()) {
			g.fillRect(road.getXCoor(), road.getYCoor(), 
					   road.getWidth(), road.getHeight());
		}
	}
	
	public void drawEnemies(Graphics g) {
		g.setColor(Color.RED);
		
		for (Enemy enemy: GameData.getGameData().getEnemies()) {
			g.fillRect(enemy.getXCoor(), enemy.getYCoor(), 
					   enemy.getWidth(), enemy.getHeight());
		}
	}
	
	public void drawTowers(Graphics g) {
		for (Tower tower: GameData.getGameData().getTowers()) {
			g.setColor(tower.getColor());
			g.fillRect(tower.getXCoor(), tower.getYCoor(), 
					   tower.getWidth(), tower.getHeight());
			
			g.drawOval(tower.getXCoor() - tower.getAttackRadius(), 
					   tower.getYCoor() - tower.getAttackRadius(), 
					   tower.getAttackRadius()*2, tower.getAttackRadius()*2);	
		}
	}
	
	public void drawProjectiles(Graphics g) {
		g.setColor(Color.BLUE);
		for (Tower tower: GameData.getGameData().getTowers()) 
		{
			for (Projectile projectile: tower.getProjectiles()) 
			{
				g.fillRect(projectile.getXCoor(), projectile.getYCoor(), 
						   projectile.getWidth(), projectile.getHeight());
			}
		}
	}
	
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setMouseX(int x) { mouseX = x; } 
	public void setMouseY(int y) { mouseY = y; } 
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getMouseX() { return mouseX; } 
	public int getMouseY() { return mouseY; } 
	
	//----------------------------------------------------
	private class MouseClickEvent implements MouseListener
	{		
		@Override
		public void mouseClicked(MouseEvent e) {
			setMouseX(e.getX());
			setMouseY(e.getY());
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	private class MouseMotionEvent implements MouseMotionListener 
	{
		@Override
		public void mouseDragged(MouseEvent arg0) {}
		@Override
		public void mouseMoved(MouseEvent e) {}
	}
}
