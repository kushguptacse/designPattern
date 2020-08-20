package structural.bridge;

public class Queue<T> implements FifoCollection<T> {

	private LinkedList<T> list;

	public Queue(LinkedList<T> list) {
		this.list = list;
	}

	@Override
	public T poll() {
		return list.removeFirst();
	}

	@Override
	public void offer(T t) {
		list.addLast(t);
	}

}
