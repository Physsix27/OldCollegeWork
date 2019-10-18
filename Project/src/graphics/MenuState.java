package graphics;

import java.awt.*;
import java.awt.event.MouseAdapter;
import game.GameManager;

//Menu Class
public class MenuState extends MouseAdapter
{
	// Images objects
	Image logo;
	Image button;
	
	// Creating rectangles for the buttons
	public Rectangle playButton = new Rectangle(GameManager.width/2 - 125, 350, 250, 70);
	public Rectangle helpButton = new Rectangle(GameManager.width/2 - 125, 450, 250, 70);
	public Rectangle quitButton = new Rectangle(GameManager.width/2 - 125, 550, 250, 70);
	
	// Constructor of the class
	public MenuState()
	{
		// Gets the image of the logo and the ship from file
		logo = Toolkit.getDefaultToolkit().getImage("images/Logo/killthemallLogo2.png");
		button = Toolkit.getDefaultToolkit().getImage("images/buttons/button.png");
	}
	 
	// Drawing method
	public void draw(Graphics g)
	{
			// Drawing images objects
			g.drawImage(logo, GameManager.width /2 - 550 , 50, 1100, 250, null);
			
			Graphics2D g2d = (Graphics2D) g;
			// Drawing letters and displaying the buttons to the screen

			Font fnt1 = new Font("Arial", Font.BOLD & Font.ITALIC, 50);
			g.setFont(fnt1);
			g.setColor(Color.black);
			g.drawImage(button, GameManager.width /2 - 250, 280, null);
			g.drawString("Play", playButton.x + 80, playButton.y + 55);
			//g2d.draw(playButton);
			
			g.drawImage(button, GameManager.width /2 - 250, 380, null);
			g.drawString("Help", helpButton.x + 80, helpButton.y + 55);
			//g2d.draw(helpButton);
			
			g.drawImage(button, GameManager.width /2 - 250, 480, null);
			g.drawString("Quit", quitButton.x + 80, quitButton.y + 55);
			//g2d.draw(quitButton);
		
	}

}
