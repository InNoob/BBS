package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProcUserDao;
import com.util.MailVerifyUtil;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		response.setContentType("text/html;charsert=UTF-8");
		ServletContext application= this.getServletContext();
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		if(null!=request.getParameter("uuid")){
		if(null!=application.getAttribute("email")&&null!=application.getAttribute("pass")){
			ProcUserDao dao = new ProcUserDao();
			dao.insertUser(application.getAttribute("email").toString(), application.getAttribute("pass").toString());
			request.getSession().setAttribute("loginMessage", "注册成功！请尽情的使用我吧");
			application.removeAttribute("email");
			application.removeAttribute("pass");
			response.sendRedirect("login.jsp");
			return;
		}
		}else{
			application.setAttribute("pass", pass);
			application.setAttribute("email", email);
			UUID uuid=UUID.randomUUID();
	        String str = uuid.toString(); 
	        String uuidStr=str.replace("-", "");
			String content = "<h1>欢迎使用BoBoSi</h1><br/><h3>通过以下操作您将可以正常使用您的BoBoSi账户</h3><br/>"+
					"</br>请点击此链接或将该链接拷贝到地址栏访问 <a href='http://192.168.43.2:8080/BBS/RegisterUserServlet?uuid="+uuidStr
					+"'>http://www.newerbbs.com/BBS/RegisterUserServlet?uuid="+uuidStr+"</a></br><h5>如果不是您本人，请忽视此邮件</h5>"
					+"<h5>此邮件为机器人自动发送，请勿回复</h5>"
					+"<h4>"+new Date().toLocaleString()+" BoBoSi账户审查小组敬上</h4>";
			try {
				MailVerifyUtil.sendMail(email, content);				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			response.getWriter().print("验证邮箱已发送,请在30分钟内完成注册程序");
		}
	}

}
