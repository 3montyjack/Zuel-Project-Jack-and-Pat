package main;

public class Enemy {
	private int health;
	private int combatStat;
	private String desc;
	
	public Enemy(		int health, int combatStat, String desc) {
		this.setHealth(health);
		this.setCombatStat(combatStat);
		this.setDesc(desc);
	}
	
	public int getHealth() {
		return health;
	}
	
	private void setHealth(int health) {
		this.health = health;
	}
	
	public int getCombatStat() {
		return combatStat;
	}
	
	private void setCombatStat(int combatStat) {
		this.combatStat = combatStat;
	}
	
	public String getDesc() {
		return desc;
	}
	
	private void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean getDead() {
		boolean dead = false;
		if (health <= 0) {
			dead = true;
		}
		return dead;
	}
}
