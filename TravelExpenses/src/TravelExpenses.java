import java.awt.*;
import javax.swing.*;  // Needed for swing classes 
import java.awt.event.*; // Needed for ActionListener Interface
import java.text.DecimalFormat;

 
//Jframe class
public class TravelExpenses extends JFrame
{
 private JPanel panel;
 private JPanel panel1;
 private JButton firstButton;
 private JButton secondButton;
 private JLabel firstfLabel;
 private JLabel secondLabel;
 private JLabel thirdLabel;
 private JLabel fourthLabel;
 private JLabel fifthLabel;
 private JLabel sixthLabel;
 private JLabel seventhLabel;
 private JLabel eighthLabel;
 private JTextField firstTextField;
 private JTextField secondTextField;
 private JTextField thirdTextField;
 private JTextField fourthTextField;
 private JTextField fifthTextField;
 private JTextField sixthTextField;
 private JTextField seventhTextField;
 private JTextField eighthTextField;
    
 private String input1;  
 private String input2;
private String input3;
private String input4;
private String input5;
private String input6;
private String input7;
private String input8;// To hold the user's input
 private double days;             
 private double airfare;
 private double carRental;
 private double miles;
 private double parking;
 private double taxi;
 private double registration;
 private double lodging;
 private double DAILY_MEAL_RATE = 37.0;
 private double MAX_PARKING_FEES = 10.0;
 private double MAX_TAXI = 20.0;
 private double MAX_LODGING_PER_NIGHT = 95.0;
 private double MILEAGE_RATE = 0.27;
 private double totalExpenses;
 private double reimbursable;
 private double totalAllowableExpenses;
 private double saved;
 private double owed;
 
 //Constructor
  public TravelExpenses()
  {
   //Set this window's title. 
    setTitle("Travel Expenses");      
      
   //Specify what happens when the close button is clicked. 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   //Build the panel and add it to the frame.
    buildPanel();  
    
   //Add the panel to the frame's content pane. 
    add(panel);
    add(panel1);
      
   //Size and Display the window.
    setSize(380, 340);
    setVisible(true);  
  }
  
  private void buildPanel() 
  {
   //create gridlayout manager
    setLayout(new GridLayout(9, 2));
    
   //Textfields AND LABELS
    firstfLabel = new JLabel("Number of days on the trip: ");
    firstTextField = new JTextField (10);
    firstfLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
    
    
    secondLabel = new JLabel("Amount of airfare: ");
    secondTextField = new JTextField (10);
    secondLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

    thirdLabel = new JLabel("Amount of car rental: ");
    thirdTextField = new JTextField(10);
    thirdLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
    
    
    fourthLabel = new JLabel("Miles driven: ");
    fourthTextField = new JTextField(10);
    fourthLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

    
    fifthLabel = new JLabel("Parking feeds: ");
    fifthTextField = new JTextField(10);
    fifthLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

    
    sixthLabel = new JLabel("Taxi feeds: ");
    sixthTextField = new JTextField(10); 
    sixthLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

    
    seventhLabel = new JLabel("Conference registration: ");
    seventhTextField = new JTextField(10);
    seventhLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

    eighthLabel = new JLabel("Lodging charges per night: ");
    eighthTextField = new JTextField(10);
    eighthLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
    
   //Buttons
    firstButton = new JButton("Reset");
    firstButton.addActionListener(new firstButton());
    
    secondButton = new JButton("Calcute Expenses");
    secondButton.addActionListener(new secondButton());
    
   //Cretae the JPanel object and color 
    panel = new JPanel();    
    panel1 = new JPanel();
    
    
    panel.setLayout(new BorderLayout());
    panel1.setLayout(new BorderLayout());
    
   //add the label, textfield, and button to the panel
    add(firstfLabel);
    add(firstTextField);
    add(secondLabel);
    add(secondTextField);
    add(thirdLabel);
    add(thirdTextField);
    add(fourthLabel);
    add(fourthTextField);
    add(fifthLabel);
    add(fifthTextField);
    add(sixthLabel);
    add(sixthTextField);
    add(seventhLabel);
    add(seventhTextField);
    add(eighthLabel);
    add(eighthTextField);
    panel.add(firstButton, BorderLayout.SOUTH);
    panel1.add(secondButton, BorderLayout.SOUTH);
    
    
  }
  
