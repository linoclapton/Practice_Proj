package snakeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {

	private boolean alive = false;
	private Snake snake;
	private MyPanel myPanel;
	private ArrayList<Obstacle> obstacles;
	private int borderX = 40,borderY=30;
	private Random random = new Random();
	public Game(){
		snake = new Snake(6);
		obstacles = new ArrayList<>();
	}
	
	public void start(){
		
			int count = 1;
			while(!alive){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			while(alive){
				alive = snake.forward();
				if(count%20==0)
				{int x = random.nextInt(borderX);
				int y = random.nextInt(borderY);
				obstacles.add(randomObstacle(new Point(x, y)));
				count = 0;
				}
				count++;
				testCollision();
				myPanel.drawGame();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		
	public void testCollision(){
		
		Point head = snake.get(0);
		for(int i = 0;i<obstacles.size();i++)
			if(obstacles.get(i).get().compareTo(head))
				{alive = obstacles.get(i).makeChange(snake);
				obstacles.remove(i);myPanel.drawGame();break;
				}
	}
	
	public Obstacle randomObstacle(Point point){
		int i = random.nextInt(2);
		Obstacle obstacle = null;
		switch (i) {
		case 0:
			obstacle = new Poison(point);
			break;
		case 1:
			obstacle = new Gift(point);
			break;
		}
		return obstacle;
	}
	public boolean up(){if(alive){alive = snake.up();testCollision();}return alive;}
	public boolean down(){if(alive){alive = snake.down();testCollision(); }return alive;}
	public boolean left(){ if(alive){alive = snake.left();testCollision(); }return alive;}
	public boolean right(){if(alive){ alive = snake.right();testCollision();} return alive;}
	public boolean stop(){return alive = false;}
	public void setPanel(MyPanel myPanel){this.myPanel = myPanel;}
	public Snake getSnake(){return snake;}
	public List<Obstacle> getGifts(){return obstacles;}
	public void setAlive(boolean alive){this.alive = alive;}
}
