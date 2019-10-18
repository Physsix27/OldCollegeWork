import java.awt.*;

// Asteroid Class
public class Asteroid
{
	// Image and controller objects
	Image asteroid;
	Controller controller;
	Rect r;
	
	// Declaring variables
    double x;
	double y;
	double velY;
	
	// Constructor of the class
	public Asteroid(double x, double y)
	{
		this.x = x;
	    this.y = y;
	    
	    // Gets the image of the asteroid from file
	    asteroid = Toolkit.getDefaultToolkit().getImage("asteroid.png");
	}
	
	// Moves the asteroid down the screen
	public void tick()
	{
		y += velY;
	}
	
	// Sets the velocity of the asteroid in a y point in the screen
	public void setVelY(double velY)
	{
		this.velY = velY; 
    }
	
	// Gets the y value of the position of the asteroid
	public double getY() 
	{
		return y;
	}
	
	// Gets the y value of the position of the asteroid
	public double getX() 
	{
		return y;
	}

	// Draws and displays graphics of the asteroids
	public void draw(Graphics g)
	{
		r = new Rect((int)x, (int)y, 60, 60);
		g.drawImage(asteroid, (int) x, (int) y, 60, 60, null);
		g.setColor(Color.red);
		r.draw(g);
	}

}
