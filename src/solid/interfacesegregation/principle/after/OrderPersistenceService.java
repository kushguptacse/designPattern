package solid.interfacesegregation.principle.after;

import java.util.HashMap;
import java.util.Map;

import solid.interfacesegregation.principle.before.Order;

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

}
