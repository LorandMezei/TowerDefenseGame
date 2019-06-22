package game.MoveStrategies;

import java.util.ArrayList;

import game.Enemies.Enemy;
import game.Projectiles.Projectile;

public class BresenhamProjectile_Move_Strategy implements IProjectileMoveStrategy {

	private ArrayList<Integer> xPath = new ArrayList<>();
	private ArrayList<Integer> yPath = new ArrayList<>();
	
	private boolean setTracking = false;
	private int currentFrame = 0;
	
	@Override
	public void move(Projectile projectile, Enemy enemy) {
		
		if (setTracking == false) {
			
			int moveToX = enemy.getXCoor();
			int moveToY = enemy.getYCoor();

			// Create the x and y path for the projectile to move along.
			bresenham(projectile.getXCoor(), projectile.getYCoor(), moveToX, moveToY);
			
			setTracking = true;
		}
		
		if (currentFrame < xPath.size()) {
			 // Move projectile based on frame since projectile was created.
			projectile.setXCoor(xPath.get(currentFrame));
			projectile.setYCoor(yPath.get(currentFrame));
			
			currentFrame++;
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
}
