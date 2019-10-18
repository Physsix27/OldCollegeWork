import java.awt.*;

// Sprite Class
public class Sprite
{
	// My x and y
	int x;
	int y;
	int width;
	int height;
	
	// Calls my animation class as an array
	Animation[] animation;
	
	//
	public static final int DN = 0;
	public static final int UP = 1;
	public static final int LT = 2;
	public static final int RT = 3; 
	
	// position
	int pos = DN;
	
	// Jumping and moving variables
	boolean moving = false;
	boolean jumping = false;

	// Constructor class
	public Sprite(int x, int y, int width, int height, String filename, int count, int duration, String [] pos)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		animation = new Animation[pos.length];
		
		for(int i = 0; i < animation.length; i++)
		{
			animation[i] = new Animation(filename + "_" + pos[i] + "_" , count, duration);
		}
        
	}
	
	// Moves the Sprite
	public void moveBy( int dx, int dy)
	{
		x += dx;
		y +=dy;
		
		if(x < 0)
			x = 0;
		
		if(x >= 725 )
			x = 725;
		
		if(y  < 0)
			y = 0;
		
		if(y >= 650)
			y = 650;
		
		moving = true;
	}
	
	// Moves the Sprite to the left
	public void moveLeftBy( int dx)
	{
		moveBy(-dx, 0);
		pos = LT;
	}
	
	// Moves the Sprite to the right
	public void moveRightBy( int dx)
	{
		moveBy(dx, 0);
		pos = RT;
	}
	
	// Moves the Sprite up
	public void moveUpBy( int dy)
	{
		moveBy(0, -dy);
		pos = UP;
	}
	
	// Moves the Sprite down
	public void moveDownBy( int dy)
	{
		moveBy(0, dy);
		pos = DN;
	}
	
	// Sets the x point of the Sprite
	public void setX(int x)
	{
	    this.x = x;
	}

	// Sets the y point of the Sprite
	public void setY(int y)
	{
	    this.y = y;
	}

	// Gets the x point of the Sprite
	public int getX()
	{
	    return this.x;
	}

	// Gets the y point of the Sprite
	public int getY()
	{
	    return this.y;
	}

	public boolean contains(int mx, int my)
	{
		return ((mx <= x +width) && (mx >= x) && (my >= y) && (my <= y + height));
		
	}
	
	public boolean hasCollided(Rect r)
	{
		moving = true;
		//       to the right
		return ((r.x <= x + width) && (r.x + r.width >= x) && (r.y + r.height >= y) && (r.y <= y + height));
	}
	
	
	// It draws and displays graphics of the sprite
	public void draw(Graphics g) 
	{	
		if(moving)
		{
			//drawing all the images that are in our file to animate them
			//first picture that is taking is the down animation image
			g.drawImage(animation[pos].nextImage(), x, y, width, height, null);
		}
		else
		{
			g.drawImage(animation[pos].staticImage(), x, y, width, height, null);
		}
		moving = false;
	}
}