package com.aptech.core.dao.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.aptech.core.dao.DAO;
import com.aptech.core.dao.ProductDao;
import com.aptech.servjsp.Product;

@Stateless
public class ProductDaoImpl implements ProductDao {

	@EJB
	private DAO dao;
	
	@Override
	public Product getProduct(int id) {
		return dao.find(Product.class, id);
	}

}
