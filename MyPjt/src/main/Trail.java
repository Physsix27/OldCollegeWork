package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject
{
	Handler handler;
	private Color color;
	private int width;
	private int height;
	private float alpha = 1;
	private float life; //life = 0.001 - 0.1

	public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) 
	{
		super(x, y, id);
		this.color = color;
		this.width = width;
		this.height = height;
		this.handler = handler; 
		this.life = life; 
	}

	public void tick() 
	{
		if(alpha > life)
		{
			alpha -= life - 0.0001;
		}
		else
			handler.removeObject(this);
			 
	}


	public Rectangle getBounds()
	{
		return null;
	}

	//render out each one
	private AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
	}
	
	public void render(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
		g2d.setComposite(makeTransparent(1 ));
		
	}
}
