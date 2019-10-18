import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Details extends JPanel {

	static JLabel connection;

	public Details(){
		
    	// Details components
		connection = new JLabel("Connection Error");
		
		// Changing the font of thelabel
		connection.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Add components
		add(connection, BorderLayout.SOUTH);
		
		connection.setForeground(new Color(100, 255, 100));
		
		// Add JPanel Color
		setBackground(Color.BLACK);
	}
}
