package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilesServlet")
public class FilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String path = this.getServletContext().getRealPath("/")+"/files";
		File file = new File(path);
		File[] files = file.listFiles();
		String[] fileName = new String[files.length];
		for (int i = 0;i<files.length;i++) {
			fileName[i] = files[i].getName();
		}
		request.getSession().setAttribute("fileName", fileName);
		response.sendRedirect("index.jsp");
	}

}
