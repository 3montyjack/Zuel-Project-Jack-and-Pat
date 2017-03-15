package main;

import java.util.ArrayList;

public class ItemList {
	
	private static  ArrayList<Item> list;
	
	public ItemList() {
		list = new ArrayList<>();	
		initializeList();
	}
	
	
	
	private void initializeList() {
		list.add(new Item("Sword", 10));
		list.add(new Item("Dagger", 30));
		
	}



	public Item getItemByName(String input) {
		Item item = null;
		for (Item current: list) {
			if (current.getName().equals(input)) {
				item = current;
			}
		}
		if (item == null) {
			System.out.println("There is no item with this name #001");
		}
		return item;
		
	}

}
