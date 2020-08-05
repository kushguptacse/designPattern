package creational.factory.method;

public class ClientApplication {

	public static void main(String[] args) {
		printMessage(new TextMessageCreator());
		printMessage(new JsonMessageCreator());
	}

	private static void printMessage(MessageCreator messageCreator) {
		Message msg = messageCreator.createMessage();
		System.out.println(msg);
		System.out.println(msg.getContent());
	}

}
