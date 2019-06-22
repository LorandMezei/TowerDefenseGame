package game.Towers;

import game.DetectStrategies.*;

public class Gunner extends Tower {
	
	public Gunner (int xCoor, int yCoor) { 
		super(xCoor, yCoor);
		
		setWidth(Tower.DEFAULT_WIDTH);
		setHeight(Tower.DEFAULT_HEIGHT);
		
		setDetectStrategy(new First_Detect_Strategy());
	}
}
