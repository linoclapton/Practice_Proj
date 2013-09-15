package snakeGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	Game game;
	public MainFrame(Game pgame) {
		this.game = pgame;

		final JButton beginButton = new JButton("begin");
		final JButton quitButton = new JButton("quit");
		final JButton controlButton = new JButton();
		final MyPanel myPanel = new MyPanel(game);
		game.setPanel(myPanel);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		add(beginButton);
		add(quitButton);
		setLayout(null);

		beginButton.setSize(200, 50);
		quitButton.setSize(200, 50);
		beginButton.setLocation(300, 300);
		quitButton.setLocation(300, 400);
		beginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				add(myPanel);
				myPanel.setSize(800, 600);
				myPanel.setLocation(0, 0);
				myPanel.setSnake(game.getSnake());
				add(controlButton);
				controlButton.setSize(1,1);
				controlButton.setLocation(0,0);
				controlButton.addKeyListener(new KeyListener() {

					boolean alive = true;
					@Override
					public void keyTyped(KeyEvent e) {
				
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyPressed(KeyEvent e) {
						if(alive)
							switch (e.getKeyCode()) {
							case KeyEvent.VK_UP:
								alive=game.up();
								break;
							case KeyEvent.VK_DOWN:
								alive=game.down();
								break;
							case KeyEvent.VK_LEFT:
								alive=game.left();
								break;
							case KeyEvent.VK_RIGHT:
								alive=game.right();
								break;
							case KeyEvent.VK_ESCAPE:
								alive=game.stop();
								break;
							case KeyEvent.VK_ENTER:
								game.setAlive(true);
								break;
							default:
								break;
							}
							myPanel.drawGame();
							myPanel.setFocusable(true);
					}
				});
				controlButton.requestFocus();
				remove(beginButton);
				remove(quitButton);
				validate();

			}
		});
		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		setVisible(true);

	}


}

@SuppressWarnings("serial")
class MyPanel extends JPanel {
	Game game;
	Snake snake = null;
	Image head = Toolkit.getDefaultToolkit().getImage("src\\head.png");
	Image tail = Toolkit.getDefaultToolkit().getImage("src\\tail.png");
	int width = 20;
	int height = 20;

	public MyPanel(Game game) {
		this.game = game;
	}

	public void start() {
		game.start();
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public void drawGame() {

		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (snake != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(head, snake.get(0).getX() * 20,
					snake.get(0).getY() * 20, width, height, this);
			for (int i = 1; i < snake.length(); i++)
				g2d.drawImage(tail, snake.get(i).getX() * 20, snake.get(i)
						.getY() * 20, width, height, this);
			for(int i = 0;i<game.getGifts().size();i++){
				Obstacle obstacle = game.getGifts().get(i);
				g2d.drawImage(obstacle.getImage(),obstacle.get().getX()*20 , obstacle.get().getY()*20, width, height,this);
			}
		}
	}

}
