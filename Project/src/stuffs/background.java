package stuffs;

import java.awt.*;


// Background Class
public class background 
{
	// Declared variables
	int x;
	int y;
	int yPos = 800;
	int xPos = 1280;
	
	// An object of type Image
	Image bg;
	
	// Constructor of the class
	public background(int x, int y, String filename)
	{
		this.x = x;
		this.y = y;
		
		// Gets the image of the a background from file that finishes with ".png"
		bg = Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	// Draws and displays graphics of the background
	public void draw(Graphics g) 
	{
		g.drawImage(bg, x, y, xPos, yPos, null);
		
	}
	
}
