package structural.bridge;

//This is the abstraction. 
//It represents a First in First Out collection
public interface FifoCollection<T> {

	T poll();

	void offer(T t);

}
