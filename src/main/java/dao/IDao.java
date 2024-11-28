package dao;

import java.util.List;

public interface IDao<T>{
	public List<T> getAll();
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(int id);
	
	public T getbyID(int id);
	
	public List<Integer> getIds();
}
