package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UpdateUserinfo;
//import com.bean.*;
/**
 * Servlet implementation class dochangeinfo
 */
@WebServlet("/dochangeinfo")
public class dochangeinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dochangeinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		out.print("ok1");
		if(null!=request.getParameter("uid")){
			out.print("ok2");
			User user = new User();
			int uid= Integer.parseInt(request.getParameter("uid"));
			String gender = Integer.parseInt(request.getParameter("gender")) >0?"男":"女";
			String birthday =request.getParameter("birth");
			String whatup= request.getParameter("whatup");
			String tag=request.getParameter("tag");
			String username=request.getParameter("username");
			String phone= request.getParameter("mobile");
			user.setUid(uid);user.setGender(gender);
			user.setBirthday(birthday);
			user.setWhatup(whatup);user.setTag(tag);user.setUsernameString(username);
			user.setPhone(phone);
			out.print("ok");
		if(UpdateUserinfo.updateuserinfo(user)){
			response.sendRedirect("dogetUserDetails");
		}
		}
		
	}

}
