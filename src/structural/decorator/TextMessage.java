package structural.decorator;

//Concrete component. Object to be decorated
public class TextMessage implements Message {
	private String text;

	public TextMessage(String msg) {
		this.text = msg;
	}

	@Override
	public String getContent() {
		return text;
	}

}
