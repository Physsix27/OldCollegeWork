import java.awt.*;

// Help Class
public class Help 
{
	// Creating rectangles for the buttons
	public Rectangle wrap = new Rectangle(Drawing.WIDTH + 50, 150, 700, 500);
	public Rectangle backButton = new Rectangle(Drawing.WIDTH + 300, 670, 200, 50);
	
	// Drawing methods
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt1 = new Font("Arial", Font.ITALIC, 80);
		Font fnt2 = new Font("Arial", Font.BOLD, 30);
		Font fnt3 = new Font("SignPainter", Font.BOLD, 30);
		g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("Instructions", wrap.x + 150, wrap.y - 50);
		g.setFont(fnt3);
		g.drawString
		(
		    "Are you ready to fly ?", wrap.x + 70, wrap.y + 35
		);
		
		g.setFont(fnt2);
		g2d.draw(wrap);
		g2d.draw(backButton);
		g2d.drawString("Back", backButton.x + 65, backButton.y + 35);
	}

}
