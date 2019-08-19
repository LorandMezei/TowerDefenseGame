package game.Maps;

public class Road {
	private int xCoor, yCoor, width, height;
	
	private boolean isHorizontal;
	private int halfWayCoor;
	
	public Road(int xCoor, int yCoor, int width, int height) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.width = width;
		this.height = height;
		
		if (width > height) {
			isHorizontal = true;
			this.halfWayCoor = (xCoor + (width/2));
		}
		else {
			isHorizontal = false;
			this.halfWayCoor = (yCoor + (height/2));
		}
	}
	
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getHalfWayCoor() { return halfWayCoor; }
	public boolean getIsHorizontal() { return this.isHorizontal;
	}
}
