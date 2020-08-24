package structural.facade.email;

public class Email {
	private Email() {

	}

	public static EmailBuilder getBuilder() {
		return new EmailBuilder();
	}
}
