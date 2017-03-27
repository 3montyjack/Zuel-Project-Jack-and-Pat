package main;

public class Player {	
	private int maxWeight;
	private int currentWeight;
	private Inventory inventory; 
	
	public Player(int weight) {
		maxWeight = weight;
		currentWeight = 0;
		inventory = new Inventory();	
	}
	
	public Player() {
		maxWeight = 150;
		currentWeight = 0;
		inventory = new Inventory();
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public String[] getInventoryNames() {
		return inventory.getInventoryNames();
	}
	
	public boolean putItemInInv(String input) {
		boolean success = false;
		Item current = inventory.getItemByName(input);
		if (currentWeight + current.getWeight() <= maxWeight) {
			inventory.addItemByName(input);	
			currentWeight += current.getWeight();
			success = true;
		}
		return success;
	}
	
	public boolean removeItem(String name) {
		boolean flag = false;
		if(inventory.removeItemByName(name)) {
			flag = true;
		}
		return flag;
	}
	
	

}
