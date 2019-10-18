import java.awt.Color;
import javax.swing.*;    // Needed for swing classes 
import java.awt.event.*; // Needed for ActionListener Interface

    /*
     A GUI window as its own main method
    */

public class KilometersToMiles extends JFrame 
{
    private JPanel panel;
    private JLabel messageLabel;
    private JButton Button;
    private JTextField TextField;

    //Constructor 
    public KilometersToMiles()
    {
     //Set this window's title. 
      setTitle("Convert to Kilometer");      
      
     //Specify what happens when the close button is clicked. 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    // Build the panel and add it to the frame.
      buildPanel();  
    
    //Add the panel to the frame's content pane. 
      add(panel);
      
     //Size and Display the window.
      setSize(350, 100);
      setVisible(true);
    }
    
   //Panel method
    private void buildPanel()
    {
     // Create a label to display instructions.
      messageLabel = new JLabel("Kilometer To Miles: ");
        
     //Create a text field 10 character wide    
      TextField = new JTextField(15);
      
     //Create a button
      Button = new JButton("Calculate");
      
      
     //Add an action listener to the button.
      Button.addActionListener(new ButtonListener());
      
     //cretae a JPanel object and let the panel field reference it
      panel = new JPanel();
      
           
     //background color
      panel.setBackground(Color.GREEN);
      
     //add the label, textfield, and button to the panel
      panel.add(messageLabel);
      panel.add(TextField);
      panel.add(Button);
      
    }
    
    //CalcButtonListener ia an action listener class for the Calculate button.
    private class ButtonListener implements ActionListener
    {
        /*   
         The actionPerformed method executes when the user clicks on the Calculate button.
         @param a The event object.
        */
        
      @Override
      public void actionPerformed(ActionEvent e)
      {

        final double CONVERSION = 0.6214;
        String input; // To hold the user's input
        double miles; // The number of miles        
        
       //Get the text entered by the user into the text field
        input = TextField.getText();
       
       //Convert the input to miles because input is a string
        miles = Double.parseDouble(input) * CONVERSION;
       
       //Display the result
        JOptionPane.showMessageDialog(null, input + " kilometers is " + miles + " miles.");
      }
    }
    
   //Main Demo
    public static void main(String[] args) 
    {
        KilometersToMiles window2 = new KilometersToMiles();
 
    }  
    
}