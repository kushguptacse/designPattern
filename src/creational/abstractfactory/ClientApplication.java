package creational.abstractfactory;

import creational.abstractfactory.Instance.Capacity;

public class ClientApplication {

	private ResourceFactory resourceFactory;

	public ClientApplication(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

	public static void main(String[] args) {
		ClientApplication clientApplication = new ClientApplication(new AwsResourceFactory());
		clientApplication.compute(Capacity.LARGE, 4000);
		ClientApplication clientApplication2 = new ClientApplication(new GoogleCloudResourceFactory());
		System.out.println("------------------------");
		clientApplication2.compute(Capacity.SMALL, 1000);
	}

	private void compute(Capacity capacity, int storageSize) {
		Instance instance = resourceFactory.createInstance(capacity);
		System.out.println(instance);
		instance.start();
		Storage storage = resourceFactory.createStorage(storageSize);
		System.out.println(storage.getId());
		System.out.println(storage);
		instance.attachStorage(storage);
		instance.stop();
	}

}
