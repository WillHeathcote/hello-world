package battleshipV2;

import java.util.Arrays;

public class Board
{
	char[][] grid ;


	public Board(int r, int c) 
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

		if(ship.o.equals("N"))
		{
			for(int i = 1; i < ship.s ; i++ )
			{
				if(ship.x+i >=0 && ship.x+i <= grid.length)
				{
					if(ship.y >=0 && ship.y <= grid.length)
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
				if(ship.x-i >=0 && ship.x-i <= grid.length)
				{
					if(ship.y >=0 && ship.y <= grid.length)
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
				if(ship.x >=0 && ship.x <= grid.length)
				{
					if(ship.y+i >=0 && ship.y+i <= grid.length)
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
				if(ship.x >=0 && ship.x <= grid.length)
				{
					if(ship.y-i >=0 && ship.y-i <= grid.length)
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
			if(ship.x >=0 && ship.x <= grid.length)
			{
				if(ship.y >=0 && ship.y <= grid.length)
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
}