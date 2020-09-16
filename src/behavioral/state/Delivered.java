package behavioral.state;

public class Delivered implements OrderState {

	@Override
	public double handleCancellation() {
		System.out.println("In Delivered State. Contacting courier service to pickup item");
		System.out.println("once item picked up rollback payment");
		return 30;
	}

}
