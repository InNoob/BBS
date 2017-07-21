package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getParameter("fileName");
		this.getServletContext().setAttribute("path", path);
		response.sendRedirect("download.jsp");
		*/
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setHeaderEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			//
			FileItem item = fileUpload.parseRequest(request).get(0);
			String value = item.getName();
			String fileName = value.substring(value.lastIndexOf("\\")+1);
			int uid = 0;
			if(null!=session.getAttribute("user")){
				uid = ((User)session.getAttribute("user")).getUid();
			}else{
				response.sendRedirect("login.jsp");
			}
			String fmt = fileName.substring(fileName.indexOf('.'));
			File newFile = new File("/home/jasonbourne/Documents/workspace/BBS/WebContent/resource/head/"+uid+fmt);
			item.write(newFile);
			UserDao dao =  new UserDao();
			if(dao.changeHeadimg((User)session.getAttribute("user"),uid+fmt)){
				response.sendRedirect(request.getSession().getAttribute("page").toString());				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
