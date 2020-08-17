package creational.abstractfactory;

public class GoogleComputeEngineInstance implements Instance {

	public GoogleComputeEngineInstance(Capacity capacity) {
		System.out.println("google cloud instance created with capacity " + capacity);
	}

	@Override
	public void start() {
		System.out.println("google cloud instance started");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("Attached " + storage + " to Compute engine instance");
	}

	@Override
	public void stop() {
		System.out.println("google cloud instance stopped");
	}
	
	@Override
	public String toString() {
		return "Google compute engine instance";
	}

}
