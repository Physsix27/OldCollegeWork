import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


	public class Connection extends JPanel implements ActionListener{
		
		private JPanel panel;
	    private JPanel panel1;
		
		JComboBox 		connectionsBox;
		JButton			connectButton;
	    JLabel          centerText;
		
		static String[] connections 		 = new String[3];
		static String 	connectionSelection  = "";
		boolean			connected 			 = false;
        
	
		public Connection(){
			// set Connection Panel looks
			setBorder(BorderFactory.createBevelBorder(4));
			
		   //Add a setLayout manager
		    setLayout(new BorderLayout());
		    
		   //create panels
		    panel = new JPanel();
		    panel1 = new JPanel();
			
            // Menu selections
			connections[0] = "Select Connection";
			connections[1] = "TCP Server";
			connections[2] = "UDP Server";
			
     		// Connection Panel components
			connectionsBox		= new JComboBox(connections);
			connectButton		= new JButton("Connect");
		    centerText          = new JLabel("Server"); 

		   
		    // Changing the font of the label
		    centerText.setFont(new Font("Arial", Font.ITALIC, 65));
		    connectionsBox.setFont(new Font("Arial", Font.BOLD, 17));
		    connectButton.setForeground(Color.red);
		    
			// action Listeners
			connectionsBox	.addActionListener(this);
			connectButton	.addActionListener(this);
			
			// Color for the label
		    centerText.setForeground(Color.black);
		    connectionsBox.setForeground(Color.black);
			
  			// add butons and box
			panel.add(centerText);
			panel1.add(connectionsBox);
			panel1.add(connectButton);	
			
			panel.setBackground(new Color(100, 255, 100));
			panel1.setBackground(new Color(100, 255, 100));
			
			//add the panel to their place in the jframe
		    add(panel, BorderLayout.NORTH);
		    add(panel1, BorderLayout.CENTER);
		    

		}
        
		
		public void actionPerformed(ActionEvent e) {
    		// If comboBox item changes, record change
			if(e.getActionCommand().equals("comboBoxChanged")){
				
				String choice = getChoice(e);
				
				if(choice.equals("Select Connection"))
					connectionSelection = "Select Connection";
				if(choice.equals("TCP Server"))
					connectionSelection = "TCP Server";
				if(choice.equals("UDP Server"))
					connectionSelection = "UDP Server";
			}//end if
			
			// When connect button pressed, connect with selected connection type
			if(e.getActionCommand().equals("Connect")){
				
				if(connectionSelection.equals("TCP Server"))
					connect("TCP Server");
				if(connectionSelection.equals("UDP Server"))
					connect("UDP Server");					
			}//end if
			
 			// When disconnect button is pressed, disconnect
			if(e.getActionCommand().equals("Disconnect") && connected == true)
				disconnect();
		}

		public void connect(String connection){
			connectionsBox		.setEnabled(false);
			connectButton		.setEnabled(false);
			Details.connection	.setText("Connecting With: " + connection);
                        
                        boolean tcp = false;
                        if( connection.equals("TCP Server") )
                            tcp = true;   
                        try{
                            EchoServer server = new EchoServer(tcp);
                        }catch(Exception e){
                            System.out.println("Connection: something went wrong with the Server");
                        }
                        try{
                            Client client = new Client("Client",tcp);
                        }catch(Exception e){
                            System.out.println("Connection : something went wrong with the Client");
                        }
                        
                        
			connected = true;
			Details.connection	.setText("Connected With: " + connection);
		}

		public void disconnect(){
			Details.connection	.setText("Diconnecting");
			
            // DISCONNECT FROM TCP/UDP HERE
			connected = false;
			connectionsBox		.setEnabled(true);
			connectButton		.setEnabled(true);
			Details.connection	.setText("Connection Error");
		}

		public String getChoice(ActionEvent e){
			JComboBox	box		= (JComboBox) e.getSource();
			Object		item	= box.getSelectedItem();
			String		choice	= item.toString();
			return 		choice;
		}

		
		
}
