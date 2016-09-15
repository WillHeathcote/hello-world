package battleship;

import java.util.Arrays;

public class Board
{
	char[][] grid ;


	public Board(int x, int y) 
	{
		grid = new char[x][y];

		for(int i = 0; i < grid.length;i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				grid[i][j] = 'O';
			}
		}
	}

	public void display()
	{
		for (char[] row : grid)
		{
			System.out.println(Arrays.toString(row));
		}
	}

	public boolean placeship(Ship ship)
	{
		boolean result= false;

		grid[ship.x][ship.y] = 'X';

		if(ship.o.equals("N"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				grid[ship.x+i][ship.y] = 'X';
				result = true;
			}
		}

		if(ship.o.equals("S"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				grid[ship.x-i][ship.y] = 'X';
				result = true;
			}
		}

		if(ship.o.equals("W"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				grid[ship.x][ship.y+i] = 'X';
				result = true;
			}
		}

		if(ship.o.equals("E"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				grid[ship.x][ship.y-i] = 'X';
				result = true;
			}
		}

		return result;		
	}
}