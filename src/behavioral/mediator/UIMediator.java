package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class UIMediator {

	List<UIControl> controls = new ArrayList<>();

	public void register(UIControl control) {
		controls.add(control);
	}

	public void valueChanged(UIControl control) {
		controls.stream().filter(c -> !c.getName().equals(control.getName())).forEach(c -> c.controlChanged(control));
	}

}
