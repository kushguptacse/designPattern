package creational.object.pool;

import javafx.geometry.Point2D;

public class BitMap implements Image {

	private Point2D location;

	private String fileName;

	public BitMap(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void reset() {
		this.location = null;
		System.out.println("Object reset done : " + this);
	}

	@Override
	public Point2D getLocation() {
		return location;
	}

	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.println("Drawing " + fileName + " @ " + location);
	}

	@Override
	public String toString() {
		return "BitMap [location=" + location + "]";
	}
}
