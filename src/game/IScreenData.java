package game;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface IScreenData {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();
    int tileWidth = screenWidth / 50;
    int tileHeight = screenHeight / 25;
	
}
