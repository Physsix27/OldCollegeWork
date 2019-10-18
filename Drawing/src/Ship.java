import java.awt.Color;
import java.awt.Graphics;

public class Ship extends Sprite
{
	Rect verticalRect;
	Rect horizontalRect;
	
	// Array of type String for our 'pos'
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
		
		verticalRect = new Rect(x + 25, y, 23, 70);
		horizontalRect = new Rect(x, y + 45, 75, 23);
	}
	
	public void moveBy(int dx, int dy)
	{
		super.moveBy(dx, dy);
		verticalRect.moveBy(dx, dy);
		horizontalRect.moveBy(dx, dy);
		if(verticalRect.x < 25 )
			verticalRect.x = 25;
		if(verticalRect.x > 750 )
			verticalRect.x = 750;
		if(horizontalRect.y < 45 )
			horizontalRect.y = 45;
		if(horizontalRect.x > 725)
			horizontalRect.x = 725;
		
	}
	
	public void draw(Graphics g)
	{	
		super.draw(g);
		g.setColor(Color.red);
		verticalRect.draw(g);
		horizontalRect.draw(g);
	}
}
