package structural.proxy.part1;

import javafx.geometry.Point2D;

public class ClientApplication {
	public static void main(String[] args) {
		Image image = ImageFactory.getInstance("file1");
		image.setLocation(new Point2D(10, 20));
		System.out.println(image.getLocation());
		System.out.println("rendering started!!");
		image.render();
	}
}
