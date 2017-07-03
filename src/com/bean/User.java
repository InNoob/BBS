package com.bean;

/**
 * User
 */
public class User {

	private int uid;
	private String username;
	private String password;
	private String headimg;
	private int level;
	private String whatup;
	private String jointime;
	private String tag;
	

	public User () {
		
	}

	public User (int uid,String username,String password,String headimg,int level,String whatup,String jointime,String tag){
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.headimg = headimg;
		this.level = level;
		this.whatup = whatup;
		this.jointime = jointime;
		this.tag = tag;
	}
	public int getUid(){
		return this.uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getHeadimg(){
		return this.headimg;
	}
	public void setHeadimg(String headimg){
		this.headimg=headimg;
	}
	public int getLevel(){
		return this.level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	public String getWhatup(){
		return this.whatup;
	}
	public void setWhatup(String whatup){
		this.whatup=whatup;
	}
	public String getJointime(){
		return this.jointime;
	}
	public void setJointime(String jointime){
		this.jointime=jointime;
	}
	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag=tag;
	}

}