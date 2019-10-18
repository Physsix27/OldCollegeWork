package game;

import input.*;
import mainGame.*;
import stuffs.*;
import sounds.*;
import sprites.*;
import graphics.*;
import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;


// GameManager manages all parts of the game
public class GameManager extends GameCore{

    public static void main(String[] args) { new GameManager().run(); }
    
    // Resource Manager
    public static ResourceManager resourcemanager;
    
    // Inout Manager
    private InputManager inputManager;
    
    // Keys
    private GameAction moveLeft;
    private GameAction moveRight;
    private GameAction moveUp;
    private GameAction moveDown;
    private GameAction xShoot;
    private GameAction zBomb;
    private GameAction boundary;
    private GameAction exit;
    private GameAction click;
    
    // Shot timer
    public int         timer1 =  50;
    
    // Screen width and height
    public static int width;
    public static int height;
    
    // Everybodys red
    boolean de = true;
    public static boolean red = false;
    
    // Sounds
    private AudioPlayer shot, gameM;
    
    // Loading
  	public static int loading;
    
    //Current Game State
    public static ID gamestate = ID.MENU;
	
    // My Init Method
    public void init(){
        super.init();

        width = screen.getWidth();
        height = screen.getHeight();
        
        // set up input manager
        initInput();
        
        // start resource manager
       	resourcemanager =  new ResourceManager(screen.getFullScreenWindow().getGraphicsConfiguration());

        // load music
       	shot 			= new AudioPlayer("/SouEff/shot.wav");
       	gameM			= new AudioPlayer("/SouEff/music.wav");
        gameM.play();
    }
    
    // Closes any resurces used by the GameManager
    public void stop(){
        super.stop();
    }
    
    private void initInput(){
        moveLeft	 = new GameAction("moveLeft");
        moveRight	 = new GameAction("moveRight");
        moveUp 		 = new GameAction("moveUp");
        moveDown	 = new GameAction("moveDown");
        xShoot		 = new GameAction("xShoot");
        zBomb 	     = new GameAction("zBomb");
        click 		 = new GameAction("click");
        boundary 	 = new GameAction("boundary");
        exit 	  	 = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
        
        inputManager = new InputManager(screen.getFullScreenWindow());
        
        
        inputManager.setCursor(InputManager.DEFAULT_CURSOR);
        inputManager.mapToMouse(click, InputManager.MOUSE_BUTTON_1);
        
        if(gamestate == ID.GAME) {
        	inputManager.setCursor(InputManager.INVISIBLE_CURSOR);
        }
        
        inputManager.mapToKey(moveLeft, KeyEvent.VK_LEFT);
        inputManager.mapToKey(moveRight, KeyEvent.VK_RIGHT);
        inputManager.mapToKey(moveUp, KeyEvent.VK_UP);
        inputManager.mapToKey(moveDown, KeyEvent.VK_DOWN);
        inputManager.mapToKey(xShoot, KeyEvent.VK_X);
        inputManager.mapToKey(zBomb, KeyEvent.VK_Z);
        inputManager.mapToKey(boundary, KeyEvent.VK_A);
        inputManager.mapToKey(exit, KeyEvent.VK_ESCAPE);     
    }
    
    // Mouse Input
    private void checkMouseInput(long elapsedTime){
    	if(gamestate == ID.MENU || gamestate == ID.HELP){
    		int mouseX = inputManager.getMouseX();
			int mouseY = inputManager.getMouseY();
    	
			if(click.isPressed()){
				buttonCollision(mouseX, mouseY);
			}
    	}
    }

    // Key input
    private void checkKeyInput(long elapsedTime){
    	if(gamestate == ID.GAME){
    		if(exit.isPressed()){
    			stop();
    		}
    		// Moving the player
    		else if(moveRight.isPressed()){
    			resourcemanager.player.rotate(3);
    			resourcemanager.player.rotateRightBy(3);
    		}
    		else if(moveLeft.isPressed()){
    			resourcemanager.player.rotate(-5);
    			resourcemanager.player.rotateLeftBy(5);
    		}
    		else if(moveUp.isPressed()){
    			resourcemanager.player.moveForwardBy(5);
    		}
    		else if(moveDown.isPressed()){
    			resourcemanager.player.moveBackwardBy(5);
    		}
    		else if(xShoot.isPressed()){
    			while(timer1 <= 0){
    				resourcemanager.addBullet(); 
    				shot.play();
    				timer1 = 50;
    			}
    		}
    		else if(zBomb.isPressed()){
	        	
    		}
    		else if(boundary.isPressed()){
    			red = true;
    		}
    		else red = false;
    	}
	}
    
