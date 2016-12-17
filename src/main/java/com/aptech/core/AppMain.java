/**
 * 
 */
package com.aptech.core;

import javax.ejb.EJB;

import com.aptech.core.dao.impl.ProductDaoImpl;
import com.aptech.servjsp.Product;

/**
 * @author KAI
 *
 */
public class AppMain {

	@EJB
	private static ProductDaoImpl productDao;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		 Product prods = productDao.getProduct(1);
		 
		 System.out.println("=====product  name :" + prods.getProductName());

	}

}
