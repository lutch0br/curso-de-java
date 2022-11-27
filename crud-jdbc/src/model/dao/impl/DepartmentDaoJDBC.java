package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import db.DB;
import db.DbException;
import entities.Department;
import model.dao.DepartmentDao;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn = null;
	private Faker faker = new Faker();
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("INSERT INTO DEPARTMENT (NAME) VALUES (?)");	
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			System.out.printf("%d rows affected\n", rowsAffected);					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		

	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("UPDATE DEPARTMENT "
					+ "SET NAME = ? WHERE ID = ?");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rowsAffected = st.executeUpdate();
			
			System.out.printf("%d rown affected\n", rowsAffected);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("DELETE FROM DEPARTMENT WHERE ID = ?");	
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			
			System.out.printf("%d rows affected", rowsAffected);					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}


	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("SELECT * FROM DEPARTMENT WHERE ID = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department dep = instantiateDepto(rs);
				return dep;
			} else {
				return null;
			}
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private Department instantiateDepto(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("ID"));
		dep.setName(rs.getString("NAME"));

		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("SELECT * FROM DEPARTMENT");			
			rs = st.executeQuery();
			
			List<Department> depts = new ArrayList<>();
			
			while (rs.next()) {
				Department dep = instantiateDepto(rs);
				depts.add(dep);
			}
			
			return depts;
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public Department findByName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("SELECT * FROM DEPARTMENT WHERE NAME = ?");
			st.setString(1, name);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department dep = instantiateDepto(rs);
				return dep;
			} else {
				return null;
			}
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}

