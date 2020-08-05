package creational.factory.method;

public class JsonMessageCreator extends MessageCreator {

	@Override
	protected Message createMessage() {
		return new JsonMessage();
	}

}
