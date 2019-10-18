import java.awt.*;

// Asteroid Class
public class Asteroid
{
	// Image and classes objects
	Image asteroid;
	Controller controller;
	CollisionBox collisionBox;
	
	// Declaring variables
    double x;
	double y;
	double width;
	double height;
	double velY;
	boolean explode ;
	Animation explosion;
	
	
	// Constructor of the class
	public Asteroid(double x, double y)
	{
		this.x = x;
	    this.y = y;
	    
	    //Box for the Asteroid
	    collisionBox = new CollisionBox(x , y ,60,60 );
	    // Gets the image of the asteroid from file
	    asteroid = Toolkit.getDefaultToolkit().getImage("asteroid.png");
	    
	    // creates the animation for explosions
	    explosion = new Animation("asteriodDeath_", 6, 3);
	    
	    
	    
	}
	
	// Moves the asteroid down the screen
	public void tick()
	{
		y += velY;
		
		//To follow the asteroid box going down
		collisionBox.moveDownBy(velY);
		
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
		return x;
	}

	// Draws and displays graphics of the asteroids
	public void draw(Graphics g)
	{
		g.drawImage(asteroid, (int) x, (int) y, 60, 60, null);
		//g.setColor(Color.green);
		//collisionBox.draw(g);
		
		if(explode == true){
			
			System.out.println("explosion");
			g.drawImage(explosion.nextImage(), (int) x, (int) y, null);
			
			
				
		}
	}

}
