public class CarClass
{
 private int yearModel;
 private String make;
 private int speed;
 
  public CarClass(int yM, String m)
  {
   yearModel = yM;
   make = m;
   speed = 0;
  }
 
  public void setYeraModel(int yM)
  {
     yearModel = yM;
  }
 public int getYearModel()
  {
     return yearModel;
  }
  
 public void setMake(String m)
  {
     make = m;
  }
 
 public String getMake()
  {
     return make;
  }
 
 public void setSpeed(int s)
  {
     speed = s;
  }
 
 public int getSpeed()
  {
     return speed;
  }

  public void accelerate()
  {
   speed += 5;  
  }
 
  public void brake()
  {
   speed -= 5; 
  }
}