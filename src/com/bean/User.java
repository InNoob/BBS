package com.bean;

public class User {
	private int uid;
	private String username;
	private String gender;
	private String birthday;
	private String phone;
	private String email;
	private String headimg;
	private int level;
	private long mark;
	private String whatup;
	private String jointime;
	private String tag;
	private int favourite;	
	private int 	carewho;
	private int whocare;
	private int topiccount;
	private int great;
	private long maxmark;
	private int isfollowing;
	private int unread;
	
	public User(){}
	public User(int uid, String username, String gender, String birthday, String phone, String email, String headimg,
			int level, long mark, String whatup, String jointime, String tag, int favourite, int carewho, int whocare,
			int topiccount,int great,int state) {
		super();
		this.uid = uid;
		this.username = username;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.headimg = headimg;
		this.level = level;
		this.mark = mark;
		this.whatup = whatup;
		this.jointime = jointime;
		this.tag = tag;
		this.favourite = favourite;
		this.carewho = carewho;
		this.whocare = whocare;
		this.topiccount = topiccount;
		this.great=great;
		this.maxmark = new Double(100*Math.pow(2,this.level)).longValue();
		this.isfollowing = state;
	}
	public User(int uid, String username, String gender, String birthday, String phone, String email, String headimg,
			int level, long mark, String whatup, String jointime, String tag, int favourite, int carewho, int whocare,
			int topiccount,int great) {
		super();
		this.uid = uid;
		this.username = username;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.headimg = headimg;
		this.level = level;
		this.mark = mark;
		this.whatup = whatup;
		this.jointime = jointime;
		this.tag = tag;
		this.favourite = favourite;
		this.carewho = carewho;
		this.whocare = whocare;
		this.topiccount = topiccount;
		this.great=great;
		this.maxmark = new Double(100*Math.pow(2,this.level)).longValue();
	}
	public int getUnread(){
		return this.unread;
	}
	public void setUnread(int unread){
		this.unread=unread;
	}
	public int getGreat() {
		return great;
	}
	public void setGreat(int great) {
		this.great = great;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", usernameString=" + username + ", gender=" + gender + ", birthday="
				+ birthday + ", phone=" + phone + ", email=" + email + ", headimg=" + headimg + ", level=" + level
				+ ", mark=" + mark + ", whatup=" + whatup + ", jointime=" + jointime + ", tag=" + tag + ", favourite="
				+ favourite + ", carewho=" + carewho + ", whocare=" + whocare + ", topiccount=" + topiccount + "great="+great+ "]";
	}
	public int getFavourite() {
		return favourite;
	}
	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}
	public int getCarewho() {
		return carewho;
	}
	public void setCarewho(int carewho) {
		this.carewho = carewho;
	}
	public int getWhocare() {
		return whocare;
	}
	public void setWhocare(int whocare) {
		this.whocare = whocare;
	}
	public int getTopiccount() {
		return topiccount;
	}
	public void setTopiccount(int topiccount) {
		this.topiccount = topiccount;
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
	public void setUsernameString(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getMark() {
		return mark;
	}
	public void setMark(long mark) {
		this.mark = mark;
	}
	public String getWhatup() {
		return whatup;
	}
	public void setWhatup(String whatup) {
		this.whatup = whatup;
	}
	public String getJointime() {
		return jointime;
	}
	public void setJointime(String jointime) {
		this.jointime = jointime;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public long getMaxMark(){
		return this.maxmark;
	}
	public int getIsfollowing(){
		return this.isfollowing;
	}
	public void setIsfollowing(int state){
		this.isfollowing = state;
	}
	
}
