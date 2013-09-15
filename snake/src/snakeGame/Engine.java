package snakeGame;

public class Engine {

	public static void main(String[] args){
		
		
		Game game = new Game();
		new MainFrame(game);
		game.start();
		
	}
	
}
