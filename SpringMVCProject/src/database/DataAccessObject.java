package database;

import java.util.List;

public interface DataAccessObject<E> {

	public E add(E e);
	
	public E find(int id);
	
	public List<E> list();
	
	public void delete(int id);
	
}
