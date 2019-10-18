import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BigShip {
	Image bigShip;
	Controller controller;
	CollisionBox collisionBox;
	
	double x;
	double y;
	double velX;
	double velY;
	
	public BigShip(int x, int y){
		
		
		bigShip = Toolkit.getDefaultToolkit().getImage("FinalShip.png");
		this.x = (int) x;
	    this.y = y;
	    
	    collisionBox = new CollisionBox(x + 5 ,y , 85, 85);
	}
	
	public void tick()
	{  
		velX = 0;
		velY = 2;
	}
	
	public void enemyMoveUp() {
		this.y = y - velY;
		collisionBox.moveUpBy(velY);

	}

	public void enemyMoveDown() {
		this.y = y + velY;
		collisionBox.moveDownBy(velY);
	}

	public void enemyMoveLeft() {
		this.x = x - velX;
		collisionBox.moveLeftBy(velX);
	}
	
	public void enemyMoveRight(){
		this.x = x + velX;
		collisionBox.moveRightBy(velX);
	}
	
	public void setVelX(double d)
	{
		this.velX =  d; 
    }
	
	public void setVelY(double d)
	{
		this.velY =  d; 
    }
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
		
	// Gets the y value of the position of the smallShip
	public double getY() 
	{
		return y;
	}
		
	// Gets the x value of the position of the smallShip
	public double getX() 
	{
		return x;
	}
	
	// Draws and displays graphics of the SmallShip.
	public void draw(Graphics g)
	{
		g.drawImage(bigShip,  (int) x, (int) y, 100, 100, null);
		//collisionBox.draw(g);
	}
	
}
