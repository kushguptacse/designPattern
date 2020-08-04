package creational.builder.implementation2;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {

	private String name;

	private String address;

	private String age;

	private UserDTO() {

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

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address;
	}

	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}

	public static class UserDTOBuilder {

		private String firstName;
		private String lastName;
		private String age;
		private String address;
		private UserDTO userDTO;

		public UserDTOBuilder withFirstName(String fName) {
			firstName = fName;
			return this;
		}

		public UserDTOBuilder withLastName(String lName) {
			lastName = lName;
			return this;
		}

		public UserDTOBuilder withBirthDay(LocalDate dob) {
			Period period = Period.between(dob, LocalDate.now());
			age = String.valueOf(period.getYears());
			return this;
		}

		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + ", " + address.getStreet() + System.lineSeparator()
					+ address.getCity() + System.lineSeparator() + address.getState() + " " + address.getZipcode();
			return this;
		}

		public UserDTO build() {
			userDTO = new UserDTO();
			userDTO.setAge(age);
			userDTO.setName(firstName + " " + lastName);
			userDTO.setAddress(address);
			return userDTO;
		}

		public UserDTO getUserDTO() {
			return userDTO;
		}

	}

}
