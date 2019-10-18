package sprites;

import java.awt.*;

import game.GameManager;
import graphics.*;

public class StrongEnemy extends GameObject{
	Image image;
	Image image_fake;
	
	Animation anim;
	
    int centerX = 50;
	int centerY = 50;
	int width   = 400;
	int height  = 400;
	
	// Constructor
	public StrongEnemy(int x, int y, ID id){
		super(x, y, id);
		
		Image[] as = new Image[3];
		for(int i = 0; i < 3; i++){
			as[i]      = Toolkit.getDefaultToolkit().getImage("images/Enemies/Enemy2/enemy" + i + ".png");
		}
		
		anim = new Animation(as, 5);
		image_fake = anim.currentImage();
	}
	
	// Rotates the image based in the angle where is at
	public void rotate(float degree){
		rotateBy(degree);
		image_fake = getRotatedImage(anim.nextImage(), angle, width, height);	
	}
	
	// It tracks the player location
	public void track(GameObject gameObject)
	{
		//Makes bad guy track 
		double d = (this.x - gameObject.getX()) * lookUp.sin[angle] - (this.y - gameObject.getY()) * lookUp.cos[angle];
		
		if(d < -30) {
			rotate(-12);
			rotateLeftBy(12);
		}
		if(d > 30){
			rotate(12); 
			rotateRightBy(12);
		}
	}
	
	// Circle chases another circle
	public void chase(GameObject gameObject)
	{
		track(gameObject);
		
		// Makes bad circle chase good
		if(diastanceTo((int) gameObject.getX(), (int) gameObject.getY()) > 40)
			moveForwardBy(3f);
	}
	
	// My draw method
	public void draw(Graphics g, int offsetX, int offsetY){
		g.drawImage(
				image_fake, (int)(x) - centerX + offsetX,
				(int)(y) - centerY + offsetY, 
				100, 
				100,
				null);
		if(GameManager.red){
		g.setColor(Color.red);
		g.drawOval(
				(int)x + offsetX - radius / 2, 
				(int)y + offsetY- radius / 2, 
				radius , 
				radius);
		g.drawLine(
				(int)x + offsetX , 
				(int)y + offsetY, 
				(int) (radius * lookUp.cos[angle] + x + offsetX), 
				(int) (radius * lookUp.sin[angle] + y + offsetY)); 
		}
	}
}