package stuffs;

import java.awt.*;

import graphics.*;

public class WorldTrees extends GameObject{
	
	Image image;
	
	public WorldTrees(Image image, int x, int y,  ID id){
		super(x, y, id);
		this.image = image;
	}
	
	public void draw(Graphics g, int offsetX, int offsetY) {
		g.drawImage(image, (int)(x) + offsetX, (int)(y) + offsetY , 100, 100, null);
	}


}
