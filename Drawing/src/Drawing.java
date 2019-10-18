import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// Main Game Class
public class Drawing extends Applet implements Runnable, KeyListener
{
	// Declaring objects from other classes
	Bullet    	    bullet;
	Ship       		plane;
	Asteroid        asteroid;
	background 		gameBackground;
	background		menuBackground;
	background 		helpBackground;
	background 		gameOver;
	
	// 
	Thread          t;
	
	// Declaring our key codes as booleans
	boolean         leftPressed 	 = false;
	boolean         rightPressed     = false;
	boolean         upPressed        = false;
	boolean         downPressed      = false;
	boolean         xPressed         = false;
	
	// Objects of other classes
	private         Controller       controller;
	private         Menu             menu;
	private         Help             help;
	
	// States Available for the game
	public enum STATE
	{
		MENU,
		GAME,
		HELP
	}; 
	
	// Main State (first one that appears)
	public static STATE State = STATE.MENU;

	// My initializer function
	public void init()
	{
		// Setting the size of my screen
	    this.setSize(800,740);
	    
	    // Width and Height of the screen
		int width        = getSize().width;
		int heigth       = getSize().height;
		
		// Initializing objects of other classes
		menu             = new Menu();
		help             = new Help();
		controller       = new Controller(this);
		asteroid         = new Asteroid(getX(), getY());
		gameBackground   = new background(getX(), getY(), "background1");
		menuBackground   = new background(getX(), getY(), "background3");
		helpBackground   = new background(getX(), getY(), "background3");
		gameOver         = new background(getX(), getY(), "background6");
		plane            = new Ship(width/2 - 38, heigth - 100);
		
		
		//
		this.addMouseListener(new MouseInput());
		
		//`
		requestFocus();
		addKeyListener(this);
		t = new Thread(this);
		t.start();
	}

	// My run method
	@Override
	public void run() 
	{
		// Game loop
		while(true)
		{	
			if(State == STATE.GAME)
			{
				// Add and moves the asteroids
				controller.generateRandomAsteroids(getY());
				
				// When key are pressed this happens
				if(leftPressed) 
				{
					plane.moveLeftBy(10);
				}
				    
				if(rightPressed) 
				{
					plane.moveRightBy(10);
				}   
				
				if(upPressed)
				{
					plane.moveUpBy(10);
				}
					
				if(downPressed) 
				{
					plane.moveDownBy(10);
				}
				
				if(xPressed)
				{
					// Calls the bullet class, to get a bullet image and the controller 
					// class adds that image bullet to the ship (x,y) and the velocity is set
					bullet = new Bullet(plane.getX() + 9, plane.getY(), this);
					controller.addBullet(bullet);
					bullet.setVelY(5);
				}
			}
			
			update();
			
			// Call the paint method every 60 of a second
			repaint();
			
			// 
			try
			{
				Thread.sleep(15);
			}
			catch (Exception x){};
		}
	}

	@Override
	public void keyTyped(KeyEvent e){}

	// Keyboard tiles were pressed
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(State == STATE.GAME)
		{
		    if(e.getKeyCode()==KeyEvent.VK_LEFT )  
		    	leftPressed = true;
		
			if(e.getKeyCode()==KeyEvent.VK_RIGHT )
				rightPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_UP ) 
				upPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN ) 
			    downPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_X)
				xPressed = true;
		}
	}

	// Keyboard tiles were released
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(State == STATE.GAME)
		{
			if(e.getKeyCode()==KeyEvent.VK_LEFT ) 
				leftPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT ) 
				rightPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_UP )
				upPressed = false;
	
			if(e.getKeyCode()==KeyEvent.VK_DOWN ) 
				downPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_X)
				xPressed = false;
		}
	}
	
	// Random methods that return a random # between 2 #
	public double random()
	{
		return  Math.random() * 1 + 1;
	}
	
	public double randomX()
	{
		return Math.random() * 725 + .1;
	}
	
	public void update()
	{
		/*
		//Collision
		for(Bullet b : controller.b){
			for(Asteroid a: controller.a){
		if
		(
			b.r.hasCollided(a.r) ||plane.verticalRect.hasCollided(a.r) || 
			plane.horizontalRect.hasCollided(a.r)
	    )
		{
			System.out.printf(" **** ");
		}
			}
		}
		*/
	}
	
	
	// My paint method, draws to the screen
	public void paint(Graphics g) 
	{
		if(State == STATE.MENU)
		{
			menuBackground.draw(g);
			menu.draw(g);
			menu.rotate(2);
		}
		else if(State == STATE.GAME)
		{
			gameBackground.draw(g);
			controller.draw(g);
			controller.tick();
			plane.draw(g);
			
		}
		else if(State == STATE.HELP)
		{
			helpBackground.draw(g);
			help.draw(g);
			
		}
	}
	
}

/*
  
  
 
 */