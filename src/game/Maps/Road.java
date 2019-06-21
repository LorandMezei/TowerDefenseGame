package game.Maps;

public abstract class Road {
	private int xCoor, yCoor, width, height, halfWayCoor;
	
	public Road(int xCoor, int yCoor, int width, int height) {
		setXCoor(xCoor);
		setYCoor(yCoor);
		setWidth(width);
		setHeight(height);
		setHalfWayCoor();
	}
	
	public void setXCoor(int xCoor) { this.xCoor = xCoor; }
	public void setYCoor(int yCoor) { this.yCoor = yCoor; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setHalfWayCoor() { this.halfWayCoor = this.yCoor + (this.height/2); }
	
	public int getXCoor() { return this.xCoor; }
	public int getYCoor() { return this.yCoor; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public int getHalfWayCoor() { return halfWayCoor; }
}
