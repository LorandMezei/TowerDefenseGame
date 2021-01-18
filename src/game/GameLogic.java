package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import game.Enemies.Enemy;
import game.Maps.Road;
import game.Panels.GameFrame;
import game.Projectiles.Projectile;
import game.Towers.Tower;

public class GameLogic 
{
	// Timer used to add enemies.
	private Timer addEnemyTimer;
	
	// Timer used to update a frame for the game.
	private Timer updateFrameEventTimer;

	//------------------ Singleton ----------------------------------
	private static GameLogic gameLogic = null;
	private GameLogic() {
		addEnemyTimer = new Timer(1000, new AddEnemyEvent());
		addEnemyTimer.start();
		
		buildUpdateFrameEventTimer();
	}
	public static GameLogic getGameLogic() {
		if (gameLogic == null) 
			gameLogic = new GameLogic(); 
  
        return gameLogic;
	}
	
	public void buildUpdateFrameEventTimer() {
		updateFrameEventTimer = new Timer(1, new UpdateFrameEvent());
		updateFrameEventTimer.start();
	}
	//---------------------------------------------------------------
	
	//---------------------------------------------------
	// Action listener used to add enemies using a timer.
	private class AddEnemyEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ArrayList<Round> rounds = GameData.getGameData().getRounds();
		
			if (Round.currentRound < rounds.size()) 
			{
				Round round = rounds.get(Round.currentRound);
				
				if (round.roundEnemies.size() > 0) {
					Enemy e = round.roundEnemies.remove(0);
					GameData.getGameData().addEnemy(e);
				}
				else
					Round.currentRound++;
			}
		}
	}
	//---------------------------------------------------
	
	//------------------------------------------------------
	// Action listener used to update a frame using a timer.
	private class UpdateFrameEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			GameFrame.getGameFrame().updateFrame();
		}
	}
	//------------------------------------------------------
}
