package behavioral.observer;

public class QuantityObserver implements OrderObserver {

	@Override
	public void updated(Order order) {

		if (order.getCount() < 5) {
			order.setShippingCost(10);
		} else {
			order.setShippingCost(10 + (order.getCount() - 5) * 1.5);
		}

	}

}
