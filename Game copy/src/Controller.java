import java.awt.*;
import java.util.*;



// Controller Class
public class Controller 
{
	// Linked list of bullets and asteroids images
	public LinkedList<Bullet> b = new LinkedList<Bullet>();
	public LinkedList<Asteroid> a = new LinkedList<Asteroid>();
	public LinkedList<SmallShip> enemyShipArray = new LinkedList<SmallShip>();
	public LinkedList<BigShip> BigShipArray = new LinkedList<BigShip>();
	public LinkedList<BluePoints> bp = new LinkedList<BluePoints>();

	public static ArrayList<Explosion> explosion; 
	
	// Objects from other classes
	Bullet Templebullet;
	Asteroid Templeasteroid;
	Game game;
	Ship plane;
	Sprite sprite;
	SmallShip smallShip;
	BigShip bigShip;
	BluePoints Templebp;
	
	private int timer = 80;
	private int timer2 = 45;
	private int clock = 100;
	
	// Constructor of the class
	public Controller(Ship ship)
	{
		this.plane = ship;
		explosion = new ArrayList<Explosion>();
	}
	
	// Creates an asteroid and puts it in the linkedList and moves 
	public void generateRandomAsteroids(int y)
	{
	//	if(clock > 0){
			if(a.isEmpty())
			{
				int asteroidsAmount = new Random().nextInt(20) + 10;
				
				for(int i = 0; i < asteroidsAmount; i++) 
				{
					Asteroid asteroid = new Asteroid(randomX(), y - 100);
					asteroid.setVelY(random());
				    addAsteroid(asteroid);
				   
				}
			}
		//}
	}
		
		public void generateRandomBluePoints(int y)
		{
			if(bp.isEmpty())
			{
				//int bluepointsAmount = new Random().nextInt(20) + 10;
				
				for(int i = 0; i < 1; i++) 
				{
					BluePoints bpoints = new BluePoints(randomX(), randomY(),10,60);
				    bpoints.setVelY(5);
				    addBluePoints(bpoints);
				}
			}
		// GENERATES THE ENEMIES SHIPS
				if (enemyShipArray.isEmpty()) {
					int aenemyShipAmount = new Random().nextInt(5) + 1;
					for (int i = 0; i < aenemyShipAmount; i++) {
						SmallShip smallShip = new SmallShip((int)randomX(), (int) randomY());
						smallShip.setVelX(random());
						smallShip.setVelY(random());
						addEnemyShip(smallShip);

					}
				}
				
				//GENERATE THE BIG SHIP
				if (BigShipArray.isEmpty()) {
					//int aenemyShipAmount = new Random().nextInt(5) + 1;
					for (int i = 0; i < 1; i++) {
						BigShip bigship = new BigShip((int)randomX(), -100);
						bigship.setVelX(random());
						bigship.setVelY(random());
						addEnemyBigShip(bigship);

					}
				}
				
				
	}
	
