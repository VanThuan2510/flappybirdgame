package flappybird.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import flappybird.controller.GameActionListener;
import flappybird.controller.GameKeyAdapter;
import flappybird.model.object.Bird;
import flappybird.model.object.Tube;
import flappybird.model.object.TubeColumn;
import flappybird.model.proxyimage.ProxyImage;

public class GamePane extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isRunning = false;
	private ProxyImage proxyImage;
	private Image background;
	private Bird bird;
	private TubeColumn tubeColumn;
	private int highScore;
	private GameKeyAdapter gameAdapter;
	private GameActionListener gameListener;

	public GamePane() {
		gameAdapter = new GameKeyAdapter(this);
		gameListener = new GameActionListener(this);
		proxyImage = new ProxyImage("/flappybird/model/images/background.jpg"); // Load the image
		background = proxyImage.loadImage().getImage().getScaledInstance(700, 450, 0); // Get the image
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(gameAdapter);
		Timer timer = new Timer(15, this);
		timer.start();
	}

	public GameActionListener getGameListener() {
		return gameListener;
	}

	public boolean getIsRunning() {
		return isRunning;
	}

	public Bird getBird() {
		return bird;
	}

	public TubeColumn getTubeColumn() {
		return tubeColumn;
	}

	// Method is used to process the action
	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().sync(); // Synchronize the display on some systems
		if (isRunning) {
			bird.tick();
			tubeColumn.tick();
			checkCollision();
		}
		repaint();
	}

// Method (paint) is used to paints and draw all components in Panel
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// Draw background
		g2.drawImage(background, 0, 0, null);
		if (isRunning) {
			this.bird.render(g2, this);
			this.tubeColumn.render(g2, this);
			g2.setColor(Color.black);
			g2.setFont(new Font("MV Boli", 1, 20));

//			public abstract void drawString(String str, int x, int y);
			g2.drawString("Current score: " + this.tubeColumn.getPoint(), 10, 20);
		} else {
			g2.setColor(Color.black);
			g.setFont(new Font("MV Boli", 1, 25));
			g2.drawString("Press Enter to Start Game", GamePane.WIDTH + 180, GamePane.HEIGHT + 130);
		}
		g2.setColor(Color.black);
		g.setFont(new Font("MV Boli", 1, 17));
		g2.drawString("High Score: " + highScore, GamePane.WIDTH + 500, 20);

//		dispose() method helps clear resources at each frame/UI component whereas System.exit() terminates abruptly

//		dispose() does not shutdown the VM whereas System.exit() shuts down the system and clears/releases every handle thats opened. 
//		It could lead to disastrous results if the termination is not handled properly
		g.dispose();
	}

	// Method that can restart game
	public void restartGame() {
		if (!isRunning) { // if(false)
			this.isRunning = true;
			// Create the bird object in the middle of the screen
			this.bird = new Bird(GamePane.WIDTH / 4, GamePane.HEIGHT / 2);
			// Create the wall object
			this.tubeColumn = new TubeColumn();
		}
	}

	// Method that can end game when checking Crash
	public void endGame() {
		this.isRunning = false;
		if (this.tubeColumn.getPoint() > highScore) { // If the current score is higher than score
			this.highScore = this.tubeColumn.getPoint(); // Set the highest score by the current score
		}
		this.tubeColumn.setPoint(0);
	}

	public void checkCollision() {
		Rectangle rectBird = this.bird.getBounds();
		Rectangle rectTube;

		for (int i = 0; i < this.tubeColumn.getTubesList().size(); i++) {
			Tube tempTube = this.tubeColumn.getTubesList().get(i);
			rectTube = tempTube.getBounds();
			if (rectBird.intersects(rectTube)) {
				endGame();
			}
		}
	}

}
