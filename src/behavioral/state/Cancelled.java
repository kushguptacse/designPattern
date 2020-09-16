package behavioral.state;

// it will behave like null object here
public class Cancelled implements OrderState {

	@Override
	public double handleCancellation() {
		System.out.println("do nothing as order is already cancelled");
		return 0;
	}

}
