package solid.singleResponsibility.after;

import solid.singleResponsibility.before.Store;
import solid.singleResponsibility.before.User;

public class UserPersistenceService {
	private Store store = new Store();

	public void saveUser(User user) {
		store.store(user);
	}

}
