package flappybird.model.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import flappybird.model.proxyimage.ProxyImage;

public class Tube extends GameObjects {
	private ProxyImage proxyImage;

	public Tube(int x, int y) {
		super(x, y);
		if (proxyImage == null) {
			proxyImage = new ProxyImage("/flappybird/model/images/TubeBody.png");
		}
		this.image = proxyImage.loadImage().getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.dx = 5;
	}

	@Override
	public void tick() {
		this.x -= dx;
	}
 
	@Override
	public void render(Graphics2D g, ImageObserver obs) {
		g.drawImage(image, x, y, obs);
	}
 
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
