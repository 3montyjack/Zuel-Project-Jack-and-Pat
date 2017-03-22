package main;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Room[][] map;
	private int size;
	private int[] lastLocation;
	private int[] centerRoom;
	private int[] currentLocation;
	private String[] rooms;
	private Random rand;
	private boolean seeded;
	int counter;

	public Map() {
		int size = 5;
		this.size = size;
		seeded = true;
		map = new Room[size][size];
		initializeLocationData(size);
		rand = new Random();
		currentLocation = new int[2];
		lastLocation = new int[2];
		centerRoom = new int[2];
		centerRoom[0] = size / 2;
		centerRoom[1] = size / 2;
		currentLocation = centerRoom.clone();
		lastLocation = currentLocation;
		rooms = new String[3];
		initialize();
	}

	public Map(int size, int seed) {
		seeded = true;
		this.size = (size * 2) + 1;
		map = new Room[this.size][this.size];
		rand = new Random(seed);
		initializeLocationData(size);
		initializeRandom();
	}

	public Map(int size) {
		seeded = false;
		this.size = (size * 2) + 1;
		map = new Room[this.size][this.size];
		rand = new Random();
		initializeLocationData(size);
		initializeRandom();
	}

	private void initializeLocationData(int size) {
		currentLocation = new int[2];
		lastLocation = new int[2];
		centerRoom = new int[2];
		centerRoom[0] = size;
		centerRoom[1] = size;
		currentLocation = centerRoom.clone();
		lastLocation = currentLocation;
		rooms = new String[3];
		rooms[0] = "Baracks";
		rooms[1] = "Prision";
		rooms[2] = "Cave";
	}

	private void initialize() {
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

	private void initializeRandom() {
		counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (rand.nextBoolean()) {
					map[i][j] = new Room(rooms[rand.nextInt(rooms.length)]);
				}
			}
		}
		map[centerRoom[0]][centerRoom[1]] = new Room("Cave");
		connectedRooms(getPossibleLocations(), getLocation());
		int connectedRooms = removeUnConnectedRooms();
		if (connectedRooms < map.length*2 && !seeded) {;
			initializeRandom();
		}
	}

	private int removeUnConnectedRooms() {
		int counter = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != null) {
					if (map[i][j].getConnected()) {
						counter += 1;
					} else {
						map[i][j] = null;
					}
				}
			}
		}
		return counter;
	}

	public void connectedRooms(ArrayList<String> possibleLocations, int[] currentLocation) {
		counter++;
		map[currentLocation[0]][currentLocation[1]].setConnected();
		if (possibleLocations.size() > 0) {
			for (String direction : possibleLocations) {
				if (!checkConnectedAllready(direction, currentLocation)) {
					int[] localCurrentLocation = getNewLocation(currentLocation, direction).clone();
					ArrayList<String> localPossibleLocations = (ArrayList<String>) getPossibleLocations(
							localCurrentLocation);
					connectedRooms(localPossibleLocations, localCurrentLocation);
				}
			}
		}

	}

	public void printMap() {
		System.out.println("X: " + centerRoom[0] + ", Y: " + centerRoom[1]);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != null && map[i][j].getConnected()) {
					if (i == centerRoom[0] && j == centerRoom[1]) {
						System.out.print("M");
					} else {
						System.out.print("X");
					}
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}

	private int[] getNewLocation(int[] location, String direction) {
		int[] locationL = location.clone();
		switch (direction) {
		case "North":
			locationL[1] = locationL[1] + 1;
			break;
		case "East":
			locationL[0] = locationL[0] + 1;
			break;
		case "South":
			locationL[1] = locationL[1] - 1;
			break;
		case "West":
			locationL[0] = locationL[0] - 1;
			break;
		}
		return locationL;

	}

	private boolean checkConnectedAllready(String direction, int[] currentLocation) {
		int[] currentLocationL = getNewLocation(currentLocation, direction);
		return map[currentLocationL[0]][currentLocationL[1]].getConnected();
	}

	public int[] getLocation() {
		int[] value = new int[2];
		value[0] = currentLocation[0];
		value[1] = currentLocation[1];
		return value;
	}

	public boolean checkRoomNorth() {
		int[] location = getLocation();
		return checkRoomNorth(location);
	}

	public boolean checkRoomNorth(int[] location) {
		boolean north = false;
		if (location[1] != map.length - 1 && map[location[0]][location[1] + 1] != null) {
			north = true;
		}
		return north;
	}

	public boolean checkRoomSouth() {
		int[] location = getLocation();
		return checkRoomSouth(location);
	}

	public boolean checkRoomSouth(int[] location) {
		boolean south = false;
		if (location[1] != 0 && map[location[0]][location[1] - 1] != null) {
			south = true;
		}
		return south;
	}

	public boolean checkRoomEast() {
		int[] location = getLocation();
		return checkRoomEast(location);
	}

	public boolean checkRoomEast(int[] location) {
		boolean east = false;
		if (location[0] != map.length - 1 && map[location[0] + 1][location[1]] != null) {
			east = true;
		}
		return east;
	}

	public boolean checkRoomWest() {
		int[] location = getLocation();
		return checkRoomWest(location);
	}

	public boolean checkRoomWest(int[] location) {
		boolean west = false;
		if (location[0] != 0 && map[location[0] - 1][location[1]] != null) {
			west = true;
		}
		return west;
	}

	public ArrayList<String> getPossibleLocations() {
		ArrayList<String> locations = new ArrayList<String>();
		if (checkRoomNorth()) {
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

	public ArrayList<String> getPossibleLocations(int[] currentLocation) {
		ArrayList<String> locations = new ArrayList<String>();
		if (!(currentLocation[0] == map.length) && !(currentLocation[1] == map.length)) {
			if (checkRoomNorth(currentLocation)) {
				locations.add("North");
			}
			if (checkRoomEast(currentLocation)) {
				locations.add("East");
			}
			if (checkRoomSouth(currentLocation)) {
				locations.add("South");
			}
			if (checkRoomWest(currentLocation)) {
				locations.add("West");
			}
		}
		return locations;
	}

	public Boolean move(String direction) {
		boolean flag = false;

		switch (direction) {
		case "north":
			if (checkRoomNorth()) {
				flag = true;
			}
			break;
		case "east":
			if (checkRoomEast()) {
				flag = true;
			}
			break;
		case "south":
			if (checkRoomSouth()) {
				flag = true;
			}
			break;
		case "west":
			if (checkRoomWest()) {
				flag = true;
			}
			break;
		}
		if (flag) {
			lastLocation = currentLocation.clone();
			currentLocation = getNewLocation(currentLocation, direction);
		}
		return flag;
	}

	public String getLongDescription() {
		return map[currentLocation[0]][currentLocation[1]].getLongDescription();
	}

}