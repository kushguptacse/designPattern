package behavioral.strategy;

import java.util.List;

public class SummaryPrinter implements OrderPrinter {

	@Override
	public void printOrder(List<Order> orders) {
		System.out.println("***************Summary Report***************");
		double total = 0;
		for (Order order : orders) {
			System.out.println(order);
			total += order.getTotal();
		}
		System.out.println("********************************************");
		System.out.println("Total Order Cost: " + total);
	}

}
