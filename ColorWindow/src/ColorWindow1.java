import javax.swing.*;    // Needed for Swing classes
import java.awt.*;       // Needed for Color class
import java.awt.event.*; // Needed for event listener interface


public class ColorWindow1 extends JFrame
{
   private JLabel messageLabel;    // To display a message
   private JButton redButton;      // Changes color to red
   private JButton blueButton;     // Changes color to blue
   private JButton yellowButton;   // Changes color to yellow
   private JPanel panel;           // A panel to hold components
   private final int WINDOW_WIDTH = 200; // Window width
   private final int WINDOW_HEIGHT = 125; // Window height

   //Constructor
   public ColorWindow1()
   {
      // Set the title bar text.
      setTitle("Colors");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a label.
      messageLabel = new JLabel("Click a button to " +
                                "select a color.");

      // Create the three buttons.
      redButton = new JButton("Red");
      blueButton = new JButton("Blue");
      yellowButton = new JButton("Yellow");

      // Register an event listener with all 3 buttons.
      redButton.addActionListener(new Action1Listener());
      blueButton.addActionListener(new Action1Listener());
      yellowButton.addActionListener(new Action1Listener());

      // Create a panel and add the components to it.
      panel = new JPanel();
      panel.add(messageLabel);
      panel.add(redButton);
      panel.add(blueButton);
      panel.add(yellowButton);

      // Add the panel to the content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }

   private class Action1Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          
          // Determine which button was clicked and display
         // a message.
         if(e.equals("Red"))
         {
          //Set the panel's background to red.
          panel.setBackground(Color.RED);

          //Set the label's text to blue.
          messageLabel.setForeground(Color.BLUE);  
         }
         
         else if(e.equals("Blue"))
         {
          //Set the panel's background to blue.
          panel.setBackground(Color.BLUE);

          //Set the label's text to yellow.
          messageLabel.setForeground(Color.YELLOW);  
         }
         
         else if(e.equals("Yellow"))
         {
          //Set the panel's background to yellow.
          panel.setBackground(Color.YELLOW);

          //Set the label's text to black.
          messageLabel.setForeground(Color.BLACK);
         }
         
        } 
      }
   
   
   //Main
   public static void main(String[] args)
   {
       ColorWindow1 colorWindow = new ColorWindow1();
   }
}