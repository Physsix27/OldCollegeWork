import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

//Menu Class
public class Menu 
{
	// Images objects
	Image logo;
	Image ship_original;
	Image ship;
	
	// Declared variables
	double angle;
	
	// Creating rectangles for the buttons
	public Rectangle playButton = new Rectangle(Drawing.WIDTH + 300, 400, 200, 50);
	public Rectangle helpButton = new Rectangle(Drawing.WIDTH + 300, 500, 200, 50);
	public Rectangle quitButton = new Rectangle(Drawing.WIDTH + 300, 600, 200, 50);
	
	// Constructor of the class
	public Menu()
	{
		// Angle of the ship
		this.angle = 90;
		
		// Gets the image of the logo and the ship from file
		logo = Toolkit.getDefaultToolkit().getImage("SpaceShipLogo.png");
		ship_original = Toolkit.getDefaultToolkit().getImage("ship_dn_1.png");
		ship = ship_original;
	}
	
	// Setting the angle
	public void setAngle(double angle)
	{
		this.angle = angle;
	}
	
	// Getting the angle
	public double getAngle()
	{
		return angle;
	}
	
	
	public void rotateBy(double degree)
	{
		angle += degree;

	    if(angle >= 360) angle -= 360;
	    if(angle < 0)    angle += 360;
	}
	
	public void rotate(double degree)
	{
		rotateBy(degree);
		
		ship = getRotatedImage(ship_original, angle);	
	}
	
	 
	 public static Image getRotatedImage(Image image, double angle) 
	 {
	        // Set up the transform
	        AffineTransform transform = new AffineTransform();
	        transform.translate(image.getWidth(null) / 2.0, image.getHeight(null) / 2.0 );

	        transform.rotate(Math.toRadians(angle));

	        // Put origin back to upper left corner
	        transform.translate(-image.getWidth(null) / 2.0, -image.getHeight(null) / 2.0);

	        // Create a transparent (not translucent) image
	        Image newImage = new BufferedImage(image.getWidth(null), image.getHeight(null), Transparency.BITMASK);

	        // Draw the transformed image
	        Graphics2D g = (Graphics2D)newImage.getGraphics();
	        AffineTransform origTransform = g.getTransform();
	        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        g.drawImage(image, transform, null);
	        g.setTransform(origTransform);
	        g.dispose();

	        return newImage;
	    }
	
	// Drawing method
	public void draw(Graphics g)
	{
		// Drawing images objects
		g.drawImage(logo, Drawing.WIDTH + 75, 50, 640, 200, null);
		g.drawImage(ship, 330, 230, 150, 150, null); 
		
		
		// Public abstract class that displays graphics
		Graphics2D g2d = (Graphics2D) g;
		
		// Drawing letters and displaying the buttons to the screen
		Font fnt1 = new Font("Arial", Font.BOLD, 30);
		g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 70, playButton.y + 35);
		g2d.draw(playButton);
		g.drawString("Help", helpButton.x + 70, helpButton.y + 35);
		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x + 70, quitButton.y + 35);
		g2d.draw(quitButton);
	}

}
