//TASK # 3 Create CreditCard Class
public class CreditCardClass
{ 

 //private fields from UML
 private Money balance;
 private Money creditLimit;
 private Person owner;

 public CreditCardClass(Person newCardHolder, Money limit)
 {

 owner = newCardHolder;
 balance = new Money(0);
 creditLimit = new Money(limit);
 }

 public Money getBalance()
 {
  return new Money(balance);
 }

 public Money getCreditLimit()
 {
  return new Money(creditLimit);
 }

 public String getPersonals()
 {
  return owner.toString();
 }

 public void charge(Money amount)
 {
  Money tempVar = new Money(balance.add(amount));
  if (tempVar.compareTo(creditLimit) > 0)
 {
  System.out.println("Exceeds credit limit");
 }
 else
 {
  balance = tempVar;
  System.out.println("Charge: " + amount);
 }
}

 public void payment(Money amount)
 {
  Money temp = new Money(balance.subtract(amount));

 }
}
