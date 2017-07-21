package com.bean;

public class Evaluat {
	private int eid;
	private int rid;
	private int uid;
	private String beuid;
	private String content;
	private String username;
	
	public Evaluat() {
		// TODO Auto-generated constructor stub
	}

	public Evaluat(int eid, int rid, int uid, String beuid, String content,String username) {
		super();
		this.eid = eid;
		this.rid = rid;
		this.uid = uid;
		this.beuid = beuid;
		this.content = content;
		this.username = username;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBeuid() {
		return beuid;
	}

	public void setBeuid(String beuid) {
		this.beuid = beuid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
