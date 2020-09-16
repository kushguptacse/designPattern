package behavioral.state;

public class InTransit implements OrderState {

	@Override
	public double handleCancellation() {
		System.out.println("It's a InTransit Order, need to contact payment gateway to rollback transaction");
		System.out.println("Contacting courier service for cancellation");
		return 20;
	}

}
