import java.awt.Graphics;

@SuppressWarnings("serial")
public class Game3 extends GameApplet
{
	ImageLayer layer1 = new ImageLayer("bg1.jpg", 0, 0, 10, 1024);
	Tank goodTank = new Tank(1024 / 2, 768 / 2, 270);
	
	public void initialize()
	{
		
	}
	
	public void respondToInput()
	{
		if(input[LT]) {
			goodTank.rotateLeftBy(10);
		}
		
		if(input[RT]){
			goodTank.rotateRightBy(10);
		}
		
		if(input[UP]){
			Camera2D.moveRightBy(10);
			goodTank.moveForwardBy(10);
		}
		
		if(input[DN]){
			Camera2D.moveLeftBy(10);
			goodTank.moveBackwardBy(10);
		}
	}
	
	public void moveGameObjects()
	{
		
	}
	

	public void handleCollisions() 
	{
		
	}

	public void keyReleased(int code)
	{
		input[code] = false;
	}

	public void keyPressed(int code, boolean shiftdown) 
	{
		input[code] = true;
	}
	
	public void paint(Graphics g)
	{	
		layer1.draw(g);
		goodTank.draw(g);
	}

	
}
