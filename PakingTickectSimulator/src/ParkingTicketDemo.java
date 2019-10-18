public class ParkingTicketDemo 
{
    public static void main(String[] args) 
    {
        ParkedCarClass highlander = new ParkedCarClass("a", "a", "a", "a", 0);
        System.out.println("Car Data:");
        System.out.println(highlander.make = "Make: Toyota");
        System.out.print("Model: ");
        System.out.println(highlander.model = "Highlander 2015");
        System.out.println(highlander.color = "Color: Black");
        System.out.println(highlander.licenseNumber = "License Number: 77K070VD");
        System.out.println("Minutes Parked: " + highlander.minutesParked);
        PoliceOfficerClass lola = new PoliceOfficerClass("Lola Smith", "00M001");
        ParkingMeterClass meter = new ParkingMeterClass(30); 
        lola.examineParkedCar(highlander, meter);
        
    }
}