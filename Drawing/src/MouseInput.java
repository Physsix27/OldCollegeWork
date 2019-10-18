import java.awt.event.*;

// MouseInput Class
public class MouseInput implements MouseListener
{

	@Override
	public void mousePressed(MouseEvent e) 
	{
		// Getters of the (x, y) position of the mouse
		int mx = e.getX();
		int my = e.getY();
		
		 // In the Menu State
		 if(Drawing.State == Drawing.STATE.MENU)
		 {
			 // Play Button
			 if(mx >= Drawing.WIDTH + 300 && mx <= Drawing.WIDTH + 500)
			 {
				 if(my >= 400 && my <= 450)
				 {
					 // Pressed play button
					 Drawing.State = Drawing.STATE.GAME;
				 }
			 } 
			 
			 
			// Help Button
			 if(mx >= Drawing.WIDTH + 300 && mx <= Drawing.WIDTH + 500)
			 {
				 if(my >= 500 && my <= 550)
				 {
					 // Pressed help button
					 Drawing.State = Drawing.STATE.HELP;
				 }
			 } 
			 
			 // Quit Button
			 if(mx >= Drawing.WIDTH + 300 && mx <= Drawing.WIDTH + 500)
			 {
				 if(my >= 600 && my <= 650)
				 {
					 // Pressed quit button
					 System.exit(1);
				 }	
			 }
		 }
		 
		 //In the Help State
		 if(Drawing.State == Drawing.STATE.HELP)
		 {
			 //Back Button
			 if(mx >= Drawing.WIDTH + 300 && mx <= Drawing.WIDTH + 500)
			 {
				 if(my >= 670 && my <= 720)
				 {
					 Drawing.State = Drawing.STATE.MENU;
				 }
			 }
		 }
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}