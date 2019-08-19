package game.MoveStrategies;

import java.util.ArrayList;

import game.GameData;
import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public class BresenhamProjectile_MoveStrategy implements IProjectileMoveStrategy {

	private ArrayList<Integer> xPath = new ArrayList<>();
	private ArrayList<Integer> yPath = new ArrayList<>();
	
	private boolean setTracking = false;
	private int currentFrame = 0;
	
	@Override
	public void move(Projectile projectile, Enemy enemy) {
		
		if (setTracking == false) {
			
			int moveToX = getMaxCoordinates(projectile, enemy)[0];
			int moveToY = getMaxCoordinates(projectile, enemy)[1];
			
			// Create the x and y path for the projectile to move along.
			bresenham(projectile.getXCoor(), projectile.getYCoor(), moveToX, moveToY);
			
			setTracking = true;
		}
		
		if (currentFrame < xPath.size()) {
			// Move projectile based on frame since projectile was created.
			projectile.setXCoor(xPath.get(currentFrame));
			projectile.setYCoor(yPath.get(currentFrame));
			
			currentFrame += projectile.getMoveSpeed();
		}	
		
		else if (currentFrame >= xPath.size()) {
			projectile.setXCoor(xPath.get(xPath.size() - 1));
			projectile.setYCoor(yPath.get(yPath.size() - 1));
			
		}			
	}
	
	// function for line generation 
    public void bresenham(int x0, int y0, int x1, int y1) 
    { 
    	 
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
 
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
 
        while (true) 
        {
            xPath.add(x0);
            yPath.add(y0);
 
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }                                
    }
    
    public int[] getMaxCoordinates(Projectile projectile, Enemy enemy) {
		
    	// Distance from projectile origin to enemy.
    	double distance_A = Math.abs(Math.sqrt( (Math.pow(enemy.getXCoor() - projectile.getXCoor(), 2)) + 
    								   (Math.pow(enemy.getYCoor() - projectile.getYCoor(), 2)) ));
    	
    	// How much more the projectile can move after reaching enemy distance.
    	double distance_Z = Math.abs(projectile.getMaxDisplacement() - distance_A);
    	
    	int opposite_Q = enemy.getYCoor() - projectile.getYCoor(); // y1 - y0 = deltaY
		int adjacent_P = enemy.getXCoor() - projectile.getXCoor(); // x1 - x0 = deltaX
		
		double angle_Theta = Math.atan2(opposite_Q, adjacent_P); 
    	
    	int x_increase = (int) (Math.cos(angle_Theta) * distance_Z);
    	int y_increase = (int) (Math.sin(angle_Theta) * distance_Z);
    		
        int[] points = new int[2];
    	points[0] = enemy.getXCoor() + x_increase;
    	points[1] = enemy.getYCoor() + y_increase;
    	
    	return points;
	}
}