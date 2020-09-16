package behavioral.template;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Abstract base class defines the template method
public abstract class OrderPrinter {

	public final void printOrder(Order order, String fileName) {
		try (PrintWriter pw = new PrintWriter(fileName)) {
			pw.println(start());
			pw.println(formatOrderNumber(order));
			pw.println(formatItems(order));
			pw.println(formatTotal(order));
			pw.println(end());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	protected abstract String start();

	protected abstract String formatOrderNumber(Order order);

	protected abstract String formatItems(Order order);

	protected abstract String formatTotal(Order order);
	
	protected abstract String end();
}

