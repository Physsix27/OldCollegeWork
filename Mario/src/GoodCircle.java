import java.awt.*;

public class GoodCircle
{
	double x;
	double y;
	
	int radius;
	int angle;
	
	CollisionBox box;
	
	
	public GoodCircle(double x, double y, int radius, int angle)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.angle = angle;
		box = new CollisionBox(x - radius , y - radius, 20, 20);
		
	}
	
	public void rotateLeftBy(int degree)
	{
		angle -= degree;
		
		if(angle < 0)
		{
			angle += 360;
		}
	}
	
	//
	public void rotateRightBy(int degree)
	{
		angle += degree;
		
		if(angle > 359)
		{
			angle -= 360;
		}
	} 

	//
	public void moveForwardBy(int d)
	{
		x += d * lookUp.cos[angle];
		y += d * lookUp.sin[angle];
	}
	
	//
	public void moveBackwardBy(int d)
	{
		x -= d * lookUp.cos[angle];
		y -= d * lookUp.sin[angle];
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y -= dy;
		
		//To follow the circle box 
		box.moveBy(dx, dy);
	}

	// Getting the y value of the position bullet 
	public double getX() 
	{
		return x;
	}
	
	// Getting the y value of the position bullet 
	public double getY() 
	{
		return y;
	}
	

	public void draw(Graphics g)
	{
		g.fillOval((int) (x) - radius, (int) (y) - radius, 2 * radius, 2 * radius);
		g.setColor(Color.cyan);
		g.drawLine((int) x, (int) y, (int) (radius * lookUp.cos[angle] + x), (int) (radius * lookUp.sin[angle] + y) );
	}
}
