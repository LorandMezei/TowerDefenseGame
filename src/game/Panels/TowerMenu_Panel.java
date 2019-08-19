package game.Panels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import game.GameData;
import game.Towers.Tower;

public class TowerMenu_Panel extends JPanel 
{	
	private int width, height;
	private int mouseX, mouseY;
	
	private JButton towerButton;
	
	private GameFrame gameFrame;
	
	public TowerMenu_Panel(int width, int height, GameFrame gameFrame) 
	{
		setWidth(width);
		setHeight(height);
		this.gameFrame = gameFrame;
		
		towerButton = new JButton("Add Tower");
		
		towerButton.addActionListener(
				e -> GameData.getGameData()
					.addTower(new Tower(gameFrame.getDrawGraphicsPanel().getMouseX(), 
									    gameFrame.getDrawGraphicsPanel().getMouseY())));
		
		add(towerButton);
		
		addMouseListener(new MouseClickEvent());
		addMouseMotionListener(new MouseMotionEvent());
	}
	
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setMouseX(int x) { this.mouseX = x; } 
	public void setMouseY(int y) { this.mouseY = y; } 
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getMouseX() { return this.mouseX; } 
	public int getMouseY() { return this.mouseY; } 
	
	//----------------------------------------------------
	private class MouseClickEvent implements MouseListener
	{		
		@Override
		public void mouseClicked(MouseEvent e) {}
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
