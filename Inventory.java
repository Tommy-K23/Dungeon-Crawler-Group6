import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;

	public Inventory(int maxWeight){
		this.maxWeight = maxWeight;
		equippedWeapon = null;
		equippedArmor = null;
	}
	
	public int getMaxWeight() {
		return this.maxWeight;
	}	

	public boolean add(Item item){
		int totalWeight = totalWeight();
		if ((totalWeight + item.getWeight()) < maxWeight){		
			System.out.println("Item added");
			items.add(item);
			return true;
		}else {
			System.out.println("Can't carry anymore weight!");
			return false;
		}
	}

	public int totalWeight(){
		int totalWeight = 0;
		for (int i=0; i < items.size(); i++){
			totalWeight += items.get(i).getWeight(); 
		}
		return totalWeight;
	}

	public void print(){
		int counter = 1;
		if (items.size() > 0) {
			for (Item i : items){
				System.out.println(counter + ". " + i.toString());
				counter++;
			}
		}else {
			System.out.println("No items in Inventory!");
		}			
	}

	public void drop(){
		Scanner in = new Scanner(System.in);
		int counter = 1;
		for (Item i : items) {
			System.out.println(counter + ". " + i.toString());
			counter++;
		}
		if (items.size() > 0){
			int item = in.nextInt() - 1;
			System.out.println(items.get(item).getName() + " dropped!");
			items.remove(item);	
		}else{
			System.out.println("No items in Inventory!");
		}
	}
	
	public void equipWeapon(){
		Scanner in = new Scanner(System.in);
		int counter = 1;
		Item[] list = new Item[10];
		for (Item i : items) {
			if (i.getType().equals(ItemType.Weapon)){			
				System.out.println(counter + ". " + i.toString());
				list[counter] = i;	
				counter++;
			}
		}
		if (list[1] != null ) {
			int item = in.nextInt();
			equippedWeapon = list[item];
			System.out.println(list[item].getName() + " equipped!");
		}else {
			System.out.println("No weapons to equip!");
		}
	}


	public void equipArmor(){
		Scanner in = new Scanner(System.in);
		int counter = 1;
		Item[] list = new Item[10];
		for (Item i : items) {
			if (i.getType().equals(ItemType.Armor)){			
				System.out.println(counter + ". " + i.toString());
				list[counter] = i;
				counter++;
			}
		}
		if (list[1] != null) {
			int item = in.nextInt();
			equippedWeapon = list[item];
			System.out.println(list[item].getName() + " equipped!");
		}else{ 
			System.out.println("No armor to equip!");	
		}
	}
}
