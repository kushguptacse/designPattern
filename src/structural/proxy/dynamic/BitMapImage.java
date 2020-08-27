package structural.proxy.dynamic;

import javafx.geometry.Point2D;

//Our concrete class providing actual functionality
public class BitMapImage implements Image {

	private Point2D location;
	private String name;

	public BitMapImage(String name) {
		// Loads image from file on disk
		System.out.println("Loaded from disk:" + name);
		this.name = name;
	}

	@Override
	public void setLocation(Point2D point2d) {
		this.location = point2d;
	}

	@Override
	public Point2D getLocation() {
		return location;
	}

	@Override
	public void render() {
		// renders to screen
		System.out.println("Rendered " + this.name);
	}

}