	// Generate bullets and asteroid and bp
	// Ckecks for collision
	public void tick()
	{System.out.println(clock);
		for(int o = 0; o < explosion.size(); o++){
			boolean remove = explosion.get(o).update();
			if(remove){
				explosion.remove(o);
			}
		}
		
		for(int i = 0; i < b.size(); i++)
		{
			Templebullet = b.get(i);

			Templebullet.tick();
			
			if(Templebullet.collisionBox.hasCollidedWith(Templeasteroid.collisionBox))
			{
				//Something goes here

			}
			
			if(Templebullet.getY() < -100){
				removeBullet(Templebullet);
				
			}
				
		}
		
		//loops through to display the asteroids
		
		for(int i = 0; i < a.size(); i++)
		{
			Templeasteroid = a.get(i);

			Templeasteroid.tick();
			
			
			if(Templeasteroid.getY() > 740)
				//removeBullet(Templebullet);
				removeAsteroid(Templeasteroid);
				
		}

		for(int i = 0; i < bp.size(); i++)
		{
			Templebp = bp.get(i);

			Templebp.tick();
			
			if(Templebp.collisionBox.hasCollidedWith(plane.collisionBox))
			{
				Game.health = Game.health+5;
				
				
			}
			if(Templebp.getY() > 740)
				removeBluePoints(Templebp);
				
		}
			
		//CollisionDetection
		for(int i = 0; i < a.size(); i ++)
		{
			Templeasteroid = a.get(i);
			Templeasteroid.tick();
			
			if(a.get(i).collisionBox.hasCollidedWith(plane.collisionBox))
			{
				//Explosion animation
				
				//Explosion Sound for the plane
				
				//Health decreased
				Game.health -= 5;
				if(Game.health <= 0)
					Game.State = Game.STATE.END;
					
				
				//remove asteroid that hit the plane
				removeAsteroid(a.get(i));
				
				//remove the plane
				
			}

			for(int k = 0; k < b.size(); k ++){
			  if(b.get(k).collisionBox.hasCollidedWith(a.get(i).collisionBox)){
				  
				//Health increases
				Game.score += 2;
				
				//Explosion Sound
				explosion.add(new Explosion(a.get(i).x + 30, a.get(i).y + 30, 25, 50));
				
				//Sound for points
					
				//remove asteroid that got hit
				removeAsteroid(a.get(i));
				
				//remove bullet that was used
				removeBullet(b.get(k));
					
			 }
			}
			
			
		}
			  
		
		
		for(int c = 0; c < bp.size(); c ++)
		{
			if(bp.get(c).collisionBox.hasCollidedWith(plane.collisionBox))
			{
				//Explosion animation
				
				//Explosion Sound for the plane
				
				//Score increase
				Game.score += 10;
				
				
				//remove asteroid that hit the plane
				removeBluePoints(bp.get(c));
				
				//remove the plane
				
			}
			
		}
				// ARIFICIAL INTELLIGENCE FOR THE smallShip class
				for (int i = 0; i < enemyShipArray.size(); i++) {
					smallShip = enemyShipArray.get(i);

					smallShip.enemyMoveDown();

					if (smallShip.getX() < plane.getX()) {
						smallShip.enemyMoveRight();
					}

					else if (smallShip.getX() > plane.getX()) {
						smallShip.enemyMoveLeft();
					}

					else if (smallShip.getX() == plane.getX()) {
						smallShip.enemyMoveDown();
					}

					if (smallShip.getY() > 740) {

						removeEnemyShip(smallShip);
					}

				}
				
				// COLLITION DETECTION FOR THE ENEMY SHIPS
				for (int i = 0; i < enemyShipArray.size(); i++) {
					if (enemyShipArray.get(i).collisionBox.hasCollidedWith(plane.collisionBox)) {
						Game.health -= 2;
						removeEnemyShip(enemyShipArray.get(i));

					}
					// Comparison of the bullets colliding enemies ships
					for (int k = 0; k < b.size(); k++) { 
						if (b.get(k).collisionBox.hasCollidedWith(enemyShipArray.get(i).collisionBox)) {
							Game.score += 2;
							explosion.add(new Explosion(enemyShipArray.get(i).x + 30, enemyShipArray.get(i).y + 30, 25, 50));
							removeBullet(b.get(k));
							removeEnemyShip(enemyShipArray.get(i));

						}
					}

				}
				clock--;
				if(clock < 0){
					// ARIFICIAL INTELLIGENCE FOR THE BigShip class
					for (int i = 0; i < BigShipArray.size(); i++) {
						
							bigShip = BigShipArray.get(i); 
							
		
							bigShip.x += bigShip.velX;
							bigShip.collisionBox.moveRightBy(bigShip.velX);
							bigShip.y += bigShip.velY;
							bigShip.collisionBox.moveDownBy(bigShip.velY);
							
							if(timer <= 0) bigShip.velY = 0;
							else timer--;
							
							if(timer <= 0) timer2--;
							if(timer2 <= 0)
							{
								if(bigShip.velX == 0)  bigShip.velX = 2;
								if(bigShip.x > 700) bigShip.velX = -2;
								if(bigShip.x < 0) bigShip.velX = 2;
							}
					
					}
				}
				
				// COLLITION DETECTION FOR THE BIG SHIPS
				for (int i = 0; i < BigShipArray.size(); i++) {
					if (BigShipArray.get(i).collisionBox.hasCollidedWith(plane.collisionBox)) {
						removeEnemyBigShip(BigShipArray.get(i));
						//Explosion
						
						//removeEnemyShip(BigShipArray.get(i));

					}
					// Comparison of the bullets colliding enemies ships
					for (int k = 0; k < b.size(); k++) {
						if (b.get(k).collisionBox.hasCollidedWith(BigShipArray.get(i).collisionBox)) {
							removeBullet(b.get(k));
							removeEnemyBigShip(BigShipArray.get(i));
							removeEnemyBigShip(bigShip);

						}
					}
				}
	}
	
	// METHOD FOR THE ENEMY SHIP(enemySHip linklist)
	public void addEnemyBigShip(BigShip bigShip) {
		BigShipArray.add(bigShip);

	}

	// METHOD FOR THE ENEMY SHIP (enemySHip linklist)
	public void removeEnemyBigShip(BigShip bigShip) {
		BigShipArray.remove(bigShip);
	}

	// METHOD FOR THE ENEMY SHIP(enemySHip linklist)
	public void addEnemyShip(SmallShip enemyShip) {
		enemyShipArray.add(enemyShip);

	}

	// METHOD FOR THE ENEMY SHIP (enemySHip linklist)
	public void removeEnemyShip(SmallShip enemyShip) {
		enemyShipArray.remove(enemyShip);
	}

	// Adds a bullet from the bullet linked list
	public void addBullet(Bullet shot) {
		b.add(shot);
	}

	// Removes a bullet that is alive
	public void removeBullet(Bullet shot) {
		b.remove(shot);
	}

	// Adds a asteroid from the asteroid linked list
	public void addAsteroid(Asteroid shot) {
		a.add(shot);
	}

	// Removes a asteroid that is alive
	public void removeAsteroid(Asteroid shot) {
		a.remove(shot);
	}
	
	public void addBluePoints(BluePoints shot) {
		bp.add(shot);
	}

	// Removes a asteroid that is alive
	public void removeBluePoints(BluePoints shot) {
		bp.remove(shot);
	}

	// Random methods that return a random # between 2 #
	public double random() {
		return Math.random() * 1 + 1;
	}

	public double randomX() {
		return (int) (Math.random() * 725 + .1);
	}

	/// ENEMY SHIPS
	public double randomY() {
		return (int) (Math.random() * 1 + 0.5);
	}

	
	// Draws in the screen
	public void draw(Graphics g)
	{
		for(int i = 0; i < b.size(); i++)
		{
			Templebullet = b.get(i);
			Templebullet.draw(g);
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			Templeasteroid = a.get(i);
			Templeasteroid.draw(g);
		}
		for (int i = 0; i < enemyShipArray.size(); i++) {
			smallShip = enemyShipArray.get(i);
			smallShip.draw(g);
		}
		for (int i = 0; i < BigShipArray.size(); i++) {
			bigShip = BigShipArray.get(i);
			bigShip.draw(g);
		}
		for(int i = 0; i < bp.size(); i++)
		{
			Templebp = bp.get(i);
			Templebp.draw(g);
		}
		for(int i = 0; i < explosion.size(); i++){
			explosion.get(i).draw(g);
		}
	}
}
