package main;

import java.util.ArrayList;

public class Map {
	private Room[][] map;
	private int currentLocationY;
	private int currentLocationX;
	private int size;
	private int lastLocationX;
	private int lastLocationY;
	
	public Map() {
		int size = 5;
		this.size = size;
		map = new Room[size][size];
		currentLocationX = size/2 +1;
		currentLocationY = size/2 +1;
		initialize();
	}
	
	

	public Map(int size) {
		this.size = size;
		map = new Room[size][size];
		initialize(size);
	}
	
	private void initialize() {
		//TODO Eventually make this random
		map[0][0] = new Room("Baracks");
		map[3][0] = new Room("Prision");
		map[4][0] = new Room("Cave");
		map[0][1] = new Room("Cave");
		map[1][1] = new Room("Baracks");
		map[3][1] = new Room("Prision");
		map[1][2] = new Room("Baracks");
		map[2][2] = new Room("Cave");
		map[3][2] = new Room("Prision");
		map[4][2] = new Room("Cave");
		map[2][3] = new Room("Baracks");
		map[3][3] = new Room("Cave");
		map[4][3] = new Room("Baracks");
		map[0][4] = new Room("Cave");
		map[1][4] = new Room("Prision");
		map[2][4] = new Room("Cave");
		
	}

	private void initialize(int size) {
		//TODO Finish random generation of rooms here
		
	}
	
	public int[] getLocation() {
		int[] value = new int[2];
		value[0] = currentLocationX;
		value[1] = currentLocationY;
		return value;
	}
	
	public boolean checkRoomNorth() {
		int[] location = getLocation();
		boolean north = false;
		if (location[1] != size && map[location[0]][location[1]+1] != null) {
			north = true;
		}
		return north;
	}
	
	public boolean checkRoomSouth() {
		int[] location = getLocation();
		boolean south = false;
		if (location[1] != 0 && map[location[0]][location[1]-1] != null) {
			south = true;
		}
		return south;
	}
	
	public boolean checkRoomEast() {
		int[] location = getLocation();
		boolean east = false;
		if (location[0] != size && map[location[0]+1][location[1]] != null) {
			east = true;
		}
		return east;
	}
	
	public boolean checkRoomWest() {
		int[] location = getLocation();
		boolean west= false;
		if (location[1] != 0 && map[location[0]+1][location[1]] != null) {
			west = true;
		}
		return west;
	}
	
	public ArrayList<String> getPossibleLocations() {
		ArrayList<String> locations = new ArrayList<String>();
		if (checkRoomNorth()){
			locations.add("North");
		} 
		if (checkRoomEast()) {
			locations.add("East");
		}
		if (checkRoomSouth()) {
			locations.add("South");
		}
		if (checkRoomWest()) {
			locations.add("West");
		}
		return locations;
	}



	public Boolean move(String direction) {
		//TODO Finish this code for next time
		return false;
	}
	
    public String getLongDescription() {
    	return map[currentLocationX][currentLocationY].getLongDescription();
    }
    
    
	
	
	
}
