package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bean.LoginUser;
import com.bean.User;
import com.dao.TakeCareDao;

/**
 * Servlet implementation class TakeCareServlet
 */
@WebServlet("/TakeCareServlet")
public class TakeCareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeCareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int who = Integer.valueOf( request.getParameter("uid"));
		int care = Integer.valueOf( request.getParameter("care"));
		User u = new User();
		if(null!=request.getSession().getAttribute("user")){
			u = (User)request.getSession().getAttribute("user");
		}else{
			out.println("请登录");
			return;
		}
		TakeCareDao dao = new TakeCareDao();
		System.out.println(dao.checkCare(u.getUid(), who));
		if(care==0){
			if(dao.takeCare(u.getUid(), who)) {
				out.print("已关注");
			}
		}else{
			if(dao.unCare(u.getUid(), who)) {
				out.print("添加关注");
			}
		}
		out.flush();
		out.close();
	}

}
