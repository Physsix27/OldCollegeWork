package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject
{
	private Handler handler;
	private Color color;
	Random r = new Random();
	
	public MenuParticle(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
		
		velocityX = r.nextInt(7 - -7) + -7;
		velocityY = r.nextInt(7 - -7) + -7;
		if(velocityX == 0) velocityX = 1; 
		if(velocityY == 0) velocityY = 1; 
		
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() 
	{
		x += velocityX;
		y += velocityY;

		if(y  <= 0 || y >= Game.HEIGHT - 32) velocityY *= -1; 
		
		if(x <= 0 || x >= Game.WIDTH - 16) velocityX *= -1; 
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.02f, handler));
	}
	
	public void render(Graphics g) 
	{
		g.setColor(color );
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	
}
