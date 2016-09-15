package battleshipV4;

import java.util.Arrays;

public class Board
{
	char[][] grid ;


	public Board(int r, int c) 	//creates a new board and fill it with 'O'
	{
		grid = new char[r][c];

		for(int i = 0; i < r;i++)
		{
			for(int j = 0; j < c; j++)
			{
				grid[i][j] = 'O';
			}
		}
	}

	public void display()	//outputs a board row at a time
	{
		for (char[] row : grid)
		{
			System.out.println(Arrays.toString(row));
		}
	}

	public boolean placeship(Ship ship)	//places a ship on a board with validation
	{
		boolean result= false;
		
		/*
		 * checks the orientation of the ship
		 * checks if the space in that direction is on the grid 
		 * checks if that space is already taken
		 * repeats for the length of the ship
		 * if all that worked then the origin will be updated too
		 * if any of the spaces fail then the user will be told to try again
		 */

		if(ship.o.equals("N"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				if(ship.x+i >=0 && ship.x+i < grid.length)
				{
					if(ship.y >=0 && ship.y < grid.length)
					{
						if(grid[ship.x+i][ship.y] != 'X')
						{
							grid[ship.x+i][ship.y] = 'X';
							result = true;
						}else
						{
							result = false; 
						}
					}else
					{
						result = false; 
						break;
					}
				}else
				{
					result = false; 
					break;
				}
			}
		}

		if(ship.o.equals("S"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				if(ship.x-i >=0 && ship.x-i < grid.length)
				{
					if(ship.y >=0 && ship.y < grid.length)
					{
						if(grid[ship.x-i][ship.y] != 'X')
						{
							grid[ship.x-i][ship.y] = 'X';
							result = true;
						}else
						{
							result = false; 
						}
					}else
					{
						result = false;
						break;
					}
				}else
				{
					result = false; 
					break;
				}
			}
		}

		if(ship.o.equals("W"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				if(ship.x >=0 && ship.x < grid.length)
				{
					if(ship.y+i >=0 && ship.y+i < grid.length)
					{
						if(grid[ship.x][ship.y+i] != 'X')
						{
							grid[ship.x][ship.y+i] = 'X';
							result = true;
						}else
						{
							result = false; 
						}
					}else
					{
						result = false; 
						break;
					}
				}else
				{
					result = false;
					break;
				}
			}
		}

		if(ship.o.equals("E"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				if(ship.x >=0 && ship.x < grid.length)
				{
					if(ship.y-i >=0 && ship.y-i < grid.length)
					{
						if(grid[ship.x][ship.y-i] != 'X')
						{
							grid[ship.x][ship.y-i] = 'X';
							result = true;
						}else
						{
							result = false; 
						}
					}else
					{
						result = false; 
						break;
					}
				}else
				{
					result = false; 
					break;
				}
			}
		}

		if(result == true)
		{
			if(ship.x >=0 && ship.x < grid.length)
			{
				if(ship.y >=0 && ship.y < grid.length)
				{
					if(grid[ship.x][ship.y] != 'X')
					{
						grid[ship.x][ship.y] = 'X';
					}else
					{
						result = false; 
					}
				}else
				{
					result = false; 
				}
			}else
			{
				result = false; 
			}
		}

		return result;		
	}

	public boolean shoot(int y, int x) //take a shot at a board
	{
		
		/*
		 * checks if the target is on the grid - sarky comment if not
		 * checks if its a hit - updates square to damaged
		 * checks if its a miss
		 * checks if already damaged
		 * returns true if it was a hit false otherwise
		 */
		
		if(y > 0 && y <= grid.length)
		{
			if(x > 0 && x <= grid.length)
			{
				if(grid[x-1][y-1] == 'X')
				{
					grid[x-1][y-1] = 'D';
					System.out.println("HIT!");
					return true;
				}else if(grid[x-1][y-1] == 'O')
				{
					System.out.println("MISS!");
					return false;
				}else if(grid[x-1][y-1] == 'D')
				{
					System.out.println("Already damaged");
				}
			}else
			{
				System.out.println("you missed the entire ocean genius!");
			}
		}else
		{
			System.out.println("you missed the entire ocean genius!");
		}
		return false;
	}

	public boolean dead() //check if all the ships are sunk 
	{
		/*
		 * goes through a players board counting the number of undamaged ships
		 * if there are no undamaged ships left on their grid that player has lost
		 */
		
		boolean result= false;
		int c = 0;

		for(int i = 0; i < grid.length;i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j] == 'X')
				{
					c++;
				}
			}
		}

		if(c == 0)
		{
			result = true;
		}

		return result;
	}

	public void update(int y, int x, boolean HM) //updates the board with hits and misses 
	{
		/*
		 * checks the shot was on the board
		 * checks if the shot was a hit or a miss
		 * updates the players shot board with the result
		 */ 
		
		if(y > 0 && y <= grid.length)
		{
			if(x > 0 && x <= grid.length)
			{
				if(HM == true)
				{
					grid[x-1][y-1] = 'H';
				}else
				{
					grid[x-1][y-1] = 'M';
				}
			}
		}
	}

}
