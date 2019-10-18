package Entity;

import java.awt.image.BufferedImage;

//Animation Class
public class Animation 
{
	//Array
	private BufferedImage[] frames;
	
	//to keep track of the current frame
	private int currentFrame;
	
	//The time to start the animation and the delay to know the time between each display
	private long startTime;
	private long delay;
	
	//This is to know if animation is played already
	private boolean playedOnce;
	
	//Constructor
	public Animation()
	{
		playedOnce = false;
	}
	
	//Setting the frames
	public void setFrame(BufferedImage[] frames)
	{
		this.frames = frames;
		currentFrame = 0;
		startTime = System.nanoTime();
		playedOnce = false;
	}
	
	//Setting the delay and the current frame
	public void setDelay(long d) {delay = d;}
	public void setFrame(int i) {currentFrame = i;}
	
	//It will determine whether or not to move to the next frame
	public void update()
	{
		//Returning because there is no animation
		if(delay == -1) return;
		
		//find out how long since the last frame came up
		long elapsed = (System.nanoTime() - startTime) / 1000000;
		if(elapsed > delay)
		{
			//move on to the next frame and reset the timer
			currentFrame++;
			startTime = System.nanoTime();
		}
		//make sure we don't go past the amount of frame there are
		//and that the animation is played once
		if(currentFrame == frames.length)
		{
			currentFrame = 0;
			playedOnce = true;
		}
		
	}
	
	//Gets the current frame number
	public int getFrame() { return currentFrame; }
	
	//gets the image that we need to draw
	public BufferedImage getImage() {return frames[currentFrame]; }
	
	//return if the animation has played one time or not
	public boolean hasPlayedOnce() {return playedOnce; }
}









