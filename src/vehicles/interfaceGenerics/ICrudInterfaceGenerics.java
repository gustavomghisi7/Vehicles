package vehicles.interfaceGenerics;

import java.util.List;

public interface ICrudInterfaceGenerics<T> {
	
	boolean create(T obj);
	
	T read(int id);
	
	boolean update(T obj);
	
	void delete(int id);
	
	List<T> readAll();

}
