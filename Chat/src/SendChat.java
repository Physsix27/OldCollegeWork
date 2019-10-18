import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SendChat {

    static DatagramSocket mySocket = null;
	
 public SendChat() {
	
 }
	
	
 public SendChat(DatagramSocket socket) {
	
		mySocket = socket;
	
 }
	
 /*
	public void removeAddress(String add) {
		for (int i = 0; i < windows.length; i ++) {
			if (windows[i].getTitle() == add) {
				
				if (i == windows.length -1) {
				windows[i] = null;
				} else {
				if (i != windows.length -1) {
				windows[i] = windows[i + 1];
				  }
				}
			  }
			
		}
	}
	*/
	
	public void send(String msg, InetAddress destinationAddress, int port) {

		
		byte[] buffer = new byte[1000];

		
			String message = msg;
			buffer = message.getBytes();
			
			try {
				DatagramPacket packet = new DatagramPacket(buffer, 
														   message.length(),
														   destinationAddress,
														   port);
        
         
         
         
				System.out.println("Sending message = " + message);
				
				mySocket.send(packet);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
	
	}
	
	
	

	
	
}
