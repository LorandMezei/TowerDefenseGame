package game.Panels;

import game.GameData;
import game.Player;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfo_Panel extends JPanel {
		
	private int width, height;
	
	private JLabel playerHealthLabel;
	private JLabel playerMoneyLabel;
	
	private GameFrame gameFrame;

	public PlayerInfo_Panel(int width, int height, GameFrame gameFrame) {
		setWidth(width);
		setHeight(height);
		this.gameFrame = gameFrame;
		
		setLayout(new FlowLayout());
		
		playerHealthLabel = new JLabel("Health: " + Double.toString(GameData.getGameData().getPlayer().getHealth()));
		playerMoneyLabel = new JLabel("Money: $" + Double.toString(GameData.getGameData().getPlayer().getMoney()));
		
		add(playerHealthLabel);
		add(playerMoneyLabel);
	}
	
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }

}
