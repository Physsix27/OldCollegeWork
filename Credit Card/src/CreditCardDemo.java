// Demonstrates the CreditCard class

public class CreditCardDemo
{
 public static void main (String [] args)
 {

  final Money LIMIT = new Money(1000);
  final Money FIRST_AMOUNT = new Money(200);
  final Money SECOND_AMOUNT = new Money(10.02);
  final Money THIRD_AMOUNT = new Money(25);
  final Money FOURTH_AMOUNT = new Money(990);
 
  Person owner = new Person("Ventura", "Jordano", new Address(" 500 FT Washington ","Manhattan ","NY" , "10033"));
  CreditCardClass visa = new CreditCardClass(owner, LIMIT);
  System.out.println(visa.getPersonals());
  System.out.println("Balance: " + visa.getBalance());
  System.out.println("Credit Limit : " + visa.getCreditLimit());
  System.out.println("Attempt to charge " + FIRST_AMOUNT);
  visa.charge(FIRST_AMOUNT);
  System.out.println("Balance : " + visa.getBalance());
  System.out.println("Attempt to charge " + SECOND_AMOUNT);
  visa.charge(SECOND_AMOUNT);
  System.out.println("Balance : " + visa.getBalance());
  System.out.println("Attempt to pay " + THIRD_AMOUNT);
  visa.payment(THIRD_AMOUNT);
  System.out.println("Payment : " + THIRD_AMOUNT);
  System.out.println("Balance : 185.02");
  System.out.println("Attempt to charge " + FOURTH_AMOUNT);
  visa.charge(FOURTH_AMOUNT);
  System.out.println("Balance : 185.02");
 }
}