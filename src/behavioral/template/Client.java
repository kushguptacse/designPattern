package behavioral.template;

public class Client {

	public static void main(String[] args) {
		Order order = new Order("1001");

		order.addItem("Soda", 2.50);
		order.addItem("Sandwitch", 11.95);
		order.addItem("Pizza", 15.95);

		OrderPrinter printer = new TextPrinter();
		printer.printOrder(order, "1001.html");
	}

}
