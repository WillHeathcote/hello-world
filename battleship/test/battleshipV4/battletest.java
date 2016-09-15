package battleshipV4;

import static org.junit.Assert.*;

import org.junit.Test;

public class battletest 
{
	@Test
	public void GridNotNull() 
	{
		Board tester = new Board(3,3);
		assertNotNull(tester.grid);
	}
	
	@Test
	public void GridO() 
	{
		Board tester = new Board(3,3);
		assertEquals('O', tester.grid[1][1]);
	}
	
	@Test
	public void ShipNotNull() 
	{
		Ship dingey = new Ship(2, 2, 2, "N");
		assertNotNull(dingey);
	}
	
	@Test
	public void PlaceShip() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(2, 2, 2, "N");
		tester.placeship(boat);
		assertEquals('X', tester.grid[boat.x][boat.y]);
	}
	
	@Test
	public void PlaceBigShip() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 3, "N");
		tester.placeship(boat);
		assertEquals('X', tester.grid[boat.x][boat.y]);
		assertEquals('X', tester.grid[boat.x+1][boat.y]);
		assertEquals('X', tester.grid[boat.x+2][boat.y]);
	}
	
	@Test
	public void OOBShip() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(10, 1, 2, "S");
		assertFalse("Boat out of bounds", tester.placeship(boat));
	}
	
	@Test
	public void TooSmallShip() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 1, "W");
		assertFalse("we need a bigger boat", tester.placeship(boat));
	}
	
	@Test
	public void TooBigShip() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 20, "N");
		assertFalse("we need a smaller boat", tester.placeship(boat));
	}
	
	@Test
	public void CrashShip() 
	{
		Board tester = new Board(3,3);
		Ship iceberg = new Ship(2, 2, 2, "N");
		tester.placeship(iceberg);
		Ship titanic = new Ship(1, 3, 2, "W");
		assertFalse("titanic crashed", tester.placeship(titanic));
	}
	
	@Test
	public void OOBShot() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(10, 1, 2, "N");
		tester.placeship(boat);
		assertFalse("Shot out of bounds", tester.shoot(10, 10));
	}
	
	@Test
	public void MissShot() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		assertFalse("Shot misses", tester.shoot(2, 2));
	}
	
	@Test
	public void HitShot() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		assertTrue("Shot hits", tester.shoot(1, 1));
	}
	
	@Test
	public void NoLife() 
	{
		Board tester = new Board(3,3);
		assertTrue("devoid of life", tester.dead());
	}
	
	@Test
	public void LetThereBeLife() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		assertFalse("Things are alive", tester.dead());
	}
	
	@Test
	public void ShootThemAll() 
	{
		Board tester = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		tester.shoot(1, 1);
		tester.shoot(1, 2);
		assertTrue("ships all sunk", tester.dead());
	}
	
	@Test
	public void ShowMissShot() 
	{
		Board tester = new Board(3,3);
		Board targets = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		targets.update(2, 2, tester.shoot(2, 2));
		assertEquals('M', targets.grid[2-1][2-1]);
	}
	
	@Test
	public void ShowHitShot() 
	{
		Board tester = new Board(3,3);
		Board targets = new Board(3,3);
		Ship boat = new Ship(1, 1, 2, "N");
		tester.placeship(boat);
		targets.update(1, 1, tester.shoot(1, 1));
		assertEquals('H', targets.grid[boat.x][boat.y]);
	}

}
