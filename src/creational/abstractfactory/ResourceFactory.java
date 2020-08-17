package creational.abstractfactory;

import creational.abstractfactory.Instance.Capacity;

public abstract class ResourceFactory {
	
	public abstract Instance createInstance(Capacity capacity);
	public abstract Storage createStorage(int capMib);

}
