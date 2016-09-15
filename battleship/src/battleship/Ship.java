package battleship;

public class Ship 
{
	int x, y, s;
	String o;
	
	public Ship(int iy, int ix, int size, String orientation) 
	{
		this.x = ix-1;
		this.y = iy-1;
		this.s = size;
		this.o = orientation;
	}
}