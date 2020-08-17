package creational.singleton;

public class ClientApplication {

	public static void main(String[] args) {
		EagerRegistry registry1 = EagerRegistry.getInstance();
		EagerRegistry registry2 = EagerRegistry.getInstance();
		System.out.println(registry1 == registry2);
		LazyRegistrationWithDCL obj1 = LazyRegistrationWithDCL.getInstance();
		LazyRegistrationWithDCL obj2 = LazyRegistrationWithDCL.getInstance();
		System.out.println(obj1 == obj2);

		LazyRegistrationWithStaticHolder obj3 = LazyRegistrationWithStaticHolder.getInstance();
		LazyRegistrationWithStaticHolder obj4 = LazyRegistrationWithStaticHolder.getInstance();
		System.out.println(obj3 == obj4);
		
		LazyRegistrationWithEnum instance1 = LazyRegistrationWithEnum.INSTANCE;
		LazyRegistrationWithEnum instance2 = LazyRegistrationWithEnum.INSTANCE;
		System.out.println(instance1==instance2);
		instance1.configure();
	}

}
