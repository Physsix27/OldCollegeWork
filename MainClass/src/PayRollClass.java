/*
Starlyn Urena
**************
*/
public class PayRollClass 
{
   //fields
    private String employeesName;
    private int idNumber;
    private double hourlyPayRate;
    private double numberOfHoursWorked;
    
  //constructor
    public PayRollClass(String en, int idn, double hpr, double nohw)
    {
         en = null;
         idn = 0;
         hpr = 0;    
         nohw = 0;
        
      employeesName = en;
      idNumber = idn;
      hourlyPayRate = hpr;
      numberOfHoursWorked = nohw;
      
    }
 
  //methods
    public void setEmployeesName(String name)
    {
      employeesName = name;
      
    }
    
    public void setIdNumber(int idnum)
    {
      idNumber = idnum;
    }
    
    public void setHourlyPayRate(double HpayR)
    {
      hourlyPayRate = HpayR;
    }
    
    public void setNumberOfHoursWorked(double hWorked)
    {
      numberOfHoursWorked =  hWorked;
    }
    
    public String getEmployeesName()
    {
      return employeesName;
    }
    
    public int getIdNumber()
    {
      return idNumber;
    }
    
    public double getHourlyPayRate()
    {
      return hourlyPayRate;
    }
    
    public double getNumberOfHoursWorked()
    {
      return numberOfHoursWorked;
    }
    
      
   public double employeeGrossPlay()
   {
   //Declare variavles
    double employeeGrossPlay;
   
   //Calculate what they are going to earn
    employeeGrossPlay = numberOfHoursWorked * hourlyPayRate;
    
   //Return what they earned
    return employeeGrossPlay;
   }
}