package flappybird.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class GameWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 700;
	public static int HEIGHT = 450;
	private GamePane game;

	public GameWindow(String title) {
		game = new GamePane();
		game.setBounds(0, 20, 700, 450);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 50, 20);
		JMenu menu = new JMenu("Difficulty");
		menu.setFont(new Font("Arial", Font.BOLD, 10));
		menuBar.add(menu);

		JMenuItem easyItem = new JMenuItem("Easy");
		easyItem.setActionCommand("Easy");
		easyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0));
		easyItem.addActionListener(game.getGameListener());

		JMenuItem mediumItem = new JMenuItem("Normal");
		mediumItem.setActionCommand("Normal");
		mediumItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0));
		mediumItem.addActionListener(game.getGameListener());

		JMenuItem hardItem = new JMenuItem("Hard");
		hardItem.setActionCommand("Hard");
		hardItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0));
		hardItem.addActionListener(game.getGameListener());

		menu.add(easyItem);
		menu.add(mediumItem);
		menu.add(hardItem);

		this.setLayout(null);
		this.add(menuBar);
		this.add(game);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			new GameWindow("Flappy Bird");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
