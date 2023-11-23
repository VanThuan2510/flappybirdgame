package flappybird.controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import flappybird.view.GamePane;

public class GameActionListener implements ActionListener {
	private Controller controller;
	private GamePane gamePanel;

	public GameActionListener(GamePane gamePanel) {
		this.controller = new Controller();
		this.gamePanel = gamePanel;
	}

	public void action() {
		Toolkit.getDefaultToolkit().sync(); // Synchronize the display on some systems
		if (gamePanel.getIsRunning()) {
			gamePanel.getBird().tick();
			gamePanel.getTubeColumn().tick();
			gamePanel.checkCollision();
		}
		gamePanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.controllerPerformed(gamePanel, e);
	}

}
