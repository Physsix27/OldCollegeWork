import java.awt.Graphics;

@SuppressWarnings("serial")
public class Game2 extends GameApplet
{
	boolean up_Pressed     = false;
	boolean dn_Pressed   = false;
	boolean lt_Pressed  = false;
	boolean rt_Pressed   = false; 
	
	Tank goodTank = new Tank (450, 450, 270);
	Enemy badTank = new Enemy (300, 450, 270);
	
	public void initialize()
	{
		
	}
	
	public void respondToInput()
	{

		if(lt_Pressed) {
			goodTank.rotateLeftBy(10);
		}
		
		if(rt_Pressed){
			goodTank.rotateRightBy(10);
		}
		
		if(up_Pressed){
			Camera2D.moveRightBy(10);
			goodTank.moveForwardBy(10);
		}
		
		if(dn_Pressed){
			Camera2D.moveLeftBy(10);
			goodTank.moveBackwardBy(10);
		}
	}
	
	public void moveGameObjects()
	{
		badTank.chase(goodTank);
	}
	

	public void handleCollisions() 
	{
		
	}

	public void keyReleased(int code)
	{
		if (code == UP) up_Pressed = true;
		if (code == DN) dn_Pressed = true;
		if (code == LT) lt_Pressed = true;
		if (code == RT) rt_Pressed = true;
		
		//input[code] = false;
	}

	public void keyPressed(int code, boolean shiftdown) 
	{
			if (code == UP) up_Pressed = false;
		if (code == DN) dn_Pressed = false;
		if (code == LT) lt_Pressed = false;
		if (code == RT) rt_Pressed = false; 
		//input[code] = true;
	}
	
	public void paint(Graphics g)
	{
		goodTank.draw(g);
		badTank.draw(g);
	}

	
}
