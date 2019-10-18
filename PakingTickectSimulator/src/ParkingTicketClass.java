                                                          
public class ParkingTicketClass 
{
    ParkedCarClass parkedCar; //The illegally parked car
    ParkingMeterClass parkingMeter; //The parking meter of the illegally parked car
    PoliceOfficerClass policeOfficer; //The police officer who issued the ticket

    int illegalMinutes;
    
    ParkingTicketClass(PoliceOfficerClass policeOfficer, ParkedCarClass parkedCar, ParkingMeterClass parkingMeter)
    {
     this.illegalMinutes = parkedCar.getMinutesParked() - parkingMeter.getParkingTimePurchased();
     this.policeOfficer = policeOfficer;
     this.parkedCar = parkedCar;
     this.parkingMeter = parkingMeter;
    }
	
    public String getColor()
    {
     return parkedCar.getColor();
    }
	
    public Double getFine()
    {
     
     double fine = 10;

     /*
      Adds the appropriate amount to the fine and then subtracts
      the number of minutes fined from illegalMinutes until
      illegalMinutes is equal to, or less than zero.
     */
		
     if(illegalMinutes >= 60)
       {
	fine += 25.00;
	illegalMinutes -= 60;
       }
		
     while(illegalMinutes > 0)
	  {
	   if(illegalMinutes >= 60)
	     {
	      fine += 10.00;
	      illegalMinutes -= 60;
	     }
	   else
	   {
            fine += 10.00;
            illegalMinutes -= illegalMinutes;
           }
          }	
       	 return fine;
    }

    public int getillegalMinutes()
    {
     return parkedCar.getMinutesParked() - parkingMeter.getParkingTimePurchased();
    }
    
    public String getLicense()
    {
     return parkedCar.getLicenseNumber();
    }
	
    public String getMake()
    {
     return parkedCar.getMake();
    }
	
    public String getModel()
    {
     return parkedCar.getModel(); 
    }
	
    public String getOfficerBadgeNumber()
    {
     return policeOfficer.getBadgeNumber();
    }
	
    public String getOfficerName()
    {
     return policeOfficer.getName();
    }
}