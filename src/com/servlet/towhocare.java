package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bean.User;
import com.dao.GetFollow;


@WebServlet("/towhocare")
public class towhocare extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public towhocare() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		System.out.println("init servlet");
		try{
			if(request.getParameter("uid")!=null && request.getParameter("how")!=null){
				System.out.println("uid how not block");
					//关注我的
					if("whocare".equals(request.getParameter("how"))){
						List<User> list=  GetFollow.getFollowers(Integer.parseInt(request.getParameter("uid")));
						session.setAttribute("followlist", list);
						System.out.println("session set success");
						response.sendRedirect("whocare.jsp");
					}
					//我的关注
					else if("carewho".equals(request.getParameter("how"))) {
						List<User> list=  GetFollow.getFollowing(Integer.parseInt(request.getParameter("uid")));
						session.setAttribute("followlist", list);
						response.sendRedirect("whocare.jsp");	
					}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
