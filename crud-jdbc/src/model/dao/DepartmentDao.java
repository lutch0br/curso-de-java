package model.dao;

import java.util.List;

import entities.Department;

public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	void delete(Integer id);
	Department findById(Integer id);
	Department findByName(String name);
	List<Department> findAll();	
}
