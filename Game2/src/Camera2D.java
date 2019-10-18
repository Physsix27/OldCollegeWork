
public class Camera2D 
{
	static double x;
	static double y;
	static int angleOfRotattion;
	
	public static void moveUpBy(int dy)
	{
		moveForwardBy(dy);
	}

	public static void moveDownBy(int dy)
	{
		moveBackwardBy(dy);
	}
	
	public static void moveRightBy(int dx)
	{
		x += dx;
	}
	
	public static void moveLeftBy(int dx)
	{
		x -= dx;
	}
	
	public void rotateLeftBy(int degree)
	{
		x -= degree;
		
		if(x < 0)
		{
			x += 360;
		}
	}
	
	//
	public void rotateRightBy(int degree)
	{
		x += degree;
		
		if(x > 359)
		{
			x -= 360;
		}
	} 

	//
	public static void moveForwardBy(int d)
	{
		x += d * lookUp.cos[angleOfRotattion];
		y += d * lookUp.sin[angleOfRotattion];
	}
	
	//
	public static void moveBackwardBy(int d)
	{
		x -= d * lookUp.cos[angleOfRotattion];
		y -= d * lookUp.sin[angleOfRotattion];
	}
}
