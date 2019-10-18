package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager
{
	//Array list to hold all of our game state
	private ArrayList<GameState> gameStates;
	
	//Index of the game state for the first in the list
	private int currentState;
	
	public static final int  MENUSTATE = 0;
	public static final int  lEVEL1STATE = 1;
	
	//This is the constructor
	public GameStateManager()
	{
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE ;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
	}
	
	
	//To be able to change the state
	public void setState(int state)
	{
		currentState = state;
		gameStates.get(currentState).init();
		
	}
	
	//
	public void update()
	{
		gameStates.get(currentState).update();

	}
	
	//My draw method
	public void draw(Graphics2D g)
	{
		gameStates.get(currentState).draw(g);
	}
	
	//keypressed method
	public void keyPressed(int k)
	{
		gameStates.get(currentState).keyPressed(k);
	}
	
	//keyReleased method
	public void keyReleased(int k)
	{
		gameStates.get(currentState).keyReleased(k);
		
	}
	
}

