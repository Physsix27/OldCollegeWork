package game;

import java.awt.*;
import graphics.*;
import sprites.*;
import stuffs.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/* The ResourceManager class loads and manages tile Images and
   "host" Sprites used in the game. Game Sprites are cloned from
   "host" Sprites */
public class ResourceManager{
	LinkedList<GameObject> tree = new LinkedList<>(); 
	
	ArrayList<Projectile> bullet = new ArrayList<>();
	ArrayList<BasicEnemy> basicenemy = new ArrayList<>();
	ArrayList<StrongEnemy> strongenemy = new ArrayList<>();
	ArrayList<CrazyEnemy> crazyenemy = new ArrayList<>();
	
	GameManager GM;
	
    private GraphicsConfiguration gc;
    public  Player				  player;
    public  House1    		      house1;
    public  House2    		      house2;
    public  headsUpDisplay        HUD;
    public  MenuState 	  	 	  menu;
    public  HelpState 			  help;
    public  background			  menubg;
    public  background			  helpbg;
    public  background            loading;
    public  Spawn 				  spawner;
   
    
    // Creates a new ResourceManager with the specified GraphicsConfiguration
    public ResourceManager(GraphicsConfiguration gc) {
        this.gc = gc;
        
        //heads Up Display & Menu state
        HUD 		= new headsUpDisplay();
        menu        = new MenuState();
        help    	= new HelpState();
        menubg      = new background(0, 0, "images/Logo/menubg.jpg");
        helpbg      = new background(0, 0, "images/Logo/helpbg.jpg");
        loading     = new background(0, 0, "images/Logo/loading.jpg");
        
        spawner     = new Spawn();
        
        // Add the player
    	player      = new Player(1740, 1740, ID.Player);
    	
    	// Stuffs
    	house1      = new House1(loadImage("Houses/house1"), 2800, 400, ID.house1);
    	house2      = new House2(loadImage("Houses/house2"), 400, 400, ID.house2);
    	
    	// Trees
    	getTrees();
    	
    	// Enemies
    	//getBasicEnemy();
    	//getStrongEnemy();
    	//getCrazyEnemy();
    }
    
    // Adds your enemies
    public void getBasicEnemy(){
    		this.basicenemy.add(new BasicEnemy((int)randomX(), (int)randomY(), ID.BasicEnemy));
    }

    public void getStrongEnemy(){
    		this.strongenemy.add(new StrongEnemy((int)randomX(), (int)randomY(), ID.StrongEnemy));
    }
    
	public void getCrazyEnemy() {
    		this.crazyenemy.add(new CrazyEnemy((int)randomX(), (int)randomY(), ID.CrazyEnemy));
	}

    // create your tree and put it in the linked list
    public void getTrees(){
    	Image tree = loadImage("Trees/tree2");
    	for(int i = 0; i < 3500; i += 85){
    		this.tree.add(new WorldTrees(tree, i, 0, ID.tree));
    		this.tree.add(new WorldTrees(tree, 3500, i, ID.tree));
    		this.tree.add(new WorldTrees(tree, 0, i, ID.tree));
    		this.tree.add(new WorldTrees(tree, i, 3500, ID.tree));
    	}
    }
    
    // Drawing all the trees
    public void drawTrees(Graphics g, int offsetX, int offsetY){
    	Iterator<GameObject> i = tree.iterator();
    	while(i.hasNext()){
    		WorldTrees tree = (WorldTrees)(i.next());
    		tree.draw(g, offsetX, offsetY);
    	}
    }
    
    // Itirators
    public Iterator<Projectile> projectile(){
		return bullet.iterator();
    }
    
    public Iterator<BasicEnemy> basicenemy(){
		return basicenemy.iterator();
    }
    
    public Iterator<StrongEnemy> strongenemy(){
		return strongenemy.iterator();
    }
    
    public Iterator<CrazyEnemy> crazyenemy(){
		return crazyenemy.iterator();
    }
    
    public void addBullet(){
    	Projectile p = new Projectile(player.getX(), player.getY(), 3, player.angle);
    	bullet.add(p);
    }
    
    // Remove enemies
    public void removeBasicEnemy(){
    	BasicEnemy be = new BasicEnemy((int)randomX(), (int) randomY(), ID.BasicEnemy);
    	basicenemy.remove(be);
    }
    
    public void removeStrongEnemy(){
    	StrongEnemy se = new StrongEnemy((int)randomX(), (int) randomY(), ID.StrongEnemy);
    	strongenemy.remove(se);
    }
    
    public void removeCrazyEnemy(){
    	CrazyEnemy ce = new CrazyEnemy((int)randomX(), (int) randomY(), ID.CrazyEnemy);
    	crazyenemy.remove(ce);
    }
    
    public void removeBullet(Projectile p){
    	Projectile bt = new Projectile(player.getX(), player.getY(), 3, player.angle);
    	bullet.remove(bt);
    }
    
    // Random X
	public double randomX() {
		int x = (int) (Math.random() * 3500 + .1);
		if(x < 100){
			 x += 100;
		}
		else if(x > 3400){
			x -= 100;
		}
		return x;
	}

	//Random Y 
	public double randomY() {
		int y = (int) (Math.random() * 3500 + .1);
		if(y < 100){
			 y += 100;
		}
		else if(y > 3400){
			y -= 100;
		}
		return y;
	}
    
    // Gets an image from the images/ directory
    public Image loadImage(String name){
        String filename = "images/" + name + ".png";
        return new ImageIcon(filename).getImage();   
    }
    
    public Image getMirrorImage(Image image){
        return getScaledImage(image, -1, 1);
    }

    public Image getFlippedImage(Image image){
        return getScaledImage(image, 1, -1);
    }
    
    private Image getScaledImage(Image image, float x, float y){
    	
        // set up the transform
        AffineTransform transform = new AffineTransform();
        transform.scale(x, y);
        transform.translate(
            (x-1) * image.getWidth(null) / 2,
            (y-1) * image.getHeight(null) / 2);

        // create a transparent (not translucent) image
        Image newImage = gc.createCompatibleImage(
            image.getWidth(null),
            image.getHeight(null),
            Transparency.BITMASK);

        // draw the transformed image
        Graphics2D g = (Graphics2D)newImage.getGraphics();
        g.drawImage(image, transform, null);
        g.dispose();

        return newImage;
    }
}