public class CheckingAccount extends BankAccount
{
      private final double FEE = 0.15; 
      
      public CheckingAccount (String name, double amount)
      {
            super(name, amount);
            String accountID = "-10";
            String acctNum = getAccountNumber();
            super.setAccountNum(acctNum, accountID);   
             
      }
      
   	public boolean withdraw(double amount)
   	{
            double total = amount;
            total += FEE;
            
            return super.withdraw(total);   
   	}

}
