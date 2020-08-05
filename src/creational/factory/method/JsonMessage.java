package creational.factory.method;

public class JsonMessage extends Message {

	@Override
	protected String getContent() {
		return "{id:1}";
	}

}
