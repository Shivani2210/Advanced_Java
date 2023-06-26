package Day_12;

import java.util.Collection;

public interface DaoInterface<T, K> {
	void createNew(T t);
	Collection<T> getAll();
	T getOneByID(K id);
	void update(T t);
	void deleteById(K id);

}
