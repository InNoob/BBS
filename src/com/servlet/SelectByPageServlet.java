package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Topic;
import com.bean.User;
import com.dao.TopicDao;
import com.util.Pager;

/**
 * Servlet implementation class SelectByPageServlet
 */

@WebServlet("/SelectByPageServlet")
public class SelectByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int pageNo = 1;

		if(null!=request.getParameter("pageNo")){
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}else if(null!=request.getSession().getAttribute("pageNo")){
			pageNo = (int)request.getSession().getAttribute("pageNo");
		}
		TopicDao dao = new TopicDao();
		request.getSession().setAttribute("pageNo", pageNo);
		Pager<Topic> pager = new Pager<Topic>();
		pager.setPageNo(pageNo);
		pager.setTotalPage(dao.getTotal());
		Object user = request.getSession().getAttribute("user");
		if(user!=null){
			pager.setList(dao.getTopicAll(pageNo,((User)user).getUid()));
		}else{
			pager.setList(dao.getTopicAll(pageNo,0000));
		}
		request.getSession().setAttribute("pager", pager);
		request.getSession().setAttribute("bbsState", "start");
		response.sendRedirect("index.jsp");
	}
}
