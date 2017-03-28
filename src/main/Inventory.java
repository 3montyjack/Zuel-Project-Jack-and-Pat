	package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that holds a list of Item objects. It is used in the game to
 * keep track of the items held by a player, and also those held in a room.
 * @author Patrick and Jack
 *
 */

public class Inventory {

	private HashMap	<Item, Integer> inventory;
	private ItemList list;
	
	/**
     * A Constructor that initializes the values for inventory and list.
     */
	
	public Inventory() {
		inventory = new HashMap<Item, Integer>();
		list = new ItemList();
	}
	
	/**
     * Adds an item to the inventory based on an input.
     * @param input
     */
	
	public void addItemByName(String input) {
		addItem(getItemByName(input));
	}
	
	/**
     * Gets an item by name and returns it.
     * @param input
     * @return an associated Item object.
     */
	
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
			inv[index] = name.getName();
			index++;
		}
		return inv;
	}
	
	public ArrayList<String> getWeaponNames() {
		ArrayList<String> inv = new ArrayList<String>();
		for(Item item: inventory.keySet()) {
			if(item.getType().equals("weapon")) {
				inv.add(item.getName());
			}
		}
		return inv;
	}
	
	

}
