package stuffs;

import java.awt.*;

import graphics.*;

public class House1{
	float x;
	float y;
	ID id;
	
	Image image;
	
	public House1(Image image, float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}
	
	public void draw(Graphics g, int offsetX, int offsetY){
		g.drawImage(image, (int)(x) + offsetX, (int)(y) + offsetY, 500, 500, null);
	}

}
