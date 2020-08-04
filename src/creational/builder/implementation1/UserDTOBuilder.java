package creational.builder.implementation1;

import java.time.LocalDate;

public interface UserDTOBuilder {

	UserDTOBuilder withFirstName(String fName);

	UserDTOBuilder withLastName(String lName);

	UserDTOBuilder withBirthDay(LocalDate dob);

	UserDTOBuilder withAddress(Address address);

	// method to assemble final object
	UserDTO build();

	// return reference to build object else return null
	UserDTO getUserDTO();

}
