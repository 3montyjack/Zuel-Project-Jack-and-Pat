package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String type;
    private String description;
    private ArrayList<String	> exits;        // stores exits of this room.
    private Inventory inv;
    private boolean connected;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String type) 
    {
        this.type = type;
        connected = false;
        exits = new ArrayList<>();
        
        generate();
    }

    

    private void generate() {
		switch (type) {
		case "Baracks": 
			generateBaracks();
			break;
		case "Prison":
			//TODO Change Prision here and in the map class
			generatePrison();
			break;
		case "Cave":
			generateCave();
			break;
		}
		
	}



	private void generateCave() {
		description = "in a very dark Cave";
		
	}



	private void generatePrison() {
		description = "in a room with what it looks like Shackles and a Cell";
	}



	private void generateBaracks() {
		description = "in a room with ";
	}



	/**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return type;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString(); //TODO  Description based on type
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
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
    
    
    
}

