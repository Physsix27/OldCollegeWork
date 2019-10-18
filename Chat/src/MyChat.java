import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;



public class MyChat implements ActionListener{

	private static JFrame StartChat;
	private JTextField portTextField;
	private JTextField ipAddtextField;
	private JTextField mesgTextField;
	private JLabel lblIpAddress;
	private JLabel lblMessage;
	private static DatagramSocket mySocket = null;
	private static SendChat sendInstance;
	private static ArrayOfWindows array;
	
	private static sound beep;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		array = new ArrayOfWindows();
		
		
	      InetAddress myAddress = null;
			try {
				myAddress = InetAddress.getLocalHost();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			
			System.out.println("this is my address from  main method " + myAddress);
			
			try {
					mySocket = new DatagramSocket(64000, myAddress);
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(-1);
					}
			
			sendInstance = new SendChat(mySocket);
			Thread receiveThread = new Thread(new Runnable () {
				public void run() {
					receiveMethod();
				}
			});
			
			receiveThread.setName("Receive Thread");
			receiveThread.start();
		
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyChat window = new MyChat();
					window.StartChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void receiveMethod() {
		int sourcePort;
		InetAddress sourceAddress = null;
		byte[] inBuffer = new byte[1000];
		
		DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
		
		do {
			for ( int i = 0 ; i < inBuffer.length ; i++ ) {
				inBuffer[i] = ' ';
			}
			
			try {
				// this thread will block in the receive call until a message is received
				System.out.println("Waiting for message");
				mySocket.receive(inPacket);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			
			sourcePort = inPacket.getPort();
			System.out.println("source port: " + sourcePort);
			sourceAddress = inPacket.getAddress();
			System.out.println("source add when i receive:" + sourceAddress);
			
			String message = new String(inPacket.getData());
			
			System.out.println("Received message = " + message);
			

			beep = new sound("/Music/softexplosion.wav");
			beep.play();
			
			if(!(array.isInArray(sourcePort, sourceAddress))){ 
			newChat myChat = new newChat();
			myChat.setTitle("Port: " + sourcePort + "    IP Address: " + sourceAddress.getHostAddress());
			System.out.println("dest :" + sourcePort +" " + sourceAddress);
			myChat.setInstance(mySocket, sendInstance, StartChat, sourcePort, sourceAddress);
			myChat.addToTextArea("Sender: " + message);
			myChat.setVisible(true);
			StartChat.setVisible(false);
			array.addWindow(myChat);
			
			} else {
				int index = array.getWindowIndex();
				array.getWindows()[index].addToTextArea("Sender: " + message);
				array.getWindows()[index].setVisible(true);
			}
		
		} while(true);
	}
	

	/**
	 * Create the application.
	 */
	public MyChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		StartChat = new JFrame();
		StartChat.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		StartChat.setTitle("Start Chat");
		StartChat.setBounds(100, 100, 450, 300);
		StartChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StartChat.getContentPane().setLayout(null);
		

		
		portTextField = new JTextField();
		portTextField.setBounds(128, 65, 251, 26);
		StartChat.getContentPane().add(portTextField);
		portTextField.setColumns(10);
		
		ipAddtextField = new JTextField();
		ipAddtextField.setToolTipText("Please enter IP Address in dotted decimal notation");
		ipAddtextField.setForeground(Color.BLACK);
		ipAddtextField.setBounds(128, 103, 251, 26);
		StartChat.getContentPane().add(ipAddtextField);
		ipAddtextField.setColumns(10);
		
		
		
		mesgTextField = new JTextField();
		mesgTextField.setBounds(128, 139, 251, 26);
		StartChat.getContentPane().add(mesgTextField);
		mesgTextField.setColumns(10);
		
		
		JButton btnChat =  new JButton("Open New Chat");
		btnChat.addActionListener(this);
		
	
		btnChat.setForeground(Color.PINK);
		btnChat.setBounds(31, 192, 141, 29);
		StartChat.getContentPane().add(btnChat);
		
		JButton btnClose = new JButton("End Chat");
		btnClose.setForeground(Color.PINK);
		btnClose.setBounds(250, 192, 117, 29);
		StartChat.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		
		JLabel lblPortNumber = new JLabel("Port Number");
		lblPortNumber.setForeground(Color.PINK);
		lblPortNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortNumber.setBounds(20, 70, 109, 16);
	    StartChat.getContentPane().add(lblPortNumber);
		
		lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpAddress.setForeground(Color.PINK);
		lblIpAddress.setBounds(31, 108, 99, 16);
	    StartChat.getContentPane().add(lblIpAddress);
		
		lblMessage = new JLabel("Message");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(Color.PINK);
		lblMessage.setBounds(41, 144, 72, 16);
	    StartChat.getContentPane().add(lblMessage);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton) e.getSource();
		
		InetAddress otherHost = null;
		int portNumber;
		
		
		switch (btnClicked.getText()) {
		case "Open New Chat":
			
			try {
				
			otherHost = InetAddress.getByName(ipAddtextField.getText());
			ipAddtextField.setText("");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			
			
			portNumber = Integer.parseInt(portTextField.getText());
			portTextField.setText("");
			 
			String text = mesgTextField.getText();
			mesgTextField.setText("");
			
			
			if(!(array.isInArray(portNumber, otherHost))){ 
				newChat myChat = new newChat();
				myChat.setTitle("Port: " + portNumber + "    IP Address: " + otherHost.getHostAddress());
				myChat.setInstance(mySocket, sendInstance, StartChat, portNumber, otherHost);
				myChat.addToTextArea("You: " + text);
				myChat.setVisible(true);
				StartChat.setVisible(false);
				sendInstance.send(text, otherHost, portNumber);
				System.out.println("this is destination address when i send: "  +  otherHost);
				array.addWindow(myChat);
				
				} else {
					int index = array.getWindowIndex();
					array.getWindows()[index].addToTextArea("You: " + text);
					array.getWindows()[index].setVisible(true);
				}
			  
			
			break;
		    case "End Chat":
		    	
			JOptionPane.showMessageDialog(null, "BYE");
			System.exit(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
			break;
		}
		
	}
}
