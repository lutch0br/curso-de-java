package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn = null;
	private Faker faker = new Faker();
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO SELLER "
					+ "(NAME, EMAIL, BIRTHDATE, BASESALARY, DEPARTMENTID) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)"
					);

			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, faker.number().numberBetween(1, 5));
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.printf("%d rows affected\n", rowsAffected);
			}
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}	
	}

	@Override
	public void update(Seller obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
			try {
				st = conn.prepareStatement(
					"UPDATE SELLER " 
					+ "SET NAME = ?, EMAIL = ?, BIRTHDATE = ?, BASESALARY = ?, "
					+ "DEPARTMENTID = ?"
					+ "WHERE ID = ?"
					);
				
				st.setString(1, obj.getName());
				st.setString(2, obj.getEmail());
				st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				st.setDouble(4, obj.getBaseSalary());
				st.setInt(5, obj.getDepartment().getId());
				st.setInt(6, obj.getId());
				
				int rowsAffected = st.executeUpdate();
				
				System.out.printf("%d rows affected.", rowsAffected);				
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
			}		
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			st = conn.prepareStatement("DELETE FROM SELLER WHERE ID = ?");			
			st.setInt(1, id);
			st.executeUpdate();			
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT SELLER.*, DEPARTMENT.NAME AS DEPNAME "
					+ "FROM SELLER INNER JOIN DEPARTMENT "
					+ "ON SELLER.DEPARTMENTID = DEPARTMENT.ID "
					+ "WHERE SELLER.ID = ?"
			);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			Seller seller = null;
			Department department = null;
			
			if (rs.next()) {
				department = new Department();
				department.setId(rs.getInt("DEPARTMENTID"));
				department.setName(rs.getString("DEPNAME"));
				
				seller = new Seller();
				seller.setId(rs.getInt("ID"));
				seller.setName(rs.getString("NAME"));
				seller.setEmail(rs.getString("EMAIL"));
				seller.setBirthDate(rs.getDate("BIRTHDATE"));
				seller.setBaseSalary(rs.getDouble("BASESALARY"));
				seller.setDepartment(department);
				return seller;
			}
			
			return null;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());			
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT s.*, d.NAME as DEPNAME "
					+ "FROM SELLER s "
					+ "INNER JOIN DEPARTMENT d "
					+ "ON (s.DEPARTMENTID = d.ID)"	
					+ "ORDER BY s.NAME"
			);
			
			rs = st.executeQuery();
			
			List<Seller> sellers = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("DEPARTMENTID"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DEPARTMENTID"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);				
				sellers.add(seller);				
			}
			
			return sellers;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT s.*, d.NAME as DEPNAME "
					+ "FROM SELLER s "
					+ "INNER JOIN DEPARTMENT d "
					+ "ON (s.DEPARTMENTID = d.ID)"	
					+ "WHERE s.DEPARTMENTID = ? "
					+ "ORDER BY s.NAME"
			);
			
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> sellers = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				Department dep = null;
				dep = map.get(rs.getInt("DEPARTMENTID"));

				if (dep == null) {
					dep = instantiateDepartment(rs);
				}
				
				Seller seller = null;
				seller = instantiateSeller(rs, dep);
				
				sellers.add(seller);				
			}			
			
			return sellers;
			
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department d = new Department();		
		d.setId(rs.getInt("DEPARTMENTID"));
		d.setName(rs.getString("DEPNAME"));
		
		return d;
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("ID"));
		seller.setName(rs.getString("NAME"));
		seller.setEmail(rs.getString("EMAIL"));
		seller.setBirthDate(rs.getDate("BIRTHDATE"));
		seller.setBaseSalary(rs.getDouble("BASESALARY"));		
		seller.setDepartment(dep);
		
		return seller;
	}

}

