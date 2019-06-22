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
			// Get the x value to move to.
			int moveToX = enemy.getXCoor() + ( (projectile.getXCoor() + projectile.getMaxDisplacement()) + 
											   (enemy.getXCoor() - projectile.getXCoor()) 
											 );
			// Using linear extrapolation formula to get the y value to move to.
			int moveToY = projectile.getYCoor() + (((moveToX - projectile.getXCoor())/(enemy.getXCoor() - projectile.getXCoor()))*((enemy.getYCoor() - projectile.getYCoor())));
			
			// Create the x and y path for the projectile to move along.
			bresenham(projectile.getXCoor(), projectile.getYCoor(), moveToX, moveToY);
			setTracking = true;
			
			System.out.println(moveToX + "," + moveToY);
		}
		
		if (currentFrame < xPath.size()) {
			 // Move projectile based on frame since projectile was created.
			projectile.setXCoor(xPath.get(currentFrame));
			projectile.setYCoor(yPath.get(currentFrame));
			
			currentFrame++;
		}		
	}
	
	// function for line generation 
    public void bresenham(int x1, int y1, int x2, int y2) 
    { 
    	
        int m_new = 2 * (y2 - y1); 
        int slope_error_new = m_new - (x2 - x1); 
      
        for (int x = x1, y = y1; x <= x2; x++) 
        { 
            //System.out.print("(" +x + "," + y + ")\n");
            xPath.add(x);
            yPath.add(y);
            
  
            // Add slope to increment angle formed 
            slope_error_new += m_new; 
  
            // Slope error reached limit, time to 
            // increment y and update slope error. 
            if (slope_error_new >= 0) 
            { 
                y++; 
                slope_error_new -= 2 * (x2 - x1); 
            } 
        } 
    }
}
