///**
// * 
// */
//package com.aptech.core;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import com.aptech.servjsp.Product;
//
///**
// * @author KAI
// *
// */
//public class AppMain {
//
//	
//	
//	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
//		
//		 EntityManager em = factory.createEntityManager();
//		
//		 EntityTransaction transaction = em.getTransaction();
//		 Product prods = em.find(Product.class, "1");
//		 
//		 System.out.println("=====product  name :" + prods.getProductName());
//
//	}
//
//}
