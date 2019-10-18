import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JFrame class
 public class ColorFactory extends JFrame {
     
     private JPanel panel;
     private JPanel panel1;
     private JPanel panel2;
     private JLabel blank;
     private JLabel centerText;
     private JButton redButton;
     private JButton orangeButton;
     private JButton yellowButton;
     private JRadioButton radio;
     private JRadioButton radio1;
     private JRadioButton radio2;     
     private ButtonGroup radioGroup;
     
  //Constructor
 public ColorFactory() {
     
   //Set this window's title. 
    setTitle("Color Factory");      
      
   //Specify what happens when the close button is clicked. 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
   //Add a setLayout manager
    setLayout(new BorderLayout());
    
   //create panels
    panel = new JPanel();
    panel1 = new JPanel();
    panel2 = new JPanel();
    
    
   //panels background
    panel.setBackground(Color.white);
    panel2.setBackground(Color.white);
    
   //Create labels
    
    centerText = new JLabel("Top buttons change the panel color and "
            + "bottom radio buttons change the text color"); 
    centerText.setForeground(Color.blue);
    blank = new JLabel("");
    
   //create buttons
    redButton = new JButton("Red");   
    orangeButton = new JButton("Orange"); 
    yellowButton = new JButton("Yellow");
    
     
   //background of buttons
    redButton.setBackground(Color.RED);
    orangeButton.setBackground(Color.ORANGE);
    yellowButton.setBackground(Color.YELLOW);
  
    redButton.setBorderPainted(true);
    redButton.setOpaque(true);

    
    orangeButton.setBorderPainted(true);
    orangeButton.setOpaque(true);
    
    
    yellowButton.setBorderPainted(true);
    yellowButton.setOpaque(true);
   
            
   //create radio buttons
    radio = new JRadioButton("Green");
    radio1 = new JRadioButton("Blue", true);
    radio2 = new JRadioButton("Cyan");

    
   //foreground for radio buttons
    radio.setForeground(Color.GREEN);
    radio1.setForeground(Color.BLUE); 
    radio2.setForeground(Color.CYAN);
    
    
   //Radio button 
    radioGroup = new ButtonGroup();
    radioGroup.add(radio);
    radioGroup.add(radio1);
    radioGroup.add(radio2);
    
    
   //create buttons listeners
    redButton.addActionListener(new ButtonListener1());     
    orangeButton.addActionListener(new ButtonListener1());
    yellowButton.addActionListener(new ButtonListener1());
    radio.addActionListener(new ButtonListener2());
    radio1.addActionListener(new ButtonListener2());
    radio2.addActionListener(new ButtonListener2());
            
    
    
   //Add the buttons and labels to the panel
    panel.add(redButton);
    panel.add(orangeButton);
    panel.add(yellowButton);
    panel1.setLayout(new GridLayout(3,1));
    panel1.add(blank);
    panel1.add(centerText);
    panel2.add(radio);
    panel2.add(radio1);
    panel2.add(radio2);
    
    
   //add the panel to their place in the jframe
    add(panel, BorderLayout.NORTH);
    add(panel1, BorderLayout.CENTER);
    add(panel2, BorderLayout.SOUTH);
    
    
   //Size and Display 
    setSize(500, 300);
    setResizable(false);
    setVisible(true);  
 }
 
  
    private class ButtonListener1 implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) 
     {
      
         String actionCommand = e.getActionCommand();

         // Determine which button was clicked and display
         // a message.
         switch (actionCommand) {
             case "Red":
                 panel1.setBackground(Color.RED);
                 break;
             case "Orange":
                 panel1.setBackground(Color.ORANGE);
                 break;
             case "Yellow":
                 panel1.setBackground(Color.YELLOW);
                 break;
         }
      
     }
    }
  
    
    private class ButtonListener2 implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         String actionCommand = e.getActionCommand();

         // Determine which button was clicked and display
         // a message.
         switch (actionCommand) {
             case "Green":
                 centerText.setForeground(Color.GREEN);
                 break;
             case "Blue":
                 centerText.setForeground(Color.BLUE);
                 break;
             case "Cyan":
                 centerText.setForeground(Color.CYAN);
                 break;
         }
     }
    }
    

  public static void main(String[] args){
     ColorFactory factory = new ColorFactory(); 
  }
 }