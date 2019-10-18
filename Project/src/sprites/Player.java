package sprites;

import java.awt.*;

import game.GameManager;
import graphics.*;

public class Player extends GameObject{
	Image image;
	Image image_fake;
	
	int   centerX = 50;
	int   centerY = 50;
	int   width   = 425;
	int   height  = 425;
	
	// Constructor
	public Player(int x, int y, ID id){
		super(x, y, id);
		
		image      = Toolkit.getDefaultToolkit().getImage("Images/Player/player.png");
		image_fake = image;
	}

	// Rotates the image based in the angle where is at
	public void rotate(float degree){
		rotateBy(degree);
		image_fake = getRotatedImage(image, angle, width, height);	
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
