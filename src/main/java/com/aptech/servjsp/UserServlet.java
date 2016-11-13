package com.aptech.servjsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======User servlet======");
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		System.out.println("==username===="+ username + "====pass=====" +pass + "====role=="+ role + "  ===context path : ");
		
		if("user".equals(username.trim()) && "user".equals(pass.trim())){
			request.setAttribute("username", username);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}else{
			response.sendRedirect("loginfilter.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
