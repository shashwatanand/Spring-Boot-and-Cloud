package database;

import java.util.List;

public interface DataAccessObject<T> {
	T add(T e);
	List<T> list();
	T find(int key);
}
