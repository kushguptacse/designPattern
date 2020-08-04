package creational.builder.implementation1;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {

	private UserDTO userDTO;
	private String firstName;
	private String lastName;
	private String age;
	private String address;

	@Override
	public UserDTOBuilder withFirstName(String fName) {
		this.firstName = fName;
		return this;
	}

	@Override
	public UserDTOBuilder withLastName(String lName) {
		this.lastName = lName;
		return this;
	}

	@Override
	public UserDTOBuilder withBirthDay(LocalDate dob) {
		Period period = Period.between(dob, LocalDate.now());
		this.age = String.valueOf(period.getYears());
		return this;
	}

	@Override
	public UserDTOBuilder withAddress(Address address) {
		this.address = address.getHouseNumber() + ", " + address.getStreet() + System.lineSeparator()
				+ address.getCity() + System.lineSeparator() + address.getState() + " " + address.getZipcode();
		return this;
	}

	@Override
	public UserDTO build() {
		userDTO = new UserDTO(firstName + " " + lastName, address, age);
		return userDTO;
	}

	@Override
	public UserDTO getUserDTO() {
		return userDTO;
	}

}
