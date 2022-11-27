package controller;

import java.sql.Connection;
import java.util.List;

import db.DB;
import entities.Seller;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class SellerController {

	private SellerDao sellerDao;
	
	public SellerController() {
		Connection con = DB.getConnection();
		this.sellerDao = new SellerDaoJDBC(con);
	}	
	
	public List<Seller> findAll(){
		return sellerDao.findAll();
	}
	
	public void delete(Integer id) {
		sellerDao.delete(id);
	}
	
	public void insert(Seller seller) {
		sellerDao.insert(seller);
	}
}