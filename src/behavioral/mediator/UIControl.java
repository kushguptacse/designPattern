package behavioral.mediator;

//colleague
public interface UIControl {

	public void controlChanged(UIControl control);

	String getValue();

	String getName();

}
