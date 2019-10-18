package graphics;

import java.awt.*;

import game.GameManager;

public class HelpState extends Menu{

	// Creating rectangles for the buttons
	public Rectangle backButton = new Rectangle(GameManager.width/2 - 125, 690, 250, 70);
	

	Image button;
	Image arrows;
	Image instruction;
	Image szxc;

	public HelpState(){

		button		 = Toolkit.getDefaultToolkit().getImage("images/buttons/button.png");	
		arrows		 = Toolkit.getDefaultToolkit().getImage("images/Logo/arrows.png");
		szxc  		 = Toolkit.getDefaultToolkit().getImage("images/Logo/szxc.gif");
		instruction  = Toolkit.getDefaultToolkit().getImage("images/Logo/instruction.png");
	}
	// Drawing methods
	public void draw(Graphics g)
	{
		g.drawImage(instruction, 170, 5, 900, 250, null);
		Font fnt1 = new Font("Arial", Font.BOLD & Font.ITALIC, 50);
		Font fnt2 = new Font("Arial", Font.ITALIC, 35);
		g.setFont(fnt1);
		g.setColor(Color.black);
		g.drawImage(button, GameManager.width /2 - 250, 620, null);
		g.drawString("Back", 590, 745);
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Moving", 300, 600);
		g.drawString("Shooting", 750, 600);
		g.drawImage(arrows, 200, 350, 300, 200, null);
		g.drawImage(szxc, 600, 250, 400, 300, null);
		
		
	}


}
