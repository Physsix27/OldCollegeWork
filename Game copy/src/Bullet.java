import java.awt.*;

// Bullet Class
public class Bullet extends Controller
{
	// An image object
	Image bullet;
	CollisionBox collisionBox;
	
	// Declared variables, (x, y) point of the bullet and the y velocity
	double x;
	double y;
	double velY;
	
	// Constructor of the class
	public Bullet(double x, double y, Ship ship)
	{
		super(ship);
		this.x = x;
	    this.y = y;
	    
	    //Box for the bullet
	    collisionBox = new CollisionBox(x + 24, y,5,15);
	    
	    // Gets the image of the bullet from file
	    bullet = Toolkit.getDefaultToolkit().getImage("bullet1.png");
	}
	
	// Moves the bullet
	public void tick()
	{
		y -= velY;
		
		//To follow the bullets box going up.
		collisionBox.moveUpBy(velY);
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
		g.drawImage(bullet, (int) x + 13, (int) y, 30, 30, null);
		//g.setColor(Color.green);
		//collisionBox.draw(g);
	}

}
