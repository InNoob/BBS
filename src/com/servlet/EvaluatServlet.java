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

@WebServlet("/EvaluatServlet")
public class EvaluatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluatServlet() {
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
		HttpSession session =  request.getSession();
		if(session.getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return;
		}
		TopicInfo topicInfo = (TopicInfo)session.getAttribute("topicInfo");
		int bid = topicInfo.getBid();
		int tid = topicInfo.getTid();
		int sender = ((User)session.getAttribute("user")).getUid();
		int reciver = Integer.parseInt(request.getParameter("uid"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		int beid = Integer.parseInt(request.getParameter("eid"));
		String content = request.getParameter("evaluatContent");
		procDao dao = new procDao();
		if(beid==0){
			dao.newEvalut(bid, tid, rid, sender, reciver, content);
		}else{
			dao.newRevaluat(bid, tid, rid, beid, sender, reciver, content);
		}
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
