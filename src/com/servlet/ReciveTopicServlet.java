package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TopicInfo;
import com.bean.User;
import com.dao.procDao;

@WebServlet("/ReciveTopicServlet")
public class ReciveTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReciveTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return;
		}
		int bid = ((TopicInfo)session.getAttribute("topicInfo")).getBid();
		int tid = ((TopicInfo)session.getAttribute("topicInfo")).getTid();
		int sender = ((User)session.getAttribute("user")).getUid();
		int revicer = ((TopicInfo)session.getAttribute("topicInfo")).getUid();
		String content = request.getParameter("repliesContent");
		procDao dao = new procDao();
		dao.newRecive(bid, tid, sender, revicer, content);
		response.sendRedirect("SelectTopicByIdServlet?tid="+tid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
