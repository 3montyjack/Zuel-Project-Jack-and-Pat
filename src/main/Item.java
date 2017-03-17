package main;

public class Item {
	private int weight;
	private String name;
	private int value;
	private String type;
	private String desc;
	private boolean canHold;
	
	public Item(String name, int weight, int value, String type, String desc, boolean canHold) {
		this.setName(name);
		this.setWeight(weight);
		this.setValue(value);
		this.setType(type);
		this.setDesc(desc);
		this.setCanHold(canHold);
	}
	public int getWeight() {
		return weight;
	}
	private void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	public String getDesc() {
		return desc;
	}
	
	private void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean getCanHold() {
		return canHold;
	}
	
	private void setCanHold(boolean canHold) {
		this.canHold = canHold;
	}
}


