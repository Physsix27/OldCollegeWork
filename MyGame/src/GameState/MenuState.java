package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState
{
	private Background bg; 
	private int currentChoice = 0;
	private String[] options =
	{
		"Start",
		"Help",
		"Quit"
	};
	
	//
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	//My Constructor
	public MenuState(GameStateManager gsm)
	{
		this.gsm = gsm;
		
		try
		{
			// Getting the image from file with a specific path
			bg = new Background("/Backgrounds/menubg.gif", 1);
			
			//Setting the vector moving to the left with a negative sign in the x value 
			bg.setVector(-0.1, 0);
			
			//Creating the letters that are going to be use in the menu
			titleColor = new Color(250, 250 ,0);
			titleFont = new Font("Century Gothic", Font.BOLD, 30);
			font = new Font("Arial", Font.PLAIN, 20);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void init() {}
	
	//Update method
	public void update() 
	{
		bg.update();
	}
	
	private void select()
	{
		if (currentChoice == 0)
		{
			//Start button
			//If enter is pressed it moves from the menu state to the level 1 state
			gsm.setState(GameStateManager.lEVEL1STATE);
		}
		
		if(currentChoice == 1)
		{
			//Help
			
		}
		
		if(currentChoice == 2)
		{
			//Quit
            System.exit(0);
		}
	}
	
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_ENTER)
			select();
		
		if(k == KeyEvent.VK_UP)
		{
			//It moves the cursor up in the menu
			currentChoice--;
			if(currentChoice == -1)
			{
				currentChoice = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_DOWN)
		{
			currentChoice++;
			if(currentChoice == options.length)
			{
				currentChoice = 0;
			}
		}
	}

	public void keyReleased(int k) {}
	
	//Draw method
	public void draw(Graphics2D g) 
	{
		//Draw background
		bg.draw(g);
			
		//Draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Survival City", 80, 70);
			
		//Drawing menu options
	    g.setFont(font);
	    for(int i = 0; i < options.length; i++)
	    {
	     	if(i == currentChoice)
	       	{
	      		g.setColor(Color.black);
	       	}
	       	else
	       	{
	       		g.setColor(Color.red);
	       	}
	        	g.drawString(options[i], 145,  140 + i * 25);
	        }	
		}
}
