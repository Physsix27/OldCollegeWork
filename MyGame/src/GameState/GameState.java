package GameState;

import java.awt.*;

// We don't want nobody using this class thats why is abstract
// We just want to extend of it subclasses, like the menustate class
public abstract class GameState
{
	// A reference that changes state
	protected GameStateManager gsm;
	
	// All the functions need it
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
