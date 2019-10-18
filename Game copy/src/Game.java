import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import Audio.AudioPlayer;

// Main Game Class
@SuppressWarnings("serial")
public class Game extends Applet implements Runnable, KeyListener
{	  
	// Number of milliseconds to wait between frames
	private       int duration   = 15;
	
	// Booleans for pausing and ending the Game Loop
    boolean           paused     = false;
    boolean           finished   = false;
    
    // The thread in which the Game Loop will execute
 	Thread            thread;
 	
 	// Loading
 	public static int loading;
 	
 	// Bullet timer
 	public 		  int timer      = 10;
 	
 	// Game Data
 	public static int health     = 100;
 	public static int score      = 0;
 	public static int highScore  = 0;
	
 	//music
 	private AudioPlayer bmusic;
 	private AudioPlayer shootingMusic;
 	
    // States Available for the game
 	public enum STATE
 	{
 		MENU,
 		GAME,
 		HELP,
 		PREGAME,
 		END
 	}; 
 	
 	// Main State (first one that appears)
 	public static STATE State = STATE.MENU;
 	
	// Declaring objects from other classes
	Ship       		plane;
	BigShip 		bigShip;
	Asteroid        asteroid;
	background		menuBackground;
	background      preGameBackground;
	ImageLayer      gameBackground;
    Controller      controller;
	Menu            menu;
	Help            help;
	BluePoints      bp;
	
	// Declaring our key codes as booleans
	boolean         leftPressed 	 = false;
	boolean         rightPressed     = false;
	boolean         upPressed        = false;
	boolean         downPressed      = false;
	boolean         xPressed         = false;
	
	// My initializer function
	public void init()
	{
		// Setting the size of my screen
	    this.setSize(800, 740);
	    
		// Initializing objects of other classes
		menu              = new Menu();
		help              = new Help();
		plane             = new Ship(getWidth()/2 - 38, getHeight() - 100);
		bigShip 		  = new BigShip(0 , 0);	
		controller        = new Controller(plane);
		asteroid          = new Asteroid(getX(), getY());
		bp                = new BluePoints(getX(), getY(), 10, 740);
		menuBackground    = new background(getX(), getY(), "menubg1");
		gameBackground    = new ImageLayer("gamebg2.png", getX(), getY(), 10, 740);
		preGameBackground = new background(getX(), getY(), "pregamebg");
		
		//music
		bmusic            = new AudioPlayer("/Music/spaceinvaders1.wav");
		bmusic.play();
		shootingMusic     = new AudioPlayer("/SouEff/fire.wav");
		
		// Mouses interaction done in the MouseInput class
		this.addMouseListener(menu);
		
		// Set up key event handling and set focus to applet window.
		requestFocus();
		addKeyListener(this);
		thread = new Thread(this);
		thread.start();
	}

	// My run method
	public void run() 
	{
		preGameLoop();
		  
		  // Game loop
		  while(!finished)
		  {
			  timer--;
		  	  inGameLoop();
		  	  repaint();
		  	  sleep(duration);
		  }
	}

	public void preGameLoop() 
	{
		//what you want to do when the game is done
		State = STATE.PREGAME;
	}

	//try and catch
	public void sleep(int milliseconds)
	{
		try
	    {
			Thread.sleep(milliseconds);
		}
		catch (Exception x){};
	}

	public void shooting() 
	{
		while(timer <= 0){
		// Calls the bullet class, to get a bullet image and the controller 
		// class adds that image bullet to the ship (x,y) and the velocity is set
		Bullet bullet = new Bullet(plane.getX() + 9, plane.getY(), plane);
		controller.addBullet(bullet);
		bullet.setVelY(20);
		shootingMusic.play();
		timer = 10;
		}
	}

	//Game state
	public void inGameLoop() 
	{
		if(State == STATE.GAME)
		{
			
		  // Add and moves the asteroids
		  controller.generateRandomAsteroids(getX());
		  controller.generateRandomBluePoints(getX());
				
		  Camera2D.moveDownBy(10);
				
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
			shooting();
		  }
		}
	}

	public void keyTyped(KeyEvent e){}

	// Keyboard tiles were pressed
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
	
	// My paint method, draws to the screen
	public void paint(Graphics g) 
	{
		if(State == STATE.PREGAME)
		{
			//Before the menu shows this is draw
			for(loading = 0; loading < 150; loading+=15)
			{
				preGameBackground.draw(g);
				Font fnt3 = new Font("SignPainter", Font.BOLD, 50);
				g.setFont(fnt3);
				g.setColor(Color.white);
				g.drawString("Loading...", 5, getHeight() - 20);
				g.setColor(new Color(255, 100, 255));
				g.drawRect(getWidth()/2 - 75, getHeight()/2, 150, 10);
				g.fillRect(getWidth()/2 - 75, getHeight()/2, loading, 10);
							
				try
				{
					Thread.sleep(100);
				}catch(Exception e){}
			}
			
			State = STATE.MENU;
		}
	    else if(State == STATE.MENU)
		{
			menuBackground.draw(g);
			menu.draw(g);
			menu.rotate(1.5);
		}
		else if(State == STATE.GAME)
		{

		 	String s = "score: " + score;
			gameBackground.draw(g);
			controller.draw(g);
			controller.tick();
			bigShip.tick();
			plane.draw(g);
			
			//Health
			Font fnt1 = new Font("Arial", Font.BOLD, 15);
			g.setColor(Color.green);
			g.setFont(fnt1);
			g.drawString("Health", 5, 20);
			g.setColor(Color.red);
			g.fillRect(5, 25, 100, 10);
			g.setColor(Color.yellow);
			g.fillRect(5, 25, health, 10);
			//score
			g.setColor(Color.white);
			g.drawString(s, 5, 55);
			
		}
		else if(State == STATE.HELP)
		{
			menuBackground.draw(g);
			help.draw(g);
			help.rotate(3);
			
		}
		else if(State == STATE.END)
		{
			setBackground(Color.black);
			
			// Drawing letters and displaying the buttons to the screen
			Font fnt1 = new Font("Arial", Font.BOLD, 70);
			Font fnt2 = new Font("Arial", Font.BOLD, 30);
			g.setColor(Color.white);
			g.setFont(fnt1);

			g.drawString("GAME OVER",200, 100);
			g.setFont(fnt2);

			g.drawString("Try Again", 330,  635);
			g.drawRect(Game.WIDTH + 300, 600, 200, 50);
			
			g.drawString("Your score is: " + score, 240, 300);

			
		}
	}
	
}