    // mouse possition to check if is inside the rect
    public void buttonCollision(int mx, int my){
    	if(gamestate == ID.MENU){
	    	//Play Button
	    	if(mx >= width/2 - 125 && mx <= width + 375){
				 if(my >= 350 && my <= 420){
					 // Pressed play button
					 gamestate = ID.GAME;	 
				 }
		     }
	    	
	        // Help Button
		    if(mx >= width/2 - 125 && mx <= width + 375){
		     	if(my >= 450 && my <= 520){
				     // Pressed help button
		     		gamestate = ID.HELP;
			     }
		     }
		    
		    // Quit Button
		    if(mx >= width/2 - 125 && mx <= width + 375){
			   if(my >= 550 && my <= 620){
				  // Pressed quit button
				  System.exit(1);
		   	   }	
		     }
		
    	}
    	
    	//In the Help State
    	if(gamestate == ID.HELP){
        		//Back Button
    		if(mx >= width/2 - 125 && mx <= 620){
    			if(my >= 690 && my <= 760){
    			 gamestate = ID.MENU;
    			}
    		 }
    	 }
    	
    }
    
    // Checking for character
    public void checkBound(Object character){
    	if(gamestate == ID.GAME){
	    	if(character instanceof Player){
	    		Player player = (Player) character;
	    		int x = (int) player.getX();
	    		int y = (int) player.getY();
	    		if(x <= 100)
	    			player.setX(100);
	    		if(y <= 100)
	    			player.setY(100);
	    		if(x >= 3500)
	    			player.setX(3500);
	    		if(y >= 3500)
	    			player.setY(3500);
	    	}
	    	else if(character instanceof BasicEnemy){
	    		BasicEnemy basicenemy = (BasicEnemy) character;
	    		int x = (int) basicenemy.getX();
	    		int y = (int) basicenemy.getY();
	    		if(x <= 100)
	    			basicenemy.setX(100);
	    		if(y <= 100)
	    			basicenemy.setY(100);
	    		if(x >= 3500)
	    			basicenemy.setX(3500);
	    		if(y >= 3500)
	    			basicenemy.setY(3500);	
	    	}
	    	else if(character instanceof StrongEnemy){
	    		StrongEnemy strongenemy = (StrongEnemy) character;
	    		int x = (int) strongenemy.getX();
	    		int y = (int) strongenemy.getY();
	    		if(x <= 100)
	    			strongenemy.setX(100);
	    		if(y <= 100)
	    			strongenemy.setY(100);
	    		if(x >= 3500)
	    			strongenemy.setX(3500);
	    		if(y >= 3500)
	    			strongenemy.setY(3500);
	    	}
    	}
    }

    
    // Check for collision
    public void checkCollision(Object character){
    	if(character instanceof Player){
    		Player player = (Player) character;
    		Iterator<BasicEnemy> i = resourcemanager.basicenemy();
        	while(i.hasNext()){
        		BasicEnemy basicenemy = (BasicEnemy) i.next();
        		if(isCollision(
        			   player.getX(), 
        			   basicenemy.getX(),
 					   player.getY(), 
 					  basicenemy.getY())){
        			//Collision
        			resourcemanager.HUD.HEALTH -= 5;
        			de = false;

        		}else{ de = true;}
        	}
    		Iterator<StrongEnemy> j = resourcemanager.strongenemy();
        	while(j.hasNext()){
        		StrongEnemy strongenemy = (StrongEnemy) j.next();
        		if(isCollision(
         			   player.getX(), 
         			   strongenemy.getX(),
  					   player.getY(), 
  					   strongenemy.getY())){
         			//Collision
        			resourcemanager.HUD.HEALTH -= 5;
         			de = false;
         			
         		}else{ de = true; }
        	}
    	}
    }

    
    public void collisionBullet(Object character){
    	if(character instanceof Projectile){
    		Iterator<Projectile> b = resourcemanager.projectile();
    		Iterator<BasicEnemy> k = resourcemanager.basicenemy();
    		while(b.hasNext()){
    			Projectile bullet     = (Projectile) b.next();
    			BasicEnemy basicenemy = (BasicEnemy) k.next();
	    		if(isCollision(
	     			   bullet.getX(), 
	     			   basicenemy.getX(),
					   bullet.getY(), 
					   basicenemy.getY())){
	     			//Collision
	    			resourcemanager.HUD.kills++;
	    			
	    			// remove enemy
	    			
	    			//remove bullet
	     			de = false;
	     		}
    		}
    	}
    }
    
    
    // Distance of 2 positions
    public boolean isCollision(float x1, float x2, float y1, float y2){
    	double xDiff = x1 - x2;
    	double yDiff = y1 - y2;
    	double distance = (xDiff * xDiff) + (yDiff * yDiff);
    	return distance < (50) * (50);
    }
    
