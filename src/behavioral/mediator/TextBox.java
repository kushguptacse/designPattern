package behavioral.mediator;

public class TextBox implements UIControl {

	private String value;

	private String name;

	public TextBox(UIMediator mediator, String name) {
		this.name = name;
		mediator.register(this);
	}

	@Override
	public void controlChanged(UIControl control) {
		this.value = control.getValue();
		System.out.println(control);
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "TextBox [value=" + value + ", name=" + name + "]";
	}
}
