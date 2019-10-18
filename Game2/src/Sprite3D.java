import java.awt.*;

public class Sprite3D extends Object3D
{
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
	
	public Sprite3D
	(
			String filename,
			double x,
			double y,
			double z,
			int width,
			int height,
			int count, 
			int duration,
			String [] pos)
	{
		super(x, y, z);
		this.width = width;
		this.height = height;
		
		animation = new Animation[pos.length];
		
		for(int i = 0; i < animation.length; i++)
		{
			animation[i] = new Animation(filename + "_" + pos[i] + "_" , count, duration);
		}
	}
	

	// Moves the Sprite
	public void moveBy( int dx, int dy, int dz)
	{
		x += dx;
		y += dy;
		z += dz;
		
		moving = true;
	}
	
	// Moves the Sprite to the left
	public void moveLeftBy( int dx)
	{
		moveBy(-dx, 0, 0);
		pos = LT;
	}
	
	// Moves the Sprite to the right
	public void moveRightBy( int dx)
	{
		moveBy(dx, 0, 0);
		pos = RT;
	}
	
	// Moves the Sprite up
	public void moveUpBy( int dy)
	{
		moveBy(0, -dy, 0);
		pos = UP;
	}
	
	// Moves the Sprite down
	public void moveDownBy( int dy)
	{
		moveBy(0, dy, 0);
		pos = DN;
	}
	
	
	public void draw(Graphics g)
	{
		if(z > 0)
		{
		 if(moving)
		 {
			g.drawImage
			(animation[pos].nextImage(),
			(int) (d/z * (x - width / 2)) + xOrigin, 
			(int) (d/z * (y - height)) + yOrigin, 
			(int) (d/z * width), 
			(int) (d/z * height),
			null);
			
			g.drawImage(animation[pos].nextImage(), (int)x, (int)y, width, height, null);
		 }
		 else
		 {
			g.drawImage
			(animation[pos].staticImage(), 
			(int) (d/z * (x - width / 2)) + xOrigin,
			(int) (d/z * (y - height)) + yOrigin, 
			(int) (d/z * width), 
			(int) (d/z * height), 
			null);
		 }
	    }
		moving = false;
	}
}
