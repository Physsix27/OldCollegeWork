
public class PoliceOfficerClass 
{
private String name;
private String badgeNumber;
	
	PoliceOfficerClass(String name, String badgeNumber)
	{
	 this.name = name;
         this.badgeNumber = badgeNumber;
	}
	
	/*
	 * Checks if a parked car's time parked has exceeded the time
	 * purchased on the parking meter.
	 */
	public void examineParkedCar(ParkedCarClass parkedCar, ParkingMeterClass parkingMeter)
	{
		if(parkingMeter.getParkingTimePurchased() < parkedCar.getMinutesParked())
		{
		    ParkingTicketClass parkingTicket = new ParkingTicketClass(this, parkedCar, parkingMeter);
		
		   //Prints parking ticket's information
		    System.out.println("Officers Data:");
		    System.out.println("Name: " + parkingTicket.getOfficerName());
	            System.out.println("Badge number: " + parkingTicket.getOfficerBadgeNumber());
                    System.out.println("Minutes Illegely Parked: " + parkingTicket.getillegalMinutes());
		    System.out.println("Fine: $" + parkingTicket.getFine());
		}
		
		else
		{
			System.out.println("No crime committed.");
		}
	}

	public String getBadgeNumber()
	{
		return badgeNumber;
	}

	public String getName()
	{
		return name;
	}    
}
