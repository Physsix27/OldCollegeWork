
public class Camera3D
{
	static double x = 0;
	static double y = 0;
	static double z = 0;
	static int angleOfRotattion;

	public static void moveUpBy(int dy)
	{
		y += dy;
	}

	public static void moveDownBy(int dy)
	{
		y -= dy;
	}
	
	public static void moveRightBy(int dx)
	{
		x += dx;
	}
	
	public static void moveLeftBy(int dx)
	{
		x -= dx;
	}
	
	public static void moveInBy(int dz)
	{
		z -= dz;	
	}
	
	public static void moveOutBy(int dz)
	{
		z += dz;	
	}
	
}

