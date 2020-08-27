package structural.proxy.part1;

import javafx.geometry.Point2D;

// base interface which actual object and proxy object will implement.
public interface Image {

	void setLocation(Point2D point2d);

	Point2D getLocation();

	void render();

}
