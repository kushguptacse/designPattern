package behavioral.observer;

public class Client {
	public static void main(String[] args) {
		Order order = new Order("123");
		OrderObserver price = new PriceObserver();
		OrderObserver quantity = new QuantityObserver();

		order.attach(price);
		order.attach(quantity);
		order.addItem(120);
		order.addItem(320);
		order.addItem(200);
		System.out.println(order);
	}
}
