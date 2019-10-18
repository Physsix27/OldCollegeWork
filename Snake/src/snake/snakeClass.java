package snake;

public class snakeClass 
{
	private Thread thread;
	public static final int witdth = 15;
	public static final int heigth = 15;
	
	
	public synchronized void start()
	{
		thread = new Thread();
		thread.start();
		
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		while(true)
		{
			
		}
	}
	
	
	
	

}
