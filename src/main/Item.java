package main;

public class Item {
	private int weight;
	private String type;
	public Item(String type, int weight) {
		this.setName(type);
		this.setWeight(weight);
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return type;
	}
	public void setName(String type) {
		this.type = type;
	}
	
	

}
