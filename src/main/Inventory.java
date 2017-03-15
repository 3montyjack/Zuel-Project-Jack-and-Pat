package main;

import java.util.HashMap;

public class Inventory {

	private HashMap	<Item, Integer> inventory;
	private ItemList list;
	
	public Inventory() {
		inventory = new HashMap<Item, Integer>();
		list = new ItemList();
	}
	
	
	public void addItemByName(String input) {
		addItem(getItemByName(input));
	}
	
	public Item getItemByName(String input) {
		return list.getItemByName(input);
	}
	
	public void addItem(Item item) {
		if (inventory.containsKey(item)) {
			int currentNumber = inventory.get(item);
			inventory.put(item, currentNumber + 1);
		} else {
			inventory.put(item, 1);
		}
	}
	
	public boolean removeItem(Item item) {
		boolean flag = false; 
		if (inventory.containsKey(item)) {
			int currentNumber = inventory.get(item);
			inventory.put(item, currentNumber - 1);
			if (inventory.get(item) == 0) {
				inventory.remove(item);
			}
			flag = true;
		} 
		return flag;
	}
	
	public int getSizeOfInventory() {
		return inventory.size();
	}
	
	public String[] getInventoryNames() {
		String[] inv = new String[inventory.size()];
		int index = 0;
		for (Item name: inventory.keySet()) {
			inv[index] = name.getType();
			index++;
		}
		return inv;
	}
	
	

}
