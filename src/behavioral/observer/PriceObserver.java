package behavioral.observer;

public class PriceObserver implements OrderObserver {

	@Override
	public void updated(Order order) {
		if (order.getItemCost() >= 500) {
			order.setDiscount(25);
		} else if (order.getItemCost() >= 200) {
			order.setDiscount(10);
		}
	}

}
