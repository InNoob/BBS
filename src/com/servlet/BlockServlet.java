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
 * Servlet implementation class BlockServlet
 */
@WebServlet("/BlockServlet")
public class BlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int pageNo = 1;

		if(null!=request.getParameter("pageNo")){
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}else if(null!=request.getSession().getAttribute("pageNo")){
			pageNo = (int)request.getSession().getAttribute("pageNo");
		}
		TopicDao dao = new TopicDao();
		int bid = Integer.valueOf(request.getParameter("bid"));
		request.getSession().setAttribute("pageNo", pageNo);
		Pager<Topic> pager = new Pager<Topic>();
		pager.setPageNo(pageNo);
		pager.setTotalPage(dao.getTotal());
		Object user = request.getSession().getAttribute("user");
		if(user!=null){
			pager.setList(dao.getTopicBlock(pageNo,((User)user).getUid(),bid));
		}else{
			pager.setList(dao.getTopicBlock(pageNo,0000,bid));
		}
		request.getSession().setAttribute("pager", null);
		request.getSession().setAttribute("pager", pager);
		request.getSession().setAttribute("bbsState", "block");
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
