package main;

public class Main {
	
	static Game game;
	static Map map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map = new Map(5);
		map.printMap();
		game = new Game();
		game.play();
		
	}

}
