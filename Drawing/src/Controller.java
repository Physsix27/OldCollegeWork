import java.awt.*;
import java.util.*;

// Controller Class
public class Controller 
{
	// Linked list of bullets and asteroids images
	public LinkedList<Bullet> b = new LinkedList<Bullet>();
	public LinkedList<Asteroid> a = new LinkedList<Asteroid>();
	
	// Objects from other classes
	Bullet Templebullet;
	Asteroid Templeasteroid;
	Drawing drawing;
	Ship plane;
	
	// Constructor of the class
	public Controller(Drawing drawing)
	{
		this.drawing = drawing;

	}
	
	// Creates an asteroid and puts it in the linkedList and moves 
	public void generateRandomAsteroids(int y)
	{
		if(a.isEmpty())
		{
			int asteroidsAmount = new Random().nextInt(20) + 10;
			
			for(int i = 0; i < asteroidsAmount; i++) 
			{
				Asteroid asteroid = new Asteroid(randomX(), y - 100);
				asteroid.setVelY(random());
				addAsteroid(asteroid);
			}
		}
	}
	
	// 
	public void tick()
	{
		for(int i = 0; i < b.size(); i++)
		{
			Templebullet = b.get(i);
			
			if(Templebullet.getY() < -100)
				removeBullet(Templebullet);
			
			Templebullet.tick();
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			Templeasteroid = a.get(i);
			
			if(Templeasteroid.getY() > 740)
				removeAsteroid(Templeasteroid);
			
			Templeasteroid.tick();
		}
	}
	
	// Adds a bullet from the bullet linked list
	public void addBullet(Bullet shot)
	{
		b.add(shot);
	}
	
	// Removes a bullet that is alive
	public void removeBullet(Bullet shot)
	{
		b.remove(shot);
	}
	
	// Adds a asteroid from the asteroid linked list
	public void addAsteroid(Asteroid shot)
	{
		a.add(shot);
	}
	
	// Removes a asteroid that is alive
	public void removeAsteroid(Asteroid shot)
	{
		a.remove(shot);
	}
	
	// Random methods that return a random # between 2 #
	public double random()
	{
		return  Math.random() * 1 + 1;
	}
	
	public double randomX()
	{
		return (int) (Math.random() * 725 + .1);
	}
	
	
	// Draws in the screen
	public void draw(Graphics g)
	{
		for(int i = 0; i < b.size(); i++)
		{
			Templebullet = b.get(i);
			Templebullet.draw(g);
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			Templeasteroid = a.get(i);
			Templeasteroid.draw(g);
		}
	}
}
