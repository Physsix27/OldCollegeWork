package stuffs;

import java.awt.*;
import sprites.*;

public class Projectile{
	
	float x;
	float y;
	float radius;
	int angle;
	
	public Projectile(float x, float y, float radius, int angle){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.angle = angle;
		
	}

	// Move fordward
	public void moveForwardBy(float d){
		x += d * lookUp.cos[angle];
		y += d * lookUp.sin[angle];
	}
	
	//Setters 
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}

	// Getting the y and y value of the position bullet 
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}

	public void draw(Graphics g, int offsetX, int offsetY){
		g.setColor(Color.cyan);
		g.fillOval((int) (x) - (int)radius + offsetX, (int) (y) - (int)radius + offsetY, 2 * (int)radius, 2 * (int)radius);
	}
}