  //An action listener class 
   public class firstButton implements ActionListener
   {   
   //When the button is pressed this is executed
    public void actionPerformed(ActionEvent e)
    {
      firstTextField.setText("0");
      secondTextField.setText("0");
      thirdTextField.setText("0");
      fourthTextField.setText("0");
      fifthTextField.setText("0");
      sixthTextField.setText("0");
      seventhTextField.setText("0");
      eighthTextField.setText("0");
    }
   }
  
    
  //An action listener class 
   public class secondButton implements ActionListener
   {
   //When the button is pressed this is executed
    public void actionPerformed(ActionEvent e)
    {
      //Get the text entered by the user into 
      //the text field.
       input1 = firstTextField.getText();
       days = Double.parseDouble(input1);
               
       input2 = secondTextField.getText();
       airfare = Double.parseDouble(input2);
               
       input3 = thirdTextField.getText();
       carRental = Double.parseDouble(input3);
               
       input4 = fourthTextField.getText();
       miles = Double.parseDouble(input4);
               
       input5 = fifthTextField.getText();
       parking = Double.parseDouble(input5);
               
       input6 = sixthTextField.getText();
       taxi = Double.parseDouble(input6);
               
       input7 = seventhTextField.getText();
       registration = Double.parseDouble(input7);
               
       input8 = eighthTextField.getText();
       lodging = Double.parseDouble(input8);
               
      //While loop to validate numDays input is greater than 0.
       while (days <= 0)
       {
       //Dialog box to let the user know to try again.
        input1 = JOptionPane.showInputDialog(null, "The number of days you traveled must be greater than 0! " +
                                           "Try again.");
        days = Double.parseDouble(input1);   
       }
         
      //While loop to validate airfare input is not a negative number.
       while (airfare < 0)
       {
       //Dialog box to let the user know to try again.
        input2 = JOptionPane.showInputDialog(null, "Airfare cannot be a negative number! Try again.");
        airfare = Double.parseDouble(input2); 
       }
          
      //While loop to validate rentalFees input is not a negative number.
       while (carRental < 0)
       {
       //Dialog box to let the user know to try again.
        input3 = JOptionPane.showInputDialog(null, "Rental fees cannot be a negative number! Try again.");
        carRental = Double.parseDouble(input3);      
       }
          
      //While loop to validate milesDriven input is not a negative number.
       while (miles < 0)
       {
       //Dialog box to let the user know to try again.
        input4 = JOptionPane.showInputDialog(null, "The miles you drove cannot be a negative number! Try again.");
        miles = Double.parseDouble(input4);    
       }
          
      //While loop to validate parkingFees input is not a negative number.
       while (parking < 0)
       {
       //Dialog box to let the user know to try again.
        input5 = JOptionPane.showInputDialog(null, "Your parking fee cannot be a negative number! Try again.");
        parking = Double.parseDouble(input5);                  
       }
          
      //While loop to validate taxiCharges input is not a negative number.
       while (taxi < 0)
       {
       //Dialog box to let the user know to try again.
        input6 = JOptionPane.showInputDialog(null, "Your taxi charges cannot be a negative number! Try again.");
        taxi = Double.parseDouble(input6);                      
       }
          
      //While loop to validate registrationFees input is not a negative number.
       while (registration < 0)
       {
       //Dialog box to let the user know to try again.
        input7 = JOptionPane.showInputDialog(null, "Your registration fees cannot be a negative number! Try again.");
        registration = Double.parseDouble(input7);                
       }
         
      //While loop to validate lodgingCharges input is greater than 0.
       while (lodging <= 0)
       {
       //Dialog box to let the user know to try again.
        input8 = JOptionPane.showInputDialog(null, "Your lodging fees must be greater than 0! Try again.");
        lodging = Double.parseDouble(input8);                                                   
       }   
   
       
       
      if(e.getSource() == secondButton)  
        {
         if(carRental > 0 && taxi == 0)   
         {
                   
      //Calculate total expenses
       totalExpenses = (airfare + carRental +(MILEAGE_RATE * miles) + (parking + days) + 
               registration + (MAX_LODGING_PER_NIGHT * days) + (DAILY_MEAL_RATE + days) );
       
                                
      //Calculate total allowable expenses
       totalAllowableExpenses = ((days * DAILY_MEAL_RATE) + (MAX_PARKING_FEES * days) + (MAX_LODGING_PER_NIGHT * days)
               + (miles * MILEAGE_RATE) + airfare + registration);
       
          if(totalExpenses > totalAllowableExpenses)
          {
           DecimalFormat dollar = new DecimalFormat("0.00");
           reimbursable = totalExpenses - totalAllowableExpenses;
           
           JOptionPane.showMessageDialog(null, "Total expenses: $" + dollar.format(totalExpenses)
                                       +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                       +"\nReimbursable Expenses : $"+ dollar.format(totalAllowableExpenses)
                                       +"\nAmount to be paid Back: $"+ dollar.format(reimbursable));
           
           
          }
          else if(totalExpenses < totalAllowableExpenses)                     
                 {
                   DecimalFormat dollar = new DecimalFormat("0.00");
                   reimbursable = totalAllowableExpenses - totalExpenses;
      
                   JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)
                                               +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                               +"\nReimbursable Expenses : $"+ dollar.format(totalExpenses)
                                               +"\n\n\nAmount Saved : $"+ dollar.format(reimbursable));
 
                 }
          else
          { 
           DecimalFormat dollar = new DecimalFormat("0.00");
           JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)
                                       +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                       +"\nReimbursable Expenses : $"+ dollar.format(totalExpenses));
          }        
         }
         else if(carRental == 0 && taxi > 0)
              {
               totalExpenses = airfare + taxi + registration + (lodging * days) + (DAILY_MEAL_RATE * days);
                
                totalAllowableExpenses = (DAILY_MEAL_RATE*days) + (MAX_LODGING_PER_NIGHT * days) + 
                                        (MAX_TAXI * days) + airfare + registration;
               
                if(totalExpenses > totalAllowableExpenses)
                  {
                   DecimalFormat dollar = new DecimalFormat("0.00");
                   reimbursable = totalExpenses - totalAllowableExpenses;
                   
                   JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)
                                               +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                               +"\nReimbursable Expenses : $"+ dollar.format(totalAllowableExpenses)
                                               +"\n\n\nAmount to be paid Back: $"+ dollar.format(reimbursable));
                  }
                 else if(totalExpenses < totalAllowableExpenses)                     
                  {
                   DecimalFormat dollar = new DecimalFormat("0.00");
                   reimbursable = totalAllowableExpenses - totalExpenses;
      
                   JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)
                                               +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                               +"\nReimbursable Expenses : $"+ dollar.format(totalExpenses)
                                               +"\n\n\nAmount Saved: $"+ dollar.format(reimbursable));
 
                  }
                else if(totalExpenses == totalAllowableExpenses)
                   { 
                   DecimalFormat dollar = new DecimalFormat("0.00");
                   
                   JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)
                                               +"\nAllowable expenses : $"+ dollar.format(totalAllowableExpenses)
                                               +"\nReimbursable Expenses : $"+ dollar.format(totalExpenses));
                  }
               }
         else if(carRental > 0 && taxi > 0)
            {
                thirdTextField.setText("0");
                fourthTextField.setText("0");
                fifthTextField.setText("0");
                sixthTextField.setText("0");
                JOptionPane.showMessageDialog(null, "You cannot rent a car and take a taxi Simultaneously");
            }
              else
              {
                thirdTextField.setText("0");
                fourthTextField.setText("0");
                fifthTextField.setText("0");
                sixthTextField.setText("0");
                
                totalExpenses = airfare + registration + (lodging * days)+ (DAILY_MEAL_RATE * days);
               
                totalAllowableExpenses = (DAILY_MEAL_RATE * days) + (MAX_PARKING_FEES * days) +
                                         (MAX_LODGING_PER_NIGHT * days) + (MILEAGE_RATE * miles) + airfare +registration;
                
              if(totalExpenses > totalAllowableExpenses)
                {
                   reimbursable = totalExpenses - totalAllowableExpenses;
                   
                   JOptionPane.showMessageDialog(null, "Total expenses: "+ totalExpenses+ "\n"+
                                               "Allowable expenses : "+ totalAllowableExpenses+ "\n"+
                                         "Reimbursable Expenses : "+ totalAllowableExpenses+ "\n"+
                                 " "+ "\n"+"\n"+"Amount to be paid Back: "+ reimbursable);
                }
                 else if(totalExpenses < totalAllowableExpenses)                     
                  {
                  //Create a DecimalFormat object to format output.
                   DecimalFormat dollar = new DecimalFormat("0.00");
                   reimbursable = totalAllowableExpenses - totalExpenses;
      
                   JOptionPane.showMessageDialog(null, "Total expenses: $"+ dollar.format(totalExpenses)+ "\n"+
                                               "Allowable expenses : $"+ dollar.format(totalAllowableExpenses)+ "\n"+
                                         "Reimbursable Expenses : $"+ dollar.format(totalExpenses)+ "\n"+
                                 " "+ "\n"+"\n"+"Amount to be paid Back: $"+ dollar.format(reimbursable));
                  }
              } 
        }
    } 
   }
    
   //Main
    public static void main(String[] args) 
    {
     TravelExpenses main = new TravelExpenses();
    }   
}