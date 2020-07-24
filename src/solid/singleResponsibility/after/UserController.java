package solid.singleResponsibility.after;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import solid.singleResponsibility.before.User;

public class UserController {

	private UserPersistenceService persistenceService = new UserPersistenceService();
	private ValidatorService validatorService = new ValidatorService();

	public String createUser(String userJson) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);
		// validate user
		if (!validatorService.isValidUser(user)) {
			return "ERROR";
		}
		// save user to store
		persistenceService.saveUser(user);
		return "SUCCESS";
	}

}
