import java.awt.*;

public class Tree extends Object3D
{
	double width;
	double height;
	
	Image image;
	Camera3D camera;

	public Tree(double x, double y, double z, double width, double height, String filename)
	{
		super(x, y, z);
		this.width = width;
		this.height = height;
		
		image = Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	public void draw(Graphics g)
	{
		double scale = d /z - Camera3D.z;
		
		if(z - Camera3D.z > 10)
		{
			g.drawImage
			(
					image,
					(int) (scale * (x - (int)Camera3D.x - width / 2)) + xOrigin ,
					(int) (scale * (y - (int)Camera3D.y- height)) + yOrigin, 
					(int) (scale * width), 
					(int) (scale * height), 
					null
			);
		}
	}
}
