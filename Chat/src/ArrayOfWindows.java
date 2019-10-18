import java.net.InetAddress;

public class ArrayOfWindows {

	private newChat[] windows = new newChat[50];
	private int index;
	
public void addWindow(newChat newWindow) {
		
	
	System.out.println(newWindow.getTitle());
		//windows = new newChat[50];
		
		if(newWindow instanceof newChat) {
			//if((isInArray(newWindow.getPort(), newWindow.getAdrress()))) {
				
		    for (int i = 0; i < windows.length; i++) {
			if(windows[i] == null) {
				windows[i] = newWindow;
				index = i;
				
				System.out.println(windows[i].getTitle());
				
				break;
			    }
			
		      //}	
		    } 
		 
		 }

	} 

public newChat[] getWindows() {
	return windows;
  }
  
  
public int getWindowIndex() {
	return index;
}


/*
	//this method will double the inetAddress array size if it is full
	private void resize() {
		
		newChat[] A = new newChat[windows.length * 2];
		
		for(int i = 0; i < windows.length; i++) {
			A[i] = windows[i]; 
		}
		windows = A;
	}*/
	
	public boolean isInArray(int port, InetAddress add) {
		
	
			
		for (int i = 0; i < windows.length; i++) {
			
			if(windows[i] == null) {
				return false;
				
			} else if((windows[i].getPort() == port) && (windows[i].getAdrress().equals(add))){

					System.out.println("entro");
					System.out.println("THIS IS THE TITLE:" + windows[i].getTitle());
					
					index = i;
					
					System.out.println(windows[i].getPort() + " add " + windows[i].getAdrress());
				return true;
		      
			}
		  }
		
		
		return false;
	}
	
}
