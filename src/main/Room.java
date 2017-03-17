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

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String type) 
    {
        this.type = type;
        exits = new ArrayList<>();
        generate();
    }

    

    private void generate() {
		switch (type) {
		case "Baracks": 
			generateBaracks();
			break;
		case "Prision":
			generatePrision();
			break;
		case "Cave":
			generateCave();
			break;
		}
		
	}



	private void generateCave() {
		// TODO Auto-generated method stub
		description = "Hello";
		
	}



	private void generatePrision() {
		// TODO Auto-generated method stub
		description = "Hello";
	}



	private void generateBaracks() {
		// TODO Auto-generated method stub
		description = "Hello";
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
        ArrayList<String> keys = exits;
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
}

