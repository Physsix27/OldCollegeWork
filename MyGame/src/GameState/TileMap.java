package GameState;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileMap 
{

	//Position
	private double x;
	private double y;
	
	//Bounds
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double tween;
	
	//Map
	private int[][] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	//Tile Set
	private BufferedImage tileset;
	private int numTilesacross;
	private Tile[][] tiles;
	
	//Drawing
	 private int rowOffset;
	 private int colOffset;
	 private int numRowsToDraw;
	 private int numColsToDraw;
	 
	
	
	public TileMap(int tileSize)
	{
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.height / tileSize + 2;
		numColsToDraw = GamePanel.width / tileSize + 2; 
		tween = 0.07;
	}
	
	public void loadTiles(String s)
	{
		try{
			tileset = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesacross = tileset.getWidth() / tileSize; 
			tiles = new Tile[2][numTilesacross];
			
			BufferedImage subImage;
			
			//importing the entire tile set
			for(int col = 0; col < numTilesacross; col++)
			{
				 subImage = tileset.getSubimage(
						 col * tileSize,
						 0, 
						 tileSize,
						 tileSize);
			
				tiles[0][col] = new Tile(subImage, Tile.NORMAL);
				subImage = tileset.getSubimage(
						col * tileSize, 
						tileSize, 
						tileSize, 
						tileSize);
			
				tiles[1][col] = new Tile(subImage, Tile.BLOCKED);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//Loading the map
	public void loadMap(String s)
	{
		try{
			
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(new InputStreamReader (in) );
			
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;
			
			xmin = GamePanel.width - width;
			xmax = 0;
			ymin = GamePanel.height - height;
			ymax = 0;
			
			//This are like spaces
			String delims = "\\s+";
			
			for(int row = 0; row < numRows; row++)
			{
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int col = 0; col < numCols; col++)
				{
					map[row][col] = Integer.parseInt(tokens[col]);

				}
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	//Getting the tile size
	public int getTileSize() {return tileSize; }
	
	//Getting the x value
	public int getx() {return (int) x; }
	
	//Getting the y value
	public int gety() {return (int) y; }
	
	//Getting the width
	public int getwidth() {return (int) width; }
	
	//Getting the height
	public int height() {return (int) height; }
	
	//Getting the type 
	public int getType(int row, int col)
	{
		int rc = map[row][col];
		int r  = rc / numTilesacross;
		int c  = rc % numTilesacross;
		return tiles[r][c] .getType();
		
	}
	
	//This make sure that the camera follows the player smoothly
	public void setPosition(double x, double y)
	{
		//The position of the camera following the player position
		this.x += (x - this.x) * tween;
		this.y += (y - this.y) * tween;
		
		fixBounds();
		
		//Where to start drawing in the column and row
		colOffset = (int) -this.x / tileSize;
		rowOffset = (int) -this.x / tileSize;

	}
	
	//
	private void fixBounds()
	{
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
		
	}
	
	//Drawing the tiles into the screen
	public void draw(Graphics2D g)
	{
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++)
		{
			if(row >= numRows)
				break;
			
			for(int col = colOffset; col < colOffset + numColsToDraw; col++)
			{
				//Stop drawing if the # of columns is greater than columns expected
				if(col >= numCols)
					break;
				
				//Keep drawing
				if(map[row][col] == 0)
					continue;
				
				int rc = map[row][col];
				int r = rc / numTilesacross;
				int c = rc % numTilesacross;
				
				g.drawImage
				( 
					tiles[r][c].getImage(),
					(int)x + col * tileSize,
					(int)y + row * tileSize,
					null
				);
			}
		}
	}
}


