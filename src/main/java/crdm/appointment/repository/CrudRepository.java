package crdm.appointment.repository;

import java.util.List;

public interface CrudRepository<T, ID> {
	
	T save(T t);
	
	T saveOrUpdate(T t);
	
	T findById(ID id);
	
	List<T> findAll();
	
	void delete(T t);
	
	void deleteById(ID id);
	
	long count();
	
}
