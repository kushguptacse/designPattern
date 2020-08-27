package structural.proxy.part1;

import javafx.geometry.Point2D;

//virtual proxy implementation where we will delay original object creation until render method is called.
public class ImageProxy implements Image {

	private BitMapImage bitMapImage;

	private String name;

	private Point2D location;

	public ImageProxy(String name) {
		this.name = name;
	}

	@Override
	public void setLocation(Point2D point2d) {
		if (bitMapImage != null) {
			bitMapImage.setLocation(point2d);
		} else {
			location = point2d;
		}
	}

	@Override
	public Point2D getLocation() {
		return bitMapImage == null ? location : bitMapImage.getLocation();
	}

	@Override
	public void render() {
		if (bitMapImage == null) {
			bitMapImage = new BitMapImage(name);
			bitMapImage.setLocation(location);
		}
		bitMapImage.render();
	}

}
