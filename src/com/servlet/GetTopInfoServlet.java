package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.BlockDetailsDao;
import com.dao.GetUserDetails;

/**
 * Servlet implementation class GetTopInfoServlet
 */
@WebServlet("/GetTopInfoServlet")
public class GetTopInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Object user = request.getSession().getAttribute("user");
		if(user!=null){
			request.getSession().setAttribute("refresh", GetUserDetails.getUserDetails(((User)user).getUid()));
		}
		request.getSession().setAttribute("topcount", new BlockDetailsDao().getBlockDetails());
		request.getSession().setAttribute("topstate", "start");
		if(null!=request.getSession().getAttribute("page")){
			response.sendRedirect(request.getSession().getAttribute("page").toString());
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
