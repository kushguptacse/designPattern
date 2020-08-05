package creational.factory.method;

public class TextMessage extends Message{

	@Override
	protected String getContent() {
		return "text content";
	}

}
