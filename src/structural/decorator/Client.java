package structural.decorator;

public class Client {

	public static void main(String[] args) {
		Message message = new TextMessage("The <FORCE> is strong with this one!");
		System.out.println("plain text is : " + getMessage(message));
		System.out.println("Base 64 encoded text is :" + getMessage(new Base64EncodedMessage(message)));
		System.out.println("html encoded text is :" + getMessage(new HtmlEncodedMessage(message)));
	}

	private static String getMessage(Message message) {
		return message.getContent();
	}

}
