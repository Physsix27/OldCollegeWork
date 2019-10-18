package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import main.Game.STATE;

public class Menu extends MouseAdapter
{
	private HUD  hud;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.hud = hud;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu){
			
			//Play Button
			if(mouseOver(mx, my, 210, 150, 200, 64 )){
				Game.gameState = STATE.Game;
				//handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			
			//Help Button
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				Game.gameState = STATE.Help;
			}
			
			//Quit Button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(1);
			}
		}
		
		//Back Button
		if(Game.gameState == STATE.Help){
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		//End State
		if(Game.gameState == STATE.End){
			//Try Again Button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				Game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(Game.gameState == STATE.Menu)
		{
			Font fnt1 = new Font("Arial", 1, 50);
			Font fnt2 = new Font("Arial", 1, 30);
			
			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawString("Survival", 215, 70);
			
			g.setFont(fnt2);
			g.drawString("Play", 280, 190);
			g.drawRect(210, 150, 200, 64);

			g.drawString("Help", 280, 290);
			g.drawRect(210, 250, 200, 64);

			g.drawString("Quit", 280, 390);
			g.drawRect(210, 350, 200, 64);
		}
		else if(Game.gameState == STATE.Help)
		{
			Font fnt1 = new Font("Arial", 1, 50);
			Font fnt2 = new Font("Arial", 1, 30);
			
			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawString("Help", 260, 70);
			
			g.setFont(fnt2);
			g.drawString("Back", 275, 390);
			g.drawRect(210, 350, 200, 64);
			
		}
		else if(Game.gameState == STATE.End)
		{
			Font fnt1 = new Font("Arial", 1, 50);
			Font fnt2 = new Font("Arial", 1, 30);
			Font fnt3 = new Font("Arial", 1, 20);
			
			g.setFont(fnt1);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 180, 70);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);
			
			g.setFont(fnt2);
			g.drawString("Try Again", 245, 390);
			g.drawRect(210, 350, 200, 64);
			
		}
		
	}

}
