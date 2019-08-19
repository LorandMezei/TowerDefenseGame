package game;

import game.Panels.GameFrame;

public class Main {

	public static void main(String[] args) {	
		GameData gameData = GameData.getGameData();
		GameLogic gameLogic = GameLogic.getGameLogic();
		GameFrame frame = new GameFrame();
	}
}
