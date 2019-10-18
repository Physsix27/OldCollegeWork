package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import GameState.GameStateManager;
import java.awt.image.BufferedImage;

//It suppresses the warning of the serial ID of the GamePanel class
@SuppressWarnings("serial")

public class GamePanel extends JPanel implements Runnable, KeyListener
{
	//Dimension
	public static final int width = 320;
	public static final int height = 240;
	public static final int scale = 2;
	
	
	//Game Threat
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private  long targetTime = 1000 / FPS;
	
	//Image this is where we drawing
	private BufferedImage image;
	private Graphics2D g;
	
	//Game State Manager
	private GameStateManager gsm;
	
	//Constructor
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(width * scale, height * scale));
		setFocusable(true);
		requestFocus();
	}
	
	//The game panel is done loading so I can go ahead and start
	public void addNotify()
	{
		//
		super.addNotify();
	
		//
		if(thread == null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	//It will initialized everything it needs to be initialized 
	public void init()
	{
		//
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
		
	}
	
	//Run methosd
	public void run() 
	{
		init();
		
		// Timers
		long start;
		long elapsed;
		long wait;
		
		//Game loop
		while(running)
		{
			//Time stamp
			start = System.nanoTime();
			
			//Calling functions that performs the gmae
			update();
			draw();
			drawToScreen();
			

			elapsed = System.nanoTime() - start;
			
			//Since target time is in nanosecond and elapsed is is milliseconds it has to divide by a million
			wait = targetTime - elapsed / 1000000;
			
			if(wait < 0)
			{
				wait = 5;
			}
			
			//Just wait that amount of time
			try{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
	}

	private void update() 
	{
		gsm.update();
	}
	
	private void draw() 
	{
		gsm.draw(g);
	}
	
	private void drawToScreen() 
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, width * scale, height * scale, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e) 
	{
		gsm.keyPressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) 
	{
		gsm.keyReleased(e.getKeyCode());
	}
	
}
