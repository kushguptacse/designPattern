package creational.builder.implementation1;

import java.time.LocalDate;

public class MainApplication {

	public static void main(String[] args) {
		User user = createUser();
		UserDTO userDTO = new UserWebDTOBuilder().withFirstName(user.getFirstName()).withLastName(user.getLastName())
				.withBirthDay(user.getBirthday()).withAddress(user.getAddress()).build();
		System.out.println(userDTO);
	}

	private static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}

}
