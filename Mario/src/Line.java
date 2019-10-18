import java.awt.*;

public class Line
{
	int x1;
	int y1;

	int x2;
	int y2;
	
	double xv;
	double yv;
	
	public Line(int x1, int x2, int y1, int y2)
	{
		// Line
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		// Precalculate Vector v
		double magnitude = Math.sqrt((x1 - x2) * (x1 - x2) + ( y1 - y2) * (y1 - y2));
		
		xv = (x1 - x2) / magnitude;
				
		yv = (y1 - y2) / magnitude;
		
	}
	
	
	public double diastance(int x, int y)
	{
		return (x - x1) * yv - (y - y1) * xv;
		
	}

	public void draw(Graphics g)
	{
		g.drawLine(x1, y1, x2, y2);
	}
}
