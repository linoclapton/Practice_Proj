package snakeGame;

import java.awt.Toolkit;

public class Poison extends Obstacle{

	public Poison(Point p) {
		super(p);
		image = Toolkit.getDefaultToolkit().getImage("src\\poison.png");
	}

	@Override
	public boolean makeChange(Snake snake) {
		return snake.minus();
	}

}
