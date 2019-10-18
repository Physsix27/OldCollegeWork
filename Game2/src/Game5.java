import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Game5 extends GameApplet{
	
	Tree[] tree = new Tree[500];
	Camera3D camera = new Camera3D();
	
	String[] name = {"tree1", "tree2"};
	
	Random rnd = new Random();
	
	public void initialize()
	{
		for(int i = 0; i < tree.length; i++){
			int r = Math.abs(rnd.nextInt()) % 2;
			tree[i] = new Tree(50*(i % 25), 20, 50*(i % 25), 20, 45, name[r] + ".png");
			
		}
	}
	
	public void respondToInput()
	{
		   if(input[LT]) Camera3D.moveLeftBy(5);
	       if(input[RT]) Camera3D.moveRightBy(5);
		   if(input[UP]) Camera3D.moveInBy(5);
		   if(input[DN]) Camera3D.moveOutBy(5);
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
		g.setColor(Color.green);
		g.fillRect(0, 360, 1024, 360);
		
		
		for(int i = 0; i <= tree.length; i++)
		{
			tree[i].draw(g);
		}
	}


}
