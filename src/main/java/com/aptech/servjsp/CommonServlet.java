package com.aptech.servjsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommonServlet
 */
@WebServlet(urlPatterns = "/CommonServlet", initParams = { @WebInitParam(name = "abc", value = "servletconfig") })
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");

	EntityManager em = factory.createEntityManager();

	EntityTransaction transaction = em.getTransaction();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param = getServletConfig().getInitParameter("abc");
		System.out.println("====param===" + param);
		Product prod = em.find(Product.class, "1");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("=====print product to user: "+ prod.getProductName());
		System.out.println("====name :" + name + "==address===" + address);

		response.getWriter().append("Served at: ").append(request.getContextPath())
				.append("value of init param servlet config: ").append(param);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
