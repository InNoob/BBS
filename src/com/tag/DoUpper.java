package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DoUpper extends TagSupport{

	private static final long serialVersionUID = 1L;
	@Override
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try {
			out.print("hello world");
			return 0;
		} catch (Exception e) {
			return SKIP_BODY;
			// TODO: handle exception
		}
	}

}
