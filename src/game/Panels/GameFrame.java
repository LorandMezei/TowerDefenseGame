package game.Panels;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import game.GameData;
import game.IScreenData;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;
import game.Towers.Tower;


public class GameFrame extends JFrame 
{	
	private DrawGraphics_Panel drawGraphicsPanel;
	private PlayerInfo_Panel playerInfoPanel;
	private TowerMenu_Panel towerMenuPanel;
		
	//------------------ Singleton --------------------------------
	private static GameFrame gameFrame = null;
	private GameFrame() {
		setLayout(new BorderLayout());
		setSize(IScreenData.screenWidth, IScreenData.screenHeight);
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildDrawGraphicsPanel();
		buildPlayerInfoPanel();
		buildTowerMenuPanel();
		
		setVisible(true);
	}
	public static GameFrame getGameFrame() {
		if (gameFrame == null) 
			gameFrame = new GameFrame(); 
  
        return gameFrame;
	}
	//-------------------------------------------------------------
	
	public void buildDrawGraphicsPanel() {
		drawGraphicsPanel = new DrawGraphics_Panel(IScreenData.screenWidth, (int)(IScreenData.screenHeight * (.7)), this);
		drawGraphicsPanel.setPreferredSize(new Dimension(drawGraphicsPanel.getWidth(), 
														 drawGraphicsPanel.getHeight()));
		drawGraphicsPanel.setBackground(Color.LIGHT_GRAY);
		add(drawGraphicsPanel, BorderLayout.CENTER);
	}
	
	public void buildPlayerInfoPanel() {
		playerInfoPanel = new PlayerInfo_Panel(IScreenData.screenWidth, (int)(IScreenData.screenHeight * (0.1)), this);
		playerInfoPanel.setPreferredSize(new Dimension(playerInfoPanel.getWidth(), playerInfoPanel.getHeight()));
		playerInfoPanel.setBackground(Color.CYAN);
		add(playerInfoPanel, BorderLayout.NORTH);
	}
	
	public void buildTowerMenuPanel() {
		towerMenuPanel = new TowerMenu_Panel(IScreenData.screenWidth, (int)(IScreenData.screenHeight * (0.1)), this);
		towerMenuPanel.setPreferredSize(new Dimension(towerMenuPanel.getWidth(), towerMenuPanel.getHeight()));
		towerMenuPanel.setBackground(Color.CYAN);
		add(towerMenuPanel, BorderLayout.SOUTH);
	}
	
	public void updateFrame() {
		for (Enemy enemy: GameData.getGameData().getEnemies()) {
			enemy.update();
		}
		
		for (Tower tower: GameData.getGameData().getTowers()) 
		{
			tower.update();
			
			for (Projectile projectile: tower.getProjectiles())
			{
				projectile.update();
			}
		}
	
		repaint();
	}
	
	public DrawGraphics_Panel getDrawGraphicsPanel() { return drawGraphicsPanel; }
	public PlayerInfo_Panel getPlayerInfoPanel() { return playerInfoPanel; }
	public TowerMenu_Panel getTowerMenuPanel() { return towerMenuPanel; }	
}
