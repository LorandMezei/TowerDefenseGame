package game.Towers;

public class TowerFactory {
	public static Tower create(int buttonIndex, int xCoor, int yCoor) {
		
		switch(buttonIndex) {
		case 1: 
			return new Gunner(xCoor, yCoor);
		case 2:
			return new Cannoneer(xCoor, yCoor);
		default:
			System.out.println("Error in TowerFactory");
			}
		
		return null;
	}
}
