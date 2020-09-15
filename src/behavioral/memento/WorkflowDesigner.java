package behavioral.memento;

// originator
public class WorkflowDesigner {

	private Workflow workflow;

	public void createWorkflow(String name) {
		workflow = new Workflow(name);
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public Memento getMemento() {
		if (workflow == null) {
			return new Memento();
		}
		return new Memento(workflow.getSteps(), workflow.getName());
	}

	public void setMemento(Memento memento) {
		if (memento == null || memento.isEmpty()) {
			workflow = null;
		} else {
			workflow = new Workflow(memento.name, memento.steps);
		}

	}

	public void addStep(String step) {
		workflow.addStep(step);
	}

	public void removeStep(String step) {
		workflow.removeStep(step);
	}

	public void print() {
		System.out.println(workflow);
	}

	// memento
	public class Memento {

		private String[] steps;

		private String name;

		private Memento() {

		}

		private Memento(String[] steps, String name) {
			this.steps = steps;
			this.name = name;
		}

		private boolean isEmpty() {
			return name == null && steps == null;
		}

	}
}
