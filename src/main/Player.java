package main;

import java.util.ArrayList;

public class Player {	
	private int maxWeight;
	private int currentWeight;
	private ArrayList<Item> inventory;
	public Player() {
		maxWeight = 150;
		inventory = new ArrayList<>();
	}
	public int getMaxWeight() {
		return maxWeight;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public boolean putItemInInv(Item item) {
		boolean success = false;
		if (currentWeight + item.getWeight() <= maxWeight) {
			inventory.add(item);
			currentWeight += item.getWeight();
			success = true;
		}
		return success;
	}
	
	

}
