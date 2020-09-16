package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		new PrintService(new SummaryPrinter()).printOrders(createOrders());
		System.out.println("                                   ");
		new PrintService(new DetailSummaryPrinter()).printOrders(createOrders());
	}

	private static List<Order> createOrders() {
		List<Order> orders = new ArrayList<>();
		Order o = new Order("100");
		o.addItem("Soda", 2);
		o.addItem("Chips", 10);
		orders.add(o);

		o = new Order("200");
		o.addItem("Cake", 20);
		o.addItem("Cookies", 5);
		orders.add(o);

		o = new Order("300");
		o.addItem("Burger", 8);
		o.addItem("Fries", 5);
		orders.add(o);
		return orders;
	}
}
