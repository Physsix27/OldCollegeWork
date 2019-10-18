import java.awt.*;

// Bullet Class
public class Bullet
{
	// An image object
	Image bullet;
	Rect r;
	
	// Declared variables, (x, y) point of the bullet and the y velocity
	double x;
	double y;
	double velY;
	
	// Constructor of the class
	public Bullet(double x, double y, Drawing drawing)
	{
		this.x = x;
	    this.y = y;
	    
	    
	    
	    // Gets the image of the bullet from file
	    bullet = Toolkit.getDefaultToolkit().getImage("bullet2.png");
	}
	
	// Moves the bullet
	public void tick()
	{
		y -= velY;
	}
	
	// Sets the velocity of the bullet in a y point in the screen
	public void setVelY(double velY)
	{
		this.velY = velY; 

    }
	
	// Getting the y value of the position bullet 
	public double getY() 
	{
		return y;
	}
	
	// Draws and displays graphics of the bullet
	public void draw(Graphics g)
	{
		r = new Rect((int)x + 25, (int)y + 5, 8, 20);
		g.drawImage(bullet, (int) x + 13, (int) y, 30, 30, null);
		g.setColor(Color.red);
		r.draw(g);
	}

}
