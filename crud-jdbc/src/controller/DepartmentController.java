package controller;

import java.sql.Connection;
import java.util.List;

import db.DB;
import entities.Department;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;

public class DepartmentController {
	
	private DepartmentDao departmentDao;
	
	public DepartmentController() {
		Connection con = DB.getConnection();
		this.departmentDao = new DepartmentDaoJDBC(con);
	}
	
	public List<Department> findAll(){
		return departmentDao.findAll();
	}
	
	public Department findById(Integer id) {
		return departmentDao.findById(id);
	}
	
	public void delete(Integer id) {
		departmentDao.delete(id);
	}
	
}
