package com.bean;

/**
 * Topic
 */
public class Topic {

	private int tid;
	private int uid;
	private String title;
	private String toptime;
	private int great;
	private int stat;
	private String tag;

	public Topic () {
		
	}

	public Topic (int tid,int uid,String title,String toptime,int great,int stat,String tag){
		this.tid = tid;
		this.uid = uid;
		this.title = title;
		this.toptime = toptime;
		this.great = great;
		this.stat = stat;
		this.tag = tag;
	}
	public int getTid(){
		return this.tid;
	}
	public void setTid(int tid){
		this.tid=tid;
	}
	public int getUid(){
		return this.uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getToptime(){
		return this.toptime;
	}
	public void setToptime(String toptime){
		this.toptime=toptime;
	}
	public int getGreat(){
		return this.great;
	}
	public void setGreat(int great){
		this.great=great;
	}
	public int getStat(){
		return this.stat;
	}
	public void setStat(int stat){
		this.stat=stat;
	}
	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag=tag;
	}

}