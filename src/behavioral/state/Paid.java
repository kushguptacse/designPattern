package behavioral.state;

public class Paid implements OrderState {

	@Override
	public double handleCancellation() {
		System.out.println("It's a paid Order, need to contact payment gateway to rollback transaction");
		return 10;
	}

}
