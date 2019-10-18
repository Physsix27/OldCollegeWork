import java.awt.*;

//
public abstract class polygonModel2D 
{
	// Declared variables
	double x;
	double y;
	int angelofRotation;
	
	// How does the structure looks like
	int[][] structX = xData();
	int[][] structY = yData();
	
	Color[] color = getColors();
	
	
	//
	public polygonModel2D(int x, int y, int angle)
	{
		this.x = x;
		this.y = y;
		angelofRotation = angle;
	}
	
	//Abstract methods, there is a function call 
	//I don't know what it does but anybody can use it 
	//and make do something
	public abstract int[][] xData();
	public abstract int[][] yData();
	public abstract Color[] getColors();
	
	//
	public void rotateLeftBy(int degree)
	{
		angelofRotation -= degree;
		
		if(angelofRotation < 0)
		{
			angelofRotation += 360;
		}
	}
	
	//
	public void rotateRightBy(int degree)
	{
		angelofRotation += degree;
		
		if(angelofRotation > 359)
		{
			angelofRotation -= 360;
		}
	} 

	//
	public void moveForwardBy(int d)
	{
		x += d * lookUp.cos[angelofRotation];
		y += d * lookUp.sin[angelofRotation];
	}
	
	//
	public void moveBackwardBy(int d)
	{
		x -= d * lookUp.cos[angelofRotation];
		y -= d * lookUp.sin[angelofRotation];
	}
	
	// x and y is what ever we are chasing
	public double diastance(int x, int y)
	{
		// x of the good guy - x of the bad guy and same for the y
		return (x - this.x) * lookUp.sin[angelofRotation] - (y - this.y) * lookUp.cos[angelofRotation];
		
	}
	
	public double diastanceTo(int x, int y)
	{
		// x of the good guy - x of the bad guy and same for the y
		return (x - this.x) * lookUp.cos[angelofRotation] + (y - this.y) * lookUp.sin[angelofRotation];
		
	}
	
	//
	public void draw(Graphics g)
	{
		int xPoints[] = new int[4];
		int yPoints[]  = new int[4];
		
		double cosA = lookUp.cos[angelofRotation];
		double sinA = lookUp.sin[angelofRotation];
		
		for(int vertx = 0; vertx < structX.length; vertx++)
		{
			for(int verty = 0; verty < structY[vertx].length; verty++ )
			{
				xPoints[verty] = (int) ((structX[vertx][verty] * cosA) - (structY[vertx][verty] * sinA) + x);
				yPoints[verty] = (int) ((structX[vertx][verty] * sinA) + (structY[vertx][verty] * cosA) + y);
			}
			
			g.setColor(color[vertx]);
			
			g.fillPolygon(xPoints, yPoints, structX.length);
			g.setColor(Color.black);
			g.drawPolygon(xPoints, yPoints, structX.length);
		}
	}

}
