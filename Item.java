public class Item {
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;

	public Item(){
	}

	public Item(ItemType type, String name, int weight, int value, int strength){
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.name = name;
		this.type = type;
	}

	public int getWeight(){
		return this.weight;
	}

	public int getValue(){
		return this.value;
	}

	public String getName(){
		return this.name;
	}

	public ItemType getType(){
		return this.type;
	}

	public String toString(){
		if (type.equals(ItemType.Weapon)){
			String info = name + ", " + weight + " lbs, " + value + " Gold, " + strength + " dmg";
			return info;
			
		}else {	
			String info = name + ", " + weight + " lbs, " + value + " Gold, " + strength + " str";
			return info;
		}
	}



}
