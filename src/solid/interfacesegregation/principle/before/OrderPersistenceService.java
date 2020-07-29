package solid.interfacesegregation.principle.before;

import java.util.HashMap;
import java.util.Map;

public class OrderPersistenceService implements PersistenceService<Order> {

	private final Map<Long, Order> store = new HashMap<>();

	@Override
	public void save(Order entity) {
		store.put(entity.getId(), entity);
	}

	@Override
	public boolean delete(Order entity) {
		return store.remove(entity.getId()) != null;
	}

	@Override
	public Order findById(Long id) {
		return store.get(id);
	}

	@Override
	public Order findByName(String name) {
		throw new UnsupportedOperationException("Order entity does not contain name field");
	}

}
