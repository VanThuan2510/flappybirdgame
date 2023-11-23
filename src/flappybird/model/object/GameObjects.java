package flappybird.model.object;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public abstract class GameObjects {
	// an object needs to have these below fields (properties) like
	// Their positions (x,y)
	// Their forms (width, height) and their images
	protected int x;
	protected int y;
	protected int dx, dy;
	protected int width;
	protected int height;
	protected Image image;

	/**
	 * Determines the height of the image. If the height is not yet known, this
	 * method returns {@code -1} and the specified {@code ImageObserver} object is
	 * notified later.
	 * 
	 * @param observer an object waiting for the image to be loaded.
	 * @return the height of this image, or {@code -1} if the height is not yet
	 *         known.
	 * @see java.awt.Image#getWidth
	 * @see java.awt.image.ImageObserver
	 */

	public GameObjects(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void tick(); // process movement of objects

	public abstract Rectangle getBounds();

	public abstract void render(Graphics2D g, ImageObserver obs); // process the drawing of objects

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
