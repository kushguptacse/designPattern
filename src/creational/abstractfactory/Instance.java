package creational.abstractfactory;

public interface Instance {

	enum Capacity {
		MICRO, SMALL, LARGE
	}

	void start();

	void attachStorage(Storage storage);

	void stop();

}
