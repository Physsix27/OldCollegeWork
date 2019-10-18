import java.awt.Graphics;

// Rect Class
public class Rect 
{

	// Declared variable
	int x;
	int y;
	int width;
	int height;
	
	// Constructor of the class 
	public Rect(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
		
		if(x < 0)
			x = 0;
		
		if(x >= 750 )
			x = 750;
		
		if(y  < 0)
			y = 0;
		
		if(y >= 650)
			y = 650;
		
	}
	
	// Moves the Sprite to the left
	public void moveLeftBy(int dx)
	{
		moveBy(-dx, 0);
	}
		
	// Moves the Sprite to the right
	public void moveRightBy(int dx)
	{
		moveBy(dx, 0);
	}
		
	// Moves the Sprite up
	public void moveUpBy(int dy)
	{
		moveBy(0, -dy);
	}
		
	// Moves the Sprite down
	public void moveDownBy(int dy)
	{
		moveBy(0, dy);
	}
	
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getLocation(int x, int y)
	{
		return x & y;
	}
	
	public boolean hasCollided(Rect r)
	{
		//       to the right
		return ((r.x <= x + width) && (r.x + r.width >= x) && (r.y + r.height >= y) && (r.y <= y + height));
	}
	
	public void draw(Graphics g)
	{
		g.drawRect(x, y, width, height);	
	}
}
