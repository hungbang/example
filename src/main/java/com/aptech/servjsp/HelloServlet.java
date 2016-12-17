package com.aptech.servjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = getServletContext().getInitParameter("param1");
		String paramSER = getServletConfig().getInitParameter("param1");
		System.out.println("======param1   :"+ param1);
		System.out.println("======param 2   :"+ paramSER);
		System.out.println("======param 2  end :");
		PrintWriter writer = response.getWriter();
		//thuộc request => dùng đường dẫn tương đối (relative path )
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/book-list.jsp");
		//thuộc servlet context => sử dụng đường dẫn tuyệt đối.
		//getServletContext().getRequestDispatcher(arg0)
		
		request.setAttribute("param", "Index page");
		
		//trả dữ liệu từ 1 servlet tới thẳng jsp 
		rd.forward(request, response);
		//bao gồm dữ liệu của những servlet trả ra jsp 
		//rd.include(request, response);
		
//		writer.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
