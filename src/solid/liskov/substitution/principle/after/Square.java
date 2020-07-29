package solid.liskov.substitution.principle.after;

public class Square implements Shape {

	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public int area() {
		return side * side;
	}

}
