package behavioral.state;

public class New implements OrderState {

	@Override
	public double handleCancellation() {
		System.out.println("It's a new Order, hence no processing needed");
		return 0;
	}

}
