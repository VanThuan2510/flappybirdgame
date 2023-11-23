package flappybird.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import flappybird.view.GamePane;

public class Controller implements IStrategy {
	@Override
	public void controllerReleased(GamePane gamePane, KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gamePane.getBird().moveLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gamePane.getBird().moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			gamePane.getBird().jump();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			gamePane.getBird().boost(); 
		}
	}

	@Override
	public void controllerPressed(GamePane gamePane, KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gamePane.restartGame();
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			gamePane.endGame();
		}
	}

	@Override
	public void controllerPerformed(GamePane gamePane, ActionEvent e) {
		if (e.getActionCommand().equals("Easy")) {
			gamePane.getTubeColumn().setAddPoint(7);
			gamePane.getTubeColumn().setNarrowedPoint(7);
		} else if (e.getActionCommand().equals("Normal")) {
			gamePane.getTubeColumn().setAddPoint(4);
			gamePane.getTubeColumn().setNarrowedPoint(4);
		} else if (e.getActionCommand().equals("Hard")) {
			gamePane.getTubeColumn().setAddPoint(2);
			gamePane.getTubeColumn().setNarrowedPoint(2);
		}
	}

}
