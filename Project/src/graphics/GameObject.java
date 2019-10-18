package graphics;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import sprites.lookUp;

/* Everything that is here is going to be use 
   for the player and all different enemies 
   that will be use for the game */

// GameObject class
public abstract class GameObject{

	// Instance variables
	protected ID id;
	
    // Position (pixels)
    protected float x;
    protected float y;
    
    // Velocity (pixels per millisecond)
    protected float velocityX;
    protected float velocityY;

    // Angle and Radius
    public    int   angle;
    protected int   radius;
    
    // Constructor of the class
	public GameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;;
		this.id = id;
		this.angle = 0;
		this.radius = 50;
	
	}
	
	/* Abstract methods that needs to be implement
	in all the classes that are going to extend this one */
	public abstract void draw(Graphics g, int offetX, int offsetY);
	
	// Update method
    public void update(long elapsedTime){
        x += velocityX * elapsedTime;
        y += velocityY * elapsedTime;
    }
    
	// x and y is what ever we are chasing
	public double diastance(int x, int y)
	{
		// x of the good guy - x of the bad guy and same for the y
		return (x - this.x) * lookUp.sin[angle] - (y - this.y) * lookUp.cos[angle];
	}
	
	public double diastanceTo(int x, int y)
	{
		// x of the good guy - x of the bad guy and same for the y
		return (x - this.x) * lookUp.cos[angle] + (y - this.y) * lookUp.sin[angle];
	}
    
	// Move fordward
	public void moveForwardBy(float d){
		x += d * lookUp.cos[angle];
		y += d * lookUp.sin[angle];
	}
	
	// Move Backward
	public void moveBackwardBy(float d){
		x -= d * lookUp.cos[angle];
		y -= d * lookUp.sin[angle];
	}
	
	// Rotates to the left
	public void rotateLeftBy(float degree){
		angle -= degree;
		if(angle < 0){
			angle += 360;
		}
	}
	
	// Rotates to the right
	public void rotateRightBy(float degree){
		angle += degree;
		if(angle > 359){
			angle -= 360;
		}
	} 
    
	// Checks the angle where is
	public void rotateBy(float degree){
		angle += degree;
	    if(angle >= 360) angle -= 360;
	    if(angle <= 0)   angle += 360;
	}
	
	// Rotating the player image
	public static Image getRotatedImage(Image image, double angle, int width, int height){
		
		// Set up the transform
		AffineTransform transform = new AffineTransform();
		transform.translate(width / 2.0, height / 2.0 );
		transform.rotate(Math.toRadians(angle));
		
		// Put origin back to upper left corner
		transform.translate(-width / 2.0, -height / 2.0);
		
		
	    // Create a transparent (not translucent) image
		Image newImage = new BufferedImage(width, height, Transparency.BITMASK);
		
		// Draw the transformed image
		Graphics2D g = (Graphics2D)newImage.getGraphics();
		AffineTransform origTransform = g.getTransform();
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, transform, null);
		g.setTransform(origTransform);
		g.dispose();

	    return newImage;
	}

    // Setters for the x and y
    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
    
    // Getters for the x and y
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    // Setters for the velocity
    public void setVelocityX(float dx){
        this.velocityX = dx;
    }

    public void setVelocityY(float dy){
        this.velocityY = dy;
    }
    
    // Getters for the velocity
    public float getVelocityX(){
        return velocityX;
    }

    public float getVelocityY(){
        return velocityY;
    }

    // Setter for ID
	public void setId(ID id){
		this.id = id;
	}
	
	// Getter for ID
	public ID getId(){
		return id;
	}
}
