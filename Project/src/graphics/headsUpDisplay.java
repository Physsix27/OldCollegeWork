package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//Heads Up Display Class
public class headsUpDisplay 
{
	public  float HEALTH            = 100;
	public  float greenValue        = 255;
	public  int   kills	         	= 0;
	public  int   score      	    = 0;
	private int   level     	    = 1;
	
	public headsUpDisplay(){
		greenValue = HEALTH * 2;
	}
	
	public void updateScore(long elapsedTime){
		score++;
	}
	
	public void setKills(int kills){
		this.kills = kills;
	}
	
	public int getKills(){
		return kills;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 16);
		g.setColor(new Color(100, (int) greenValue, 0));
		g.fillRect(15, 15, (int) (HEALTH * 2), 16);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 16);

		Font fnt1 = new Font("Arial", Font.BOLD, 15);
		g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("Score: " + score, 15, 50);
		g.drawString("Kills: " + kills, 15, 65);
		g.drawString("Level: " + level, 15, 80);
		
	}

}
