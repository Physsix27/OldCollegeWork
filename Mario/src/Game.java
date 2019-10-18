import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

@SuppressWarnings("serial")
public class Game extends Applet implements Runnable, KeyListener
{
	//Player
	GoodCircle goodCircle;
//private ArrayList bullets; // this will hold our bullets 
	Bullet 	   b;
	Control controller;
	
	//Boundaries 
	Line Ll;
	Line Lr;
	Line Lb;
	Line Lt;
	
	Thread t;
	
	//
	Image offscreen;
	Graphics offscreen_g;
	Image tree;
	
	//Declaring our key codes as booleans
	boolean         leftPressed 	 = false;
	boolean         rightPressed     = false;
	boolean         upPressed        = false;
	boolean         downPressed      = false;
	boolean         xPressed         = false;
	
	//My initializer function
    public void init()
	{
    	setSize(1024, 768);
    	
		offscreen = this.createImage(1250, 740);
		offscreen_g = offscreen.getGraphics();
		
		tree = Toolkit.getDefaultToolkit().getImage("Tree_up_0.png");

    	Lt = new Line(0, 1024, 0, 0);
    	Lb = new Line(1023, 1, 739, 739);
    	Ll = new Line(1, 1, 739, 1);
    	Lr = new Line(1023, 1023, 1, 739);
    	
		goodCircle  = new GoodCircle(600, 250, 10, 270);
		b = new Bullet(goodCircle.getX(), goodCircle.getY(), goodCircle.angle, 5, 5);
		
		//Acquire method defined in class
    	requestFocus();
    	
    	//Attach the KeyLister in order to motinor keyPresses
    	addKeyListener(this);
    	
    	//The thread for the main loop
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
			moving();
			boundaries();
			repaint();
			sleep();
		}
	}
	
	public void update(Graphics g)
	{
		offscreen_g.clearRect(0, 0, 1024, 768);
		paint(offscreen_g);
		g.drawImage(offscreen, 0, 0, this);
	}
	
	public void sleep()
	{
		// Going to sleep
		try
		{
			Thread.sleep(15);
		}
		catch (Exception x){};
	}
	
	public void moving()
	{
		// When key are pressed this happens
		if(leftPressed) 
		{
			goodCircle.rotateLeftBy(5);
		}
					
		if(rightPressed) 
		{
			goodCircle.rotateRightBy(5);
		}   
						
		if(upPressed)
		{
			goodCircle.moveForwardBy(5);
		}
						
		if(downPressed) 
		{
			goodCircle.moveBackwardBy(5);
		}
		if(xPressed) 
		{	
			
			b.hashCode();
			b.moveForward(10);
			
		}
	}
    
	public void boundaries()
	{
		//Line collision
		double d = Ll.diastance((int) (goodCircle.x), (int) (goodCircle.y));
		if(d < goodCircle.radius)
		{
			goodCircle.moveBy((int) ((goodCircle.radius - d) * Ll.yv), (int) ((d - goodCircle.radius) * Ll.xv));
		}
		
		d = Lr.diastance((int) (goodCircle.x), (int) (goodCircle.y));
		if(d < goodCircle.radius)
		{
			goodCircle.moveBy((int) ((goodCircle.radius - d) * Lr.yv), (int) ((d - goodCircle.radius) * Lr.xv));
		}
		
		d = Lt.diastance((int) (goodCircle.x), (int) (goodCircle.y));
		if(d < goodCircle.radius)
		{
			goodCircle.moveBy((int) ((d - goodCircle.radius) * Lt.yv), (int) ((goodCircle.radius - d) * Lt.xv));
		}
		
		d = Lb.diastance((int) (goodCircle.x), (int) (goodCircle.y));
		if(d < goodCircle.radius)
		{
			goodCircle.moveBy((int) ((d - goodCircle.radius) * Lb.yv), (int) ((goodCircle.radius - d) * Lb.xv));
		}
	}
	
	public void keyTyped(KeyEvent e){}

	// Keyboard tiles were pressed
	public void keyPressed(KeyEvent e) 
	{
		
		    if(e.getKeyCode()==KeyEvent.VK_LEFT)  {
		    	leftPressed = true;
		    }
		
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				rightPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_UP) 
				upPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN) 
			    downPressed = true;
			
			if(e.getKeyCode()==KeyEvent.VK_X)
				xPressed = true;
	}
	
	// Keyboard tiles were released
	public void keyReleased(KeyEvent e)
	{
			if(e.getKeyCode()==KeyEvent.VK_LEFT) 
				leftPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
				rightPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_UP)
				upPressed = false;
	
			if(e.getKeyCode()==KeyEvent.VK_DOWN) 
				downPressed = false;
			
			if(e.getKeyCode()==KeyEvent.VK_X)
				xPressed = false;
	}
	
    
    // My paint method, draws to the screen
 	public void paint(Graphics g) 
 	{
 		//g.drawImage(tree, 350, 500, 100, 100, this);
 		
 		g.setColor(Color.red);
		Lt.draw(g);
		Lb.draw(g);
		Lr.draw(g);
		Ll.draw(g);
		

		goodCircle.draw(g);
		g.setColor(Color.green);
		b.draw(g);
		
		
 	}

}
