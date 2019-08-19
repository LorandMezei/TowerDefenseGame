package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import game.Enemies.Enemy;
import game.Maps.Road;

public class GameLogic 
{
	// Timer used to add enemies.
	private Timer addEnemyTimer;

	//------------------ Singleton --------------------------
	private static GameLogic gameLogic = null;
	private GameLogic() {
		addEnemyTimer = new Timer(1000, new AddEnemyEvent());
		addEnemyTimer.start();
		GameData.getGameData().addEnemy(new Enemy());
	}
	public static GameLogic getGameLogic() {
		if (gameLogic == null) 
			gameLogic = new GameLogic(); 
  
        return gameLogic;
	}
	//-------------------------------------------------------
	
	//---------------------------------------------------
	// Action listener used to add enemies using a timer.
	private class AddEnemyEvent implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GameData.getGameData().addEnemy(new Enemy());
		}
	}
	//---------------------------------------------------
}
