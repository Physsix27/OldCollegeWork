import java.awt.*;
import java.applet.*;

public class Drawing extends Applet
{
 public void paint(Graphics g)
 {
   g.drawLine(10, 10,100, 100);
   drawPoint(10, 10, g);
   drawHorLine(100, 100, 100, g);
   drawVerLine(100, 100, 100, g)

 }

 public void drawPoint(int x, int y, graphics g)
 {
   g.drawPoint(x, y, x, y);
 }

 public void drawHorLine(int x1, int x2, int y, graphics g)
 {
   for(int x = x1; x < x2; x++)
   (
     drawPoint(x, y, g);
   )
 }

 public void drawVerLine(int y1, int y2, int x, graphics g)
 {
   for(int y = y1; y < y2; y++)
   {
     drawPoint(x, y, g)
   }

 }

}