package creational.abstractfactory;

import creational.abstractfactory.Instance.Capacity;

public class AwsResourceFactory extends ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new EC2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}

}
