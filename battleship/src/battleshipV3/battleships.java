package battleshipV3;
import java.util.Scanner;

public class battleships 
{
	public static void main(String[] args) 
	{
		int c1 = 0, c2 = 0, ns = 5,		//counters for ships placed and total number of ships per player
				col = 3, row = 3;		//size of boards
		boolean playing = true, win = false, 	//game loop and victory condition
				setup1 = true, setup2 = true, 	//set up phases for both players
				player = true, 	//Iterator to swap between players taking shots
				HM;	//hit or miss
		
		Board board1 = new Board(row, col);		//player 1's placement board
		Board board2 = new Board(row, col);		//player 2's placement board
		Board board3 = new Board(row, col);		//player 1's shooting board
		Board board4 = new Board(row, col);		//player 2's shooting board
		
		Scanner S = new Scanner(System.in);

		while (setup1 == true)		//setup for player 1
		{
			
			/*
			 * displays the current placement board (empty at start)
			 * asks for ships bow x,y
			 * asks for the ships size
			 * asks for the orientation of the ship
			 * creates the ship
			 * tries to place the ship on their board
			 * adds to a counter if the ship was placed 
			 * asks for a different location if the placement failed
			 * repeats until number of ships reaches the max
			 */
			
			System.out.println("player 1");
			board1.display();

			System.out.println();
			System.out.println("input bow of ships X: ");
			int x = S.nextInt();
			System.out.println("input bow of ships Y: ");
			int y = S.nextInt();
			System.out.println("input ship size: ");
			int s = S.nextInt();
			System.out.println("input ships orientation(N,S,E,W): ");
			String o = S.next().toUpperCase();
			System.out.println();

			Ship ship = new Ship(x,y,s,o);

			if(board1.placeship(ship))
			{
				System.out.println("Ship placed!");
				System.out.println();
				c1++;
			}else
			{
				System.out.println("Invalid ship placement try again");
				System.out.println();
			}
			if(c1 >= ns)
			{
				setup1 = false;
			}
		}

		for(int i = 0; i < 15; i++)
		{
			System.out.println();		//prints white space to hide previous players placements
		}

		System.out.println("switch players");

		while (setup2 == true)		//setup for player 2 (see setup player 1 for details)
		{
			System.out.println("player 2");
			board2.display();

			System.out.println();
			System.out.println("input bow of ships X: ");
			int x = S.nextInt();
			System.out.println("input bow of ships Y: ");
			int y = S.nextInt();
			System.out.println("input ship size: ");
			int s = S.nextInt();
			System.out.println("input ships orientation(N,S,E,W): ");
			String o = S.next().toUpperCase();
			System.out.println();

			Ship ship = new Ship(x,y,s,o);

			if(board2.placeship(ship))
			{
				System.out.println("Ship placed!");
				System.out.println();
				c2++;
			}else
			{
				System.out.println("Invalid ship placement try again");
				System.out.println();
			}
			if(c2 >= ns)
			{
				setup2 = false;
			}
		}
		
		System.out.println("All ships placed!");
			
		System.out.println("player 1");		//prints both players ship placements (mainly for debugging)
		board1.display();
		System.out.println();
		System.out.println("player 2");
		board2.display();

		for(int i = 0; i < 15; i++)
		{
			System.out.println();		//prints white space to hide previous players placements
		}

		while (playing == true && win == false) //main game loop
		{
			while(player == true && win == false)	//player 1's shoot phase
			{
				
				/*
				 * prints the players target map (blank at first)
				 * asks for target
				 * shoots at target
				 * updates board for next shoot phase
				 * checks if the player has won
				 * repeat until one of the players destroy the enemy fleet
				 */
				
				System.out.println();
				board3.display();
				System.out.println("player 1");	
				System.out.println("input target X: ");
				int x = S.nextInt();
				System.out.println("input target Y: ");
				int y = S.nextInt();
				System.out.println();	
				if(board2.shoot(x,y))
				{
					HM = true;
				}else
				{
					HM = false;
				}
				board3.update(x,y,HM);
				if(board2.dead() == true)
				{
					System.out.println("player 1");
					win = true;
				}
				player = false;		
			}

			while(player == false && win == false)	//player 2's shoot phase (see player 1 shoot phase for details)
			{
				System.out.println();
				board4.display();
				System.out.println("player 2");
				System.out.println("input target X: ");
				int x = S.nextInt();
				System.out.println("input target Y: ");
				int y = S.nextInt();
				System.out.println();
				if(board1.shoot(x,y))
				{
					HM = true;
				}else
				{
					HM = false;
				}
				board4.update(x,y,HM);
				if(board1.dead() == true)
				{
					System.out.println("player 2");
					win = true;
				}
				player = true;
			}
		}

		if(win == true)		//win condition
		{
			System.out.println("VICTORY!");
		}	
		S.close();
	}
}