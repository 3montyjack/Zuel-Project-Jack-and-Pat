package main;

public class Item {
	private int weight;
	private String type;
	public Item(String type, int weight) {
		this.setType(type);
		this.setWeight(weight);
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
