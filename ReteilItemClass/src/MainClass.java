
public class MainClass
{
 public static void main(String[] args)  
 { 
  //call methos
   RetailItem class1 = new RetailItem("a", 1, 1.1);
   RetailItem class2 = new RetailItem("a", 1, 1.1);
   RetailItem class3 = new RetailItem("a", 1, 1.1);
   
   
   class1.description = "Jacket";
   class1.unitsOnHand = 12;
   class1.price = 59.95;
   
   System.out.println("          Description          Units On Hand          Price");
   System.out.println("-----------------------------------------------------------");
   System.out.println("Item #1" + "   " + class1.description +"               " + class1.unitsOnHand +"                     " + class1.price);
   System.out.println("Item #2" + "   " + class2.accessor() +"       " + class2.accessor1() +"                     " + class2.accessors2());
   System.out.println("Item #3" + "   " + class3.accessor3() +"                " + class3.accessor4() +"                     " + class3.accessor5());
   
 }
}