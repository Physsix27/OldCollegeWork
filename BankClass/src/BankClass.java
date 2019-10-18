public class BankClass 
{
    private double balance;
    
    
    BankClass()
    {
        balance = 0.0;
        
    }   
    
    public BankClass(double startBalance)
    {
        balance = startBalance;
        
    }
    
    public void deposit (double amount)
    {
        balance += amount;
    }  
    
    public void withdraw(double amount)
    {
        balance -= amount;
    }
          
    public void setBalance(double b )
    {
        balance = b;
        
    }
    
}