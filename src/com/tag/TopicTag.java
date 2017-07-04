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
	private String titleUrl;
	private String headimg;
	private String block;
	private String blockUrl;
	private String tpcUname;
	private Date tpcTime;
	private String rcvUname;
	private Date rcvTime;
	private int count;
	
	public void doTag() throws JspException,IOException{
		JspWriter out = getJspContext().getOut();
		if(title!=null){
		StringBuilder sb = new StringBuilder("<div class=\"topic-rows\">")
								.append("<div class=\"topic-headimg\">")
								.append("<a href=\"").append(headimg).append("\" title=\"").append(tpcUname).append("\"><img src=\"").append(headimg).append("\" height=\"60\" width=\"60\" ></a></div>")
								.append("<div class=\"topic-content\">")
								.append("<div class=\"topic-title\"><a href=\"").append(titleUrl).append("\">").append(title).append("</a></div>")
								.append("<div class=\"topic-block\"><div><a href=\"").append(blockUrl).append("\">").append(block).append("</a></div></div>")
								.append("</div>").append("<div class=\"topic-count\"><a href=\"").append(titleUrl).append("\">").append(count).append("</a></div>").append("</div>");
		out.print(sb.toString());
		}
	}

	public void setTitle(String title){
		this.title=title;
	}
	public void setTitleUrl(String titleUrl){
		this.titleUrl=titleUrl;
	}
	public void setHeadimg(String headimg){
		this.headimg=headimg;
	}
	public void setBlock(String block){
		this.block=block;
	}
	public void setBlockUrl(String blockUrl){
		this.blockUrl=blockUrl;
	}
	public void setTpcUname(String tpcUname){
		this.tpcUname=tpcUname;
	}
	public void setTpcTime(Date tpcTime){
		this.tpcTime=tpcTime;
	}
	public void setRcvUname(String rcvUname){
		this.rcvUname=rcvUname;
	}
	public void setRcvTime(Date rcvTime){
		this.rcvTime=rcvTime;
	}
	public void setCount(int count){
		this.count=count;
	}
}