package structural.facade;

import structural.facade.email.EmailFacade;

public class ClientApp {
	public static void main(String[] args) {
		EmailFacade facade = new EmailFacade();
		boolean result = facade.sendOrderEmail(new Order("2", 233.0));
		System.out.println("Order email: " + (result ? "sent" : "not sent"));
	}
}
