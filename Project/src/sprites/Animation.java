package sprites;
import java.awt.*;

// Animation Class
public class Animation 
{
	// Array of type Image
	private Image[] image;
	
	// Declared variables
	private int current = 0;
    private int duration;
    private int counDown;
	
    // Constructor of the class
	public Animation(Image[] image, int duration)
	{
		this.image = image;
		this.duration = duration;
		counDown = duration;
	}
    
	// <= or == or image.length - 1
	// Gets the next image in file
	public Image nextImage()
	{
		counDown--;
		
	    if(counDown == 0)
	    {
	    	counDown = duration;
	    	
			current++;
			
			if(current == image.length)
			{
				current = 1;
			}	
	    }
	    
	    return image[current];
	}
	
	// First image of the list
	public Image staticImage()
	{
		return image[0];
	}
	
	public Image currentImage(){
		return image[current];
	}
	
	
	
	
	
	
	
}