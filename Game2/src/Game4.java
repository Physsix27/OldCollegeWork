import java.awt.Graphics;

@SuppressWarnings("serial")
public class Game4 extends GameApplet
{

	Sprite3D[] player = new Sprite3D[25];
	
	private static final String[] pos = 
		{
				"up",
				"rt",
				"lt",
				"rt"
		};
	
	public void initialize()
	{
		for(int x = 0; x < 250; x += 50)
		{
			for(int z = 100; z < 350; z += 50)
			{
				player[x/50 + 5 *(z-100)/50] = new Sprite3D("mario_dn_0", x, 100, z, 50, 50, 5, 5, pos);
			}
			
		}

	}
	
	public void respondToInput()
	{
		for(int i = 0; i >=25; i++)
		{
		   if(input[LT]) player[0].moveLeftBy(-5);
	       if(input[RT]) player[0].moveRightBy(5);
		   if(input[UP]) player[0].moveUpBy(-5);
		   if(input[DN]) player[0].moveDownBy(5);
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
		for(int i = 24; i >= 25; i++)
		{
			player[i].draw(g);
		}
	}

	
}
