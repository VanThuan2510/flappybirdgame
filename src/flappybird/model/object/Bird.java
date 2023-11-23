package flappybird.model.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import flappybird.model.proxyimage.ProxyImage;
import flappybird.view.GameWindow;

public class Bird extends GameObjects {
	private ProxyImage proxyImage;

	public Bird(int x, int y) {
		super(x, y);
		this.proxyImage = new ProxyImage("/flappybird/model/images/bird.gif");
		this.image = proxyImage.loadImage().getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.x = 300; // Adjust the x position of the bird
		this.y = 200; // Adjust the y position of the bird
		this.dy = 5; // Set the initial (first) speed of the bird
	}

	public void checkWindowBorder() {
		if (this.x <= 0) {
			this.x = 50;
		}
		if (this.x >= GameWindow.WIDTH - -50) {
			this.x = GameWindow.WIDTH - -50;
		}
		if (this.y <= 0) {
			this.y = 50;
		}
		if (this.y >= GameWindow.HEIGHT - 70) {
			this.y = GameWindow.HEIGHT - 70;
		}
	}

	@Override
	public void tick() {
		if (dy <= 3) {
			dy += 2;
		}
		this.y += dy;
		checkWindowBorder();
	}

	@Override
	public void render(Graphics2D g, ImageObserver obs) {
		g.drawImage(image, x, y, obs);
	}

	public void jump() {
		if (dy > 0) { // When the bird is down to the screen, we decrease the speed to 5, make easy to
			dy = 5;
		}
		dy -= 18;
	}

	public void boost() {
		if (dy > 0) { // When the bird is down to the screen, we decrease the speed to 5, make easy to
			dy = 5;
		}
		dy -= 21;
	}

	public void moveLeft() {
		this.x -= 50;
	}

	public void moveRight() {
		this.x += 50;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
