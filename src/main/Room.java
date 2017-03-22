package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room {
	private String type;
	private String description;
	private ArrayList<String> exits; // stores exits of this room.
	private Inventory inv;
	private boolean connected;
	private Random rand;
	private int itemsInRoom;

	/**
	 * Create a room described "description". Initially, it has no exits.
	 * "description" is something like "a kitchen" or "an open court yard".
	 * 
	 * @param description
	 *            The room's description.
	 */
	public Room(String type) {
		this.type = type;
		connected = false;
		exits = new ArrayList<>();
		rand = new Random();
		generate();
	}

	public Room(String type, Random rand) {
		this.type = type;
		connected = false;
		exits = new ArrayList<>();
		this.rand = rand;
		generate();
	}

	private void generate() {
		ArrayList<String> items = new ArrayList<String>();
		itemsInRoom = rand.nextInt(5);
		switch (type) {
		case "Baracks":
			generateBaracks(items);
			break;
		case "Prison":
			// TODO Change Prision here and in the map class
			generatePrison(items);
			break;
		case "Cave":
			generateCave(items);
			break;
		case "Teleporter":
			generateTeleporter(items);
			break;
		}

	}

	private void generateCave(ArrayList<String> items) {
		description = "in a very dark Cave";

		items.add("sword");
		items.add("crate");

		populateItems(items);
	}

	private void generatePrison(ArrayList<String> items) {
		description = "in a room with what it looks like Shackles and a Cell";
		items.add("sword");
		items.add("crate");

		populateItems(items);
	}

	private void generateBaracks(ArrayList<String> items) {
		description = "in a room with ";
		items.add("sword");
		items.add("crate");

		populateItems(items);
	}
	
	private void generateTeleporter(ArrayList<String> items) {
		description = "in a room with ";
		items.add("teleporter");

		populateItems(items);
	}

	private void populateItems(ArrayList<String> items) {
		String[] itemList = new String[items.size()];
		Iterator<String> iter = items.iterator();
		int index = 0;
		while (iter.hasNext()) {
			itemList[index] = iter.next();
		}
		for (int i = 0; i < itemsInRoom; i++) {
			inv.addItemByName(itemList[rand.nextInt(items.size())]);
		}
	}

	/**
	 * @return The short description of the room (the one that was defined in
	 *         the constructor).
	 */
	public String getShortDescription() {
		return type;
	}

	/**
	 * Return a description of the room in the form: You are in the kitchen.
	 * Exits: north west
	 * 
	 * @return A long description of this room
	 */
	public String getLongDescription() {
		return "You are " + description + ".\n" + getExitString();
	}

	/**
	 * Return a string describing the room's exits, for example "Exits: north
	 * west".
	 * 
	 * @return Details of the room's exits.
	 */
	private String getExitString() {
		String returnString = "Exits:";
		return returnString;
	}

	public void setConnected() {
		connected = true;
	}

	public boolean getConnected() {
		return connected;
	}

	public boolean getItemByName(String name) {
		boolean flag = false;
		if (inv.getItemByName(name) != null) {
			flag = true;
		}
		return flag;
	}

	public boolean takeObject(String name) {
		boolean flag = false;
		if (inv.removeItem(inv.getItemByName(name))) {
			flag = true;
		}
		return flag;
	}
	
	public void addItemToInventoryByName(String name) {
		inv.addItemByName(name);
	}

}
