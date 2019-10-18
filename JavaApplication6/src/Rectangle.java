public class Rectangle 
{
 private double length;
 private double width;
 
 public void setLegth(double len)
 {
  length = len;
 }

 public void setWidth(double wid)
 {
  width = wid;   
 }
 
 public double getLegth()
 {
     return length;
 }
 
 public double getWidth()
 {
     return width;
 }
 
 public double getArea()
 {
  return length * width;
 }
}