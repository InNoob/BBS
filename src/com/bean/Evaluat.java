package com.bean;

/**
 * Evaluat
 */
public class Evaluat {

	private int eid;
	private int rid;
	private int tid;
	private int uid;
	private String content;
	private String evatime;
	private int great;
	private int type;
	private String tag;

	public Evaluat () {
		
	}

	public Evaluat (int eid,int rid,int tid,int uid,String content,String evatime,int great,int type,String tag){
		this.eid = eid;
		this.rid = rid;
		this.tid = tid;
		this.uid = uid;
		this.content = content;
		this.evatime = evatime;
		this.great = great;
		this.type = type;
		this.tag = tag;
	}
	public int getEid(){
		return this.eid;
	}
	public void setEid(int eid){
		this.eid=eid;
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
	public String getEvatime(){
		return this.evatime;
	}
	public void setEvatime(String evatime){
		this.evatime=evatime;
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