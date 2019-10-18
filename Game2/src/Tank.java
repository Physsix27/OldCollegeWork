import java.awt.*;

public class Tank extends polygonModel2D
{

	/*/ 1-2 2-3 3-4 4-1
	int[] bodyX = {40, -40, -40, 40};
	int[] bodyY = {20, 20, -20, -20};
	
	int[] lTrackX = {30, -30, -30, 30};
	int[] lTrackY = {-20, -20, -30, -30};
	
	int[] rTrackX = {30, -30, -30, 30};
	int[] rTrackY = {20, 20, 30, 30};
	
	int[] gunX = {35, 10, 10, 35};
	int[] gunY = {3, 3, -3, -3};
	//*/
	
	public Tank(int x, int y, int angle)
	{
		super(x, y, angle);
		
	}
	
	public int[][] xData()
	{
		int[][] structX = 
		{
			{40, -40, -40, 40},
			{30, -30, -30, 30},
			{30, -30, -30, 30},
			{35, 10, 10, 35}
		};

		return structX;
	}
	
	public int[][] yData()
	{
		
		int[][] structY = 
		{
			{20, 20, -20, -20},
			{-20, -20, -30, -30},
			{20, 20, 30, 30},
			{3, 3, -3, -3}
		};
		
		return structY;
	}
	
	public Color[] getColors()
	{
		Color[] c =
			{
				Color.black,
				Color.gray,
				Color.gray,
				Color.white
			};
		return c;
	}

	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.gray);
		g.fillOval((int)x - 10, (int)y - 10, 20, 20);
		g.setColor(Color.gray);
		g.drawOval((int)x - 45, (int)y - 45, 90, 90);
	}
}
