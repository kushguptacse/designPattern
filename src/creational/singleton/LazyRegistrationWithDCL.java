package creational.singleton;

public class LazyRegistrationWithDCL {

	// volatile is used so that thread will not used cached copy of the variable.
	// and always read object from memory
	private static volatile LazyRegistrationWithDCL INSTANCE;

	private LazyRegistrationWithDCL() {

	}

	public static LazyRegistrationWithDCL getInstance() {

		if (INSTANCE == null) {
			// here one thread goes inside and below block but it might be possible that
			// other thread waits. so in this way two objects will get created and
			// that is why null check is added inside synchronized block also.
			synchronized (LazyRegistrationWithDCL.class) {
				if (INSTANCE == null) {
					INSTANCE = new LazyRegistrationWithDCL();
				}
			}
		}
		return INSTANCE;
	}

}
