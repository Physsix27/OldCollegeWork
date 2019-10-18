package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject
{
	private Handler handler;
	private Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
		
		velocityX = r.nextInt(5 - -5) + -5;
		velocityY = 5;
	}


	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}


	public void tick() 
	{
		x += velocityX;
		y += velocityY;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	
}
