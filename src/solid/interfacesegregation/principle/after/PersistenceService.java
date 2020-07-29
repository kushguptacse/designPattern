package solid.interfacesegregation.principle.after;

import solid.interfacesegregation.principle.before.Entity;

public interface PersistenceService<T extends Entity> {

	public void save(T entity);

	public boolean delete(T entity);

	public T findById(Long id);

}
