package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.utils.URI;

@SuppressWarnings("unused")
public class DownloadsServlet extends HttpServlet {
	
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		
		String path = (String)this.getServletContext().getRealPath("/")+"/files/"+name;
		System.out.println(path);
		response.setHeader("content-disposition", "attachment;filename="+new String(name.getBytes("GB2312"),"ISO-8859-1"));
		FileInputStream in = null;
		ServletOutputStream out = null;
		in = new FileInputStream(path);
		int len = 0;
		byte[] buffer = new byte[1024];
		out = response.getOutputStream();
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
	}

}
