
public class EchoServer {
	
    private static final int SERVER_PORT = 4000;

    EchoServer(boolean listenTCP){
    	//JOptionPane.showMessageDialog(null,"Starting EchoServer");
        System.out.println("Starting Server");
       // if(listenTCP)
            new TCP_Handler("TCP Server", SERVER_PORT);
       // else
            new UDP_Handler("UDP Server",SERVER_PORT);
    }
}
