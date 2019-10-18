import java.awt.Graphics;
import java.util.LinkedList;

public class control {
	public LinkedList<Bullet> bulletForCircle = new LinkedList<Bullet>();
	
	Bullet bullet;
	
	public control(GoodCircle circle){
		
	}
	
	public void addBullet(Bullet bulletForCircle){
		this.bulletForCircle.add(bulletForCircle);
	}
	
	public void removeBullet(Bullet bulletForCircle){
		this.bulletForCircle.remove(bulletForCircle);
	}
	
	public void draw(Graphics g){
		
		for(int i = 0; i < bulletForCircle.size(); i++){
			bullet = bulletForCircle.get(i);
			bullet.draw(g);
		}
	}
}
