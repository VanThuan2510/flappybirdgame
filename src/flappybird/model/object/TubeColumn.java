package flappybird.model.object;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TubeColumn {
	private List<Tube> tubesList;
	private Random random;
	private int baseHeight = 400;
	private int narrowedPoint = 5;
	private int point = 0;
	private int tubeSpeed = 5;
	private int changedSpeed = tubeSpeed;
	private int addPoint = 10;

	public TubeColumn() {
		tubesList = new ArrayList<Tube>();
		random = new Random();
		createTubes();
	}

	private void createTubes() {
		int last = baseHeight;
		int randWay = random.nextInt(10);
		for (int i = 0; i < 20; i++) {
			Tube temp = new Tube(690, last);
			temp.setDx(tubeSpeed);
			last = temp.getY() - temp.getHeight();
			if (i < randWay || i > randWay + narrowedPoint) {
				tubesList.add(temp);
			}
		}
	}

	public void tick() {
		for (int i = 0; i < tubesList.size(); i++) {
			tubesList.get(i).tick();

			if (tubesList.get(i).getX() < 0) {
				tubesList.remove(tubesList.get(i));
			}
		}
		if (tubesList.isEmpty()) {
			this.point += 1;
			if (changedSpeed == point) {
				this.tubeSpeed++;
				this.changedSpeed += addPoint;
			}
			createTubes();
		}
	}

	public void render(Graphics2D g, ImageObserver obs) {
		for (int i = 0; i < tubesList.size(); i++) {
			tubesList.get(i).render(g, obs);
		}
	}

	public List<Tube> getTubesList() {
		return tubesList;
	}

	public void setTubesList(List<Tube> tubesList) {
		this.tubesList = tubesList;
	}

	public int getNarrowedPoint() {
		return narrowedPoint;
	}

	public void setNarrowedPoint(int narrowedPoint) {
		this.narrowedPoint = narrowedPoint;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getChangedSpeed() {
		return changedSpeed;
	}

	public void setChangedSpeed(int changedSpeed) {
		this.changedSpeed = changedSpeed;
	}

	public int getAddPoint() {
		return addPoint;
	}

	public void setAddPoint(int addPoint) {
		this.addPoint = addPoint;
	}

}
