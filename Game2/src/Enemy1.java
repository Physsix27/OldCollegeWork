import java.awt.Color;
import java.awt.Graphics;

public class Enemy1 extends polygonModel2D
{
	public Enemy1(int x, int y, int angle)
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
				Color.red,
				Color.red,
				Color.white
			};
		return c;
	}

	public void draw(Graphics g) 
	{
		super.draw(g);
		g.setColor(Color.red);
		g.fillOval((int)x - 10, (int)y - 10, 20, 20);
		g.setColor(Color.red);
		g.drawOval((int)x - 45, (int)y - 45, 90, 90);
		
		
	}
	
	
}
