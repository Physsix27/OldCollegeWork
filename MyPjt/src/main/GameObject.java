package main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject 
{

	protected ID id;
	protected float x;
	protected float y;
	protected float velocityX;
	protected float velocityY;

	
	public GameObject(float x, float y, ID id)
	{
		this.x = x;
		this.y = y;;
		this.id = id;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//Setters
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void setVelocityX(int velX)
	{
		this.velocityX = velX;
	}
	
	public void setVelocityY(int velY)
	{
		this.velocityY = velY;
	}
	
	public float getVelocityX()
	{
		return velocityX;
	}
	
	public float getVelocityY()
	{
		return velocityY;
	}
	
	public void setId(ID id)
	{
		this.id = id;
	}
	
	public ID getId()
	{
		return id;
	}
}
