public class RectangleDemo
{
 public static void main(String[] args) 
 {
   //create a rectangle object
     Rectangle box = new Rectangle();
     
   //set length to 10.0 and width to 20.0
     box.setLegth(10.0);
     box.setWidth(20.0);
     
   //display length
     System.out.println("The box length is " + box.getLegth());//method that belonds to the 
                                                               //rectangle class
     
   //display the width
     System.out.println("The box width is " + box.getWidth());
     
   //display the are
     System.out.println("The box area is " + box.getArea());
 }
}