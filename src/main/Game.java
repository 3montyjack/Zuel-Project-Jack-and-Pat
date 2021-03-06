package main;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * Hi my names patrick
 * 
 * @author Michael K�lling and David J. Barnes
 * @version 2016.02.29
 */

public class Game {
	private Parser parser;
	private Player player;
	private int invSize;
	private Map map;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		invSize = 20;
		parser = new Parser();
		player = new Player(invSize);
		map = new Map();
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to the World of Zuul!");
		System.out.println("World of Zuul is a new, incredibly boring adventure game.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		System.out.println(map.getLongDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			wantToQuit = quit(command);
		} else if (commandWord.equals("back")) {
			goBack();
		} else if (commandWord.equals("pickup")) {
			pickup(command);
		} else if (commandWord.equals("drop")) {
			drop(command);
		}
		// else command not recognised.
		return wantToQuit;
	}

	// implementations of user commands:

	private void drop(Command command) {
		String secondWord = command.getSecondWord();
		player.removeItem(secondWord);
		map.addItemByNameCurrentRoom(secondWord);
	}

	private void pickup(Command command) {
		String secondWord = command.getSecondWord();
		if (player.putItemInInv(secondWord)) {
			System.out.println("Sucessfully put " + secondWord + " in your inventory.");
		} else {
			System.out.println("Could not put " + secondWord + " in your inventory.");
		}
	}
	
	

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at the university.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * Try to in to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Boolean good = map.move(direction);

		if (good) {
			System.out.println(map.getLongDescription());
		} else {
			System.out.println("There is no door!");

		}
	}

	private void goBack() {
		map.moveBack();
		System.out.println(map.getLongDescription());
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		} else {
			return true; // signal that we want to quit
		}
	}
}
