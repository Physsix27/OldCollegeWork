package TileMap;

import java.awt.*;
import Main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Background 
{
	public BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;

	//Constructor
	public Background(String s, double ms)
	{
		try
		{
			//Getting the image from the resource folder and with the 
			//resource folder you can have access to anything with this
			//through a path
			image = ImageIO.read(getClass().getResource(s));
			moveScale = ms;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	//Position of the screen
	public void setPosition(double x, double y)
	{
		//We don't want the image going off the screen
		this.x = (x * moveScale) % GamePanel.width;
		this.y = (y * moveScale) % GamePanel.height;
	}
	
	// dx and dy to automatically scroll the screen
	public void setVector(double dx, double dy)
	{
		this.dx = dx;
		this.dy = dy;
	}
	
	//update method
	public void update()
	{
		x += dx;
		y += dy;
	}
	
	
	public void draw(Graphics2D g)
	{
		g.drawImage(image, (int)x, (int)y, null);
		
		//Scrolling background make sure we draw another instance of the background
		//Scrolling to the left
		if(x < 0)
		{
			g.drawImage(image, (int)x + GamePanel.width, (int)y, null);
		}
		
		if(x > 0)
		{
			g.drawImage(image, (int)x - GamePanel.width, (int)y, null);
		}
	}
}
