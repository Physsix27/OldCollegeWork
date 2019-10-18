import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class newChat extends JFrame implements ActionListener{

	
    private InetAddress address = null;
    private int port;
	private static DatagramSocket mySocket = null;
    private static SendChat sendReceive;
    private JFrame mainWindow;
    private JTextArea textArea;
    private JTextField textField;



    
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newChat frame = new newChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setInstance(DatagramSocket socket, SendChat newSend, JFrame startChat, int portNumber, InetAddress add) {
		mySocket = socket;
		sendReceive = newSend;
		mainWindow = startChat;
		address = add;
		port = portNumber;
	}

	
	public int getPort() {
		return port;
	}
	
	public InetAddress getAdrress() {
		return address;
	}
	
	/**
	 * Create the frame.
	 */
	public newChat() {
		
		 
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(25, 29, 407, 153);
		contentPane.add(textArea);
		
		JButton	btnClose = new JButton("Close");
		btnClose.setBounds(35, 242, 117, 29);
		contentPane.add(btnClose);
		btnClose.addActionListener(this);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(274, 242, 117, 29);
		contentPane.add(btnSend);
		btnSend.addActionListener(this);
	   
		
		textField = new JTextField();
		textField.setBounds(25, 194, 407, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewChat = new JButton("Open New Chat/End Chat");
		btnNewChat.setBounds(25, 0, 209, 29);
		contentPane.add(btnNewChat);
		
		JScrollPane scrollPane = new JScrollPane(textArea, 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(25, 29, 407, 153);
		contentPane.add(scrollPane);
		btnNewChat.addActionListener(this);
	}

	public void addToTextArea(String text) {
		if (textArea.getText().trim().length() == 0) {
			textArea.append(text);
		} else {
		textArea.append("\n" + text);
		}
	}
	
	
	
	
	@Override 
	public void actionPerformed(ActionEvent e) {
    
		JButton btnClicked = (JButton) e.getSource();
		String button = btnClicked.getText();
		
		switch (button) {
		case "Send":
			 String text = textField.getText();
			 textField.setText("");
			 sendReceive.send(text, address, port);
			
			 addToTextArea("You: " + text);
			
			break;
			
		 case "Close":
			JOptionPane.showMessageDialog(null, "BYE");
			setVisible(false);
			
			//System.exit(DISPOSE_ON_CLOSE);
			
			
			break;
			
		 case "Open New Chat/End Chat":
			mainWindow.setVisible(true);
		}				
		
	 }
	}

