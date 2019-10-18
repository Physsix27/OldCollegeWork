import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageLayer
{
	Image image;
	
	//Position
	double x;
	double y;

	//How far away something is
	double z;
	
	int width;
	
	//Constructor
	public ImageLayer(String filename, double x, double y, double z, int width)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		
	}
	
	
	//Draw Method
	public void draw(Graphics g)
	{
		for(int i = 0; i < 1; i++)
		{
			g.drawImage(image, (int) (x - Camera2D.x / z) + width * i, (int) (y - Camera2D.y / z), null);
		}
		
	}
}
