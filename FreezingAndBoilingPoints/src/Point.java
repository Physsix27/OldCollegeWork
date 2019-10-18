/*
Starlyn Urena
Prof. Persuad
csc 110
05/06/15
**************
HW #5
PG #403
Class
**************
*/
public class Point 
{
  //fields
    private double temperature;
    
 //constructor
  Point (double temp)
  {
        temperature = temp;
  }

 //methods
  public void setTemperature(double tmp)
  {
      temperature = tmp;
  }
    
  public double getTemperature()
  {
      return temperature;
      
  }
    
  public boolean isEthylFreezing()
  {
      if(getTemperature() <= -173)
      {
          return true;
      }
      else
          return false;
  }
  
  public boolean isEthylBoiling()
  {
      if(getTemperature() >= 172)
      {
          return true;
      }
      else
          return false;
  }
  
  public boolean isOxigenFreezing()
  {
      if(getTemperature() <= -362)
      {
          return true;
      }
      else
          return false;
  }
  
  public boolean isOxygenBoiling()
  {
      if(getTemperature() >= -306)
      {
          return true;
      }
      else
          return false;
  }
  
  public boolean isWaterFreezing()
  {
      if(getTemperature() <= 32)
      {
          return true;
      }
      else
      return false;
      
  }
  
  public boolean isWaterBoiling()
  {
      if(getTemperature() >= 212)
      {
          return true;
      }
      else
          return false;
  } 
}