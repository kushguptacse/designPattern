package solid.interfacesegregation.principle.before;

public interface PersistenceService<T extends Entity> {

	public void save(T entity);

	public boolean delete(T entity);

	public T findById(Long id);

	public T findByName(String name);

}
