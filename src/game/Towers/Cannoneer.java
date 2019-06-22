package game.Towers;

import game.DetectStrategies.*;

public class Cannoneer extends Tower {
		
	public Cannoneer(int xCoor, int yCoor) { 
		super(xCoor, yCoor);
		
		setWidth(Tower.DEFAULT_WIDTH);
		setHeight(Tower.DEFAULT_HEIGHT);
		
		setDetectStrategy(new Close_Detect_Strategy());
	}
}
