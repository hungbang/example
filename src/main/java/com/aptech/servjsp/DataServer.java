package com.aptech.servjsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Servlet implementation class DataServer
 */
@WebServlet("/DataServer")
public class DataServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> prods = new ArrayList<Product>();
		for(int i = 0; i < 10; i++){
			Product product = new Product();
			product.setProductName("name "+ i);
			product.setPrice(String.valueOf(10 + i));
			prods.add(product);
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(prods);
		response.getWriter().append(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
