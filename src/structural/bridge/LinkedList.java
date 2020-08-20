package structural.bridge;

//This is the implementor. 
//Note that this is also an interface
//As implementor is defining its own hierarchy which not related
//at all to the abstraction hierarchy. 
public interface LinkedList<T> {

	void addFirst(T t);

	void addLast(T t);

	T removeFirst();

	T removeLast();

	int getSize();

}
