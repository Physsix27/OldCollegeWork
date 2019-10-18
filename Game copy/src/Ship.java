import java.awt.*;

public class Ship extends Sprite
{
	// Classes objects
	Game game;
	CollisionBox collisionBox;
	
	// Array of type String for our 'position'
	private final static String[] pos =
	{
			"dn",
			"up",
			"lt",
			"rt"
	};
	
	
	public Ship(int x, int y) 
	{
		super(x, y, 75, 95, "ship", 3, 5, pos);
		
		// Box for the plane
		collisionBox = new CollisionBox(x, y, 75, 75);
	}
	
	public void moveBy(int dx, int dy)
	{
		super.moveBy(dx, dy);
	
		//Doesn't let the plane box go out of the screen
		int tempY = (int)collisionBox.y + dy;
        if(tempY <= 350  || tempY >= 660)
			dy = 0;
        int tempX = (int)collisionBox.x + dx;
		if(tempX >= 725  || tempX <= 0)
			dx = 0;
		
		collisionBox.moveBy(dx, dy);
		
	}
	
	public void draw(Graphics g)
	{	
		super.draw(g);
		//collisionBox.draw(g);
	}
}
