package creational.abstractfactory;

public class EC2Instance implements Instance {

	public EC2Instance(Capacity capacity) {
		System.out.println("EC2 instance created with capacity " + capacity);
	}

	@Override
	public void start() {
		System.out.println("Ec2Instance started");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("Attached " + storage + " to Ec2Instance");
	}

	@Override
	public void stop() {
		System.out.println("Ec2Instance stopped");
	}

	@Override
	public String toString() {
		return "EC2Instance";
	}
}
