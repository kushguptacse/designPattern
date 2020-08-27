package structural.proxy.dynamic;

import javafx.geometry.Point2D;
import structural.proxy.part1.Image;
import structural.proxy.part1.ImageFactory;

public class ClientApp {

	public static void main(String[] args) {
		Image image = ImageFactory.getInstance("file12");
		image.setLocation(new Point2D(11, 120));
		System.out.println(image.getLocation());
		System.out.println("rendering started!!");
		image.render();
	}

}
