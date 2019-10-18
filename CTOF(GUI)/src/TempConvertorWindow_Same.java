import java.awt.*;          
import java.awt.event.*;    
import javax.swing.*;   
 
public class TempConvertorWindow_Same extends JFrame
{
    private JPanel panel;
    private JLabel celsiusLabel;        
    private JLabel fahrenheitLabel;
    private JTextField celsiusTF;       
    private JTextField fahrenheitTF;   
    private JButton convertToFah;
    private JButton convertToCel;
          
    public TempConvertorWindow_Same()
    {
       //create title
        setTitle("Temperature Conversion");
        
       //Specify what happens when the close button is clicked. 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        buildPanel();
        
       //add panel
        add(panel);

       //Size and Display
        setSize (300, 100);
        setResizable(false);
        setVisible(true);
    }
    
    private void buildPanel()
    {
       //create panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
         
        
       //create label
        celsiusLabel = new JLabel("Temp in Celsius: ");
        fahrenheitLabel = new JLabel("Temp in Fahrenheit: ");
       
        
       //create textfields
        celsiusTF = new JTextField(10);
        fahrenheitTF = new JTextField(10);
        
        
       //create buttons
        convertToFah = new JButton("Convert To Fah");
        convertToCel = new JButton("Convert To Cel");
        
        
       //create button listener 
        convertToFah.addActionListener((ActionListener) this); //new convertToFahListerner()
        convertToCel.addActionListener((ActionListener) this); //new convertToCelListener()
        
        
       //add Panel, JLabels and textFields
        panel.add(celsiusLabel);
        panel.add(fahrenheitLabel);
        panel.add(celsiusTF);
        panel.add(fahrenheitTF);
        panel.add(convertToFah, BorderLayout.SOUTH);
        panel.add(convertToCel);
    }
    
  //private class convertToFahListerner implements ActionListener
  //{
     public void actionPerformed(ActionEvent e) 
     {
            double celsius, fahrenheit;
         
            celsius = Double.parseDouble(celsiusTF.getText());
            
            fahrenheit = celsius * 9/5 + 32;
            fahrenheitTF.setText(String.format("%.2f", fahrenheit));
     }     
  // } 
    
  //private class convertToCelListener implements ActionListener
  //{
     public void actionPerformed1(ActionEvent e) 
     {
            double celsius, fahrenheit;
             
            fahrenheit = Double.parseDouble(fahrenheitTF.getText());
           
            celsius = (fahrenheit - 32) * 5/9;
            celsiusTF.setText(String.format("%.2f", celsius));
     }
  //}
     
    public static void main(String[] args)
    {
        new TempConvertorWindow_Same();
    }
}