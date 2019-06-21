package game.Panels;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.GameData;
import game.IScreenData;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;
import game.Towers.Tower;


public class GameFrame extends JFrame {
	
	private DrawGraphics_Panel drawGraphicsPanel;
	private PlayerInfo_Panel playerInfoPanel;
	private TowerMenu_Panel towerMenuPanel;
	
	private Timer updateFrameEventTimer;
	
	public GameFrame() {
		setLayout(new BorderLayout());
		setSize(IScreenData.screenWidth, IScreenData.screenHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildDrawGraphicsPanel();
		buildPlayerInfoPanel();
		buildTowerMenuPanel();
	
		buildUpdateFrameEventTimer();
		
		setVisible(true);
	}
	
	public void buildDrawGraphicsPanel() {
		drawGraphicsPanel = new DrawGraphics_Panel(IScreenData.screenWidth, IScreenData.screenHeight / 2, this);
		drawGraphicsPanel.setPreferredSize(new Dimension(drawGraphicsPanel.getWidth(), 
														 drawGraphicsPanel.getHeight()));
		drawGraphicsPanel.setBackground(Color.LIGHT_GRAY);
		add(drawGraphicsPanel, BorderLayout.CENTER);
	}
	
	public void buildPlayerInfoPanel() {
		playerInfoPanel = new PlayerInfo_Panel(IScreenData.screenWidth, IScreenData.screenHeight / 16, this);
		playerInfoPanel.setPreferredSize(new Dimension(playerInfoPanel.getWidth(), playerInfoPanel.getHeight()));
		playerInfoPanel.setBackground(Color.CYAN);
		add(playerInfoPanel, BorderLayout.NORTH);
	}
	
	public void buildTowerMenuPanel() {
		towerMenuPanel = new TowerMenu_Panel(IScreenData.screenWidth, IScreenData.screenHeight / 8, this);
		towerMenuPanel.setPreferredSize(new Dimension(towerMenuPanel.getWidth(), towerMenuPanel.getHeight()));
		towerMenuPanel.setBackground(Color.CYAN);
		add(towerMenuPanel, BorderLayout.SOUTH);
	}
	
	public void buildUpdateFrameEventTimer() {
		updateFrameEventTimer = new Timer(1, new UpdateFrameEvent());
		updateFrameEventTimer.start();
	}
	
	public DrawGraphics_Panel getDrawGraphicsPanel() { return drawGraphicsPanel; }
	public PlayerInfo_Panel getPlayerInfoPanel() { return playerInfoPanel; }
	public TowerMenu_Panel getTowerMenuPanel() { return towerMenuPanel; }
	
	//------------------------------------------------------
	private class UpdateFrameEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			for (Enemy enemy: GameData.getGameData().getEnemies()) {
				enemy.update();
			}
			
			for (Tower tower: GameData.getGameData().getTowers()) {
				tower.update();
				for (Projectile projectile: tower.getProjectiles())
				{
					projectile.update();
				}
			}
		
			repaint();
		}
	}	
}
