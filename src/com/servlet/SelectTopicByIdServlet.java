package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TopicInfo;
import com.dao.ReciveDao;
import com.dao.TopicDao;


@WebServlet("/SelectTopicByIdServlet")
public class SelectTopicByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int tid = Integer.parseInt(request.getParameter("tid"));
		TopicDao dao = new TopicDao();
		dao.addFlow(tid);
		TopicInfo topicInfo = dao.getTopicInfo(tid);
		if(topicInfo!=null){
			request.getSession().setAttribute("topicInfo", topicInfo);
			ReciveDao rdao = new ReciveDao();
			request.getSession().setAttribute("reciveInfo", rdao.SelectReciveById(tid));
			request.getSession().setAttribute("bbsState", "start");
			response.sendRedirect("reply.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
