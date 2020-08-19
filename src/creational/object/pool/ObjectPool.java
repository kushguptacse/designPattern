package creational.object.pool;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T extends Poolable> {

	private final BlockingQueue<T> availablePool = new LinkedBlockingQueue<>();

	public ObjectPool(List<T> suppliers) {
		suppliers.forEach(obj -> availablePool.add(obj));
	}

	public T get() {
		try {
			return availablePool.take();
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		return null;
	}

	public void release(T object) {
		try {
			object.reset();
			availablePool.put(object);
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}

}
