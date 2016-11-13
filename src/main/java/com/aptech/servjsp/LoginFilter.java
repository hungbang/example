package com.aptech.servjsp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {

	
	
	String contextPath = "";
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		
		System.out.println("==username===="+ username + "====pass=====" +pass + "====role=="+ role + "  ===context path : "+ contextPath);
		
		
		if("admin".equals(role.trim())){
//			request.getRequestDispatcher("admin.jsp").forward(request, response);
			request.getRequestDispatcher("AdminServlet").forward(request, response);
		}else{
//			request.getRequestDispatcher("user.jsp").forward(request, response);
			request.getRequestDispatcher("UserServlet").forward(request, response);
		}
		
		// pass the request along the filter chain
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		contextPath =  fConfig.getServletContext().getContextPath();
	}

}
