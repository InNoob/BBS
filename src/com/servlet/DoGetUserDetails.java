package com.servlet;

import java.io.IOException;

//import java.io.PrintWriter;

//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.GetUserDetails;
//import com.bean.*;
//import com.dao.*;


@WebServlet("/DoGetUserDetails")
public class DoGetUserDetails extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public DoGetUserDetails() {
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
		//判断是否登录
		session.setAttribute("infostate","info");
		if(session.getAttribute("user")!=null){
			//已登录
			User user = (User)session.getAttribute("user");
			//判断参数uid与登录用户id是否不同
			if(request.getParameter("uid")!=null){
				if(user.getUid()!=Integer.parseInt(request.getParameter("uid"))){
					//不同则查询参数uid所指用户以及是否被登录用户关注
					user = GetUserDetails.getOtherUserDetails(Integer.parseInt(request.getParameter("uid")),user.getUid());
					session.setAttribute("user2", user);
					response.sendRedirect("otherinfo.jsp");
				}
				else {
					//相同进入登录用户自己的页面
						 user = GetUserDetails.getUserDetails(user.getUid());
						 session.setAttribute("user", user);
						 response.sendRedirect("userinfo.jsp");
				}
			}else{
				 user = GetUserDetails.getUserDetails(user.getUid());
				 session.setAttribute("user", user);
				 response.sendRedirect("userinfo.jsp");
			}

		}
		//未登录
		else{
				//进入详细页面
				User	user = GetUserDetails.getOtherUserDetails(Integer.parseInt(request.getParameter("uid")),-1);
				session.setAttribute("user2", user);
				response.sendRedirect("otherinfo.jsp");
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
