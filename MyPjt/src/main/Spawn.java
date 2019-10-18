package main;

//This is the class that spawns the enemies, makes them as the score increase and level too

import java.util.Random;

public class Spawn 
{
	private Handler handler;
	private Random r = new Random(); 
	private HUD hud;
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick ()
	{
		//Your can have a timer if you last 10 seconds you go to the next level
		//or you can have a score system if is constantly going up it goes to the next level
		scoreKeep++;
		
		//Everytime our scoreKeep gets to 1000 level increases
		if(scoreKeep >= 250)
		{
			scoreKeep = 0;
		    hud.setLevel(hud.getLevel() + 1);
		    
		    if(hud.getLevel() == 2){
		    	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		    	//handler.addObject(new BossEnemy(r.nextInt(Game.WIDTH / 2) - 48, -120, ID.BossEnemy, handler));
		    }
		    if(hud.getLevel() == 3){
		    	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		    }
		    if(hud.getLevel() == 4){
		    	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
		    }
		    if(hud.getLevel() == 5){
		    	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
		    }
		    if(hud.getLevel() == 6){
		    	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
		    }
		    if(hud.getLevel() == 7){
		    	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
		    }
		    if(hud.getLevel() == 10){
		    	handler.clearEnemies();
		    	handler.addObject(new BossEnemy(r.nextInt(Game.WIDTH / 2) - 48, -120, ID.BossEnemy, handler));
		    }
		    if(hud.getLevel() == 12){
		    	handler.clearEnemies();
		    	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
		    }

		}
	}

}
