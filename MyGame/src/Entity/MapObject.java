package Entity;


import java.awt.Rectangle;

import GameState.Tile;
import GameState.TileMap;
import Main.GamePanel;

//This is the root of all game object that we will use
//When I need a player or a enemy class I would need to
//use all the things that are here
public abstract  class MapObject
{
	//Tile Stuff
	protected TileMap tileMap;
	protected int tileSize;
	protected double xmap;
	protected double ymap;
	
	//Position
	protected double x;
	protected double y;
	
	//Vector, Direction the object is going
	protected double dx;
	protected double dy;
	
	//Dimensions
	protected int width;
	protected int height;
	
	//Collision Box
	protected int cwidth;
	protected int cheight; 
	
	//Collision, variables so we don't have to keep
	//making new ones, destination where we are going
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	//Animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;
	protected boolean facingLeft;
	
	//Movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;
	
	//Prevent attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;
	protected double jumpStart;
	protected double stopJumpSpeed;
	 
	
	//Constructor
	public MapObject(TileMap tm)
	{
		//setting the tilemap and get the tile size
		tileMap = tm;
		tileSize = tm.getTileSize();
		
	}
	
	
	//Every map object needs to be able to  
	//check if it can collide every map object
	public boolean intersects(MapObject o)
	{
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		
		//It will tell me if these 2 map objects have collide
		return r1.intersects(r2);

	}
	
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)x - cwidth, (int)y - cheight, cwidth, cheight);
	}
	
	
	public void calculateCorners(double x, double y)
	{
		//four corners
		int leftTile = (int) (x - cwidth / 2) / tileSize;
		int rightTile = (int) (x + cwidth / 2 - 1) / tileSize; //The -1 is so we don't step into next column
		int topTile = (int) (y - cwidth / 2) / tileSize;
		int bottomTile = (int) (y + cwidth / 2 - 1) / tileSize;
		
		//
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		
		//This is a boolean that is sets true when the 
		//player goes to any of this corner and it prevents 
		//them to go trough the tiles
		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;
		
		 
		
	}
	
	
	public void checkTileMapCollision()
	{
	
		currCol = (int)x / tileSize;
		currRow = (int)y / tileSize;
		
		xdest = x + dx;
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
	
		//if we move upward
		calculateCorners(x, ydest);
		if(dy < 0)
		{
			if(topLeft || topRight)
			{
				dy = 0;
				
				//Sets the player right below the tile 
				ytemp = currRow * tileSize + cheight / 2;
			}
			else
			{
				//otherwise we can keep going up
				ytemp += dy;
			}
		}
		
		if(dy > 0)
		{
			if(bottomLeft || bottomRight)
			{
				//stop
				dy = 0;
				
				//if we're falling stop
				falling = false;
				
				//set the player one pixel above we're we just land it the tile
				ytemp = (currRow + 1) * tileSize - cheight / 2;
			}
			else
			{
				//otherwise we can keep going meaning there is no tile yet
				ytemp += dy;
				
			}
		}
		
		calculateCorners(xdest, y);
		//If either of this is true we need to stop moving we hit a tile
		if(dx < 0)
		{
			if(topLeft || bottomLeft)
			{
				dx = 0;
				xtemp = currCol * tileSize + cwidth / 2;	
			}
			else
			{
				xtemp += dx;
			}
		}
		
		if(dx > 0)
		{
			if(topRight || bottomRight)
			{
				dx = 0;
				xtemp = (currCol + 1) * tileSize - cwidth / 2;
				
			}
			else
			{
				xtemp += dx;
			}
		}
		
		//Check if we ran out of a cliff, check the ground
		if(!falling)
		{
			calculateCorners(x, ydest + 1);
			//we are no longer standing on a ground
			//so we need to start falling
			if(!bottomLeft && !bottomRight)
			{
				falling = true;
			}
			
		}
	}
	
	public int getx() {return (int)x; }
	
	public int gety() {return (int)y; }
	
	public int getWidth() {return (int)width; }
	
	public int getHeight() {return (int)height; }
	
	public int getCWidth() {return (int)cwidth; }
	
	public int getCHeight() {return (int)cheight; }
	
	
	//setting the position
	public void setPosition(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setVector(double dx, double dy)
	{
		this.dx = dx;
		this.dy = dy;
	}
	
	//Set the Map position
	public void setMapPosition()
	{
		//It tell us where to draw character because
		//we need to know how far the tile map has moved
		//in order to offset the player back to the screen
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}
	
	//set the action for the object
	public void setLeft(boolean b) { left = b; }
	public void setRight(boolean b) { right = b; }
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }
	public void setJumping(boolean b) {jumping = b; }
	
	
	//To determine whether the object is not on the screen
	public boolean notScreen()
	{
		return x + xmap + width < 0 ||
			   x + xmap - width > GamePanel.width ||
			   y + ymap + height < 0 ||
			   y + ymap - height > GamePanel.height;
	}
	
	
}
