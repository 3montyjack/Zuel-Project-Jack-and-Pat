	package main;
	
	import java.util.ArrayList;
	
	public class ItemList {
		
		private static  ArrayList<Item> list;
		
		public ItemList() {
			list = new ArrayList<>();	
			initializeList();
		}
		
		
		
		private void initializeList() {
			list.add(new Item("sword", 30, 5, "weapon", "A short, durable steel sword. The blade is slightly dull.", true));
			list.add(new Item("dagger", 10, 3, "weapon", "A small dagger. There is an engraving on the handle in\n"
					+ " a language you don't recognize.", true));
			list.add(new Item("crate", 150, 0, "storage", "A sealed wooden box. What do goblins have to store?", false));
			list.add(new Item("bat", 10, 2, "weapon", "A small piece of wood rounded arround the edges", false));
			list.add(new Item("teleporter", 0, 0, "object","A mysterious piece of telepotation technology", false));
			
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
