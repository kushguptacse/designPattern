package creational.singleton;

public class LazyRegistrationWithStaticHolder {

	private LazyRegistrationWithStaticHolder() {

	}

	// this class will be loaded only when getInstance is called.
	private static class RegistoryHolder {
		// object will be created as soon as RegistoryHolder is loaded.
		private static final LazyRegistrationWithStaticHolder INSTANCE = new LazyRegistrationWithStaticHolder();
	}

	// RegistoryHolder class will be loaded only when getInstance is called.
	public static LazyRegistrationWithStaticHolder getInstance() {
		return RegistoryHolder.INSTANCE;
	}

}
