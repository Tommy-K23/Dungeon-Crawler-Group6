import java.util.Random;
public class ItemGenerator {
	
	public ItemGenerator() {

	}

	public static Item generate(){
		Random rng = new Random();
		ItemType type = null;
		String[] wType = new String[13];
		String[] weapon = new String[9];
		String[] item = new String[13];
		String[] armor = new String[3];
		String name = "";
		int weight = 0;
		int value = 0;
		int strength = 0;
		int rando = rng.nextInt(3);

		wType[0] = "Iron"; wType[1] = "Steel"; wType[2] = "Silver"; wType[3] = "Orcish"; wType[4] = "Dwarven"; wType[5] = "Nordic"; wType[6] = "Elven"; wType[7] = "Glass"; wType[8] = "Ebony"; wType[9] = "Daedric"; wType[10] = "Dragonborne"; wType[11] = "Long"; wType [12]= "Hunting";
		weapon[0] = "Sword"; weapon[1] = "War Axe"; weapon[2] = "Mace"; weapon[3] = "Dagger"; weapon[4] = "Great Sword"; weapon[5] = "Battle Axe"; weapon[6] = "Warhammer"; weapon[7] = "Bow"; weapon[8] = "Crossbow";
		item[0] = "Gold"; item[1] = "Lockpick"; item[2] = "Ingot"; item[3] = "Soul Gem"; item[4] = "Arrow"; item[5] = "Book"; item[6] = "Key"; item[7] = "Vase"; item[8] = "Health Potion"; item[9] = "Stamina Potion"; item[10] = "Magica Potion"; item[11] = "Food"; item[12] = "Torch";
		armor[0] = "Light"; armor[1] = "Heavy"; armor[2] = "Magical";
		
 		int low = rng.nextInt(20);
		switch (rando) {
			case 0:
			type = ItemType.Weapon;
			break;
			case 1:
			type = ItemType.Armor;
			break;	
			case 2:
			type = ItemType.Other;
			break;
		}
		switch (type) {
			case Weapon:
			int rw = rng.nextInt(9);
			if (rw <= 6){
				int rt = rng.nextInt(11);
				name = "" + wType[rt] + " " + weapon[rw];	
				weight = 20 + low;
				if (rt <=  3) {
					value = rng.nextInt(100) + 10;
					strength = 20 + low;
				}else if ( rt >= 4 && rt < 6){
					value = rng.nextInt(150) + 15;
					strength = 40 + low;
				}else if (rt >= 6 && rt <7 ) {
					value = rng.nextInt(200) + 25;
					strength = 80 + low;	
				}else if (rt == 7) {
					value = rng.nextInt(250)+ 50;
					strength = 100 + low;
				}else if (rt > 7 && rt < 11){
					value = rng.nextInt(300) + 75;
					strength = 150 + low;
				}					
				
			}else if( rw > 6 ){
				int rt = rng.nextInt(13);
				if (rt > 3) {
					name = "" + wType[rt] + " " + weapon[rw];
				}else{
					name = "" + weapon[rw];
				}
				weight = rng.nextInt(low) + low;
				if(rt >= 11) {
					value = rng.nextInt(50) + 10;
					strength = 20 + low;
				}else if ( rt > 3 && rt < 6){
					value = rng.nextInt(100)+ 10;
					strength = 70 + low;	
				}else if (rt == 7) {
					value = rng.nextInt(150) + 25;
					strength = 90 + low;
				}else if (rt > 7 && rt < 11){
					value = rng.nextInt(200) + 30;
					strength = 120 + low;
				}
			}
			break;
			case Armor:
			int rt = rng.nextInt(11);
			int ra = rng.nextInt(3);
			name = "" + armor[ra] + " " + wType[rt] + " Armor";
			weight = rng.nextInt(100 - low) + low; 
			if (rt <  4) {
				value = rng.nextInt(50) + 10;
				strength = 40 + low;
			}else if ( rt >= 4 && rt < 6){
				value = rng.nextInt(150) + 15;
				strength = 75 + low;
			}else if (rt >= 6 && rt < 13) {
				value = rng.nextInt(200) + 20;	
				strength = 120 + low;		
			}
			break;
			case Other:
			int ri = rng.nextInt(13);
			name = "" + item[ri];
			weight = rng.nextInt(20);
			value = rng.nextInt(20);
			break;
		}
				
			return new Item(type, name, weight, value, strength);
		}

	}
	

