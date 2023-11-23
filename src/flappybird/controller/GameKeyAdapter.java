package flappybird.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import flappybird.view.GamePane;

public class GameKeyAdapter extends KeyAdapter {
	private Controller controller;
	private GamePane gamePanel;

	public GameKeyAdapter(GamePane gamePanel) {
		this.controller = new Controller();
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		controller.controllerPressed(gamePanel, e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.controller.controllerReleased(gamePanel, e);
	}

}
