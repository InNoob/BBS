package com.bean;

/**
 * Recive
 */
public class Recive {

	private int rid;
	private int tid;
	private int uid;
	private String content;
	private String rectime;
	private int great;
	private int type;
	private String tag;

	public Recive () {
		
	}

	public Recive (int rid,int tid,int uid,String content,String rectime,int great,int type,String tag){
		this.rid = rid;
		this.tid = tid;
		this.uid = uid;
		this.content = content;
		this.rectime = rectime;
		this.great = great;
		this.type = type;
		this.tag = tag;
	}
	public int getRid(){
		return this.rid;
	}
	public void setRid(int rid){
		this.rid=rid;
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
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getRectime(){
		return this.rectime;
	}
	public void setRectime(String rectime){
		this.rectime=rectime;
	}
	public int getGreat(){
		return this.great;
	}
	public void setGreat(int great){
		this.great=great;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag=tag;
	}

}