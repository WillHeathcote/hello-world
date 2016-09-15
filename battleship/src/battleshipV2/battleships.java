package battleshipV2;
import java.util.Scanner;

public class battleships 
{
	public static void main(String[] args) 
	{
		boolean playing = true, win = false;
		Board board = new Board(3, 3);
		
		while (playing == true && win == false)
		{
			board.display();
			
			System.out.println();
			System.out.println("input bow of ships X: ");
			int x = new Scanner(System.in).nextInt();
			System.out.println("input bow of ships Y: ");
			int y = new Scanner(System.in).nextInt();
			System.out.println("input ship size: ");
			int s = new Scanner(System.in).nextInt();
			System.out.println("input ships orientation(N,S,E,W): ");
			String o = new Scanner(System.in).next().toUpperCase();
			System.out.println();
			
			Ship ship = new Ship(x,y,s,o);
			
			if(board.placeship(ship))
			{
				System.out.println("Ship placed!");
				System.out.println();
			}else
			{
				System.out.println("Invalid ship placement try again");
				System.out.println();
			}
		}
	}
}