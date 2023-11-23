package flappybird.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import flappybird.view.GamePane;

public interface IStrategy {
	public void controllerReleased(GamePane gamePane, KeyEvent e);

	public void controllerPressed(GamePane gamePane, KeyEvent e);

	public void controllerPerformed(GamePane gamePane, ActionEvent e);
}
