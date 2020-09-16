package behavioral.state;

//context class
public class Order {

	private OrderState currentState;

	public Order() {
		currentState = new New();
	}
	
	public double cancel() {
		double result = currentState.handleCancellation();
		currentState = new Cancelled();
		return result;
	}

	public void paymentSuccessful() {
		currentState = new Paid();
	}

	public void dispatched() {
		currentState = new InTransit();
	}

	public void delivered() {
		currentState = new Delivered();
	}
}
