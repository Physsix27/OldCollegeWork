public class RetailItem 
{
 //Fields
    String description;
    int unitsOnHand;
    double price;
    
 //constructor
 public RetailItem(String des, int uoh, double pri)
 {
  description = des;
  unitsOnHand = uoh;
  price = pri;
 }
 
 //methods
 public String accessor()
 {
     description = "Designer Jeans";
     return description;
 }
 
 public int accessor1()
 {
     unitsOnHand = 40;
     return unitsOnHand;
 }
 
 public double accessors2()
 {
     price = 34.95;
     return price;
 }
 
 public String accessor3()
 {
      description = "Shirt";
      return description;
      
 }
 
 public int accessor4()
 {
     unitsOnHand = 20;
     return unitsOnHand;
    
 }
 
 public double accessor5()
 {
    price = 24.95;
    return price;
 }
}
