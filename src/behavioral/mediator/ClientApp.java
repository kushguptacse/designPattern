package behavioral.mediator;

public class ClientApp {

	public static void main(String[] args) {
		UIMediator mediator = new UIMediator();
		TextBox textBox1 = new TextBox(mediator, "textfield1");
		Label label = new Label(mediator, "label1");
		Slider slider = new Slider(mediator, "slider1");
		textBox1.setValue("first text ");
		label.setValue("first label");
		slider.setValue("10");
		
		textBox1.setValue("updated text");
		// will be called when in ui someone change text value
		mediator.valueChanged(textBox1);
		slider.setValue("20");
		// will be called when in ui someone change slider value
		mediator.valueChanged(slider);
	}

}
