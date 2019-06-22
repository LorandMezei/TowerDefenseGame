package game.Enemies;

public class EnemyFactory {
	public static Enemy create(int round) {
		switch (1) {
		case 1:
			return new BasicEnemy();
		default:
			System.out.println("Error in TowerFactory");
	    }
	
		return null;
	}
}
