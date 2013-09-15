package snakeGame;

import java.awt.Toolkit;

public class Gift extends Obstacle{

	

	public Gift(Point p) {
		super(p);
		image = Toolkit.getDefaultToolkit().getImage("src\\gift.png");
	}

	@Override
	public boolean makeChange(Snake snake) {
		snake.add();
		return true;
	}
}
