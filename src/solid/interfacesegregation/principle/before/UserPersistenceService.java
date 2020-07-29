package solid.interfacesegregation.principle.before;

import java.util.HashMap;
import java.util.Map;

public class UserPersistenceService implements PersistenceService<User> {

	private final Map<Long, User> store = new HashMap<>();

	@Override
	public void save(User entity) {
		store.put(entity.getId(), entity);
	}

	@Override
	public boolean delete(User entity) {
		return store.remove(entity.getId()) != null;
	}

	@Override
	public User findById(Long id) {
		return store.get(id);
	}

	@Override
	public User findByName(String name) {
		return store.values().stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
	}

}
