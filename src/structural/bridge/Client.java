package structural.bridge;

public class Client {
	
	public static void main(String[] args) {
		FifoCollection<String> queue = new Queue<>(new SingleLinkedList<>());
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
