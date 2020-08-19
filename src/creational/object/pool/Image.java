package creational.object.pool;

import javafx.geometry.Point2D;
//Represents our abstract reusable

public interface Image extends Poolable {

	Point2D getLocation();
	
    void setLocation(Point2D location);
    
    void draw();
	
}
