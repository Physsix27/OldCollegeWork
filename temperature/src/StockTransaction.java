import java.util.Scanner;

public class StockTransaction
{
    public static void main(String[]args) 
    {
        int Shares;
        double BPrice; //The buying price for each share
        double SPrice; //The selling price for each share

        Scanner richard = new Scanner(System.in); //creating the scanner
        System.out.print("Enter the number of shares purchased:  ");
        Shares = richard.nextInt();
        System.out.print("Enter the buying price for each share:  ");
        BPrice = richard.nextDouble();
        System.out.print("Enter the selling price for each share: ");
        SPrice = richard.nextDouble();
        
        System.out.println("\n");
        
        System.out.println("Amount paid for the stock: " + BPrice * Shares);
        System.out.println("Buying commission paid to the broker: " + Shares);
        System.out.println("Amount the stock sold for: " + SPrice * Shares);
        System.out.println("Selling commission paid to the broker: " ); //missing calculacion
        System.out.println("Profit/Loss: " ); //missing calculation
    }
}
