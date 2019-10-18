
public class SavingsAccount extends BankAccount
{
      private double rate = 0.025; 
      private int savingNum = 0; 
      private static String accountNumber; 
      
      public SavingsAccount(String name, double amount)
      {
            super(name,amount);
            String accountID = "-"+savingNum;
            String acntNumber = super.getAccountNumber();
            accountNumber = acntNumber + accountID; 
               
      }
      
      public SavingsAccount(SavingsAccount oldAccount, double amount)
      {
            super(oldAccount, amount);
            savingNum++;
            String accountID = "-"+savingNum;
            String acntNumber = super.getAccountNumber();
            accountNumber = acntNumber + accountID; 
                         
      }
      
      public void postInterest()
      {
            double newBal = getBalance()*(1+(rate*0.0834));
            super.setBalance(newBal); 
      }
      
      public String getAccountNumber()
      {
            return accountNumber;
      }
}