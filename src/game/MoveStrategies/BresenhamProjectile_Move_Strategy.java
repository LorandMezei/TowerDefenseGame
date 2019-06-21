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
			bresenham(projectile.getXCoor(), projectile.getYCoor(),
					   enemy.getXCoor(), enemy.getYCoor());
		}
		
		projectile.setXCoor(xPath.get(currentFrame));
		projectile.setYCoor(yPath.get(currentFrame));
	}
	
	// function for line generation 
    public void bresenham(int x1, int y1, int x2, int y2) 
    { 
    	ArrayList<Integer> xPath = new ArrayList<>();
    	ArrayList<Integer> yPath = new ArrayList<>();
    
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
