package creational.builder.implementation1;

public class UserDTO {

	private String name;

	private String address;

	private String age;

	public UserDTO(String name, String address, String age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address;
	}

}
