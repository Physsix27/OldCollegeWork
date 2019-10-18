package graphics;

import game.GameManager;

public class Spawn 
{
	private headsUpDisplay hud;
	private int scoreKeep = 0;
	
	public Spawn(){
		hud = new headsUpDisplay();
	}
	
	public void updateLevels()
	{
		//Your can have a timer if you last 10 seconds you go to the next level
		//or you can have a score system if is constantly going up it goes to the next level
		scoreKeep++;
		
		//Everytime our scoreKeep gets to 1000 level increases
		if(scoreKeep >= 1000)
		{
			scoreKeep = 0;
		    hud.setLevel(hud.getLevel() + 1);
		    
		    if(hud.getLevel() == 2){
		    	GameManager.resourcemanager.getBasicEnemy();
		    	GameManager.resourcemanager.getBasicEnemy();
		    	GameManager.resourcemanager.getBasicEnemy();
		    	
		    }
		    if(hud.getLevel() == 3){
		    	GameManager.resourcemanager.getStrongEnemy();
		    	GameManager.resourcemanager.getStrongEnemy();
		    }
		    if(hud.getLevel() == 4){
		    	
		    }
		    if(hud.getLevel() == 5){
		    	
		    }
		    if(hud.getLevel() == 6){
		    	
		    }
		    if(hud.getLevel() == 7){
		    	
		    }
		    if(hud.getLevel() == 10){
		    	
		    	
		    }
		}
	}
}
