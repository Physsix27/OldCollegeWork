import javax.swing.*; //it has gui windows 

public class Window 
{
 public static void main(String[] args) 
 {
 //constants for the window 
  int Height = 250;
  int Width = 350;
        
 //Create a Jframe object
  JFrame window = new JFrame();
        
 //Set window titles
  window.setTitle("This is a simple window");
        
 //Set the size of the window
  window.setSize(Width, Height);
        
 //Specify what happends when the red button is pressed
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
 //Display window
  window.setVisible(true);
    
    }   
}