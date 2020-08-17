package creational.abstractfactory;

import creational.abstractfactory.Instance.Capacity;

public class GoogleCloudResourceFactory extends ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capacityInMib) {
		return new GoogleCloudStorage(capacityInMib);
	}

}
