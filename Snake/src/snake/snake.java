package snake;

import java.awt.*;
import javax.swing.*;


public class snake
{
	private String title;
	private int width;
	private int height;
	private JFrame frame;
	private Canvas canvas;
	
	
	
	public snake(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		createSnake();
		
	}
	
	
	public void createSnake()
	{
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		frame.add(canvas);

	
	}

}
