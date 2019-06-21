package game;

public class Player {
	private double health, money;
	
	public Player(double health, double money) {
		setHealth(health);
		setMoney(money);
	}
	
	public void setHealth(double health) { this.health = health; }
	public void setMoney(double money) { this.money = money; }
	
	public double getHealth() { return this.health; }
	public double getMoney() { return this.money; }
}
