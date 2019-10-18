import java.awt.BorderLayout;
import javax.swing.JApplet;


@SuppressWarnings("serial")
public class GUI extends JApplet {
	     
		public void init(){
			 
            // Create panels
			Connection	connection	= new Connection();
			Details		details		= new Details();
			
			// Add panels
			add(details, 	BorderLayout.SOUTH);
			add(connection, BorderLayout.CENTER);

			 //Size and Display 
		    setSize(250, 450);
		    setVisible(true);
		}


	}
