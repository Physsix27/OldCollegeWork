package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import Entity.*;
import Main.GamePanel;
import TileMap.*;


public class Level1State extends GameState 
{
	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	public Level1State(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}

	//Init method, initializes everything that it needs 
	// to be initialized
	public void init() 
	{
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		
		//Setting a new background for level1
		bg = new Background("/Backgrounds/gamebg.gif", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
		
	}
	public void update() 
	{
		//update player
		player.update();
		tileMap.setPosition(GamePanel.width / 2 - player.getx(), GamePanel.height / 2 - player.gety());
		
	}
	public void draw(Graphics2D g) 
	{
		//Draw the background
		bg.draw(g);
		
		//Draw tilemap
		tileMap.draw(g);
		
		//Draw player
		player.draw(g);
	}
	
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		if(k == KeyEvent.VK_A) player.setGliding(true);
		if(k == KeyEvent.VK_S) player.setScratching();
		if(k == KeyEvent.VK_D) player.setFiring();
		
		
	}
	
	public void keyReleased(int k) 
	{
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
		if(k == KeyEvent.VK_A) player.setGliding(false);
	}

}
