import ansi_terminal.*;
public class Map {
	private static String[] grid = {
"##########################################                                                                   #######################                                                  ",
"#                                        #                                                                   #                     #                                                  ",
"#                                        #                                                                   #                     #                                                  ",
"#                      ##############    #                                                                   #                     #                                                  ",
"#                      #            #    #                                                                   #                     #                                                  ",
"#                      #            #    #                  ##################################################                     #                                                  ",
"#                      #            #    #                  #                                                                      #                                                  ",
"#                      #            #    #                  #                                                                      #                                                  ",
"#                      #            #    #                  #   ##############################################                     #                                                  ",
"########################            #    #                  #   #                                            #                     #                                                  ",
"                                    #    #                  #   #                                            #                     #                                                  ",
"                                    #    #                  #   #                                            #                     #                                                  ",
"                                    #    #                  #   #                                            #########   ###########                                                  ",
"                                    #    #                  #   #                                                    #   #                                                            ",
"                                    #    #                  #   #                                                    #   #                                                            ",
"                                    #    #                  #   #                                                    #   #                                                            ",
"                                    #    #                  #   #                                                    #   #                                                            ",
"     ################################    ####################   #########                                            #   #                                                            ",
"     #                                                                  #                                            #   #                                                            ",
"     #                                                                  #                                            #   #                                                            ",
"     #                                                                  #                                 ############   ###########                                                  ",
"     #                                                                  #                                 #                        #                                                  ",
"     #                                                                  #                                 #                        #                                                  ",
"     #                                                                  #                                 #                        #                                                  ",
"     #                                                                  #                                 #                        #                                                  ",
"     #                                                                  #                                 ##########################                                                  ",
"     #                                                                  #                                                          ###################################################",
"     #                                                                  #                                                         #                                                  #",
"     #                                                                  #                                                        #                                                   #",
"     #                                                                  #                                                       #                                                    #",
"     #                                                                  #                                                      #                                                     #",
"     #                                                                  #                                                     #                                                      #",
"     ##############   ################################   ################                                                    #                                                       #",
"                  #   #                              #   #                                                                  #                                                        #",
"                  #   #                              #   #                                                                 #                                                         #",
"                  #   #                              #   #                                                                #                                                          #",
"                  #   #                              #   #                                                               #                                                           #",
"                  #   #                              #   #                                                              #                                                            #",
"                  #   #                              #   #                                                             #                                                             #",
"                  #   #                              #   #                                                            #                                                              #",
"                  #   #                              #   #                                                           #                                                               #",
"     ##############   #########                      #   ############################################################                                                                #",
"     #                        #                      #                                                                                                                               #",
"     #                        #                      #                                                                                                                               #",
"     #                        #                      ################################################################                                                                #",
"     #                        #                                                                                      #                                                               #",
"     #                        #                                                                                       #                                                              #",
"     ##########################                                                                                        ###############################################################",
};
	public static void drawMap(int hrow, int hcol) {
		Terminal.clear();
		for (int row = 0; row < 48; row++){
			for (int col = 0; col < 182; col++){
				if (row == hrow && col == hcol){				
					Terminal.setForeground(Color.CYAN);				
					Terminal.warpCursor(hrow, hcol);					
					System.out.print("@ ");	
					Terminal.reset();
				}else {
					char cell = grid[row].charAt(col);
					if (cell == '#'){
					System.out.print('\u2588');
					}else {
					System.out.print(cell);
					}
				}
			}	System.out.print("\n\r");		
		}	       
	}
	public static void drawInfo() {
		Terminal.setForeground(Color.RED);
		Terminal.warpCursor(1,152);
		System.out.print("Commands:");
		Terminal.warpCursor(2, 155);
		System.out.print("Move: WASD");
		Terminal.warpCursor(3, 155);
		System.out.print("Help: ?");
		Terminal.warpCursor(4, 155);
		System.out.print("Pickup: e");
		Terminal.reset();
	}
	
	public static void game() {
		Inventory inventory = new Inventory(100);
		int hrow = 4, hcol = 4;
		boolean done = false;
		while (!done){
			drawMap(hrow, hcol);		
			drawInfo();
			placeItems(hrow, hcol);
		Key key = Terminal.getKey();
		Terminal.warpCursor(hrow, hcol);
		if(canMove(hrow, hcol) == true){
		switch (key){
			case ESCAPE:
				done = true;
				break;	
			case a: hcol--; break;
			case d: hcol++; break;
			case w: hrow--; break;
			case s: hrow++; break;
			case e: 
				if (grid[hrow].charAt(hcol) == '\u0197'){
					inventory.add(new Item(ItemType.Weapon, "Steel Sword", 10, 5, 7));	
					Terminal.warpCursor(5, 152);
					System.out.print("Steel Sword added!\n\r");
					inventory.equipWeapon();

				}
				Terminal.pause(1.5);
				break;
			case COLON:
				Terminal.warpCursor(40, 0);
				String cmd = Terminal.getLine(":");
				if (cmd.equals("use")) {
					String item = Terminal.getLine("Use what? ");
					System.out.print("You don't have that! \n\r");
					Terminal.pause(1.5);
				}else{
					System.out.print("Invalid command\n\r");
					Terminal.pause(1.5);
					break;
				}
			}
		}else {
		switch(key){
			case ESCAPE: done = true; break;
			case a: hcol=hcol+2; break;
			case d: hcol=hcol-2; break;
			case w: hrow=hrow+2;break;
			case s: hrow=hrow-2; break;
			case e:
				System.out.print("There is nothing here! \n\r");
				Terminal.pause(1.5);
				break;
			case COLON:
				Terminal.warpCursor(40, 0);
				String cmd = Terminal.getLine(":");
				if (cmd.equals("use")) {
					String item = Terminal.getLine("Use what? ");
					System.out.print("You don't have that! \n\r");
					Terminal.pause(1.5);
				}else{
					System.out.print("Invalid command \n\r");
					Terminal.pause(1.5);
					break;
				}
			}
		
		}	
		}
	}
	public static void placeEnemys(){

	}
	
	public static void placeItems(int hrow, int hcol){
		Terminal.warpCursor(4, 5);
		System.out.print("\u0197");
		char cell = grid[hrow].charAt(hcol);
	}
	
	public static boolean canMove(int hrow, int hcol){
		char cell = grid[hrow].charAt(hcol);
		if (cell == '#'){
			return false;
		}else{
			return true;
		}
	}

	public static void main(String args[]){
	Terminal.rawMode();
	System.out.print("Welcome to the program!! \n\r");
	String name = Terminal.getLine("What is your name adventurer? ");
	game();

	Terminal.cookedMode();
	}	
}
