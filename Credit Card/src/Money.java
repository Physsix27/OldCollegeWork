//Objects represent non-negative amounts of money
public class Money
{
  private long dollars;  // A number of dollars
  private long cents;    // A number of cents

 //Constructor creates a Money object using the amount of money in
 //dollars and cents represented with a decimal number
 public Money(double amount)
 {
  if(amount < 0)
  {
   System.out.println("Error: Negative amount of money are not allowed.");
   System.exit(0);
  }

  else
  {
   long allCents = Math.round(amount*100);
   dollars = allCents/100;
   cents = allCents%100;
  }
 }

 //TASK #1 Overload the Constructor
 public Money (Money otherObject)
 {
  this.dollars = otherObject.dollars;
  this.cents = otherObject.cents;
 }

 //Adds the calling Money object to the parameter Money object
 public Money add(Money otherAmount)
 {
  Money sum = new Money(0);
  sum.cents = this.cents + otherAmount.cents;
  long carryDollars = sum.cents/100;
  sum.cents = sum.cents%100;
  sum.dollars = this.dollars + otherAmount.dollars + carryDollars;
  return sum;
 }

 //Subtracts the parameter Money object from the calling Money
 //object and returns the difference
 public Money subtract (Money amount)
 {
  Money difference = new Money(0);
  if(this.cents < amount.cents)
  {
   this.dollars = this.dollars -1;
   this.cents = this.cents + 100;
  }

  difference.dollars = this.dollars - amount.dollars;
  difference.cents = this.cents - amount.cents;
  return difference;
 }
 
 public int compareTo(Money amount)
 {
  int value;
  if(this.dollars < amount.dollars)
  {
   value = -1 ;
  }
  else if(this.dollars > amount.dollars)
  {
   value = 1 ;
  }
  else if(this.cents < amount.cents) 
  { 
   value = -1 ;
  }
  else if(this.cents > amount.cents)
  {
   value = 1 ;
  }
  else
  {
   value = 0 ;
  }
  return value;
 }

 //Task #2 Equals method
 public boolean equals(Money amount)
 {
  return(this.dollars == amount.dollars && this.cents == amount.cents);
 }

 //Task #2 toString method
 public String toString()
 {
  //creates a string that looks like money
  String str = "$" + dollars;
  if(cents < 10)
  {
   str = str + ".0" + cents;
   return str;
  }
  else
  {
   str = str + "." + cents;
   return str;
  }
 }
}