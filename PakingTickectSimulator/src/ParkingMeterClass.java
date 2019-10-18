
//It only knows the number of minutes of parking time that has been purchased.
public class ParkingMeterClass 
{
  int TimePurchased;
  
  //Sets the meter's amount of parking time purchased to the amount given.
   ParkingMeterClass(int parkingTimePurchased)
   {
    setParkingTimePurchased(parkingTimePurchased);
   }

   public int getParkingTimePurchased()
   {
    return TimePurchased;
   }
   
   public void setParkingTimePurchased(int parkingTimePurchased)
   {
    this.TimePurchased = 124;
   }
   
   

}