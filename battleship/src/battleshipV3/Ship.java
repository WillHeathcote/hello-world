package battleshipV3;

public class Ship 
{
	int x, y, s; //coords, size and orientation of the ship
	String o;
	
	public Ship(int iy, int ix, int size, String orientation) 
	{
		this.x = ix-1;	//-1 to make the grid start from 1,1 not 0,0
		this.y = iy-1;
		this.s = size;
		this.o = orientation;
	}
}