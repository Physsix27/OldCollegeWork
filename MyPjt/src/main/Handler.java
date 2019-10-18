package main;

import java.awt.Graphics;
import java.util.LinkedList;

//Maintain and render all the objects in the game
public class Handler 
{
	LinkedList<GameObject> object = new LinkedList<>();
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	//
	public void clearEnemies() 
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() != ID.Player)
			{
				object.clear();
				if(Game.gameState !=  Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	public void render(Graphics g)
	{
		try{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
				
			tempObject.render(g);
		}
		}catch(Exception e){e.printStackTrace();}
	}
	
	
}
