package com.tag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
/**
 * TopicTag
 */
public class TopicTag extends SimpleTagSupport{

	private String title;
	private Date time;
	
	public void doTag() throws JspException,IOException{
		if(title!=null){
			JspWriter out = getJspContext().getOut();
			out.print(this.title);
		}
	}

	public void setTitle(String title){
		this.title=title;
	}
}