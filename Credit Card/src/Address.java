
public class Address 
{
 private String street; //The Street number and street name
 private String city; //The city in which the address is located
 private String state; //The state in whcih the address is located
 private String zip; //The zip code associated with that city and street


 //Constructor create an address using four parameters
 public Address (String road, String town, String st, String zipCode)
 {

 street = road;
 city = town;
 state = st;
 zip = zipCode;
 }

 //toString method returns information about the address
 public String toString()
 {

 return (street + ", " + city + ", " + state + " " + zip);
 }
}