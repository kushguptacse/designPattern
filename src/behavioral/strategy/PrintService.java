package behavioral.strategy;

import java.util.List;

// context class
public class PrintService {

	private OrderPrinter orderPrinter;

	public PrintService(OrderPrinter orderPrinter) {
		this.orderPrinter = orderPrinter;
	}

	public void printOrders(List<Order> orders) {
		orderPrinter.printOrder(orders);
	}

}
