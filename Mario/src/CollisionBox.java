import java.awt.Color;
import java.awt.Graphics;

public class CollisionBox 
{
	   double  x;
	   double y;
	   int w;
	   int h;


	   public CollisionBox(double x, double y, int w, int h)
	   {
	      this.x = x;
	      this.y = y;

	      this.w = w;
	      this.h = h;
	   }

	   public boolean contains(double mx, double my)
	   {
	      return ((mx < x+w) && (mx > x) && (my > y) && (my < y+h));
	   }

	   public boolean hasCollidedWith(CollisionBox r)
	   {
	      return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h >= y) && (r.y <= y+h));
	   }

	   public void moveBy(double dx, double dy)
	   {
	      x += dx;
	      y += dy;
	   }

	   public void moveLeftBy(double dx)
	   {
	      x -= dx;
	   }

	   public void moveRightBy(double dx)
	   {
	      x += dx;
	   }

	   public void moveUpBy(double dy)
	   {
	      y -= dy;
	   }

	   public void moveDownBy(double dy)
	   {
	      y += dy;
	   }

	   public void draw(Graphics g)
	   {	
		   g.setColor(Color.white);
		   g.drawRect((int)x,(int) y, w, h);
		   
	   }

}
