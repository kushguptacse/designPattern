package creational.singleton;

public enum LazyRegistrationWithEnum {

	INSTANCE;

	public void configure() {
		System.out.println("some configuration");
	}
}
