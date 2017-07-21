package com.bean;

import java.util.List;

public class Recive {
	private int rid;
	private int tid;
	private int uid;
	private String username;
	private String content;
	private String recTime;
	private String great;
	private String headimg;
	private List<Evaluat> list;
	
	public Recive() {
		// TODO Auto-generated constructor stub
	}
	
	public Recive(int rid, int tid, int uid, String username, String content, String recTime, String great,String headimg,List<Evaluat> list) {
		super();
		this.rid = rid;
		this.tid = tid;
		this.uid = uid;
		this.username = username;
		this.content = content;
		this.recTime = recTime;
		this.great = great;
		this.headimg = headimg;
		this.list = list;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}

	public String getGreat() {
		return great;
	}

	public void setGreat(String great) {
		this.great = great;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public List<Evaluat> getList() {
		return list;
	}

	public void setList(List<Evaluat> list) {
		this.list = list;
	}
	
	
}
