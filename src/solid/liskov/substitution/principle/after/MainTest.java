package solid.liskov.substitution.principle.after;

public class MainTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(3);
		rectangle.setWidth(2);
		Square square = new Square();
		square.setSide(4);
		System.out.println(rectangle.area());
		System.out.println(square.area());
		useRectangle(rectangle);
	}

	// This method when designed assumed it will always receive rectangle object
	// whose height and width has fixed behavior.
	// In our case Square cannot be passed now.
	private static void useRectangle(Rectangle rectangle) {
		rectangle.setHeight(5);
		rectangle.setWidth(10);
		if (rectangle.getHeight() != 5) {
			System.out.println("Invalid value. error");
		}
		if (rectangle.getWidth() != 10) {
			System.out.println("Invalid value. error");
		}
	}

}
