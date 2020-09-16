package behavioral.template;

//Concrete implementation. Implements steps needed..
//..by template method
public class TextPrinter extends OrderPrinter {

	@Override
	protected String start() {
		return "Order Details";
	}

	@Override
	protected String formatOrderNumber(Order order) {
		return "Order #" + order.getId();
	}

	@Override
	protected String formatItems(Order order) {
		StringBuilder sb = new StringBuilder("Items\n....................");
		order.getItems().forEach((k, v) -> sb.append(k).append("$").append(v).append("\n"));
		return sb.append("-----------------------------").toString();
	}

	@Override
	protected String formatTotal(Order order) {
		return "Total #" + order.getTotal();
	}

	@Override
	protected String end() {
		return "";
	}

}
