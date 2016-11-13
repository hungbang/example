package com.aptech.servjsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		HttpSession session = request.getSession();
//		session.setAttribute("name", name);
//		session.setAttribute("title", "Profile page");
//		request.getRequestDispatcher("profile.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("======login servlet======");
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		System.out.println("==username===="+ username + "====pass=====" +pass + "====role=="+ role + "  ===context path : ");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
