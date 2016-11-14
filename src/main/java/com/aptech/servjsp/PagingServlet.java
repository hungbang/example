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

import com.aptech.servjsp.vo.PagingVO;

/**
 * Servlet implementation class PagingServlet
 */
@WebServlet("/PagingServlet")
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int totalRecord = 99;
		int recordInPage = 10;
		int pageNumber = 0;
		if(totalRecord % recordInPage == 0){
			pageNumber = totalRecord / recordInPage;
		}else{
			pageNumber = (totalRecord / recordInPage) + 1;
		}
		List<Product> prods = new ArrayList<Product>();
		for(int i = 0; i < 10; i++){
			Product product = new Product();
			product.setProductName("name "+ i);
			product.setPrice(String.valueOf(10 + i));
			prods.add(product);
		}
		PagingVO pagingVO = new PagingVO();
		pagingVO.setPageNumber(pageNumber);
		pagingVO.setProducts(prods);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(pagingVO);	
		
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
