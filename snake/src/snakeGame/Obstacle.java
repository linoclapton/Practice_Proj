package snakeGame;

import java.awt.Image;

public abstract class Obstacle {
	private Point p;
	protected Image image = null;
	public Obstacle(Point p){
		this.p = p;
	}
	public abstract boolean makeChange(Snake snake);
	public Image getImage(){return image;}
	public Point get(){return p;}
}
