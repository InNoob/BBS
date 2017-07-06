package com.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * TopicTag
 */
public class TopicTag extends SimpleTagSupport{

	private String title;
	private String titleUrl;
	private String headimg;
	private String userinfoUrl;
	private int level;
	private long mark;
	private String block;
	private String blockUrl;
	private String tpcUname;
	private String tpcTime;
	private String rcvTime;
	private int count;
	
	public void doTag() throws JspException,IOException{
		JspWriter out = getJspContext().getOut();
			if(title!=null){
			long levmark = new Double(100*Math.pow(2,level)).intValue();
				StringBuilder sb = new StringBuilder("<div class=\" topic-rows\">\n")
				.append("<div class=\"topic-headimg-box\">\n").append( 
				"            <div class=\"topic-headimg\">\n").append( 
				"                <a href=\"").append(userinfoUrl).append("\" title=\"").append(tpcUname).append("\">\n").append(
				"                    <img src=\"").append(headimg).append("\" height=\"60\" width=\"60\" alt=\"\">\n").append( 
				"                </a>\n").append( 
				"            </div>\n").append( 
				"            <div class=\"topic-details\">\n").append(
				"                <div class=\"topic-innerimg\">\n").append(
				"                    <a href=\"").append(userinfoUrl).append("\" title=\"").append(tpcUname).append("\">\n").append(
				"                        <img src=\"").append(headimg).append("\"  height=\"60\" width=\"60\" alt=\"\">\n").append( 
				"                    </a>\n").append( 
				"                </div>\n").append(
				"                <span class=\"topic-level\">Lv.").append(level).append("</span>\n").append(
								"<span class=\"topic-name\">").append(tpcUname).append("</span>").append(
				"                <span class=\"topic-markbox\"><span class=\"topic-markbar\" style=\"width:").append((mark*100)/levmark).append("%\"></span><span class=\"topic-mark\">").append(mark).append("/").append(levmark).append("</span></span>\n").append( 
				"                <a href=\"").append("ajax").append("\"> <button type=\"button\" >添加关注</button></a>").append( 
				"                <a href=\"").append("ajax").append("\"> <button type=\"button\">和他私聊</button></a>").append( 
				"            </div>\n").append( 
				"        </div>\n").append( 
				"        <div class=\"topic-content\">").append( 
				"            <div class=\"topic-title\"><a href=\"").append(titleUrl).append("\">").append(title).append("</a></div>\n").append( 
				"            <div class=\"topic-block\">\n").append( 
				"                <div><a href=\"").append(blockUrl).append("\">").append(block).append("</a></div>\n").append( 
				"            </div>\n").append( 
                "                <div class=\"topic-time\">\n").append( 
                "                    <span>发帖时间:").append(tpcTime).append("</span><span>最后回复:").append(rcvTime).append("</span>").append(
                "                </div>").append(
				"        </div>\n").append( 
				"        <div class=\"topic-count\">\n").append( 
				"            <a href=\"").append(titleUrl).append("\">").append(count).append("</a>\n").append( 
				"        </div>\n").append( 
				"    </div>");
        
			out.print(sb.toString());
		}
	}
	public void setUid(int uid) {
		this.userinfoUrl = new StringBuilder("ServletUserinfo?uid=").append(uid).toString();
	}
	
	public void setBid(int bid) {
		this.blockUrl = new StringBuilder("ServletBlock?bid=").append(bid).toString();
	}
	
	public void setTid(int tid) {
		this.titleUrl = new StringBuilder("SrvletTopic?tid=").append(tid).toString();
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public void setTitle(String title){
		this.title=title;
	}
	public void setHeadimg(String headimg){
		this.headimg=headimg;
	}
	public void setBlock(String block){
		this.block=block;
	}
	public void setTpcUname(String tpcUname){
		this.tpcUname=tpcUname;
	}
	public void setTpcTime(String tpcTime){
		try {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date fromDate = simpleFormat.parse(tpcTime);
			simpleFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
			this.tpcTime=simpleFormat.format(fromDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMark(long mark) {
		this.mark = mark;
	}

	public void setRcvTime(String rcvTime){
		try {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			String fromDate = simpleFormat.format(simpleFormat.parse(rcvTime));
			String toDate = simpleFormat.format(new Date());
			Date form = simpleFormat.parse(fromDate);
			Date to = simpleFormat.parse(toDate);
			this.rcvTime = to.getYear()-form.getYear() > 0 ? to.getYear()-form.getYear()+"年前":
				to.getMonth()-form.getMonth() > 0 ? to.getMonth()-form.getMonth()+"个月前" :
				to.getDay()-form.getDay() > 0 ? to.getDay()-form.getDay()+"天前" :
				to.getHours()-form.getHours() > 0 ? to.getHours()-form.getHours()+"小时前" :
				to.getMinutes()-form.getMinutes() > 0 ? to.getMinutes()-form.getMinutes()+"分钟前" :
				to.getSeconds()-form.getSeconds() > 0 ? to.getSeconds()-form.getSeconds()+"秒前" : "刚刚";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setCount(int count){
		this.count=count;
	}
}