    /* Updates Animation, position, and velocity of all Sprites
       in the current map */
    public void update(long elapsedTime){
    	if(gamestate == ID.MENU || gamestate == ID.HELP){
    		// Get mouse input
    		checkMouseInput(elapsedTime);
    	}
    	
    	if(gamestate == ID.GAME){
    		
	        // Get keyboard input
	        checkKeyInput(elapsedTime);
	        
	        // Timers
	        timer1--;
	        
	        // Heads Up Display
	        resourcemanager.HUD.updateScore(elapsedTime);
	        
	        // Update player
	        resourcemanager.player.update(elapsedTime);
	        
	        //Updates the levels
	        resourcemanager.spawner.updateLevels();
	        
	        // Update bullet & enemies
	        updateProjectile();
	        updateEnemies();

	        // Checking for Bounduries
	        checkBound(resourcemanager.player);
	        checkBound(resourcemanager.basicenemy);
	        checkBound(resourcemanager.strongenemy);
	        
	        // Collision
	        checkCollision(resourcemanager.player);
	       // collisionBullet(resourcemanager.bullet);
	        }    
    }

    // Updates Enemies
	public void updateEnemies(){
    	Iterator<BasicEnemy> i = resourcemanager.basicenemy();
    	while(i.hasNext()){
    		BasicEnemy basicenemy = (BasicEnemy)(i.next());
    		basicenemy.chase(resourcemanager.player);
    	}
    	Iterator<StrongEnemy> j = resourcemanager.strongenemy();
    	while(j.hasNext()){
    		StrongEnemy strongenemy = (StrongEnemy)(j.next());
    		strongenemy.chase(resourcemanager.player);
    	}
    	Iterator<CrazyEnemy> k = resourcemanager.crazyenemy();
    	while(k.hasNext()){
    		CrazyEnemy crazyenemy = (CrazyEnemy)(k.next());
    		//make it rotate & shoot
    		crazyenemy.rotating();
    		//crazyenemy.chase(resourcemanager.player);
    	}
    }
	
	// Updates bullet
    public void updateProjectile(){
    	Iterator<Projectile> i = resourcemanager.projectile();
    	while(i.hasNext()){
    		Projectile bullet = (Projectile)(i.next());
    		bullet.moveForwardBy(15);
    	}
    }
    
    // Draws Enemies
    public void drawEnemies(Graphics g, int offsetX, int offsetY){
		Iterator<BasicEnemy> i = resourcemanager.basicenemy();
		while(i.hasNext()){
			BasicEnemy basicenemy = (BasicEnemy)(i.next());
			basicenemy.draw(g, offsetX, offsetY);
		}
		Iterator<StrongEnemy> j = resourcemanager.strongenemy();
		while(j.hasNext()){
			StrongEnemy strongenemy = (StrongEnemy)(j.next());
			strongenemy.draw(g, offsetX, offsetY);
		}
		Iterator<CrazyEnemy> k = resourcemanager.crazyenemy();
		while(k.hasNext()){
			CrazyEnemy crazyenemy = (CrazyEnemy)(k.next());
			crazyenemy.draw(g, offsetX, offsetY);
		}
    }
    
    // draws Bullets
    public void drawBullet(Graphics g, int offsetX, int offsetY){
    	Iterator<Projectile> i = resourcemanager.projectile();
    	while(i.hasNext()){
    		Projectile bullet = (Projectile)(i.next());
    		bullet.draw(g, offsetX, offsetY);
    	}
    }
    
    // My Draw Method
    public void draw(Graphics2D g){
    	 if(gamestate == ID.GAME){
    		int offsetX = 640 - (int) resourcemanager.player.getX();
    		int offsetY = 400 - (int) resourcemanager.player.getY();
        	
        	g.setColor(new Color(0, 130, 0));
    	    g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
    	     
    	    resourcemanager.house1.draw(g, offsetX, offsetY);
    	    resourcemanager.house2.draw(g, offsetX, offsetY);
    	    resourcemanager.drawTrees(g, offsetX, offsetY);
    	    drawBullet(g, offsetX, offsetY);
    	    resourcemanager.player.draw(g, offsetX, offsetY);
    	    resourcemanager.HUD.draw(g);

    	    if(de == true){
    	    	drawEnemies(g, offsetX, offsetY);
	    	}
	    	
    	}
    	else if(gamestate == ID.MENU){
    		resourcemanager.menubg.draw(g);
    		resourcemanager.menu.draw(g);
    		
    	}else if(gamestate == ID.HELP){
    		resourcemanager.helpbg.draw(g);
    		resourcemanager.help.draw(g);
    		
    	}
    }
}