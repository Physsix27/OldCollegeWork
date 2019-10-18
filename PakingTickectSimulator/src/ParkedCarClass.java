
public final class ParkedCarClass 
{	
    String make;
    String model;
    String color;
    String licenseNumber;
    int minutesParked;
	
/*	
Constructor for ParkedCar. Sets the car's make, model, color, license number, 
and minutes parked from parameters given.
*/	  

    ParkedCarClass(String make, String model, String color, String licenseNumber, int minutesParked)
    {
     setMake(make);
     setModel(model);
     setColor(color);
     setLicenseNumber(licenseNumber);
     setMinutesParked(minutesParked);
    }
    
    public String getColor()
    {
     return color;
    }
	
    public String getLicenseNumber()
    {
     return licenseNumber;
    }
	
    public String getMake()
    {
     return make;
    }
	
    public int getMinutesParked()
    {
     return minutesParked;
    }
	
    public String getModel()
    {
     return model;
    }
	
    public void setColor(String color)
    {
     this.color = color;
    }
	
    public void setLicenseNumber(String licenseNumber)
    {
     this.licenseNumber = licenseNumber;
    }
	
    public void setMake(String make)
    {
     this.make = make;
    }
	
    public void setMinutesParked(int minutesParked)
    {
     this.minutesParked = 125;
    }
	
    public void setModel(String model)
    { 
     this.model = model;
    }
    
}
